package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 중앙값 구하기
 *
 *
 * 수열이 있는데 홀수번쨰 수를 읽을 때마다 지금까지 입력받은 값의 중앙값을 출력해야함.
 * 수열중에 가운데에있는 위치에 있는 값을 중앙값이라고 하나봄
 *
 * 그러면 수를 넣을때마다 중앙값을 출력해주는 무언가가없나...
 *  1, 5, 4, 3, 2
 *  1  4  2
 *  첫번째 : 1 -> 1
 *  세번쨰 : 4
 *  다섯번쨰 : 3
 *
 *
 *  216ms
 *
 *
 *  큐 두개를 만든다 (우선순위큐)
 */

public class Main2696 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        //[1] 테스트 케이스 수 만큼 반복 (1~1000번)
        while (T --> 0){

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            sb.append((M+1)/2);
            sb.append("\n");


            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //오름 차순 정렬 힙
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1)); //얘는 내림차순 정렬

            int count = 0; //10개 출력하면 줄바꿈을 넣기 위함

            //[2] 수열 읽기
            for(int i = 0; i < M; i++){

                if(i % 10 == 0) st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                //[3] maxHeap 에 더 많게 유지
                if(minHeap.size() == maxHeap.size()) maxHeap.add(num);
                else minHeap.add(num);

                //[4]
                if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {

                    int temp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(temp);
                }

                //홀수번째 순서의 수를 읽을때는 중앙값을 출력 , 이 때 한줄에 10개씩 출력

                if(i % 2 == 0) {
                    sb.append(maxHeap.peek()).append(" ");
                    count++;
                    if (count % 10 == 0)  sb.append("\n");
                }

            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}
