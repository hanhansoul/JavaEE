package cache;

import CRUD.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/4/25.
 */

public class CacheTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession session = null;

    @Before
    public void initialization() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void cache1Test() {
        // ≤‚ ‘“ªº∂ª∫¥Ê
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user1 = userMapper.selectUserById(1);
        System.out.println(user1);

//        User user = new User("Alice", "f", "Brooklyn");
//        userMapper.insertUser(user);
//        session.commit();

        User user2 = userMapper.selectUserById(1);
        System.out.println(user2);
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }
}
