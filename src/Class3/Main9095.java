package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//dp 1,2,3 더하기
public class Main9095 {
     static  int count =0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수


        while (T -->0){
            dp(Integer.parseInt(br.readLine()));
            sb.append(count).append("\n");
            count=0;
        }

        System.out.print(sb);
    }

    public static void dp(int n){

        if(n==0){
            count++;
        }else if (n<0){
            return ;
        }

        dp(n-1);
        dp(n-2);
        dp(n-3);

    }
}
