package bak.model;

import bak.domain.Notice;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public interface NoticeDao {
    List<Notice> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    Notice selectById(int id);

    void deleteById(Integer id);

    void save(Notice notice);

    void update(Notice notice);
}
