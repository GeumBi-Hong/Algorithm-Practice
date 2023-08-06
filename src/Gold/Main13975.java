package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 파일 합치기 3
 *
 * [문제 풀이]
 * 이거 백준 1715번이랑 비슷한거같은데
 * 합칠때 있는 파일 중에 가장 작은 두개를 골라서 합쳐야 가장 최소 비용이 나온다
 */

public class Main13975 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());


        //테스트 케이스 수 만큼 반복
        while (testCase-- > 0) {

            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> queue = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            //우선순위 큐로 오름 차순 정렬
            while (N-- > 0) {
                queue.add(Long.parseLong(st.nextToken()));
            }


            //파일의 최소 합
            long answer = 0L;

            while (!queue.isEmpty()) {

                long numA = queue.poll();

                if (queue.isEmpty()) {
                    break;
                }

                long numB = queue.poll();

                answer += numA + numB;
                queue.add(numA + numB);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }


}
