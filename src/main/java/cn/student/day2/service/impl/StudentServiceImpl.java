package cn.student.day2.service.impl;

import cn.student.day2.dao.StudentDao;
import cn.student.day2.dao.impl.StudentDaoImpl;
import cn.student.day2.entity.StudentEntity;
import cn.student.day2.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: yuanjialei
 * @Mail: yuanjialei@ibiandan.cn
 * @Date: 2023/2/15 11:24
 * @Version: 1.0
 * @Description: 学生表业务类,这里一般处理业务
 */
public class StudentServiceImpl implements StudentService {


    public List<StudentEntity> studentList(String name) {
        // 创建数据库交互层对象
        StudentDao studentDao = new StudentDaoImpl();
        // 获取查询结果
        List<StudentEntity> studentList = null;
        try {
            studentList = studentDao.selectStudentList(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 给名称加上引号
        for (StudentEntity studentEntity : studentList) {
            if (studentEntity.getName() != null) {
                studentEntity.setName("\"" + studentEntity.getName() + "\"");
            }
        }
        return studentList;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int updateNmae(Integer id, String name) {
        return 0;
    }
}
