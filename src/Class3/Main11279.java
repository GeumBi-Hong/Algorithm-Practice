package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main11279 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 큰 값이 가장 위


        int N = Integer.parseInt(br.readLine()); //연산의 개수

        while (N-->0){
            int num = Integer.parseInt(br.readLine());

            if(num==0){
                if(queue.isEmpty()){
                    sb.append("0").append("\n");
                }else {
                    sb.append(queue.poll()).append("\n");
                }
            }else {
                queue.add(num);
            }
        }
        System.out.print(sb);

    }
}
