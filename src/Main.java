import dao.rawDataDao;
import dao.resultDao;
import dto.rawDataDto;
import dto.resultDto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //rawData 가져와 생성된 배열에 저장 및 rawDB연결
        rawDataDao rawDbConn = new rawDataDao();
        ArrayList<rawDataDto> rawDataList = rawDbConn.rawData();
/*
      //데이터 받아오는 지 확인용
        for (rawDataDto elem : rawDataList) {
            System.out.println(elem.getId() + "\t" + elem.getTitle());
        }
*/

        //배열을 토대로 카운팅 결과 받을 배열 생성
        ArrayList<resultDto> resultSend;
        Counting counting = new Counting();
        resultSend = counting.wordCount(rawDataList);

        //결과DB 연결 및 word_count table에 저장
        resultDao resultDbConn = new resultDao();
        resultDbConn.insertResultList(resultSend);
    }
}
