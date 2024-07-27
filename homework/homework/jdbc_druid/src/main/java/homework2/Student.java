package homework2;

import java.util.Date;

/**
 * @Project: homework2
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/9 19:34
 * @Description:
 */
public class Student {

    private Long id; //ID

    private String number; //学号

    private String name; //姓名

    private int sex; //性别 0:女 1:男

    private String phone; //电话

    private String qq; //QQ

    private String address; // 家庭住址

    private Date updateTime; // 更新时间

    private Date createTime; // 创建时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Student(Long id, String number, String name, int sex, String phone, String qq, String address, Date updateTime, Date createTime) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.qq = qq;
        this.address = address;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", address='" + address + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
