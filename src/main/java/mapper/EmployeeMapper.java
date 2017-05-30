package mapper;

import entity.Employee;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/26 19:03
 */
public interface EmployeeMapper {
    public List<Employee> getall();
    public void add(Employee employee);
    public void delete(String employeeId);
    public void update(Employee employee);
    public Employee findById(String employeeId);
    public List<Employee> findbyEmployeeByDepeId(String deptId);
}
