package action;

import entity.Leader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.LeaderService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/6/3 15:12
 */
@Controller
public class LeaderAction {
    @Autowired
    LeaderService leaderService;

   @RequestMapping(value = "leader/job")
    public String job(Model model,String state){
       List<Leader> leaderList = new ArrayList<Leader>();
       if (state.equals("true")){
           System.out.println("在职");
           leaderList = leaderService.findByPosition("在职");
       }
       else if(state.equals("false")){
           System.out.println("退休");
           leaderList = leaderService.findByPosition("退休");
       }
       model.addAttribute("leaderList",leaderList);
       return "leader-list";
   }
    @RequestMapping(value = "leader/add",method = RequestMethod.POST)
    public String add(Leader leader, @RequestParam("file") MultipartFile file,
                      HttpServletRequest request, String endate,String nodate) throws IOException, ParseException {
        //获取webapp的物理路劲
        System.out.println("简介");
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path="";
        System.out.println("文件上传");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date eDate = sdf.parse(endate);
        Date oDate = sdf.parse(nodate);
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            System.out.println(contentType);
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/static/images/"+uuid+".jpg";
            leader.setPhoto(path);
            file.transferTo(new File(pathRoot+path));
        }
        leader.setEnterDate(eDate);
        leader.setNowDate(oDate);
        leaderService.add(leader);
        return "index";
    }

    /**@author yu
     * @version 1.0
     * @Date 2017/6/3
     * 进入修改界面
     */
      @RequestMapping(value = "leader/updateUi")
      public String updateUi(Model model,String id){
          Leader leader = leaderService.findById(id);
          model.addAttribute("leader",leader);
          return "leader-update";
      }
      /**@author yu
       * @version 1.0
       * @Date 2017/6/3
       *修改领导信息
       */
      @RequestMapping(value = "leader/update",method = RequestMethod.POST)
      public String update(Leader leader, @RequestParam("file") MultipartFile file,
                        HttpServletRequest request, String endate,String nodate) throws IOException, ParseException {
          //获取webapp的物理路劲
          System.out.println("简介");
          String pathRoot = request.getSession().getServletContext().getRealPath("");
          String path="";
          System.out.println("文件上传");
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          Date eDate = sdf.parse(endate);
          Date oDate = sdf.parse(nodate);
          if(!file.isEmpty()){
              //生成uuid作为文件名称
              String uuid = UUID.randomUUID().toString().replaceAll("-","");
              //获得文件类型（可以判断如果不是图片，禁止上传）
              String contentType=file.getContentType();
              //获得文件后缀名称
              System.out.println(contentType);
              String imageName=contentType.substring(contentType.indexOf("/")+1);
              path="/static/images/"+uuid+".jpg";
              leader.setPhoto(path);
              file.transferTo(new File(pathRoot+path));
          }
          leader.setEnterDate(eDate);
          leader.setNowDate(oDate);
          leaderService.update(leader);
          return "index";
      }

}
