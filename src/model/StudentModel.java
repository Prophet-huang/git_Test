package model;

import java.sql.Timestamp;

/**
 * 该类用于封装表内的字段信息
 */
public class StudentModel {
    private StudentModel() {
    }

    private long pkId;
    private String name;
    private byte age;
    private byte gender;
    private Timestamp createTime;
    private Timestamp updateTime;



    public long getPkId() {
        return pkId;
    }

    public void setPkId(long pkId) {
        this.pkId = pkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public StudentModel(long pkId, String name, byte age, byte gender, Timestamp createTime, Timestamp updateTime) {
        setPkId(pkId);
        setName(name);
        setAge(age);
        setGender(gender);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
    }

    @Override
    public String toString() {
        return "pkId=" + pkId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime ;
    }
}
