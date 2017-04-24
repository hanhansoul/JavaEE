package oneToManyMapper;

import po.Lesson;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/24.
 */
interface LessonMapper {
    public Lesson selectLessonById(int id);

    public List<Lesson> selectLessonsMoreThanScore(int score);

    public List<Lesson> selectLessonsLessThanScore(int score);

    public List<Lesson> selectLessonsEqualToScore(int score);

    public List<Lesson> selectLessonByUserId(int id);

    public List<Lesson> selectLessonsWithUserIdAndScore(Map map);
}
