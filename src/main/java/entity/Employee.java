package entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/26 18:52
 */
public class Employee {
    private String empId; //职工id
    private String empName;//职工姓名
    private String empGrade;//职工性别
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date  enterDate; //开始工作时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date  overDate;//结束工作时间
    private Dept enterDept; //开始工作部门
    private String enterDeptId;//开始工作部门id
    private String overDeptId;//退休部门id或当前部门id
    private Dept overDept;  //退休部门或当前部门
    private String photo;//照片
    private String state;//是否退休

    public String getEnterDeptId() {
        return enterDeptId;
    }

    public void setEnterDeptId(String enterDeptId) {
        this.enterDeptId = enterDeptId;
    }

    public String getOverDeptId() {
        return overDeptId;
    }

    public void setOverDeptId(String overDeptId) {
        this.overDeptId = overDeptId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpGrade() {
        return empGrade;
    }

    public void setEmpGrade(String empGrade) {
        this.empGrade = empGrade;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    public Dept getEnterDept() {
        return enterDept;
    }

    public void setEnterDept(Dept enterDept) {
        this.enterDept = enterDept;
    }

    public Dept getOverDept() {
        return overDept;
    }

    public void setOverDept(Dept overDept) {
        this.overDept = overDept;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empGrade='" + empGrade + '\'' +
                ", enterDate=" + enterDate +
                ", overDate=" + overDate +
                ", enterDept=" + enterDept +
                ", enterDeptId='" + enterDeptId + '\'' +
                ", overDeptId='" + overDeptId + '\'' +
                ", overDept=" + overDept +
                ", photo='" + photo + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
