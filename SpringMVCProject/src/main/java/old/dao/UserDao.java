package old.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import old.po.Department;
import old.po.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/1.
 */

@Repository
public class UserDao {
    private static Map<Integer, User> users = null;
    private static Integer id;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        users = new HashMap<Integer, User>();
        id = 1005;
        users.put(1001, new User(1001, "A", 10, 1, "aa@163.com", "123", new Department(101, "D-AA")));
        users.put(1002, new User(1002, "B", 11, 0, "bb@163.com", "123", new Department(102, "D-BB")));
        users.put(1003, new User(1003, "C", 12, 1, "cc@163.com", "123", new Department(103, "D-CC")));
        users.put(1004, new User(1004, "D", 13, 0, "dd@163.com", "123", new Department(104, "D-DD")));
        users.put(1005, new User(1005, "E", 14, 1, "ee@163.com", "123", new Department(105, "D-EE")));
    }

    public void save(User user) {
        if (user.getId() == null) {
            user.setId(++id);
        }
        user.setDepartment(departmentDao.getDepartmentById(user.getDepartment().getId()));
        users.put(user.getId(), user);
    }

    public Collection<User> getAll() {
        return users.values();
    }

    public User getUser(Integer id) {
        return users.get(id);
    }

    public void deleteUser(Integer id) {
        users.remove(id);
    }
}
