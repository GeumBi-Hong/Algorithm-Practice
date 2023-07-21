package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main10282 {
    static class Node {
        int idx;
        int cost ;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;


        //테스트 케이스 수 만큼 반복
        for(int t = 0 ; t <T ; t++){

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); //의존성 개수
            int hacking = Integer.parseInt(st.nextToken()); //해킹 당한 컴퓨터 번호


            //인접 리스트
            ArrayList<ArrayList<Node>> graph = new ArrayList<>();

            for(int i = 0; i<=n;i++ ){
                graph.add(new ArrayList<Node>());
            }

            //연관관계 설정 (a,b) a가 b를 의존한다. a <-b
            for(int i = 0 ; i < d ; i++){

                st = new StringTokenizer(br.readLine());

                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());


                graph.get(from).add(new Node(to,cost));
            }

            int []answer = dijkstra(hacking,n,graph);

            sb.append(answer[0]+" "+answer[1]+"\n");



        }

        System.out.println(sb);

    }
    private static int [] dijkstra (int start ,int n , ArrayList<ArrayList<Node>> graph){

        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost,o2.cost)));
        queue.add(new Node(start,0));

        //각 정점에 대한 최소 비용 저장할 배열
        int [] dist = new int[n+1];

        //최대 값으로 초기화
        for(int i =0; i <=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        //출발점은 0
        dist[start] = 0;

        while (!queue.isEmpty()){

            Node curNode = queue.poll();

            if(dist[curNode.idx] < curNode.cost){
                continue;
            }




            for(int i = 0 ;  i < graph.get(curNode.idx).size();i++){
                Node nxtNode = graph.get(curNode.idx).get(i);

                if(dist[nxtNode.idx] > dist[curNode.idx] +  nxtNode.cost ){
                    dist[nxtNode.idx] =dist[curNode.idx] +  nxtNode.cost;
                    queue.offer(new Node(nxtNode.idx,dist[nxtNode.idx]));
                }

            }
        }

        //총 걸린 시간과 해킹 당한 컴퓨터의 개수 구하기
        int count = 0;
        int time = 0 ;
        for(int i = 1; i <=n;i++){
            if(dist[i]!= Integer.MAX_VALUE){
                time =  Math.max(time,dist[i]);
                count++;
            }


        }

        return new int[]{count,time};

    }
}
