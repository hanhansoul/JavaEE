package Annotation.OneToOneExample.po;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public class Card {
    private Integer id;  // ����id
    private String code; // ���֤���

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
