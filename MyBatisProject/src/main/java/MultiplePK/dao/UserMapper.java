package MultiplePK.dao;

import MultiplePK.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}