package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * GOLD 2 : 가운데를 말해요
 * 자료구조 - 우선순위큐
 *
 * [첫 풀이]
 *
 * 처음에는 가운데 인덱스 기준으로 3개의 수를 유동적으로 계속 바꾸는 식으로 풀이하려했음
 * 뭐 예를 들면  1   3    5 이렇게 있다고 했을 때 다음 수가 1과 3사이 혹은 3과 5사이 이렇게 왔을때 정답을 가지는 부분만 계속 바꿔가면서 출력하려했슴.
 * 근데 중간에 하다 꼬임
 *
 * 일단 완탐 기준으로 생각했을때는 매번 N번 만큼 정렬 시켜버려서 중간 인덱스 찾아서 출력하면 끝. 근데 이는 N * NLogN ? 이여서 시간상 안될거임
 * 어짜피 가운데 수만 찾으면 되기도 하고 매번 정렬할 필요가 없다고 생각함, 정렬되어있는거에서 수 하나만 찾아서 넣으면되니까
 * 그래서 가운데 인덱스 기준으로 수 범위를 체크해서 매번 갱신하려 했음
 *
 * 근데 이 풀이는...전혀 생각못함..
 *
 * maxHeap과 minHeap을 두어서 size크기를 계속 똑같이 만든다. 그렇다고 하면 계속 3 3 4 4이렇게 맞을테니 가운데 인덱스를 쉽게 찾을 수 있을 것이다.
 * 그리고 짝수개일 경우 작은 수를 출력하라 했는데 뭐 maxHeap에서 peek하면 되니까..
 * 뭐 이부분까지는 어케 이해를 하겠는데 이 swap시키기 까지 생각해 낼 수 있었을까
 *
 * 1 3 10 |  2  14  51 이렇게  들어왔다고 하면 가운데 수를 찾기 힘드니 peek한 값을 swap하여 계속 맞춰간다.
 * 1 2  3|  10 14 51
 *
 * 이렇게 딱 중간 힙을 유지하는게 key point 였다...
 */

public class Main1655 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <N; i++) { // 시간 복잡도  N

            int num = Integer.parseInt(br.readLine()); //숫자 부르기

            if(minHeap.size() == maxHeap.size()) maxHeap.add(num);
            else minHeap.add(num);


            if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }
            sb.append(maxHeap.peek() + "\n");

        }

        System.out.println(sb);

    }
}
