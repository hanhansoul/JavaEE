package CRUD;

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
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/23.
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
    public void testSelectUserById() {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void testSelectUserByName() {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUserByName("ac");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.insertUser(new User("Brown", "m", "Brooklyn"));
    }

    @Test
    public void testUpdateUserById() {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User("Brown", "f", "Queen");
        user.setId(4);
        userMapper.updateUserById(user);
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }
}