package action;

import entity.Comment;
import entity.LyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;
import util.OrderUtil;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/5 20:07
 */
@Controller
public class CommentAction {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    @ResponseBody
    public  String add(BigInteger acticleId,String content, HttpServletRequest request){
        LyUser userInfo = (LyUser) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/";
        }
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser_id(userInfo.getId());
        comment.setDate(new Date(System.currentTimeMillis()));
        comment.setArtcle_id(acticleId);
        comment.setId(new BigInteger(OrderUtil.getOrderNumber("10")));
        commentService.add(comment);
        return "suecces";
    }

    /**
     * 登录用户的评论
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "myCommentList",method = RequestMethod.GET)
    public  String commentList(Model model,HttpServletRequest request){
        LyUser userInfo = (LyUser)request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/";
        }
        List<Comment> commentList = commentService.findByUserComment(userInfo.getId());
        model.addAttribute("commentList",commentList);
        return "feedback-list";
    }
    /**
     * 所有评论
     * @param model
     * @param
     * @return
     */
    @RequestMapping(value = "commentList",method = RequestMethod.GET)
    public  String commentList(Model model){
        List<Comment> commentList = commentService.getAll();
        model.addAttribute("commentList",commentList);
        return "feedback-list";
    }

    /**
     * 删除评论
     * @return
     */
    @RequestMapping(value = "deletecomment",method = RequestMethod.GET)
    @ResponseBody
    public String deleteComment(BigInteger id){
        commentService.delete(id);
        return "success";
    }

    /**
     * 修改评论
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "updateCommentUi",method = RequestMethod.GET)
    public String updateUi(Model model,BigInteger id){
        Comment comment = commentService.findById(id);
        model.addAttribute("comment",comment);
        return "comment-update";
    }

    @RequestMapping(value = "updateComment",method = RequestMethod.POST)
    @ResponseBody
    public String updateComment(Comment comment){
        commentService.update(comment);
        return "success";
    }

    /**
     * 删除评论
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteComment",method = RequestMethod.GET)
    @ResponseBody
    public String deleteCOmment(BigInteger id){
        commentService.delete(id);
        return "success";
    }
}
