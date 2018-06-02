package service;

import entity.Acticle;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/4 20:09
 */
public interface ActicleService {

    /**
     * 新增文章
     * @param acticle
     */
    void add(Acticle acticle);

    /**
     * 查询所有文章
     * @return
     */
    List<Acticle> getAll();

    /**
     * 查询所有文章
     * @return
     */
    List<Acticle> getMyAll(BigInteger id);

    /**
     * 修改文章
     * @param acticle
     */
    void update(Acticle acticle);

    /**
     * 删除文章
     * @param id
     */
    void delele(java.math.BigInteger id);

    /**
     * 根据星星排行
     */
    List<Acticle> startnum();

    /**
     * 根据星星排行
     */
    Acticle startmax();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Acticle findById(BigInteger id);
    /**
     * 根据用户id查询所有的文章
     * @param id
     * @return
     */
    List<Acticle> findByUserId(BigInteger id);
    /**
     * 查询该用户转发的内容
     * @param id
     * @return
     */
     List<Acticle> findByUserIdForword(BigInteger id);

    /**
     * 根据标题查询
     * @param title
     * @return
     */
     List<Acticle> selectActicle(String title);

    /**
     *修改文章状态
     */
     void updateState(Acticle acticle);

    /**
     * 查询用户的分享记录
     * @param acticle_id
     * @return
     */
     List<Acticle> forwardList(BigInteger user_id,BigInteger acticle_id);

    /**
     * 查询用户的分享记录
     * @param user_id
     * @return
     */
    List<Acticle> forwardUserList(BigInteger user_id);
}
