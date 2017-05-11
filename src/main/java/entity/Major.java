package entity;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/1 16:15
 */
public class Major {
    private String mcourse_id;
    private String major_Id;
    private String major_name;
    private Course course;
    private List<Grade> gradeList;

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }


    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    public String getMcourse_id() {
        return mcourse_id;
    }

    public void setMcourse_id(String mcourse_id) {
        this.mcourse_id = mcourse_id;
    }
    public String getMajor_id() {
        return major_Id;
    }

    public void setMajor_id(String major_id) {
        this.major_Id = major_id;
    }
}
