package service;

import entity.Leader;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/6/3 15:10
 */
public interface LeaderService {

    public List<Leader> getall();
    public void add(Leader leader);
    public void delete(String id);
    public void update(Leader leader);
    public Leader findById(String id);
    public List<Leader> findByPosition(String state);
}
