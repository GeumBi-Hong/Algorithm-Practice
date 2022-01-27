package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-"); // "-" 를 기준으로해서 식을 나누어 준다.
        int total =Integer.MAX_VALUE; //처음 토큰인지 확인하기 위함이다.

    while (st.hasMoreTokens()){

        int num = 0;
         StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+");

                 while (st2.hasMoreTokens()){//덧셈 식들을 전부 더한다.
                     num+=Integer.parseInt(st2.nextToken());
                 }

         if( total ==Integer.MAX_VALUE){ //첫 수 인지 확인하기 위함이다.
            total = num ; //첫 수였다면 -가 아닌 +로 나와야 하기때문에 total 에 num을 그대로 넘긴다.
         }else {
            total-= num;
         }

     }
        System.out.println(total);


    }
}
