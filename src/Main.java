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

        //결과 받을 배열 생성 및 배열을 토대로 카운팅
        ArrayList<resultDto> resultSend;
        Counting counting = new Counting();
        resultSend = counting.wordCount(rawDataList);

        //최종DB 연결 및 word_count table에 저장
        resultDao resultDbConn = new resultDao();
        resultDbConn.insertResultList(resultSend);
    }
}
