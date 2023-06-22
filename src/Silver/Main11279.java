package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


/**
 * 최대 힙
 *
 *
 * - 입력되는 자연수는 2^
 * - 입력된 수가 0이라면 최대값을 출력하고 그 값을 배열에서 제거
 * - 그렇지 않으면 배열에 추가
 */
public class Main11279 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            int number = Integer.parseInt(br.readLine());

            //입력된 수가 0이라면 최대값을 출력하고 그 값을 배열에서 제거
            if(number == 0){

                //근데 비어있다고 하면 0을 출력
                if(priorityQueue.isEmpty()) {
                    sb.append("0").append("\n");
                    continue;
                }

                sb.append(priorityQueue.peek()).append("\n");
                priorityQueue.poll();

            }else{

                priorityQueue.add(number);
            }
        }


        System.out.println(sb);

    }
}
