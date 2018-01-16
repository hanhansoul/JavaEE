package ManyToManyMapper.mapper;

import ManyToManyMapper.po.Order;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public interface OrderMapper {
    List<Order> selectOrderByUserId(int id);
}
