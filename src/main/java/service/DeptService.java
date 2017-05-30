package service;

import entity.Dept;
import entity.Employee;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/29 20:40
 */

public interface DeptService {
    public List<Dept> getall();
    public void add(Dept dept);
    public void delete(String deptId);
    public void update(Dept dept);
    public Employee findById(String deptId);
}
