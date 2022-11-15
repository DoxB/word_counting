import dao.rawDataDao;
import dao.resultDao;
import dto.rawDataDto;
import dto.resultDto;
import operation.Counting;
import operation.Filtering;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("----------------------Start-------------------");
        System.out.println();

        ArrayList<rawDataDto> rawDataList; //rawDataList 담을 List
        ArrayList<String> preprocessedDataList; //전처리된 DataList 담을 List
        ArrayList<resultDto> resultDataList; //카운팅 결과를 저장 및 DB 전송용 List

        //DB에 연결해 rawDataList 받아옴
        rawDataDao rawData = new rawDataDao();
        rawDataList = rawData.importRawData();

        System.out.println("----------------------------------------------");
        System.out.println("Operation process to preprocess and count words");
        System.out.println("----------------------------------------------");

        //필터링 클래스로 rawDataList 전송 및 결과를 List로 받아옴
        Filtering filtering = new Filtering();
        preprocessedDataList = filtering.filter(rawDataList);

        //결과 받을 배열 생성 및 배열을 토대로 카운팅
        Counting counting = new Counting();
        resultDataList = counting.wordCounter(preprocessedDataList);

        System.out.println("----------------------------------------------");

        //최종DB 연결 및 word_count table에 저장
        resultDao resultDbConn = new resultDao();
        resultDbConn.insertResultList(resultDataList);

        System.out.println();
        System.out.println("---------------------End----------------------");
    }
}
