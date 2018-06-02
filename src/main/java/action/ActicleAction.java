package action;

import com.alibaba.fastjson.JSON;
import emuns.ResultEnum;
import entity.*;
import exceptin.SellException;
import mapper.ShareMapper;
import mapper.StarMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import service.ActicleService;
import service.ImgService;
import util.OrderUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/4 20:06
 */
@Controller
public class ActicleAction {

    @Autowired
    ActicleService acticleService;
    @Autowired
    ImgService imgService;
    List<Img> imgList = new ArrayList<Img>();
    @Autowired
    ShareMapper shareMapper;

    @Autowired
    StarMapper starMapper;

    @RequestMapping(value = "acticleList")
    public String list(Model model){
        List<Acticle> all = acticleService.getAll();
        int num  = all.size();
        model.addAttribute("acticleList",all);
        model.addAttribute("num",num);
        System.out.println("你好");
        return "product-list";
    }


    @RequestMapping(value = "myacticleList")
    public String mylist(Model model,HttpServletRequest request){
        LyUser userInfo = (LyUser)request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "login";
        }

        List<Acticle> all = acticleService.getMyAll(userInfo.getId());
        int num  = all.size();
        model.addAttribute("acticleList",all);
        model.addAttribute("num",num);
        return "myproduct-list";
    }

    @RequestMapping(value = "indexui")
    public String index(Model model){
        List<Img> imgList = imgService.starnum();
        List<Acticle> all = acticleService.startnum();
        Acticle acticle = acticleService.startmax();
        int num  = all.size();
        model.addAttribute("acticleList",all);
        model.addAttribute("num",num);
        model.addAttribute("imgs",imgList);
        model.addAttribute("acticle",acticle);
        return "indexui";
    }
    @RequestMapping(value = "acticle/add",method = RequestMethod.POST)
    public String add(Acticle acticle,HttpServletRequest request,Model model) throws IOException {
        LyUser userInfo = (LyUser)request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "login";
        }
        String orderNumber = OrderUtil.getOrderNumber("10");
        acticle.setId(new BigInteger(orderNumber));
        for (Img img:imgList){
            img.setActicle_id(new BigInteger(orderNumber));
            imgService.add(img);
        }
        //百度api
        String url  = "http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location="+acticle.getWd()+","+acticle.getJd()+"&output=json&pois=1&ak=2yzaejuxHacVcruOaB9fmO3jodgWmAuU";

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request1 = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request1).execute();
        String string = response.body().string();
        String substring = string.substring(29,string.length()-1);
        Adress adress= JSON.parseObject(substring, Adress.class);
        acticle.setAddress(adress.getResult().getFormatted_address());
        acticle.setUser_id(userInfo.getId());
        acticle.setStar(0);
        acticle.setUser_id(userInfo.getId());
        acticleService.add(acticle);
        imgList = new ArrayList<Img>();
        return "index";
    }
    @RequestMapping(value = "activle/activlebyid",method = RequestMethod.GET)
    public  String findbyId(String id,Model model){
        Acticle acticle = acticleService.findById(new BigInteger(id));
        List<Acticle> acticleList = acticleService.findByUserId(acticle.getUser_id());
        model.addAttribute("acticle",acticle);
        model.addAttribute("acticleList",acticleList);

        return "single";
    }

    /**
     * 上传图片
     * @param request
     * @param response
     * @return
     * @throws IllegalStateException
     * @throws IOException
     * @throws IOException
     */
    @RequestMapping(value = "/imgupload")
    public String upload2(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, IOException {
        //创建一个通用的多部分解析器
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
                        Img img = new Img();
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = "demoUpload" + file.getOriginalFilename();
                        //定义上传路径
                        path = "/static/images/" + fileName;
                        file.transferTo(new File(pathRoot+path));
                        img.setUrl(path);
                        imgList.add(img);
                    //    pictureMapper.add(picture);
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }

        }
        return "index";
    }
    @RequestMapping(value = "forward",method = RequestMethod.GET)
    @ResponseBody
    public String forward(BigInteger id,HttpServletRequest request){

        List<Img> imgs = imgService.findByActicle(id);

        LyUser userInfo = (LyUser)request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "login";
        }
        //查询出转发的文章
        List<Acticle> acticleList = acticleService.forwardList(userInfo.getId(),id);
        //遍历

        if(acticleList.size()>0){
            throw  new SecurityException("您已经转发过了！");
        }
        Share share = new Share();
        share.setActicle_id(id);
        share.setUser_id(userInfo.getId());
        shareMapper.addShare(share);
        return "转发成功";
    }

    /**
     * 查转发的文章
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "userforward",method = RequestMethod.GET)
    public  String forwardList(BigInteger id,Model model){

        List<Acticle> acticleList = acticleService.findByUserIdForword(id);

        model.addAttribute("acticleList",acticleList);
        return "product-list";
    }

    @RequestMapping(value = "selectacticle")
    public String selectlist(String title,Model model) throws UnsupportedEncodingException {
        String param = new String(title.getBytes("ISO8859-1"), "UTF-8");
        List<Acticle> all = acticleService.selectActicle(param);
        int num  = all.size();
        model.addAttribute("acticleList",all);
        model.addAttribute("num",num);
        return "product-list";
    }

    /**
     * 修改文章状态
     * @param acticle
     * @return
     */
    @RequestMapping(value = "updateActicleState" ,method = RequestMethod.GET)
    @ResponseBody
    public String updateState(Acticle acticle){
        acticleService.updateState(acticle);
        return  "succes";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteact",method = RequestMethod.GET)
    @ResponseBody
    public String deleteActicle(BigInteger id){
        acticleService.delele(id);
        return "succes";
    }

    /**
     * 分享记录
     * @param model
     * @return
     */
    @RequestMapping(value = "forwardlist")
    public String forward(Model model,HttpServletRequest request){
        LyUser userInfo = (LyUser)request.getSession().getAttribute("userInfo");
         // List<Acticle> all = acticleService.forwardList(userInfo.getId());
        //int num  = all.size();
        //model.addAttribute("acticleList",all);
        //model.addAttribute("num",num);
        List<Acticle> acticleList = acticleService.forwardUserList(userInfo.getId());
        model.addAttribute("acticleList",acticleList);
        return "product-list";
    }

    @RequestMapping(value = "addStar",method = RequestMethod.GET)
    public   @ResponseBody String addStare(BigInteger id,HttpServletRequest request){
        Acticle acticle = acticleService.findById(id);
        LyUser userInfo = (LyUser)request.getSession().getAttribute("userInfo");
        Star star = new Star();
        if(userInfo==null){
           throw  new SellException(ResultEnum.valueOf("失败"));
        }

        star.setActicle_id(id);
        star.setUser_id(userInfo.getId());
        List<Star> all = starMapper.getUserStar(star);

        if(all.size()>0){
            throw  new SecurityException("您已经点过赞了");
        }
        Integer star1 = acticle.getStar();
        star1++;
        acticle.setStar(star1);
        acticleService.update(acticle);
        starMapper.add(star);
        return "点赞成功";
    }
    @RequestMapping(value = "blogList")
    public String blogList(Model model){
        List<Img> imgList = imgService.starnum();
        List<Acticle> all = acticleService.startnum();
        Acticle acticle = acticleService.startmax();
        int num  = all.size();
        model.addAttribute("acticleList",all);
        model.addAttribute("num",num);
        model.addAttribute("imgs",imgList);
        model.addAttribute("acticle",acticle);
        return "blog";
    }


    /**
     * 修改图片ui界面
     * @param id
     * @return
     */
    @RequestMapping(value = "acticleUi",method = RequestMethod.GET)
    public String updateActicleUi(BigInteger id,Model model){

        Acticle acticle = acticleService.findById(id);
        model.addAttribute("acticle",acticle);
        return "acticle-update";
    }

    @RequestMapping(value = "updateActicle",method = RequestMethod.POST)
    @ResponseBody
    public String updateActicle(Acticle acticle){
        for (Img img:imgList){
            img.setActicle_id(acticle.getId());
            imgService.add(img);
        }
        imgList = new ArrayList<Img>();
        acticleService.update(acticle);
        return "success";
    }
}
