package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 소수 최소 공배수
 *
 * [1] 백만 이하의 수까지 소수 먼저 판단
 * [2] 입력값 소수이면 최소 공배수 구하기
 */
public class Main21919 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //[1] 소수판정 에라토스테네스의 체
        int MAX = 1_000_001;
        boolean[] isPrime = new boolean[MAX];

        Arrays.fill(isPrime,true);

        isPrime[0] = false;
        isPrime[1] = false;

        boolean[] isUsed = new boolean[MAX];

        findPrimeNumber(isPrime,MAX);

        StringTokenizer st = new StringTokenizer(br.readLine());


        long lcm = -1;
        for(int i = 0; i < n ;i++){

            int number = Integer.parseInt(st.nextToken());


            //소수 판정하기
            if(isPrime[number] && !isUsed[number]){
                if(lcm == -1) {
                    lcm = number;
                }else{
                    lcm = calLCM(lcm,number);
                }

                isUsed[number] = true;

            }


        }

        System.out.println(lcm);


    }

    private static void findPrimeNumber (boolean[] isPrime , int n){


        for(int i =2; i * i < n; i++){
            if(isPrime[i]){
                for(int j = i * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }

    //최대 공약수 구하는 메서드
    private  static long calGCD(long a, long b){
        if( a % b == 0) return b;
        return calGCD(b, a % b);

    }

    //최소 공배수 구하는 메서드

    public static long calLCM(long a, long b) {
        return (a * b) / calGCD(a, b);
    }
}
