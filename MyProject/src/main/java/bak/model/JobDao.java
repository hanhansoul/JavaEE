package bak.model;

import bak.domain.Job;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public interface JobDao {

    Job selectById(int id);

    List<Job> selectAllJob();

    List<Job> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    void deleteById(Integer id);

    void save(Job job);

    void update(Job job);
}
