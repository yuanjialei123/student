package cn.student.day2.service;

import cn.student.day2.entity.StudentEntity;

import java.util.List;

/**
 * @Author: yuanjialei
 * @Mail: yuanjialei@ibiandan.cn
 * @Date: 2023/2/15 11:23
 * @Version: 1.0
 * @Description: 学生业务处理类
 */
public interface StudentService {

    /**
     * 学生列表
     *
     * @param name 名字
     * @return {@link List}<{@link StudentEntity}>
     */
    List<StudentEntity> studentList(String name);

     int delete(Integer id);
     int updateNmae(Integer id,String name);

}
