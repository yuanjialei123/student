package cn.student.day2.servlet;


import cn.student.day2.entity.StudentEntity;
import cn.student.day2.service.StudentService;
import cn.student.day2.service.impl.StudentServiceImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author: yuanjialei
 * @Mail: yuanjialei@ibiandan.cn
 * @Date: 2023/2/15 10:59
 * @Version: 1.0
 * @Description: 学生Servlet
 */
public class StudentServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        StudentService studentService = new StudentServiceImpl();

        // 获取参数查询数据
        String name = req.getParameter("name");
        List<StudentEntity> list = studentService.studentList(name);
        // 设置中文编码
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        // 没有数据回到Index界面
        if(list.size()==0){
            try {
                resp.sendRedirect("/index.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        // 查到数据返回结果
        list.forEach(item -> {
            try {
                resp.getWriter().println(new String(item.toString().getBytes(), StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
