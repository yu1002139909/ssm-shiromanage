package mapper;

import entity.Dept;
import entity.Employee;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/4 11:09
 */
public interface DeptMapper {
    public List<Dept> getall();
    public void add(Dept dept);
    public void delete(String deptId);
    public void update(Dept dept);
    public Employee findById(String deptId);
}
