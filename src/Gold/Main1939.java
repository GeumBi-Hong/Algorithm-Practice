package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 풀이시간 1시간 20분
 * - 이분탐색에서 isVisted..배열 초기화 안해서..계속틀림.
 * - 분류를 보니 다른 풀이도 존재할거같음
 * - 본인은 이분 탐색 + dfs로 품
 */
public class Main1939 {

    /**
     * e 섬 번호
     * w e와 연결된 다리의 중량제한
     */

    static class Info{
        int e;
        int w;

        public Info(int e,int w){
            this.e=e;
            this.w=w;
        }
    }

    /**
     * A,B 공장이 세워진 섬의 번호
     * arrayLists 인접리스트로 섬의 관계를 저장
     * canGoFlag 이분탐색으로 정한 물품의 무게로 A->B로 갈수 있는지 없는지 체크하는 flag변수
     */
    static int A,B;
    static ArrayList<Info>[] arrayLists ;
    static boolean isVisited[];
    static boolean canGoFlag = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //섬 개수
        int M = Integer.parseInt(st.nextToken()); // 다리 개수

        /**
        * 섬의 번호가 1번 부터 시작하기때문에 섬의개수 +1 해서 패딩 해줌
         */
        isVisited = new boolean[N+1];
        arrayLists = new ArrayList[N+1];
        for(int i = 1; i <=N ;i++){
            arrayLists[i] = new ArrayList<Info>();
        }

        //인접 리스트에 섬 관계 저장

        /**
         *  max 섬과 섬사이의 다리 중량 제한 중 가장 큰 값을 저장할거임(그 이유는 max보다 큰 물품의 무게로 탐색하지 않아도 되기때문)
         *
         */
        int max = -1;
        for(int i = 0 ; i <M;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //양방향 관계
            arrayLists[start].add(new Info(end,weight));
            arrayLists[end].add(new Info(start,weight));

            max= Math.max(max,weight);
        }

        //공장이 세워진 두 섬의 번호
        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


       /**
        *   이진 탐색의 범위  (물품의 무게를 이진 탐색을 통해 찾을 거임)
        *   문제의 C(다리 중량 제한)범위가 (1 <= C <= 1_000_000_000 (10억)) 임
        *   따라서 물품의 무게 범위도 (0 or 1 <= 물품 무게 <=1_000_000,000) 인데
        *   이걸 처음부터 끝까지 다 탐색하면 10억 번 탐색해야되서 1초만에 안됨 o(n)
        *   따라서 o(n) 보다 더 작은 시간복잡도로 풀어야된다는걸 알수 있음
        *   그 방법 중 하나 이분탐색. (매개변수탐색) o(logN)
        */

       /**
        * left물품의 최소 무게
        * rigth 위에서 구한 다리 중 가장 큰 중량 무게
        * answer 이동해서 옮길 수 있는 물품의 무게
        *
        * left ~ right (물품의 무게 범위)
        */

        int left =0;
        int right = max;
        int answer = 0;

        while (left<=right){

            int mid = (left+right)/2;
            canGoFlag =false; // 다른 물품의 무게로 탐색할때마다 초기화 시켜줘야됨
            isVisited = new boolean[N+1];//*** 여기 빼먹어서 틀렷음 ㅠ 매번 새로운 판에서 dfs를 하기 때문에 isVisited 초기화.
            canGo(mid,A,B); // mid의 무게로 이동 가능한지 판단
            if(canGoFlag){ //갈 수 있다면 최대 중량을 늘린다.
                answer=mid;
                left=mid+1;
            }else { //갈 수 없다면 최대 중량을 줄인다.
                right= mid-1;
            }

        }

        System.out.println(answer);

    }
    private static void canGo(int weight_of_things,int start ,int end){
        isVisited[start]=true; //도착한 섬은 방문처리

        if(start==end){ //도착지에 도착했다면 c
            canGoFlag =true;
            return;
        }

        for(int i = 0 ; i < arrayLists[start].size();i++){
            if(canGoFlag)return; //계속 빠져나오게 해줌 ( 여기서 아주조금? 단축)
            Info nextInfo = arrayLists[start].get(i);

            int next = nextInfo.e; //다음 섬의 번호
            int cost = nextInfo.w; // 다리 중량
            if(!isVisited[next]&&weight_of_things<=cost){ //다음 갈 섬은 방문했던 섬이면 안되고 물품이 다리 중량보다 작거나 같아야만함 (그래야만 통과를할테니)
                canGo(weight_of_things,next,end); //된다면 깊이 우선 탐색으로 탐색

            }

        }

    }
}
