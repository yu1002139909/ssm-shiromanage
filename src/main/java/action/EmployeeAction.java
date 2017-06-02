package action;

import entity.Dept;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.DeptService;
import service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/31 10:59
 *emp控制层
 */

@Controller
public class EmployeeAction {
    //注入service
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DeptService deptService;

    @RequestMapping(value = "emp/list")
    public String  empList(Model model,String dept_id){
        List<Employee> employeeList = employeeService.findbyEmployeeByDepeId(dept_id);
        model.addAttribute("employeeList",employeeList);
        return "emplist";
    }
    /**@author yu
     * @version 1.0
     * @Date 2017/5/31
     * 新增职工
     */
    @RequestMapping(value = "emp/addUi")
    public  String addUi(Model model){
        List<Dept> deptList = deptService.getall();
        model.addAttribute("deptList",deptList);
        return "emp-add";
    }
    /**@author yu
     * @version 1.0
     * @Date 2017/5/31
     * 新增职工
     */
    @RequestMapping(value = "emp/add",method = RequestMethod.POST)
     public String add(Employee employee, @RequestParam("file") MultipartFile file,
                       HttpServletRequest request,String enterDate ,String overDate) throws IOException, ParseException {
        //获取webapp的物理路劲
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path="";
        System.out.println("文件上传");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date eDate = sdf.parse(enterDate);
        Date oDate = sdf.parse(overDate);
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            System.out.println(contentType);
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/static/images/"+uuid+".jpg";
            employee.setPhoto(path);
            file.transferTo(new File(pathRoot+path));
        }
        employee.setEnterDate(eDate);
        employee.setOverDate(oDate);
        employeeService.add(employee);
        return "index";
      }
      /**@author yu
       * @version 1.0
       * @Date 2017/5/31
       *删除职工
       */
      @RequestMapping (value = "emp/delete")
    public String delete(String id){
          employeeService.delete(id);
          return "index";
      }
    @RequestMapping(value = "emp/updateUi")
    public String updateUi(Model model,String id){
        Employee employee = employeeService.findById(id);
        System.out.println(employee.getEmpId());
        List<Dept> deptList = deptService.getall();
        model.addAttribute("deptList",deptList);
        model.addAttribute("employee",employee);
        return "emp-update";
    }
    /**@author yu
     * @version 1.0
     * @Date 2017/5/31
     * 修改职工
     */
    @RequestMapping(value = "emp/update",method = RequestMethod.POST)
    public String update(Employee employee, @RequestParam("file") MultipartFile file,
                      HttpServletRequest request,String enterDate ,String overDate) throws IOException, ParseException {
        //获取webapp的物理路劲
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path="";
        System.out.println("文件上传");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date eDate = sdf.parse(enterDate);
        Date oDate = sdf.parse(overDate);
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            System.out.println(contentType);
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/static/images/"+uuid+".jpg";
            employee.setPhoto(path);
            file.transferTo(new File(pathRoot+path));
        }
        employee.setEnterDate(eDate);
        employee.setOverDate(oDate);
        System.out.println(employee);
        employeeService.update(employee);
        return "index";
    }
}




