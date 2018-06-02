package service.impl;

import entity.Img;
import mapper.ImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ImgService;
import util.OrderUtil;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/5 12:01
 */
@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    ImgMapper imgMapper;

    /**
     * 获取所有图片
     *
     * @return
     */
    @Override
    public List<Img> getAll() {
        return imgMapper.getAll();
    }

    /**
     * 新增
     *
     * @param img
     */
    @Override
    public void add(Img img) {
            img.setId(new BigInteger(OrderUtil.getOrderNumber("10")));
            imgMapper.add(img);
    }

    /**
     * 根据文章id获取
     *
     * @param id
     */
    @Override
    public List<Img> findByActicle(BigInteger id) {
        return imgMapper.findById(id);
    }

    /**
     * 星星排行
     */
    @Override
    public List<Img> starnum() {
        return imgMapper.starnum();
    }

    /**
     *
     */
    @Override
    public List<Img> imglist() {
        return imgMapper.imglist();
    }

    /**
     * 删除图片
     *
     * @param id
     */
    @Override
    public void delele(BigInteger id) {
            imgMapper.delele(id);
    }
}
