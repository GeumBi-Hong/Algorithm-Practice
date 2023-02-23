package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916 {
    static int N ;
    static int  M;
    static ArrayList<Node>[] graph ;
    static int dist[];

    static class Node   {
        int idx; //도착 노드
        int cost; //도착 노드까지 가는 비용

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }


    }
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;


        N = Integer.parseInt(br.readLine()); //도시의 개수
        M = Integer.parseInt(br.readLine()); //버스의 개수

        graph = new ArrayList[N+1];
        dist = new int[N+1]; // 각 노드 최소 비용 저장

        for(int i = 0 ; i < N+1;i++){
            graph[i] = new ArrayList<>();
        }


        for(int i = 0 ; i < M ; i++){

            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 양방향
            graph[s].add(new Node(e,cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); //출발점의 도시번호
        int end = Integer.parseInt(st.nextToken()); //도착점의 도시번호

        //최소 비용을 저장하기위해 최대값으로 초기화
        for(int i = 1; i <N+1;i++){
            dist[i]= Integer.MAX_VALUE;
        }

        //시작점의 최소 비용은 0
        dist[start] = 0;

        //다익스트라 알고리즘
        dijkstra(start);

        //도착지점까지의 최소 비용 출력
        System.out.println(dist[end]);





    }

    private static void dijkstra (int start){

        //우선순위 큐 -> 최소 비용으로 정렬
        // PriorityQueue <Node> queue = new PriorityQueue<>();
        PriorityQueue <Node> queue = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        //첫 노드는 시작점 ,  비용은 0이다.
        queue.add(new Node(start,0));

        while (!queue.isEmpty()){

            Node currNode = queue.poll();

            if(dist[currNode.idx] < currNode.cost){
                continue;
            }

            //꺼낸 노드로부터 인접한 노드 최소 비용 갱신
            for(int i = 0 ; i< graph[currNode.idx].size();i++){
                //다음 인접 노드
                Node adjNode = graph[currNode.idx].get(i);
                // 다음 인접 노드의 비용 이  현재 선택된 노드의 최소비용 + 현재 선택된 노드에서 인접 노드까지 가는 비용의 합보다 클 경우 값을 갱신한다.
                if(dist[adjNode.idx] > currNode.cost+adjNode.cost){
                    dist[adjNode.idx] = currNode.cost+adjNode.cost;
                    queue.add(new Node(adjNode.idx,dist[adjNode.idx]));
                }

            }




        }


    }
}
