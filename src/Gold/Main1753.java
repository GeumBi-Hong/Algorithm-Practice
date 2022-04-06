/*
package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//최단 경로

public class Main1753 {


    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx,int cost){
            this.idx=idx;
            this.cost=cost;
        }


        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static ArrayList<ArrayList<Node>> arrayLists = new ArrayList<>();
    static int [] distance;
    static boolean [] visited;
    static int INF = 200001;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        distance = new int[V+1];
        visited = new boolean[V+1];

        //최대값으로 초기화
        Arrays.fill(distance,INF);


        //ArrayList초기화
        for(int i=0;i<=V;i++){
            arrayLists.add(new ArrayList<>());
        }


        while (E -->0){
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            //여러 간선이 있을 수 있음.
            arrayLists.get(u).add(new Node(v,w));
        }
        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        distance[start]=0;
        visited[start]=true;
        priorityQueue.add(new Node(start,0));

        while (!priorityQueue.isEmpty()){
            Node n = priorityQueue.poll();
            int currNode = n.idx;
            int currCost = n.cost;

           if(visited[currNode]){
               continue;
           }

            for(int i =0; i<arrayLists.get(currNode).size();i++){ //현재노드와 인접한 노드들중에
                Node n2 = arrayLists.get(currNode).get(i);

                int nextNode = n2.idx;
                int nextCost = n2.cost;

                if(!visited[nextNode]&&distance[nextNode] > currCost+nextCost){
                    distance[nextNode] = currCost+nextCost;
                    priorityQueue.add(new Node(nextNode,distance[nextNode]));
                }

            }
        }
    }
}
*/
