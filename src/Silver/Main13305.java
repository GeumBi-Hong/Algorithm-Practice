package Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주유소

 [풀이]
 - 구해야 할 값 : 제일 왼쪽 도시에서 제일 오른쪽 도시러 이동하는 최소의 비용을 계산
 - 방법 : 최소 비용을 구하고 싶으면 당연히 기름값이 작은 주유소에서 구매하는게 좋을 것임
 - 입력값 N 이 최대 100,000이기 때문에 O(N^2)는 불가 그 이하로 어떻게 접근할 것인가
 - 처음에는 당연히 기름이 없으니 첫 주유소에서 기름을 구매 처음에 5비용으로 구매를 했다면, 그 이후의 도시가 5의 비용보다 작은 도시이면 그 도시로 가는 거리 만큼의 기름
 - 5의 비용으로 구매하고 더 작은 비용의 도시가 나왔으니 그 가격으로 또 구매한다. 구매한 비용보다 작은 비용의 도시가 나올때까지 구매한다면 최소 비용으로 이동할 수 있을 것이다.
 */

public class Main13305 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //도시의 수

        int[] distance = new int[N-1];
        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine());

        //[1]거리 저장

        for (int i = 0; i < N - 1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        //처음 기름 구매 비용은 첫 도시의 기름 비용
        int currCost = cost[0];
        long totalCost = 0;

        for (int i = 0 ; i < N - 1; i++){


            //지금 비용보다 더 작은 비용의 도시가 있다면 이전의 비용까지만
            if(currCost > cost[i]){
                currCost = cost[i];
            }

            // currCost * distance[i] -> int * int 가  long형 범위를 넘어가면 오버 플로우가 발생하기때문에
            //원래 구해야할 값이 오버플로우 발생한 값으로 들어갈 수 있음 그래서 형변환으로 해서 값을 구해야함
            totalCost += (long)currCost * distance[i];
        }

        System.out.println(totalCost);

    }
}
