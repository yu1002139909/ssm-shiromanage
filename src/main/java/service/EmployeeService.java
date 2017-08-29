package service;

import entity.Employee;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/31 10:57
 */
public interface EmployeeService {
    public List<Employee> getall();
    public void add(Employee employee);
    public void delete(String employeeId);
    public void update(Employee employee);
    public Employee findById(String employeeId);
    public List<Employee> findbyEmployeeByDepeId(String deptId);

    void exportExcel(List<Employee> employeeList, ServletOutputStream outputStream);
}
