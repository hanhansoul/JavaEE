package conversionService;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import po.Department;
import po.User;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
/*
 * 创建自定义的类型转化器，实现Converter<S, D>接口
 * 在mvc-dispacher-servlet.xml中注册类型转换器，定义<mvc:annotation-driven conversion-service="" >标签
 */
@Component
public class CustomedConverter implements Converter<String, User> {

    public User convert(String s) {
        if (s != null) {
            String[] vals = s.split("-");
            if (vals != null && vals.length == 6) {
//                <!-- name-age-gender-email-password-department.id -->
                String name = vals[0];
                Integer age = Integer.parseInt(vals[1]);
                Integer gender = Integer.parseInt(vals[2]);
                String email = vals[3];
                String password = vals[4];
                Department department = new Department(Integer.parseInt(vals[5]));
                User user = new User(name, age, gender, email, password, department);
                return user;
            }
        }
        return null;
    }
}
