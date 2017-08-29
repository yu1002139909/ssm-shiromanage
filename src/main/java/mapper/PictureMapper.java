package mapper;

import entity.Course;
import entity.Picture;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/4 11:09
 */
public interface PictureMapper {
    public List<Picture> getall();
    public void add(Picture picture);
    public void delete(String id);
    public void update(Picture picture);
    public Picture findById(String id);
}
