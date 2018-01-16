package Annotation.OneToOneExample.mapper;

import Annotation.OneToOneExample.po.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public interface PersonMapper {
    @Select("SELECT * FROM tb_person where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "card_id", property = "card",
            one=@One())
    })
    Person selectPersonById(Integer id);
}
