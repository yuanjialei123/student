package cn.student.day2.util;

import java.sql.*;

/**
 * @Author: yuanjialei
 * @Mail: yuanjialei@ibiandan.cn
 * @Date: 2023/2/15 11:12
 * @Version: 1.0
 * @Description: JDBC工具类
 */
public class JdbcUtil {
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.3.139:3306/student";

    static final String USER = "root";

    static final String PASSWORD = "Biandan@123";


    private static Connection conn = null;
    private static Statement stmt = null;

    public static void connection() throws ClassNotFoundException, SQLException {
        // 注册 JDBC 驱动 通过类路径 注册驱动类
        Class.forName(JDBC_DRIVER);

        // 打开数据库链接
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        System.out.println("链接数据库成功...");

        // 执行查询
        stmt = conn.createStatement();
        System.out.println("实例化Statement对象...");
    }

    /**
     * 执行查询Sql
     *
     * @param sql sql
     * @return {@link ResultSet}
     */
    public static ResultSet select(String sql) throws SQLException {
        return stmt.executeQuery(sql);
    }

    public static void close() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ignored) {

        }
    }


}
