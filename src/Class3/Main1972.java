package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1972 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine()); //연산의 개수

        while (N -- > 0){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){ //0일때
                if(queue.isEmpty()){ //우선순위 큐가 비어있다면 0을 출력한다.
                    sb.append("0").append("\n");
                }else {
                    sb.append(queue.poll()).append("\n");
                }
            }else { //0이 아닐때
                queue.add(num);
            }
        }

        System.out.print(sb);

    }
}
