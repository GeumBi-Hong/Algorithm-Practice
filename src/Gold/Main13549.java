package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13549 {
    static class  Node {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수빈의 위치
        int K = Integer.parseInt(st.nextToken()); //동생의 위치

        // 0초 순간이동 X*2
        // 1초 양 옆이동 X-1 , X+1

        int [] cost = new int[100_001];

        for(int i = 0 ; i <=100_000;i++){
            cost[i]=Integer.MAX_VALUE;
        }


     Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(N,0));
        cost[N]=0; //수빈의 처음 위치는 0

        while (!queue.isEmpty()){

            Node curNode = queue.poll();
            //동생을 찾았을 경우 while문을 빠져 나온다.
            if(curNode.idx==K){;
                break;
            }

            if(cost[curNode.idx] < curNode.time) continue;


            // 1. 현재 위치에서 순간이동을 하는 경우
            //순간이동할 좌표까지 가는 시간이 현재 시간보다 큰 경우 다시 갱신해주어야함
            if(curNode.idx*2<=100_000 && cost[curNode.idx*2] > curNode.time){
                cost[curNode.idx*2]= curNode.time;
                queue.offer(new Node(curNode.idx*2, cost[curNode.idx*2]));
            }

            // 2.  현재 위치에서 양 옆으로 움직이는 경우
            if(curNode.idx+1<=100_000 &&cost[curNode.idx+1] > curNode.time+1){
                cost[curNode.idx+1]= curNode.time+1;
                queue.offer(new Node(curNode.idx+1, cost[curNode.idx+1]));
            }
            if(curNode.idx-1>=0 &&cost[curNode.idx-1] > curNode.time+1){
                cost[curNode.idx-1]= curNode.time+1;
                queue.offer(new Node(curNode.idx-1, cost[curNode.idx-1]));
            }

        }


        System.out.println(cost[K]);



    }
}
