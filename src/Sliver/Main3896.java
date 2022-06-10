package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main3896 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        int maxPrime = 1299709;
        boolean[] isPrime = new boolean[maxPrime + 1];
        isPrime[0] = true;
        isPrime[1] = true; //true -> 소수가 아니라는 의미


        //에라토스테네스의 체
        for (int i = 2; i * i <= maxPrime; i++) {
            if (!isPrime[i]) {//i 가 소수라면 i의 배수들은 소수가 아니다.
                for (int j = i * i; j <= maxPrime; j += i) isPrime[j] = true;
            }
        }

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            if (!isPrime[k]) {//소수이면
                sb.append(0).append("\n");
                continue;
            }

            //소수가 아니면

            //k보다 크고  거리가 가장 가까운 소수를 찾는다(A)
            int A = 0;
            for (int i = k + 1; i <= maxPrime; i++) {
                if (!isPrime[i]) {
                    A = i;
                    break;
                }
            }

            //k보다 작고 거리가 가장 가까운 소수를 찾는다(B)
            int B = 0;
            for (int i = k - 1; i >= 2; i--) {
                if (!isPrime[i]) {
                    B = i;
                    break;
                }
            }


            //A-B 가 k를 포함하는 소수 사이의 수열 길이임.
            sb.append(A - B).append("\n");

        }

        System.out.println(sb);

    }
}

