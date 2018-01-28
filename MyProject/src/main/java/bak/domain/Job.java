package bak.domain;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public class Job {
    private Integer id;			// id
    private String name;		// Ö°Î»Ãû³Æ
    private String remark;		// ÏêÏ¸ÃèÊö

    public Job() {
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
