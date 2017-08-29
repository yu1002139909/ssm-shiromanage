import entity.Employee;
import mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/31 10:32
 */
public class EmpTest  {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    // 从spring容器中获取mapper代理对象
    EmployeeMapper employeeMapper = context.getBean(EmployeeMapper.class);

    /**@author yu
     * @version 1.0
     * @Date 2017/5/31
     *增加emp测试
     *
     */
    @Test
    public void add(){
        Employee employee = new Employee();
        employee.setOverDeptId("47f4b17b935f1035993062d817e7418e");
        employee.setState("在职");
        employee.setPhoto("");
        employee.setEnterDeptId("47f4b17b935f1035993062d817e7418e");
        employee.setOverDate(new Date());
        employee.setEmpName("张三"+221);
        employee.setEnterDate(new Date());
        employee.setEmpGrade("男");
        employeeMapper.add(employee);
    }
    /*@author yu
     * @version 1.0
     * @Date 2017/5/31
     *获取所有emp
     */
    @Test
    public void  getall(){
        List<Employee> employeeList = employeeMapper.getall();
        for (int i = 0;i<employeeList.size();i++){
            System.out.println(employeeList.get(i).getEmpName());
        }
    }
    /*@author yu
     * @version 1.0
     * @Date 2017/5/31
     *根据当前或退休部门获取员工
     */
    @Test
    public void  findEmpByNowDeptId(){
        List<Employee> employeeList = employeeMapper.findbyEmployeeByDepeId("47f4b17b935f1035993062d817e7418e");
        for (Employee employee:employeeList){
            System.out.println(employee.getEnterDept()+" "+employee.getOverDept());
        }
    }
    @Test
    public void  findById(){
        Employee employee = employeeMapper.findById("b7cdb76b97d01035ad79b37223574b71");
        System.out.println(employee.getOverDept()+" ："+employee.getEnterDept());
    }
}
