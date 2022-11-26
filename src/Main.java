import dao.rawDataDao;
import dao.resultDao;
import dto.rawDataDto;
import dto.resultDto;
import operation.Counting;
import operation.Filtering;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        ArrayList<rawDataDto> rawDataList;
        ArrayList<String> preprocessedDataList;
        ArrayList<resultDto> resultList;


        rawDataDao rawData = new rawDataDao();
        rawDataList = rawData.importRawData();

        Filtering filtering = new Filtering();
        preprocessedDataList = filtering.filter(rawDataList);

        Counting counting = new Counting();
        resultList = counting.wordCounter(preprocessedDataList);

        resultDao resultData = new resultDao();
        resultData.insertResultList(resultList);

    }

}

