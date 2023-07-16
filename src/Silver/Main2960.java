package Silver;

import java.io.*;
import java.util.*;

/**
 * 에라토스테네스의 체
 *
 */
public class Main2960 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        primeNumber(N,K);
    }

    //에라토스테네스의 체 알고리즘
    static void primeNumber(int n, int k) {


        int[] arr = new int[n+1];


        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        // 2 ~ n 까지
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) continue; //이미 지운 수는 건너뛰기

            //[1]배수 지우기
            for (int j = i; j <= n; j+=i) {
                if (arr[j] != 0) {
                    arr[j] = 0;
                    k--;
                    //[2]k번째로 지운 수 출력한다.
                    if (k == 0) {
                        System.out.print(j);
                        return;
                    }
                }
            }
        }
    }
}