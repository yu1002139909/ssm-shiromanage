package service.impl;

import entity.Major;
import mapper.MajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MajorServlice;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/4 21:10
 */
@Service
public class MajorServiceImpl implements MajorServlice {
    @Autowired
    private MajorMapper majorMapper;

    public void setMajorMapper(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    public void add(Major major) {
          majorMapper.add(major);
    }

    public List<Major> getAll() {
        return majorMapper.getAll();
    }

    public void delete(String major_id) {
         majorMapper.delete(major_id);
    }

    public Major findById(String major_id) {
        return majorMapper.findById(major_id);
    }

    public void update(Major major) {
       majorMapper.update(major);
    }

    public List<Major> findbymajorByCouserId(String couser_Id) {
        return majorMapper.findbymajorByCouserId(couser_Id);
    }
}
