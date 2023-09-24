package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * 줄세우기
 *
 * 문제 핵심 : N명의 아이들이 임의의 순서로 줄을 서 있을 때, 번호 순서대로 배치하기 위해 옮겨지는 아이의 최소 수를 구하기
 * => 그래서 오름 차순으로 정렬되어있는 아이 빼고 나머지만 이동시키는게 최소이니, LIS 방법으로 가장 긴 수열 수를 구하고 전체에서 그 수를뺴면 정답이다. 이거네
 *
 *
 *
 * 예시
 * 3 7 5 2 6 1 4 => 4번만에 가능 3번 불가
 *
 * N은 200이하의 정수
 *
 * - 완탐으로 1,2,3,4,5번...n번만에 변경되는걸 찾아서 하는건 100% 비효율
 *
 *
 * - 
 *
 * */

public class Main2631 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        int [] dp = new int[N];


        for(int i = 0; i < N ; i++){

            int num = Integer.parseInt(br.readLine());

            array[i] = num;
        }


        //LIS
        dp[0] = 1;
        int maxLength = 0;
        for(int i = 1; i < N; i++){
            //맨 처음의 최소는 자기 자신일꺼니까 1로 초기화
            dp[i] = 1;

            for(int j = 0 ; j < i; j++){

                if(array[j] < array[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }

            maxLength = Math.max(dp[i],maxLength);
        }


        System.out.println(N - maxLength);
    }
}
