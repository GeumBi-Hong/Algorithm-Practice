package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 서로소 평균
 */
public class Main21920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int number = Integer.parseInt(st.nextToken());
            num[i] = number;
        }

        int x = Integer.parseInt(br.readLine());

        double count = 0;
        long sum = 0;
        //서로소 체크 => 최대 공약 수 1
        for (int i = 0; i < n; i++){
            if( calGCD(num[i],x) == 1 ) {
                count++;
                sum += num[i];
            }
        }

        System.out.println(sum/count);

    }

    //최대 공약수 구하는 메서드
    private  static int calGCD(int a, int b){
        if( a % b == 0) return b;
        return calGCD(b, a % b);

    }
}
