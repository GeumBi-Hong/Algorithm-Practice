package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 카드 정렬하기 (376ms)
 *
 * [문제풀이]
 * - 오름 차순으로 정렬 시키는 우선순위 큐를 이용해서
 * 계속해서 가장 작은 값의 합을 해서 최소 비용을 구할 수 있도록 함
 */
public class Main1715 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int totalSum = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        while (N --> 0){
            int n = Integer.parseInt(br.readLine());
            queue.add(n);
        }



        int answer = 0;



        while (!queue.isEmpty()){

            int a = queue.poll();

            if(queue.isEmpty()) {
                answer = a;
                break;
            }
            int b = queue.poll();
            queue.add(a + b);
            totalSum += a+b;



        }

        System.out.println(totalSum);

    }
}
