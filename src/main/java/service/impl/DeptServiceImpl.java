package service.impl;

import entity.Dept;
import entity.Employee;
import mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DeptService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/29 21:32
 */
@Service
public class DeptServiceImpl implements DeptService {

    //注入deptMapper
    @Autowired
    DeptMapper deptMapper;

    public List<Dept> getall() {
        return deptMapper.getall();
    }

    public void add(Dept dept) {
               deptMapper.add(dept);
    }

    public void delete(String deptId) {
               deptMapper.delete(deptId);
    }

    public void update(Dept dept) {
               deptMapper.update(dept);
    }

    public Employee findById(String deptId) {
        return deptMapper.findById(deptId);
    }
}
