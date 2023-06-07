package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미네랄
 *
 *  왼쪽 or 오른쪽 차례로 막대를 던진다.
 * 미네랄을 맞췄다 : 바닥에 있는 애를 기준으로 방문체크 (공중에 떠있지 않는 클러스터)
 * 그럼 나머지 애들이 지금 공중에 떠있다고 봐도됨
 * 한칸씩 아래로 이동시키면서 이동시킬수 있을때까지 움직인다.
 *
 *
 */
public class Main2933 {

    static class Dot{

        private int r;
        private int c;

        public Dot(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C, N;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //미네랄 Map
        map = new char[R][C];
        //방문 체크
        isVisited = new boolean[R][C];

        for(int r = 0; r < R; r++){
           String str = br.readLine();
            for(int c = 0; c < C; c++){
             map[r][c] = str.charAt(c);
            }
        }

        //막대를 던진 횟수
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        /** 막대 던지기 시작 **/
        for(int i = 1 ; i <=N; i++){
            int height = R - Integer.parseInt(st.nextToken());

            int col = throwStick(i,height);
            //미네랄이 깨졌다면 공중에 떠있는 클러스터가 있는지 확인하고 아래로 떨군다.
            if(col != -1){
                checkCluster();
            }

        }

        System.out.println(answer());
    }
    private static void printMap (){

        for(int r= 0; r<R ;r++){
            for(int c=0;c<C;c++){
                System.out.print(map[r][c]+" ");
            }
            System.out.println();
        }
    }


    private static String answer (){
        StringBuilder sb = new StringBuilder();

        for(int r= 0; r < R ;r++){
            for(int c=0; c < C ;c++){
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    /** 막대기 던지기 **/
    private static int throwStick(int index, int row){

        //어느 열 좌표에서 미네랄이 깨졌는지 저장
        int col = -1;

        if(index % 2 == 1){
            //홀수경우 왼쪽에서 오른쪽으로 막대 이동
            for(int c = 0 ; c < C; c++){
                if(map[row][c] == 'x'){
                    map[row][c] = '.';
                    col = c;
                    break;
                }
            }

        }else {
            //짝수의 경우 오른쪽에서 왼쪽으로 막대 이동
            for(int c = C -1;  c >=0; c--){
                if(map[row][c] == 'x'){
                    map[row][c] = '.';
                    col = c;
                    break;
                }
            }
        }

        return col;
    }

    /** 클러스터 확인하기 **/
    private static void checkCluster(){
        isVisited = new boolean[R][C];

        //바닥(땅) 범위를 체크한다 땅에 닿아있는 클러스터를 먼저 탐색.
        for(int c = 0 ; c < C; c++){
            //방문 되어있지 않고 미네랄 칸인경우만 클러스터 bfs 체크를 한다.
            if(!isVisited[R-1][c] && map[R-1][c] == 'x'){
                bfs(R-1,c);
            }
        }

        //그렇지 않고 떠있는 클러스터 하나씩 찾아서 리스트에 저장

        ArrayList<Dot> arrayList = new ArrayList<>();

        //이동 시켜야하는 미네랄 위치 저장
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(!isVisited[r][c] && map[r][c] == 'x'){
                    arrayList.add(new Dot(r,c));
                    map[r][c] = '.';
                }
            }
        }
        if(arrayList.isEmpty()) return;

        /** 얼만큼 아래로 이동할 수 있는지 공중에 떠있는 클러스터 좌표를 한칸씩 아래로 이동시킨다 갈 수 없는 경우는 이동하지 않고 빠져나온다.*/
        boolean canMove = true;
        while (canMove){
            for (Dot dot : arrayList) {
                int nr = dot.r + 1;
                int nc = dot.c;

                if (!isRange(nr,nc) || map[nr][nc]== 'x'){
                    canMove = false;
                    break;
                }
            }

            if(canMove){
                for (Dot dot : arrayList) {
                    dot.r++;
                }
            }
        }

    /**   이동 시킬 좌표로 미네랄 이동 **/
        for (Dot dot : arrayList) {
            map[dot.r][dot.c] = 'x';
        }

    }
    /** 너비 우선 탐색 **/
    private static void bfs (int r ,int c){

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r,c});
        isVisited[r][c] = true;


        while (!queue.isEmpty()){

            int[] curr = queue.poll();

            for(int i = 0 ; i < 4; i++){

                //다음 이동할 좌표
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if(!isRange(nr,nc))continue;

                if(!isVisited[nr][nc] && map[nr][nc] == 'x'){
                    queue.add(new int[]{nr,nc});
                    isVisited[nr][nc] = true;
                }
            }
        }
    }


    /** 2차원 배열 범위 체크 **/
    private static boolean isRange(int r ,int c){
        return r>=0 && r < R && c >= 0 && c < C ;
    }
}
