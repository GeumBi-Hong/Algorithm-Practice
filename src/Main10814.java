import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
3
21 Junkyu
21 Dohyun
20 Sunyoung*/

public class Main10814 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //나이와 같은 인덱스 번호에 정보를 저장하려고 한다.
        StringBuilder[] ageArray = new StringBuilder[201];

        for (int i = 0; i < ageArray.length; i++) {
            ageArray[i] = new StringBuilder();
        }

        for (int i = 0; i <n; i++){
            String str = br.readLine(); // 입력 값을 저장해둔다.
            int age = Integer.parseInt(new StringTokenizer(str).nextToken());// 나이 값만 따로 저장해둔다.

            //ageArray에 age와 같은 인덱스 번호에 str을 저장한다.
            ageArray[age].append(str).append("\n");
        }

        //출력한다.
        StringBuilder sb = new StringBuilder();
        for (StringBuilder s : ageArray) {
            sb.append(s);
        }

        System.out.println(sb);

    }



}
