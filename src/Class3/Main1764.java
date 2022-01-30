package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//듣보잡 (해시)
public class Main1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); //보도 못한 사람 수
        HashMap<String,Integer> hashMap = new HashMap<>();
        List<String> person = new ArrayList<>();
        String str;
        int count=0;

        while (N-->0){
            hashMap.put(br.readLine(), 1);
        }

        while (M-->0){
             str = br.readLine();
            if(hashMap.get(str) != null) { //듣도보도 못한 사람의 이름이 저장되어있다면
                count++;
                person.add(str); // 리스트에 그 사람의 이름을 저장한다.
            }
        }

        Collections.sort(person);//정렬
        sb.append(count + "\n");
        for (String s : person){
            sb.append(s+"\n");
        }
        System.out.print(sb);
    }
}
