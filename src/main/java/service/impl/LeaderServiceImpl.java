package service.impl;

import entity.Leader;
import mapper.LeaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LeaderService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/6/3 15:11
 */
@Service
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    LeaderMapper leaderMapper;
    public List<Leader> getall() {
        return leaderMapper.getall();
    }

    public void add(Leader leader) {
              leaderMapper.add(leader);
    }

    public void delete(String id) {
              leaderMapper.delete(id);
    }

    public void update(Leader leader) {
              leaderMapper.update(leader);
    }

    public Leader findById(String id) {
        return leaderMapper.findById(id);
    }

    public List<Leader> findByPosition(String state) {
        return leaderMapper.findByPosition(state);
    }
}
