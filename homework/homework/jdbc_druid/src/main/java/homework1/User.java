package homework1;

import java.util.Date;

/**
 * @Project: homework1
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/10 14:17
 * @Description:
 */
public class User {
    private Long id;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User(Long id, String phone, String password, String role, Date updateTime, Date createTime) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    private String phone;
    private String password;
    private String role;
    private Date updateTime;
    private Date createTime;


}
