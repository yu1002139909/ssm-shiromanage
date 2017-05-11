package service.impl;

import entity.Grade;
import mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GradeService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/8 18:16
 */
@Service
public class GradeServiceImpl implements GradeService{
    @Autowired
    private GradeMapper gradeMapper;

    public void setGradeMapper(GradeMapper gradeMapper) {
        this.gradeMapper = gradeMapper;
    }

    public List<Grade> getall() {
        return gradeMapper.getall();
    }

    public void add(Grade grade){
        gradeMapper.add(grade);
    }

    public void delete(String grade_id) {
       gradeMapper.delete(grade_id);
    }

    public void update(Grade grade) {
     gradeMapper.update(grade);
    }

    public Grade findById(String grade_id) {
        return gradeMapper.findById(grade_id);
    }

    public List<Grade> findbyGradeMapperByMajorId(String gmajor_id) {
        return gradeMapper.findbyGradeMapperByMajorId(gmajor_id);
    }
}
