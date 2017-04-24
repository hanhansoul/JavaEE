package po;

/**
 * Created by Administrator on 2017/4/24.
 */
public class Lesson {
    private Integer id;
    private String code;
    private Integer score;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", score=" + score +
                '}';
    }
}
