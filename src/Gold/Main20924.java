package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 20924. 트리의 기둥과 가지
 *
 * [고민]
 * - 인접 리스트도 결국 최악은 o(v^2) 아닌가 .. 그래서 N이 200,000개인데 ㄱㅊ나 라는 생각이 들었음. 어케 계산해야되나
 *
 * [좋은 풀이 같음]
 * https://www.acmicpc.net/source/30188056
 */
public class Main20924 {

    static class Node{
        private int num;
        private int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }


    static int N, R;
    static int gigaNode, pillarCost, maxLeafCost;

    static boolean findGigaNodeFlag = false;


    static ArrayList<Node>[] treeList;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        treeList = new ArrayList[N + 1];
        isVisited = new boolean[N + 1]; //해당 노드에 방문 했었는지 체크하기 위함

        for (int i = 1; i <=N; i++){
            treeList[i] = new ArrayList<>();
        }

        //[1]트리 그래프 만들기
        for(int i = 0 ; i < N -1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            treeList[a].add(new Node(b,cost));
            treeList[b].add(new Node(a,cost));
        }

        //노드 개수가 1개 일때는 제외하고 해야함
        if (N != 1){
            //[2] 루트 노드에서 부터 기가 노드 : 기둥 길이
            // 일단 처음으로 자식 노드의 개수가 2개 이상 나오는 노드가 기가 노드인데
            // (1) 리프 노드가 딱 단 하나일 경우 그 리프 노드가 기가 노드가 될 수 있음
            // (2) 루트 노드가 기가 노드 될 수 있음
            // (3) 그냥 노드
            isVisited[R] = true;
            findGigaNode(R,0);
            //[3] 기가노드에서 리프 노드 : 가장 긴 가지 길이
            isVisited[gigaNode] = true;
            findMaxLeafCost(gigaNode,0);
        }

        //[4] 정답 출력
        System.out.println(pillarCost+" "+maxLeafCost);

    }


    //기가 노드 찾기
    //깊이 우선? 식으로 들어가야될듯
    private static void findGigaNode(int node ,int cost){
        if(findGigaNodeFlag) return;

        //이제 여기가 문젠데.. 기가 노드 인 경우가 좀 다양함..
        //루트 노드 였을때는 자식 개수가 두개 이상 이어야함 즉 간선 개수가 2개 이상 루트 노드는 부모가 없음
        //그리고 그냥 3개였을 때
        //마지막으로 그냥 리프노드였을떄는 어카지 .. 간선 개수가 1개인 경우 를 찾으면 된다. 1개 짜리 뒤로 막 3개인 경우가 나올 수 있냐 라고 했을때 나올 수 없음
        //그러면 이미 3개짜라나 다른 경우가 먼저 걸렸겠지, 끝까지 가다가다 없는 상황이 왓을때까지 간 경우인듯
        //그리고 이 경우는 시작 점은 제외 해야함 루트 노드간선이 하나인 경우가 있는데 이걸로 바로 걸러져버리면 안됨 뒤에 다른 경우 가 있는데 리프노드로 생각해버릴 수 있음
        if(treeList[node].size() >= 3 || (node == R  && treeList[node].size() >= 2) || ( node != R && treeList[node].size() ==1)){
            gigaNode = node;
            pillarCost = cost;
            findGigaNodeFlag = true;
            return;
        }

        for (Node nextNode : treeList[node]){
            //방문 했던 곳이면 다시 가지 않는다.
            if (isVisited[nextNode.num]) continue;
          //  System.out.println(node+"방문 노드"+nextNode.num+"다음노드");
            isVisited[nextNode.num] = true;
            findGigaNode(nextNode.num, cost + nextNode.cost);
        }
    }

    //가장 긴 가지 길이 구하는 메서드
    private static void findMaxLeafCost(int node,int cost){
        //리프 노드 까지 왔을때
        if(treeList[node].size() == 1){
           maxLeafCost = Math.max(cost,maxLeafCost);
           return;
        }

        for (Node nextNode : treeList[node]){

            //방문 했던 곳이면 다시 가지 않는다.
            if (isVisited[nextNode.num]) continue;
          //  System.out.println(node+"방문 노드"+nextNode.num+"다음노드");
            isVisited[nextNode.num] = true;
            findMaxLeafCost(nextNode.num, cost + nextNode.cost);
        }

    }
}
