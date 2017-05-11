package entity;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/1 16:10
 */
public class Student {
    private String id;
    private String tel;
    private String name;
    private String photo;
    private String qq;
    private String company;
    private Grade grade;
    private Course course;
    private String scourse_id;
    private String sgrade_id;
    private Major major;

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getScourse_id() {
        return scourse_id;
    }

    public void setScourse_id(String scourse_id) {
        this.scourse_id = scourse_id;
    }

    public String getsgrade_id() {
        return sgrade_id;
    }

    public void setsgrade_id(String sgrade_id) {
        this.sgrade_id = sgrade_id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
