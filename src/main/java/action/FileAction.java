package action;

import entity.Picture;
import mapper.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/6/4 12:41
 */
@Controller
public class FileAction {
    @Autowired
    PictureMapper pictureMapper;


    //获取所有图片
    @RequestMapping(value = "pic/getAll")
    public String getAll(Model model){
        List<Picture> pictureList = pictureMapper.getall();
        model.addAttribute("pictureList",pictureList);
        return "picture-show";
    }

    @RequestMapping(value = "/upload2")
    public String upload2(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, IOException {
        //创建一个通用的多部分解析器
        System.out.println("请求成功");
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path="";
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        Picture picture = new Picture();
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = "demoUpload" + file.getOriginalFilename();
                        //定义上传路径
                         path = "/static/images/" + fileName;
                         file.transferTo(new File(pathRoot+path));
                         picture.setSrc(path);
                         pictureMapper.add(picture);
                        System.out.println("上传成功");
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }

        }
        return "index";
    }

    @RequestMapping("/toUpload" )
    public String toUpload() {
        return "/upload";
    }

}

