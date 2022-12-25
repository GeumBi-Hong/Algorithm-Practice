package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main20160 {
    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static int V , E ;
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); //정점의 개수
        E = Integer.parseInt(st.nextToken()); //간선의 개수

        //인접 리스트
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0 ; i <=V;i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0 ; i < E; i++){

            st = new StringTokenizer(br.readLine());

            int from  = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());


            //양방향임에 주의
            graph.get(from).add(new Node(to,cost));
            graph.get(to).add(new Node(from,cost));

        }
        //야구르트 아줌마가 지점 이동하는 순서를 저장한 배열
       int [] moveOrder= new int[10];

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < 10 ;i++){
            moveOrder[i] = Integer.parseInt(st.nextToken());
        }

        //나의 출발지점
        int myStart = Integer.parseInt(br.readLine());

        //내 출발점으로 부터 다른 지점 까지 가는데 걸리는 비용을 구함
        int [] myCost = dijkstra(graph,myStart);


        //야구르트 아줌마가 이전에 순차적으로 지점을 방문해온 시간을 저장하는 변수
        //**주의 ** : beforetime 은 long으로 선언해야한다.
        //그 이유는 예를 들어 a->b까지 가는 경우의 최소 비용이 최악의 경우 10,000 x 100,000 이면 10억이다.
        //그런데 다음 지점으로 가는게 b->a가 또 최악으로 10억이라고 치자
        //그러면 이전에 방문했던 지점의 시간 비용을 누적해서 더해주어야 할때 20억 이상 , 즉 int형 범위를 넘어선다.
        //따라서 long으로 선언.
        long beforetime = 0;

        int answer  =10_001;

        //내 출발점과 아줌마의 출발점이 같다면 이 출발점을 정답으로 초기화 시켜준다.
        if(myStart ==moveOrder[0]) {
            answer = myStart;
        }

        //야구르트 아줌마가 10개의 지점을 순차적으로 이동
        //8까지만 하게 한 이유는 index 가 9일때는 다음 이동할 지점이 없기때문에 다익스트라 알고리즘을 사용할 필요가 없기때문
        for(int i = 0 ; i <9;i++){

            // i 번째 지점에서 다른 지점으로 가는 최소 비용을 구한다.
          int [] cost = dijkstra(graph,moveOrder[i]);

            //다음 이동 가능한 지점의 인덱스 번호를 저장하기 위한 변수
             int nextIdx = i+1;

             //방문 할 수 없는 지점이라면  그 다음 번호의 지점을 탐색한다. 방문할 수 있는 지점을 찾는다.
            while (cost[moveOrder[nextIdx]]==Integer.MAX_VALUE){
                //갈수 없는 경우이므로 다음 지점의 인덱스로 증가시킨다.
                   nextIdx++;
                    if(nextIdx>=10){
                        break;
                    }
                }

            //끝지점까지 왔다면 더 이상 구할 필요가 없다.
            if(nextIdx>=10)break;

            //야구르트 아줌마가 이동한 지점에 본인이 갈 수 있는지 없는지 비용을 비교한다.
            //여러 야구르트 점을 갈 수 있다면 번호가 작은 지점을 출력해야하므로 최소값으로 갱신한다.
            if(myCost[moveOrder[nextIdx]]<= beforetime+cost[moveOrder[nextIdx]] &&  moveOrder[nextIdx] < answer){
                answer=moveOrder[nextIdx];
            }
            //다음 방문할 지점의 비용을 구하기 위해 지금까지의 비용을 저장해둔다.
            beforetime+=cost[moveOrder[nextIdx]];

            i=nextIdx-1;


        }
        //방문한 지점이 없다면 -1을 리턴한다.
        if(answer==10_001) answer=-1;
        System.out.println(answer);

    }

    private static int[] dijkstra(ArrayList<ArrayList<Node>> graph ,int start){

        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost,o2.cost)));
        int []dist = new int[V+1]; //최소 비용을 저장할 배열

        for(int i = 1 ; i <=V;i++){
            dist[i]= Integer.MAX_VALUE;
        }

        //출발 지점의 최소 비용은  0
        dist[start]=0;

        queue.add(new Node(start,0));

        while (!queue.isEmpty()){

            Node  curNode = queue.poll();

            if(dist[curNode.idx] < curNode.cost){
                continue;
            }

            for(int i = 0 ; i < graph.get(curNode.idx).size();i++){

                Node  nxtNode = graph.get(curNode.idx).get(i);

                if(dist[nxtNode.idx] > dist[curNode.idx] + nxtNode.cost){
                    dist[nxtNode.idx] = dist[curNode.idx] + nxtNode.cost;
                    queue.add(new Node(nxtNode.idx,dist[nxtNode.idx]));
                }
            }

        }
        return dist;
    }
}
