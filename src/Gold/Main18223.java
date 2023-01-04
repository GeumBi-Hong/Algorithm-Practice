package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main18223 {
    static class Node {
        int idx;
        int cost ;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); //정점의 개수
        int E = Integer.parseInt(st.nextToken()); //간선의 개수
        int P = Integer.parseInt(st.nextToken()); //건우가 위치하는 정점


        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0 ; i <= V; i++){
            graph.add(new ArrayList<Node>());
        }

        // 양방향 관계 설정
        for(int i = 0 ; i <  E ; i++){

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to,cost));
            graph.get(to).add(new Node(from,cost));
        }


        //1->V =====  가 최소면 good bye
        //1->건우 ===== V  가 최소면 save him


        int []distStart= dijkstra(1,graph,V);

        int []distEnd = dijkstra(V,graph,V);

        System.out.println(distStart[V] >= distStart[P]+distEnd[P] ? "SAVE HIM": "GOOD BYE");


    }
    private static int [] dijkstra(int start , ArrayList<ArrayList<Node>> graph, int V){


        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost,o2.cost));

        int []dist = new int[V+1];
        for(int i = 0 ; i <=V; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start]=0;
        queue.offer(new Node(start,0));

        while (!queue.isEmpty()){

            Node curNode = queue.poll();

            if(dist[curNode.idx] < curNode.cost){
                continue;
            }


            for(int i = 0 ; i < graph.get(curNode.idx).size();i++){
                Node nxtNode = graph.get(curNode.idx).get(i);

                if(dist[nxtNode.idx] > dist[curNode.idx]+ nxtNode.cost){
                    dist[nxtNode.idx] = dist[curNode.idx]+ nxtNode.cost;
                    queue.add(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        return dist;
    }
}
