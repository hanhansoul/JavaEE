package dao;

import model.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeMapper {
    List<Notice> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    Notice selectById(int id);

    void deleteById(Integer id);

    void save(Notice notice);

    void update(Notice notice);
}