package ManyToManyMapper.mapper;

import ManyToManyMapper.po.User;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public interface UserMapper {
    User selectUserById(int id);
}
