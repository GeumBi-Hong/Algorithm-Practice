package Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * LCM : 최소 공배수
 *
 * [풀이 방법]
 *
 * 최소 공배수 : a * b /  최대 공약수
 *
 * 근데 이 최대 공약수 구하는거도 효율적으로 접근해야함 -> 유클리드 호제법
 *
 */
public class Main5347 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.
               in ));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0){

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(a * b / calGCD(a,b));
        }
    }

    //최대 공약수 구하는 메서드
    public  static long calGCD(int a, int b){
        if( a % b == 0) return b;
        return calGCD(b, a % b);

    }
}
