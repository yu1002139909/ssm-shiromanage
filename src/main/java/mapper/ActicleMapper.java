package mapper;

import entity.Acticle;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/4 18:46
 */
public interface ActicleMapper {
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
    void delele(BigInteger id);

    /**
     * 根据星排行
     */
    List<Acticle> startnum();
    /**
     * 根据星排行
     */
    Acticle startamx();
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
    public List<Acticle> findByUserIdForword(BigInteger id);
    /**
     * 根据标题查询
     * @param title
     * @return
     */
    public List<Acticle> selectActicle(@Param("title")String title);
    /**
     *修改文章状态
     */
    void updateState(Acticle id);


    /**
     * 查询用户的分享记录
     * @param id
     * @return
     */
    List<Acticle> forwardList(BigInteger id);
}
