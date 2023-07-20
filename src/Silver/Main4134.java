package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


/**
 * 다음 소수
 *
 * [풀이]
 *
 * 소수 : 약수가 1과 자기 자신인 수 뿐
 *
 */
public class Main4134 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] num =  new long[T];

        for(int i = 0; i < T; i++){

            long n = Long.parseLong(br.readLine());
            BigInteger prime = new BigInteger(String.valueOf(n));

            if(prime.isProbablePrime(10)){
                System.out.println(prime);
            }else{
                System.out.println(prime.nextProbablePrime());
            }
        }
    }
}
