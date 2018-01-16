package Annotation.DMLExample.mapper;

import Annotation.DMLExample.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession session = null;

    @Before
    public void initialization() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }

    @Test
    public void testSaveUser() throws Exception {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User("test", "male", 19);
        userMapper.saveUser(user);
    }

    @Test
    public void testRemoveUser() throws Exception {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.removeUser(1);
    }

    @Test
    public void testModifyUser() throws Exception {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User("test1", "female", 30);
        user.setId(2);
        userMapper.modifyUser(user);
    }

    @Test
    public void testSelectUserById() throws Exception {

    }

    @Test
    public void testSelectAllUser() throws Exception {

    }
}