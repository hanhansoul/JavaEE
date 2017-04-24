package oneToManyMapper;

import oneToManyMapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.Lesson;
import po.User;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/24.
 */
public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession session = null;

    @Before
    public void initialization() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelectUserAndCarById() {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserWithLessonById(1);
        System.out.println(user);
        for (Lesson lesson : user.getLessons()) {
            System.out.println(lesson);
        }
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }
}