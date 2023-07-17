package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GCD 합
 *
 * GCD :두 수 이상의 최대 공약수
 */
public class Main9613 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        //테스트케이스 수 만큼 반복
        while (t --> 0){

            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]); //수의 개수

            int[] num = new int[n];

            for (int i = 0 ; i < n ;i++){
                num[i] = Integer.parseInt(str[i+1]);
            }

            //합 구할때  int 범위 벗어나는거 주의
            long total = 0;

            for (int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    if(i != j) total += calGCD(num[i],num[j]);
                }
            }
            System.out.println(total);
        }


    }

    //최대 공약수 구하는 메서드
    public  static long calGCD(int a, int b){
        if( a % b == 0) return b;
        return calGCD(b, a % b);

    }
}
