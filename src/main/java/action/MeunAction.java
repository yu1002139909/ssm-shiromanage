package action;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CourseService;
import service.DeptService;
import service.GradeService;
import service.MajorServlice;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/2 15:15
 */
@Controller
public class MeunAction {
  @Autowired
  CourseService courseService;
  @Autowired
  MajorServlice majorServlice;
  @Autowired
  GradeService gradeService;
  @Autowired
  DeptService deptService;

  @RequestMapping(value = "test.action")
    public String test(HttpServletResponse response, String major_name) throws Exception {
      System.out.println("ajax请求");
      System.out.println(major_name);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String string = sdf.format(new Date());
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter pw = response.getWriter();
      pw.write(string);
      pw.flush();
      pw.close();
      return null;
  }
  @RequestMapping(value = "json")
   public @ResponseBody
  List<Muen> json(String userRole){
    List<Muen> muens = new ArrayList<Muen>();
    List<ChildMenusBean> coursemMuens = new ArrayList<ChildMenusBean>();//学院
    List<ChildMenusBean> menusBeans = new ArrayList<ChildMenusBean>();//管理员列表
    List<ChildMenusBean> depteMuens = new ArrayList<ChildMenusBean>(); //部门菜单显示
    Muen muen = new Muen();//校友系统菜单
    muen.setId("1");
    muen.setIsHeader("1");
    muen.setOrder("1");
    muen.setUrl("");
    muen.setIcon("");
    muen.setName("校友系统");
    muen.setParentId("0");
    Muen deptMuen = new Muen();//教职工系统

    deptMuen.setId("2");
    deptMuen.setIcon("");
    deptMuen.setIsHeader("1");
    deptMuen.setOrder("2");
    deptMuen.setUrl("");
    deptMuen.setName("教职工系统");
    deptMuen.setParentId("0");
    //获取所有部门列表
    List<Dept> deptList = deptService.getall();
    for (Dept dept :deptList){
       ChildMenusBean deptChildMenu  = new ChildMenusBean();
       deptChildMenu.setParentId(deptMuen.getId());
       deptChildMenu.setIsHeader("");
       deptChildMenu.setUrl("emp/list?dept_id="+dept.getDeptId());
       deptChildMenu.setName(dept.getDeptName());
       deptChildMenu.setId(dept.getDeptId());
       deptChildMenu.setIcon("&#xe609");
       depteMuens.add(deptChildMenu);
    }
    deptMuen.setChildMenus(depteMuens);
    Muen adminMuen = new Muen();//管理员菜单
    adminMuen.setId("3");
    adminMuen.setIcon("");
    adminMuen.setIsHeader("1");
    adminMuen.setOrder("2");
    adminMuen.setUrl("");
    adminMuen.setName("管理员中心");
    adminMuen.setParentId("0");
    //专业
    List<Course> all = courseService.getAll();
    for (Course course:all){
      List<ChildMenusBean> majorlist = new ArrayList<ChildMenusBean>();//专业
      String course_id = course.getCourse_id();
      //获取所选学院下的所有专业
      List<Major> majors = majorServlice.findbymajorByCouserId(course_id);
      for(Major major:majors){
        ChildMenusBean majorbean = new ChildMenusBean();
        majorbean.setIcon("&#xe609");
        majorbean.setUrl("grade/list?majorid="+major.getMajor_id());
        majorbean.setParentId(course_id);
        majorbean.setId(major.getMajor_id());
        majorbean.setName(major.getMajor_name());
        majorbean.setOrder("1");
        majorbean.setIsHeader("0");
        majorlist.add(majorbean);
        List<ChildMenusBean> gradebenanlist = new ArrayList<ChildMenusBean>();//班级
        List<Grade> grades = gradeService.findbyGradeMapperByMajorId(major.getMajor_id());
        for (Grade grade:grades){
          ChildMenusBean gradeMuen = new ChildMenusBean();
          gradeMuen.setUrl("student/stulist?grade_id="+grade.getGrade_id());
          gradeMuen.setName(grade.getGrade_name()+"班");
          gradeMuen.setId(grade.getGmajor_id());
          gradeMuen.setIcon("&#xe609");
          gradeMuen.setIsHeader("2");
          gradeMuen.setOrder("2");
          gradeMuen.setParentId(major.getMajor_id());
          gradebenanlist.add(gradeMuen);
        }
        majorbean.setChildMenus(gradebenanlist);
      }
      ChildMenusBean childmenus = new ChildMenusBean();
      childmenus.setName(course.getCourse_name());
      childmenus.setId(course_id);
      childmenus.setUrl("major/list?course_id="+course_id);
      childmenus.setParentId("1");
      childmenus.setIcon("&#xe609");
      childmenus.setOrder("");
      childmenus.setIsHeader("0");
      childmenus.setChildMenus(majorlist);
      coursemMuens.add(childmenus);
    }
    muen.setChildMenus(coursemMuens);
    muens.add(muen);
    muens.add(deptMuen);
    ChildMenusBean adminMues = new ChildMenusBean();
    adminMues.setIcon("&#xe609");
    adminMues.setParentId("1");
    adminMues.setName("管理员列表");
    adminMues.setUrl("user/userlist");
    menusBeans.add(adminMues);
    adminMuen.setChildMenus(menusBeans);
    if(userRole.equals("admin")){
      muens.add(adminMuen);
    }
    return muens;
  }
}
