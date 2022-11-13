import dto.rawDataDto;
import dto.resultDto;

import java.util.ArrayList;
import java.util.HashMap;

public class Counting {
    public ArrayList<resultDto> wordCount(ArrayList<rawDataDto> rawDataList) {

        // 문장 DB 배열 받기 및 결과 저장용 Map 생성, 전송용 List 생성
        ArrayList<rawDataDto> rawData = rawDataList;
        HashMap<String, Integer> resultHash = new HashMap<>();
        ArrayList<resultDto> resultSend = new ArrayList<>();

        String read = null;
        for (rawDataDto sentence : rawData) {
            read = sentence.getTitle();
            String[] split = read.split("\\s");


            for (int i = 0; i < split.length; i++) {
                if (resultHash.get(split[i]) != null)
                    resultHash.replace(split[i], resultHash.get(split[i]) + 1);
                else
                    resultHash.put(split[i], 1);
            }
        }

        // 전송용 List 만들기
        for(String key : resultHash.keySet()){
            resultSend.add(new resultDto(key, resultHash.get(key)));
        }

        return resultSend;
    }
}