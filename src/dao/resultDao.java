package dao;


import dto.resultDto;

import java.sql.*;
import java.util.ArrayList;

public class resultDao {
    private Connection conn = null;

    public void insertResultList(ArrayList<resultDto> resultList) {
        DBConnection dc = new DBConnection();
        conn = dc.getConnection(); //db 내의 데이터를 저장
        PreparedStatement pstmt = null;

        try {
            String sql;
            //최종 DB에 결과값이 있으면 현재 찾은 거 더하기
            sql = "insert into word_count (word, count) values (?, ?) ON DUPLICATE KEY UPDATE count=count + ?";
            pstmt = conn.prepareStatement(sql);
            for(resultDto result : resultList) {
                //PreparedStatement 객체의 참조값 얻어오기
                pstmt = conn.prepareStatement(sql);
                //? 에 필요한값 바인딩하기
                pstmt.setString(1, result.getWord());
                pstmt.setInt(2, result.getCount());
                pstmt.setInt(3, result.getCount());
                //sql 문 실행하기 (INSERT, UPDATE, DELETE)
                pstmt.executeUpdate();
            }
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pstmt != null)
                    pstmt.close();
                if(conn != null)
                    conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }

        }
    }
}
