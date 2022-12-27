package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1504 {
    static class Node {
        int idx;
        int cost ;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static int N ,E ;
    static int MAX = 10000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점의 수
        E = Integer.parseInt(st.nextToken()); //간선의 수


        //인접리스트
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0 ; i <=N;i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0 ; i < E ; i++){

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //양방향 관계
            graph.get(from).add(new Node(to,cost));
            graph.get(to).add(new Node(from,cost));
        }

        //반드시 지나야 하는 두 정점
        st= new StringTokenizer(br.readLine());
        int pointA = Integer.parseInt(st.nextToken());
        int pointB = Integer.parseInt(st.nextToken());

        // 시작점 1: ,  반드시 지나야하는 정점 A,B , 도착지 N



      if(pointA==1 && pointB==N){
          int []distN = dijkstra(N,0,graph);
         System.out.println(distN[1]==MAX?- 1 :distN[1]);
      }else if(pointA ==1 && pointB!=N){

          // 1- >B ->N
          int []distB = dijkstra(1,pointB,graph);
          int []distN = dijkstra(N,0,graph);

          int answer = distB[pointB]+distN[pointB];
          System.out.println(answer>=MAX?-1:answer);

      }else if(pointA!=1 && pointB==N){

          int []distA = dijkstra(1,pointA,graph);
          int []distN = dijkstra(N,0,graph);
          int answer = distA[pointA]+distN[pointA];
          System.out.println(answer>=MAX?-1:answer);

      }else {

          int []distA = dijkstra(1,pointA,graph);
          int []distAB= dijkstra(pointA,pointB,graph);
          int []distBA= dijkstra(pointB,pointA,graph);
          int []distN = dijkstra(N,0,graph);

          int courseA = distA[pointA]+distAB[pointB]+distN[pointB];
          int courseB = distA[pointB]+distBA[pointA]+distN[pointA];

          if(courseA >=MAX && courseB >=MAX) {
              System.out.println(-1);
          }else{
              int answer = Math.min(courseA,courseB);

              System.out.println(answer);
          }
      }




    }
    private static int[] dijkstra (int start , int end ,ArrayList<ArrayList<Node>>graph){


        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost,o2.cost)));

        int []dist = new int[N+1];


        for(int i = 1 ; i <= N ; i++){
            dist[i] = MAX;
        }

        //시작점의 초기값은 0

        dist[start] = 0;
        priorityQueue.add(new Node(start,0));

        while (!priorityQueue.isEmpty()){

            Node currNode = priorityQueue.poll();



            if(currNode.idx==end){
                break;
            }
            if(dist[currNode.idx] < currNode.cost){
                continue;
            }


            for(int i = 0 ; i < graph.get(currNode.idx).size();i++) {
                Node nxtNode = graph.get(currNode.idx).get(i);

                if(dist[nxtNode.idx] > dist[currNode.idx]+nxtNode.cost){
                    dist[nxtNode.idx] = dist[currNode.idx]+nxtNode.cost;
                    priorityQueue.add(new Node(nxtNode.idx,dist[nxtNode.idx]));

                }
            }
        }



        return dist;
    }
}
