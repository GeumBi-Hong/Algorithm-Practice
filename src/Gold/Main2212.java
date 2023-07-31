package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 센서
 *
 * [문제조건]
 * - 센서의 개수 N 최대 1만개
 * - 집중국의 개수 k 최대 1000
 * - 좌표의 절대값은 1,000,000 이하
 *
 *
 * [문제 풀이]
 *
 * 집중국을 세울껀데 센서가 적어도 하나의 집중국과는 통신해야되고 그 수신가능길이는 최소여야함
 * 즉 K개를 설치해서 가장 거리차이가 많은 부분을 제거
 */
public class Main2212 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //센서 개수
        int K = Integer.parseInt(br.readLine()); //최대 집중국 개수



        //[1]센서를 먼저 좌표 순으로 오름차순으로 정렬한다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> sensorList = new ArrayList<>();
        for (int i = 0; i < N; i++){
            sensorList.add(Integer.parseInt(st.nextToken()));

        }

        Collections.sort(sensorList);

        //[2] 센서간의 차를 내림 차순으로 정렬한다.

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N - 1; i++){
            queue.add(sensorList.get(i+1) - sensorList.get(i));
        }
        K--;
        while (K --> 0){
            queue.poll();
        }

        int answer = 0;

        while (!queue.isEmpty()){
            answer += queue.poll();
        }

        System.out.println(answer);
    }
}
