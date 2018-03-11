package dao;

import model.Document;

import java.util.List;
import java.util.Map;

public interface DocumentMapper {
    List<Document> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    void save(Document document);

    Document selectById(int id);

    void deleteById(Integer id);

    void update(Document document);
}