package cn.student.day2.entity;

import java.util.Date;

/**
 * @Author: yuanjialei
 * @Mail: yuanjialei@ibiandan.cn
 * @Date: 2023/2/15 11:09
 * @Version: 1.0
 * @Description: 学生实体类
 */
public class StudentEntity {

    /**
     * id
     */
    Long Id;

    /**
     * 学生编号
     */
    String stuNo;

    /**
     * 名字
     */
    String name;

    /**
     * 年龄
     */
    Integer age;

    /**
     * 年级没有
     */
    String gradeNo;

    /**
     * 课堂上没有
     */
    String clasNo;

    /**
     * 创建时间
     */
    Date createTime;

    /**
     * 更新时间
     */
    Date updateTime;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGradeNo() {
        return gradeNo;
    }

    public void setGradeNo(String gradeNo) {
        this.gradeNo = gradeNo;
    }

    public String getClasNo() {
        return clasNo;
    }

    public void setClassNo(String clasNo) {
        this.clasNo = clasNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "Id=" + Id +
                ", stuNo='" + stuNo + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gradeNo='" + gradeNo + '\'' +
                ", clasNo='" + clasNo + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
