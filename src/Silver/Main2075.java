package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N번째 큰 수
 *
 * [풀이 1]
 * - 우선순위 큐에 넣고 정렬 시킨 후 N개 만큼 pop해서 찾기
 * - 리스트에 넣고 내림차순 후 , N-1번째 인덱스 값 출력
 *
 * 이렇게 풀라고 낸 문제는 아닐거같은데....
 */
public class Main2075 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        //입력값을 우선순위 큐에 저장 -> 내림 차순 정렬됨(Collections.reverseOrder())
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < N - 1; i++){
            queue.remove();
        }

        System.out.println(queue.peek());

    }
}
