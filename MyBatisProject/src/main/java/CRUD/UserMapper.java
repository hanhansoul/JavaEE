package CRUD;

import po.User;

import java.util.List;

/**
 * Created by Administrator on 2017/4/23.
 */
public interface UserMapper {
    User selectUserById(int id);

    List<User> selectUserByName(String username);

    void insertUser(User user);

    void updateUserById(User user);
}
