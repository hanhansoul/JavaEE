package dao;

import model.Job;

import java.util.List;
import java.util.Map;

public interface JobMapper {

    Job selectById(int id);

    List<Job> selectAllJob();

    List<Job> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    void deleteById(Integer id);

    void save(Job job);

    void update(Job job);
}