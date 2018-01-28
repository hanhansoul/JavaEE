package bak.model;

import bak.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public interface UserDao {

    User selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password);

    User selectById(Integer id);

    void deleteById(Integer id);

    void update(User user);

    List<User> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    void save(User user);

}
