package ManyToManyMapper.mapper;

import ManyToManyMapper.po.Order;
import ManyToManyMapper.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public class OrderMapperTest {

    SqlSessionFactory sqlSessionFactory = null;
    SqlSession session = null;

    @Before
    public void initialization() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelectOrderById() throws Exception {
        session = sqlSessionFactory.openSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.selectOrderByUserId(1);
        for(Order order : orders){
            System.out.println(order);
            System.out.println();
        }
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }

}