package connecter;

import java.sql.*;

public class DBConnection {
    String JDBC_DRIVER = "org.mariadb.jdbc.Driver"; //드라이버
    String DB_URL = "jdbc:mariadb://bangwol08.iptime.org:30000/distribute_database"; //접속할 DB 서버

    String USER_NAME = "tempuser"; //DB에 접속할 사용자 이름
    String PASSWORD = "qwe123!@#"; //사용자의 비밀번호

    //DB 접속부
    public Connection getConnection() {
        System.out.println("----------------------------------------------");
        System.out.println("Connection Results to distribute_database");
        System.out.println("----------------------------------------------");
        Connection conn = null; //connection 객체
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("1. Succeeded to connect distribute_database!");
        } catch (ClassNotFoundException e) {
            System.out.println("1. Failed to connect distribute_database! (ClassNotFoundException)");
        } catch (SQLException e) {
            System.out.println("1. Failed to connect distribute_database! (SQLException)");
        }
        return conn;
    }
}