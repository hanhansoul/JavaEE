package annotationTest;

import org.apache.ibatis.annotations.*;
import po.User;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public interface UserMapper {
    @Insert("INSERT INTO TB_USER(name, sex, age) VALUES (#{name}, #{sex}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveUser(User user);

    @Delete("DELETE FROM TB_USER WHERE id = #{id}")
    int removeUser(@Param("id") Integer id);

    @Update("UPDATE TB_USER SET name=#{name}, sex=#{sex}, age=#{age} WHERE id = #{id}")
    void modifyUser(User user);

    @Select("SELECT * FROM TB_USER WHERE id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age")
    })
    User selectUserById(Integer id);

    @Select("SELECT * from TB_USER")
    List<User> selectALlUser();
}
