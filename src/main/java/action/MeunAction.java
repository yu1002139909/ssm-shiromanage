package action;

import entity.Muen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/2 15:15
 */
@Controller
public class MeunAction {
    @RequestMapping("/page/muen.action")
    public @ResponseBody
    Muen major(HttpServletResponse response)throws Exception{
        Muen muen = new Muen();
        muen.setId("6");
        muen.setName("测试");
        muen.setParentId("3");
        muen.setUrl("");
        muen.setIcon("");
        muen.setOrder("1");
        muen.setIsHeader("0");
        muen.setChildMenus("");
        return  muen  ;

  }
  @RequestMapping(value = "test.action")
    public String test(HttpServletResponse response, String major_name) throws Exception{
      System.out.println("ajax请求");
      System.out.println(major_name);
      SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String string = sdf.format(new Date());
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter pw = response.getWriter();
       pw.write(string);
       pw.flush();
       pw.close();
       return null;
  }
}
