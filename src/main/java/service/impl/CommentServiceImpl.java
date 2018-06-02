package service.impl;

import entity.Acticle;
import entity.Comment;
import entity.LyUser;
import mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ActicleService;
import service.CommentService;
import service.LyUserService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/5 20:06
 */
@Service
public class CommentServiceImpl  implements CommentService {


    @Autowired
    CommentMapper commentMapper;
    @Autowired
    LyUserService lyUserService;
    @Autowired
    ActicleService acticleService;
    /**
     * 新增评论
     *
     * @param comment
     */
    @Override
    public void add(Comment comment) {
         commentMapper.add(comment);
    }

    /**
     * 获取所有评论
     *
     * @return
     */
    @Override
    public List<Comment> getAll() {
        List<Comment> comments = commentMapper.getAll();
        List<Comment> commentList = new ArrayList<Comment>();
        for (Comment comment :comments){
            Acticle acticle = acticleService.findById(comment.getArtcle_id());
            if(acticle!=null){
                comment.setActicle(acticle);
            }
            LyUser lyUser = lyUserService.findById(comment.getUser_id());
            comment.setLyUser(lyUser);
            commentList.add(comment);
        }
        return commentList;
    }

    /**
     * 删除评论
     *
     * @param id
     */
    @Override
    public void delete(BigInteger id) {
        commentMapper.delete(id);
    }

    /**
     * 修改评论
     *
     * @param comment
     */
    @Override
    public void update(Comment comment) {
        commentMapper.update(comment);
    }

    /**
     * 根据文章id查询
     *
     * @param id
     * @return
     */
    @Override
    public List<Comment> findByActicleId(BigInteger id) {
        List<Comment> comments = new ArrayList<Comment>();
        List<Comment> commentList = commentMapper.findByActicleId(id);
        for (Comment comment :commentList){
            LyUser lyUser = lyUserService.findById(comment.getUser_id());
            comment.setLyUser(lyUser);
            comments.add(comment);
        }
        return comments;
    }

    /**
     * 查询用户发出的评论
     *
     * @param id
     * @return
     */
    @Override
    public List<Comment> findByUserComment(BigInteger id) {
        List<Comment> comments = commentMapper.findByUserComment(id);
        List<Comment> commentList = new ArrayList<Comment>();
        for (Comment comment :comments){
            Acticle acticle = acticleService.findById(comment.getArtcle_id());
            LyUser lyUser = lyUserService.findById(comment.getUser_id());
            comment.setLyUser(lyUser);
            comment.setActicle(acticle);
            commentList.add(comment);
        }
        return commentList;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Comment findById(BigInteger id) {
        return commentMapper.findById(id);
    }

}
