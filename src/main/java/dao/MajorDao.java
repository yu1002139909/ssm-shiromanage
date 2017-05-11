package dao;

import entity.Major;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/1 16:41
 */
public interface MajorDao {
 public List<Major> getAll(String name);
 public void add(Major major);
 public void delete(int major_id);
 public void update(Major major);
 public  Major findByid(int major_id);
}
