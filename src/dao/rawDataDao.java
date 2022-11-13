package dao;

import dto.rawDataDto;

import java.sql.*;
import java.util.ArrayList;

public class rawDataDao {
    private Connection conn = null;
    private Statement state = null;

    // 배열로 기존 DB 내역 가져오기
    public ArrayList<rawDataDto> rawData(){
        ArrayList<rawDataDto> rawDataList = new ArrayList<>();
        try {

            DBConnection dc = new DBConnection();
            conn = dc.getConnection(); //db 내의 데이터를 저장
            state = conn.createStatement(); //sql 문을 실행하기 위해 conn 연결 정보를 state로 생성

            String sql;
            sql = "select * from rawData";
            ResultSet rs = state.executeQuery(sql); // sql 실행결과를 rs에 저장
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                rawDataList.add(new rawDataDto(id, title));
            }

            rs.close();
            state.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(state != null)
                    state.close();
                if(conn != null)
                    conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }

        return rawDataList;
    }

}