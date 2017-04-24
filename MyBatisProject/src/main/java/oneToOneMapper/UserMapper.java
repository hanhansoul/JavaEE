package oneToOneMapper;

import po.User;

/**
 * Created by Administrator on 2017/4/23.
 */
public interface UserMapper {
    public User selectUserWithCarById(int id);

}
