package Annotation.DMLExample.mapper;

import Annotation.DMLExample.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public interface UserMapper {
    @Insert("INSERT INTO tb_user_info (name, sex, age) VALUES (#{name}, #{sex}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveUser(User user);

    @Delete("DELETE FROM tb_user_info where id = #{id}")
    int removeUser(@Param("id") Integer id);

    @Update("UPDATE tb_user_info SET name = #{name}, sex = #{sex}, age = #{age} where id = #{id}")
    void modifyUser(User user);

    @Select("SELECT * FROM tb_user_info where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age")})
    User selectUserById(int id);

    @Select("SELECT * FROM tb_user_info")
    List<User> selectAllUser();
}
