package mapper;

import entity.Comment;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/4 19:10
 */
public interface CommentMapper {
    /**
     * 新增评论
     * @param comment
     */
    void add(Comment comment);

    /**
     * 获取所有评论
     * @return
     */
    List<Comment> getAll();

    /**
     * 删除评论
     * @param id
     */
    void delete(BigInteger id);

    /**
     * 修改评论
     * @param comment
     */
    void update(Comment comment);

    /**
     * 根据文章id查询
     * @param id
     * @return
     */
    List<Comment> findByActicleId(BigInteger id);

    /**
     * 查询用户发出的评论
     * @param id
     * @return
     */
    List<Comment> findByUserComment(BigInteger id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Comment findById(BigInteger id);
}
