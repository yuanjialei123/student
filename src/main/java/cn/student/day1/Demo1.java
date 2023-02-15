package cn.student.day1;

import java.sql.*;

/**
 * @Author: yuanjialei
 * @Mail: yuanjialei@ibiandan.cn
 * @Date: 2023/2/14 09:01
 * @Version: 1.0
 * @Description: Demo1
 *
 *         // 链接数据库
 *         // 查询学生列表
 *         // 新增一条学生记录
 *         // 修改一条学生记录
 */
public class Demo1 {
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.3.139:3306/student";

    static final String USER = "root";

    static final String PASSWORD = "Biandan@123";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            // 注册 JDBC 驱动 通过类路径 注册驱动类
            Class.forName(JDBC_DRIVER);

            // 打开数据库链接
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("链接数据库成功...");

            // 执行查询
            stmt = conn.createStatement();
            System.out.println("实例化Statement对象...");

            // 编写要执行的Sql语句
            String sql;
            sql = "select stu_no,name from student";

            // 执行
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()){
                // 通过字段名获取数据
                String stuNo = result.getString("stu_no");
                String name = result.getString("name");

                // 输出数据
                System.out.printf("学号:%s 姓名:%s\n",stuNo,name);
            }
        } catch (ClassNotFoundException e) {
            // Class.forName(JDBC_DRIVER); 防止找不到类
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
                if(stmt != null){
                    stmt.close();
                }
            } catch (SQLException ignored) {

            }
        }

    }
}
