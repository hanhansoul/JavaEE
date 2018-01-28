package bak.domain;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public class Notice {
    private Integer id;        // 编号
    private String title;   // 标题
    private String content; // 内容
    private java.util.Date createDate;  // 发布日期
    private User user;        // 发布人

    // 无参数构造器
    public Notice() {
    }

    @Override
    public String toString() {
        return "Notice{" +
                "user=" + user +
                ", createDate=" + createDate +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
