package mapper;

import entity.Major;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/4 17:46
 */
public interface MajorMapper {
    public void add(Major major);
    public List<Major> getAll();
    public void delete(String major_id);
    public Major findById(String major_id);
    public void update(Major major);
    public  List<Major> findbymajorByCouserId(String couser_Id);
}
