package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 생태학
 * - 소수 4째짜리 까지 반올림 / 사전순 정렬
 * - 입력받는 개수가 따로없넹
 * - hashmap getOrDefault 써서 개수 저장하고 전체개수로나누면 댈듯
 */
public class Main4358 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str ;

        //전체 개수
        int total = 0;

        Map<String, Integer> map = new HashMap<>();

        //[1] 입력값 저장 -> hashMap을 이용하여 중복제거하고 , 중복 개수를 구함
        // 입력값이 따로 없으니까 null이 아닐때까지 반복
        while ((str = br.readLine()) != null){
            map.put(str, map.getOrDefault(str,0) + 1);
            total++;
        }

        List<String> nameList = new ArrayList<>();
        //[2] 중복제거된 종 이름 저장
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String name = entry.getKey();
            nameList.add(name);
        }

        //[3] 사전 순 정렬
        Collections.sort(nameList);

        StringBuilder sb = new StringBuilder();
        //[4] 정답 출력 => 소숫점 넷째짜리까지 출력
        for (String name : nameList) {

            int num = map.get(name) * 100;
            sb.append(name + " " + String.format("%.4f",(double)num/(double)total) + "\n");
        }

        System.out.println(sb);
    }
}
