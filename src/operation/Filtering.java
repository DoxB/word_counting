package operation;

import dto.rawDataDto;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filtering {

    // rawDataList 받아와서 필터링, String 배열로 반환
    public ArrayList<String> filter(ArrayList<rawDataDto> rawDataList) {
        System.out.println("1. Filtering rawData...");
        ArrayList<String> preprocessedDataList = new ArrayList<>();      // 전처리된 rawData 받을 List

        Matcher matcher;    // 정규식에 일치하는 문자열 찾는 객체
        Pattern wordFilter = Pattern.compile("[a-z]+");  // 알파벳으로 이루어진 단어만 인식
        String read = null;  //rawData 담을 String 초기화
        String sentence = null;  // 반환 리스트에 담을 String 초기화

        try {
            for (rawDataDto rawData : rawDataList) {
                // 1차 전처리
                read = rawData.getTitle();
                read = read.replaceAll("<[^>]+>|:|''|\"\"|!|~|;|,", ""); //HTML 태그 제거, 특수문자 1차 처리
                read = read.toLowerCase();       // 처리된 거 전체 소문자로 변경

                // 최종 전처리
                matcher = wordFilter.matcher(read);          // 1차 처리 된거에서 단어만 그룹화 (배열이랑 비슷)

                while (matcher.find()) {
                    if (sentence == null)
                        sentence = matcher.group();
                    else if (matcher.group().length() < 3 || matcher.group().equals("with") || matcher.group().equals("can"))
                        continue;
                    else if (matcher.group().equals("are") || matcher.group().equals("new") || matcher.group().equals("but"))
                        continue;
                    else if (matcher.group().equals("any") || matcher.group().equals("you"))
                        continue;
                    else sentence = sentence + " " + matcher.group();
                }
                preprocessedDataList.add(sentence); // 최종 전처리된 문장 전달할 리스트에 추가

                sentence = null; // 반환 리스트에 담을 String 초기화
            }

            for (String rawData : preprocessedDataList)
                System.out.println(rawData);

            System.out.println("2. Succeeded to Filtering rawData!");
        } catch (NullPointerException e) {
            System.out.println("2. Failed to Filtering rawData!");
        }

        return preprocessedDataList; // 결과값 DB에 전송하기 위한 List 반환
    }
}
