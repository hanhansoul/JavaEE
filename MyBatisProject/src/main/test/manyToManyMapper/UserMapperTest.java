package manyToManyMapper;

import manyToManyMapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.Card;
import po.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = userMapper.selectUserWithCardById(1);
        System.out.println(user);
        for (Card card : user.getCards()) {
            System.out.println(card);
        }
    }

    @Test
    public void testSelectUserOnScore() {
        session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("id", (Integer) 1);
        input.put("score", "3");
        List<Map<String, Object>> output = userMapper.selectUserOnScore(input);
        for (Map<String, Object> item : output) {
            System.out.println(item.get("username") + " " + item.get("address") + " " +
                    item.get("code").toString() + " " + item.get("score").toString());
//            System.out.println(item.get("score"));
        }
    }


    @Test
    public void testSelectUserOnScoreToResultMap() {
//        将resultMap作为连接查询的输出有问题
//        session = sqlSessionFactory.openSession();
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        Map<String, Object> input = new HashMap<String, Object>();
//        input.put("id", (Integer) 1);
//        input.put("score", "3");
//        User output = userMapper.selectUserOnScoreToResultMap(input);
//        System.out.println(output);
//        for (Card c : output.getCards()) {
//            System.out.println(c);
//        }
    }


    @After
    public void destroy() {
        session.commit();
        session.close();
    }
}