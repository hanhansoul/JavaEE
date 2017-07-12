package conversionService;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import po.Department;
import po.User;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
/*
 * �����Զ��������ת������ʵ��Converter<S, D>�ӿ�
 * ��mvc-dispacher-servlet.xml��ע������ת����������<mvc:annotation-driven conversion-service="" >��ǩ
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
