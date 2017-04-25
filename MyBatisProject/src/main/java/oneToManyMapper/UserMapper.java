package oneToManyMapper;

import po.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/23.
 */
interface UserMapper {
    public User selectUserWithCardById(int id);

    public List<Map<String, Object>> selectUserOnScore(Map<String, Object> map);

    public User selectUserOnScoreToResultMap(Map<String, Object> map);

}
