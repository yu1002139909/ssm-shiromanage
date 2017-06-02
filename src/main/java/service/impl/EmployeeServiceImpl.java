package service.impl;

import entity.Employee;
import mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.EmployeeService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/31 10:57
 *emp实现类
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getall() {
        return employeeMapper.getall();
    }

    public void add(Employee employee) {
        employeeMapper.add(employee);
    }

    public void delete(String employeeId) {
        employeeMapper.delete(employeeId);
    }

    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    public Employee findById(String employeeId) {
        return employeeMapper.findById(employeeId);
    }

    public List<Employee> findbyEmployeeByDepeId(String deptId) {
        return employeeMapper.findbyEmployeeByDepeId(deptId);
    }
}
