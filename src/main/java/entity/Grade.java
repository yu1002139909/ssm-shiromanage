package entity;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/1 16:12
 */
public class Grade {
    private String grade_id;
    private String grade_name;
    private Major major;
    private  String photo;
    private String year;
    private String gmajor_id;

    public String getGmajor_id() {
        return gmajor_id;
    }

    public void setGmajor_id(String gmajor_id) {
        this.gmajor_id = gmajor_id;
    }

    private List<Student> studentList;

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getGrade_id() {
        return grade_id;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public Major getMajor() {
        return major;
    }

    public String getPhoto() {
        return photo;
    }

    public String getYear() {
        return year;
    }
}
