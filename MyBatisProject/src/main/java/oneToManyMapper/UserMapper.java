package oneToManyMapper;

import po.User;

import java.util.List;

/**
 * Created by Administrator on 2017/4/23.
 */
interface UserMapper {
    public User selectUserWithLessonById(int id);

}
