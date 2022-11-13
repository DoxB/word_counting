package dao;

import java.sql.*;

public class DBConnection {
    String JDBC_DRIVER = "org.mariadb.jdbc.Driver"; //드라이버
    String DB_URL = "jdbc:mariadb://bangwol08.iptime.org:30000/distribute_database"; //접속할 DB 서버

    String USER_NAME = "tempuser"; //DB에 접속할 사용자 이름
    String PASSWORD = "qwe123!@#"; //사용자의 비밀번호

    //접속부
    public Connection getConnection() {
        Connection conn = null; //connection 객체
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}