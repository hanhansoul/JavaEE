package dao;

import model.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    List<Dept> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    List<Dept> selectAllDept();

    Dept selectById(Integer id);

    void deleteById(Integer id);

    void save(Dept dept);

    void update(Dept dept);
}