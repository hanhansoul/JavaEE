package Annotation.OneToOneExample.po;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public class Card {
    private Integer id;  // 主键id
    private String code; // 身份证编号

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

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
}
