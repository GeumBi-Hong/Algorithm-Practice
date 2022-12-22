package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1238 {

    static class Node {
        int idx ;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int N,M,X;
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<ArrayList<Node>> reverseGraph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //마을 개수
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()); //파티하러갈 마을 번호

        //인접 리스트
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverseGraph = new ArrayList<>();

        for(int i = 0; i <=N;i++){
            graph.add(new ArrayList<Node>());
            reverseGraph.add((new ArrayList<Node>()));
        }

        //단방향 관계 연결
        for(int i = 0 ; i < M; i++){

            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //단방향
            graph.get(from).add(new Node(to,cost));
            //관계를 반대로 저장 ->  각마을에서 파티마을로 가는 최소 비용을 구하기 위함
            reverseGraph.get(to).add((new Node(from,cost)));

        }

        //각 마을에서 ->  파티장으로 가는  최소 비용
        int [] villageCost = dijkstra(X,reverseGraph);
        //파티를 개최한 마을 -> 각 마을 으로 가는 비용
        int [] homeCost =  dijkstra(X,graph);


        int maxCost = Integer.MIN_VALUE;

        for(int i =1; i<=N;i++){
            maxCost=Math.max(maxCost,villageCost[i]+homeCost[i]);
        }

        System.out.println(maxCost);

    }
    private static int[] dijkstra (int start ,ArrayList<ArrayList<Node>>graph){


        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost,o2.cost)));
        int [] dist = new int[N+1];

        for(int i =1; i<=N;i++){
            dist[i]= Integer.MAX_VALUE;
        }

        queue.add(new Node(start,0));
        dist[start]=0 ;;//출발지에서 출발지로 가는 비용은 0

        while (!queue.isEmpty()){

            Node currNode = queue.poll();


            if(dist[currNode.idx] < currNode.cost ){
                continue;
            }

            for(int i = 0 ; i < graph.get(currNode.idx).size();i++){

                Node nxtNode = graph.get(currNode.idx).get(i);

                if(dist[nxtNode.idx] > dist[currNode.idx] + nxtNode.cost){
                    //최소 비용으로 갱신
                    dist[nxtNode.idx] = dist[currNode.idx] + nxtNode.cost;
                    queue.offer(new Node(nxtNode.idx,dist[nxtNode.idx]));
                }

            }

        }

        return dist;
    }
}
