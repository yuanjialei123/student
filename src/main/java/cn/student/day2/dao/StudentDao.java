package cn.student.day2.dao;

import cn.student.day2.entity.StudentEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: yuanjialei
 * @Mail: yuanjialei@ibiandan.cn
 * @Date: 2023/2/15 11:08
 * @Version: 1.0
 * @Description: 学生数据查询类
 */
public interface StudentDao {

    /**
     * 查询学生列表
     *
     * @param name 名字
     * @return {@link List}<{@link StudentEntity}>
     */
    List<StudentEntity> selectStudentList(String name) throws SQLException;



}
