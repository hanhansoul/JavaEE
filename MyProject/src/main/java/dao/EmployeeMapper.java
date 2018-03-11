package dao;

import model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Integer count(Employee employee);

    List<Employee> selectByPage(Map<String, Object> params);

    void save(Employee employee);

    void deleteById(Integer id);

    Employee selectById(Integer id);

    void update(Employee employee);
}