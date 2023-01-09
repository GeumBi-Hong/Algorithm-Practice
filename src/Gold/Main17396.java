package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17396{

    static class Node {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static long MAX_VALUE = 9999900001L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수


        boolean []isShow = new boolean[N]; //해당 정점이 시야에 보이는지 저장하기 위한 배열

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            if(Integer.parseInt(st.nextToken())==1){
                isShow[i]=true; // 시야에 보이는 정점이라면 true;
            }
        }

        //인접 리스트
        ArrayList<Node> [] graph = new ArrayList[N];

        for(int i = 0 ; i < N ; i++){
            graph[i] = new ArrayList<Node>();
        }


        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //양방향 관게 설정
            graph[from].add(new Node(to,cost));
            graph[to].add(new Node(from,cost));
        }


        long dist = dijkstra(N,graph,isShow);

        // dist 가 MAX_VALUE 라면 넥서스 까지 가지 못하는 경우이기때문에 -1를 출력하고 그렇지 않으면 최소비용을 출력한다.
        System.out.println(dist==MAX_VALUE?"-1":dist);
    }


    private static long dijkstra (int N ,ArrayList<Node> [] graph , boolean[]isShow) {


        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost,o2.cost));
        //정점까지의 최소비용을 갱신하는 배열을 long으로 잡은 이유는
        //어느 한 정점에서 정점까지 비용이 최대 10만이다.
        // 그런데 최대로 정점이 10만개가 주어질 수 있다.
        //이렇게 되었을때 최악의 경우 10만 * 약 10 만 = 100억 의 비용이 발생하기때문에 long형으로 선언해야한다.
        long [] dist = new long[N];
        for(int i = 0; i < N; i++){
            dist[i] = MAX_VALUE;

        }

        dist[0]=0;
        queue.add(new Node(0,0));

        while (!queue.isEmpty()){

            Node currNode = queue.poll();



            //도착지점에 오면 break;
            if(currNode.idx==N-1)break;
            if(dist[currNode.idx] < currNode.cost) continue;


            for(int i = 0 ; i< graph[currNode.idx].size();i++){

                Node nxtNode = graph[currNode.idx].get(i);

                //만약 다음 이동할 노드가 적에 시야에 보인다면 탐색하지 않는다. 넥서스의 경우 이동가능
                if(isShow[nxtNode.idx] && nxtNode.idx!=N-1)continue;

                if(dist[nxtNode.idx] > dist[currNode.idx]+ nxtNode.cost ){
                    dist[nxtNode.idx] = dist[currNode.idx]+ nxtNode.cost;
                    queue.offer(new Node(nxtNode.idx,dist[nxtNode.idx]));

                }
            }

        }

        return dist[N-1];
    }

}
