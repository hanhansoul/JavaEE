package bak.model;

import bak.domain.Dept;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public interface DeptDao {

    List<Dept> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    List<Dept> selectAllDept();

    Dept selectById(Integer id);

    void deleteById(Integer id);

    void save(Dept dept);

    void update(Dept dept);
}
