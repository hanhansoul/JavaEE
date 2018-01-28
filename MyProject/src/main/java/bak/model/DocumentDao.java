package bak.model;

import bak.domain.Document;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public interface DocumentDao {

    List<Document> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    void save(Document document);

    Document selectById(int id);

    void deleteById(Integer id);

    void update(Document document);
}
