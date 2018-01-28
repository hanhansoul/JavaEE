package bak.model;

import bak.domain.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public interface EmployeeDao {

    Integer count(Map<String, Object> params);

    List<Employee> selectByPage(Map<String, Object> params);

    void save(Employee employee);

    void deleteById(Integer id);

    Employee selectById(Integer id);

    void update(Employee employee);
}
