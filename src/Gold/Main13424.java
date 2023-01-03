package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main13424 {
    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수

        //테스트 케이스 수 만큼 반복
        for(int t = 0 ; t < T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 방 개수
            int M = Integer.parseInt(st.nextToken()); // 비밀통로 개수


            //인접리스트
            ArrayList<ArrayList<Node>> graph = new ArrayList<>();

            for(int i = 0 ; i <=N;i++){
                graph.add(new ArrayList<Node>());
            }

            //양방향 관계 설정

            for(int i = 0 ; i < M ; i++){
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(from).add(new Node(to,cost));
                graph.get(to).add(new Node(from,cost));

            }


            //몇명의 친구
            int friendCount = Integer.parseInt(br.readLine());
            int friendRoom [] = new int[friendCount];
            st = new StringTokenizer(br.readLine());
            //친구가 존재하는 방 번호 저장
            for(int i = 0 ; i<friendCount ; i++){
                friendRoom[i]=Integer.parseInt(st.nextToken());
            }



            int [][]friendDist  = new int[friendCount][N+1];


            //다익스트라 해서 최소 비용구하기
            for(int i = 0; i < friendCount;i++){
                friendDist[i]=dijkstra(N,graph,friendRoom[i]);
            }


            int dist = Integer.MAX_VALUE;
            int answer = -1 ;

            //최소비용을 가질 수 모임방 찾기
            for(int i = 1; i<=N;i++){

                int sum = 0;
                 for(int j = 0 ; j<friendCount;j++){
                     sum += friendDist[j][i];
                 }

                 if(dist > sum){
                     dist=sum;
                     answer = i;
                 }

            }

            System.out.println(answer);




        }

    }

    private static int[] dijkstra (int N , ArrayList<ArrayList<Node>> graph,int start){


        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        int[]dist = new int[N+1];

        for(int i = 0 ; i <=N;i++){
            dist[i]= Integer.MAX_VALUE;
        }
        dist[start]= 0;

        queue.add(new Node(start,0));


        while (!queue.isEmpty()){

            Node curNode = queue.poll();

            if(dist[curNode.idx] < curNode.cost){
                continue;
            }

            for(int i = 0 ; i<graph.get(curNode.idx).size();i++){
                Node nxtNode = graph.get(curNode.idx).get(i);

                if(dist[nxtNode.idx] > dist[curNode.idx]+ nxtNode.cost){
                    dist[nxtNode.idx] = dist[curNode.idx]+ nxtNode.cost;
                    queue.offer(new Node(nxtNode.idx,dist[nxtNode.idx]));
                }
            }
        }

        return dist;

    }
}
