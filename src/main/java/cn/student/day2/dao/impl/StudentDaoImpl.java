package cn.student.day2.dao.impl;

import cn.student.day2.dao.StudentDao;
import cn.student.day2.entity.StudentEntity;
import cn.student.day2.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yuanjialei
 * @Mail: yuanjialei@ibiandan.cn
 * @Date: 2023/2/15 11:08
 * @Version: 1.0
 * @Description: 学生数据查询类
 */
public class StudentDaoImpl implements StudentDao {
    public List<StudentEntity> selectStudentList(String name) throws SQLException {
        // 拼接sql
        // 根据crate_time 倒叙排序
        // 如果有name就模糊查询
        StringBuilder sql = new StringBuilder("select *");
        sql.append(" from student ");
        if (null != name && !"".equals(name)) {
            sql.append(" where name like '%").append(name).append("%'");
        }
        sql.append(" order by create_time desc");

        // 获取结果
        try {
            JdbcUtil.connection();
            ResultSet select = JdbcUtil.select(sql.toString());

            List<StudentEntity> list = new ArrayList<StudentEntity>();

            while (select.next()) {
                Long id = select.getLong("id");
                String stuNo = select.getString("stu_no");
                String name1 = select.getString("name");
                Integer age = select.getInt("age");
                String gradeNo = select.getString("grade_no");
                String classNo = select.getString("class_no");
                Date createTime = select.getDate("create_time");
                Date updateTime = select.getDate("update_time");

                // 创建一个学生对象
                StudentEntity student = new StudentEntity();
                student.setId(id);
                student.setStuNo(stuNo);
                student.setName(name1);
                student.setAge(age);
                student.setGradeNo(gradeNo);
                student.setClassNo(classNo);
                student.setCreateTime(createTime);
                student.setUpdateTime(updateTime);
                list.add(student);
            }
            return list;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close();
        }
    }
}
