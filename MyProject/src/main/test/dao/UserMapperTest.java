package dao;

import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/2/1 0001.
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
    public void testSelectByLoginnameAndPassword() throws Exception {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
//        User user = new User("test", "male", 19);
//        userMapper.saveUser(user);
        User user = new User();
        user.setLoginname("test");
        user.setPassword("1234");
        user.setStatus(2);
        user.setUsername("test");
        user.setCreatedate(new Date());
        userMapper.save(user);
    }

    @Test
    public void testSelectById() throws Exception {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectById(2);
        System.out.println(user);
    }

    @Test
    public void testDeleteById() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testSelectByPage() throws Exception {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", "test");
        params.put("status", 2);
        params.put("firstLimitParam", 1);
        params.put("pageSize", 2);
        List<User> users = userMapper.selectByPage(params);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testCount() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

    }
}