package entity;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/26 18:51
 */
public class Dept {
    private String deptId; //部门id

    private String deptName; //部门名称

    private List<Employee> employeeList;//部门下的员工

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
