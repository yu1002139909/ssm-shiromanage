package mapper;

import entity.Img;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/4 17:09
 */
public interface ImgMapper {
    /**
     * 获取所有图片
     * @return
     */
    List<Img> getAll();

    /**
     * 新增
     * @param img
     */
    void add(Img img);

    /**
     *
     * @param id
     * @return
     */
    List<Img> findById(BigInteger id);

    /**
     * 星星排行
     */
     List<Img> starnum();

    /**
     *
     */
    List<Img> imglist();

    /**
     * 删除图片
     * @param id
     */
    void delele(BigInteger id);
}
