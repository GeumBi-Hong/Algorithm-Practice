package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


/**
 * 문자열-집합
 *
 * 집합 s에 포함되는 문자열이 몇개인지 구하는 문제
 *
 * 1. Set 에 N개의 String문자열을 저장 ->  Set에 저장하면 중복값이 제거가 되가때문
 * 2. M개의 문자열을 하나씩 확인하면서 set에 있나없나 체크
 */
public class Main14425 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> stringSet = new HashSet<>();


        for(int i = 0; i < N; i++){
            stringSet.add(br.readLine());
        }

        int answer = 0;

        for(int i = 0; i < M; i++){
            if(stringSet.contains(br.readLine())) answer++;
        }

        System.out.println(answer);


    }
}
