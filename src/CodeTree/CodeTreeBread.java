package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeTreeBread {

    static class Node{
        int r;
        int c;

        public Node (int r ,int c){
            this.r = r;
            this.c = c;
        }

        public boolean isSame(Node n){
            return this.r == n.r && this.c == n.c;
        }
    }


    static int N , M;
    static final int MAX_N = 15;
    static final int MAX_M = 30;
    static final  Node EMPTY = new Node(-1,-1);

    //↑, ←, →, ↓ 순서로 진행해야함 . 그래야 우선 순위 대로 찾을 수 있음
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};

    static int[][] map = new int[MAX_N][MAX_N];

    //편의점 좌표
    static Node[] storeLocation = new Node[MAX_M];

    //사람 좌표
    static Node[] personLocation = new Node[MAX_M];

    static boolean[][] isVisited = new boolean[MAX_N][MAX_N]; //방문 여부 표시
    static int[][] step = new int[MAX_N][MAX_N];      // 최단거리 결과 기록

    static int currTime = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //사람 수 m

        //좌표 값 저장
        for (int i = 0; i < N; i++) {

          st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        //편의점 좌표 입력값 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            storeLocation[i] = new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
            //사람의 초기 좌표를 (-1,-1)로 설정한다.
            personLocation[i] = EMPTY;

        }

        //시뮬 시작
        while (true){

            currTime++;
            /**123번 과정을 거친다 **/
            simulation();
            /**모든 사람이 편의점에 도착하였다면 종료한다.**/
            if(end())break;
        }

        System.out.println(currTime);

    }
    private static void simulation(){

        //아직 격자 밖에 있는 사람이거나 편의점에 도착한 사람의 경우는 넘어간다.
        //[1단계] 상 좌 우 하 우선순위로 1칸 이동한다.
        for(int i = 0; i < M; i++){
            if(personLocation[i].isSame(EMPTY) || personLocation[i].isSame(storeLocation[i])) continue;




            //1. 상 좌 우 하 우선순위로 1칸 이동한다.
            // 원래는 현재 위치에서 편의점 위치까지의 최단거리를 구해줘야 한다.
            // 다만 최단거리가 되기 위한 그 다음 위치를 구하기 위해서는
            // 거꾸로 편의점 위치를 시작으로 현재 위치까지 오는 최단거리를 구해주는 주어야한다.

            bfs(storeLocation[i]);


            //현재 사람의 좌표 기준으로 상좌우하 중 최단 거리값이 가장 작은 곳을 고르면
            // 그 곳으로 이동하는 것이 최단거리 대로 이동하는 것이 된다.
            //그러한 위치 중 우선순위 대로 가장 적절한 곳을 찾는다.

            int pr = personLocation[i].r; int pc = personLocation[i].c;
            int minDist = Integer.MAX_VALUE;
            int minR = -1; int minC = -1;

            for(int d = 0 ; d < 4; d++){
                int nr = pr + dr[d]; int nc = pc +  dc[d];
                if(inRange(nr,nc) && isVisited[nr][nc] && minDist > step[nr][nc]){
                    minDist = step[nr][nc];
                    minR = nr;
                    minC = nc;
                }
            }

            //우선순위가 가장 높은 위치로 한 칸 움직인다.
            personLocation[i] = new Node(minR,minC);





        }//for

        //[2단계] 편의점에 도착한 사람에 한하여 앞으로 도착할 수 없는 좌표를 2로 변경한다.
        for (int i = 0 ; i < M ;i++){
            if(personLocation[i].isSame(storeLocation[i])){
                map[personLocation[i].r][personLocation[i].c] = 2;
            }
        }//for

        //[3단계] 현재시간 currTime에 대하여 currTime <= M을 만족한면 t번 사람이 베이스 캠프로 이동한다.


        //3-1) M보다 현재 초 가 크면 패스한다.
        if(currTime > M) return;


        //3-2) 그렇지 않으면 bfs 탐색을 하여 가장 가까운 거리의 베이스 캠프를 찾는다.
        bfs(storeLocation[currTime-1]);


        //3-3) 편의점에서 가장 가까운 베이크 캠프를 찾는다. r,c가 증가하는 순으로 돌린다.
        // 그 이유는 가장 가까운 베이스 캠프가 여러가지여도 알아서(행,열) 우선순위대로 골라진다.

        int minDist =Integer.MAX_VALUE;
        int minR = -1 ; int minC = -1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                if(isVisited[r][c] && map[r][c] == 1 && minDist > step[r][c]){
                    minDist = step[r][c];
                    minR = r;
                    minC = c;
                }

            }

        }

        //3-4) 따라서 해당 좌표로 사람을 이동시키고 다시는 방문할 수 없도록 처리한다.
        personLocation[currTime-1] = new Node(minR,minC);
        map[minR][minC] = 2;


    }

    private static void bfs(Node start){

        //편의점 좌표를 시작점으로 bfs를 돌린다.

        //초기화
        for (int r = 0; r < N; r++) {
            for (int c = 0; c <  N; c++) {
              isVisited[r][c] = false;
              step[r][c] = 0;
            }

        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);
        isVisited[start.r][start.c] = true;
        step[start.r][start.c]  = 0;


        while (!queue.isEmpty()){


            Node curNode = queue.poll();


            int curR = curNode.r;
            int curC = curNode.c;

            for(int i = 0 ; i < 4 ; i++){
                int nextR = dr[i] + curR;
                int nextC = dc[i] + curC;

                //다음 이동할 좌표는
                //1.격자 안의 범위에 존재해야하며
                //2.방문하지 않은 곳이어야하고
                //3.갈수 있는 좌표이여야한다.
                if(inRange(nextR,nextC) && !isVisited[nextR][nextC] && map[nextR][nextC] != 2){
                    //방문 처리
                    isVisited[nextR][nextC] = true;
                    step[nextR][nextC] = step[curR][curC] + 1;
                    queue.add(new Node(nextR,nextC));

                }
            }

        }

    }
    private static boolean inRange (int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    //전부 편의점에 도착하였는지 확인
    private static boolean end(){
        for (int i = 0; i < M; i++) {
           if (!personLocation[i].isSame(storeLocation[i])) return false;

        }
        return true;
    }

}
