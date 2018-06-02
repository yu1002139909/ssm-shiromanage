package mapper;

import entity.Star;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/7 20:05
 */
public interface StarMapper {

    /**
     * 获取用户点赞记录
     * @return
     */
    List<Star> getUserStar(Star star);

    /**
     * 新增点赞
     * @param share
     */
    void add(Star star);

    /**
     * 获取用户所有点赞记录
     * @param
     * @return
     */
    List<Star> getAll(Star star);

    List<Star> findByActicleId(BigInteger ActicleId);

}
