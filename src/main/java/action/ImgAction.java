package action;

import entity.Img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ImgService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/7 13:05
 */
@Controller
public class ImgAction {

    @Autowired
    ImgService imgService;

    @RequestMapping(value = "imglist",method = RequestMethod.GET)
    public String  imglist(Model model){
        List<Img> all = imgService.imglist();
        model.addAttribute("imglist",all);
        System.out.println("aasd");
        return "gallery";
    }
    @RequestMapping(value = "deleteImg",method = RequestMethod.GET)
    @ResponseBody
    public String  deleteImg(BigInteger id){
        imgService.delele(id);
        return "success";
    }
}
