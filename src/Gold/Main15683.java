package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15683 {

    static class CCTV {
        int r;
        int c;
        int type;

        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    static int N,M ;
    static int [][] map;
    static int [] dr =  {0,-1,0,1};
    static int [] dc = {-1,0,1,0};

    static int [][][]direction = { {{0}}, //패딩
            {{0},{1},{2},{3}}, // 1
            {{1,3},{0,2}}, //2
            {{1,2},{2,3},{3,0},{0,1}},//3
            {{0,1,2},{1,2,3},{2,3,0},{3,0,1}},//4
            {{0,1,2,3}}//5
    };
    static int block = 0;
    static ArrayList <CCTV> cctvIndexList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int r = 0 ; r <  N ; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c]!=0 && map[r][c]!=6){
                    cctvIndexList.add(new CCTV(r,c,map[r][c]));
                }
                if(map[r][c]==0){
                    block++; //사각지대 개수
                }
            }
        }

        int [][] copyMap = new int[N][M];
        copyMap = copyMap(copyMap, map);
        backTracking(0,copyMap,0);

        System.out.println(answer);

    }

    private static void backTracking (int cur,int [][]origin,int count){

        if(cur == cctvIndexList.size()){
            //감시가 안된 전체 구역 개수 (block) - 감시된 구역의 개수  - > 의 최소값을 갱신한다.
            answer = Math.min(answer,block-count);
            return;
        }

        int [][] tempMap  = new int[N][M];
        tempMap = copyMap(tempMap,origin);

        CCTV cctv = cctvIndexList.get(cur); //현재 cctv에 대한 객체

        for(int i = 0 ; i <direction[cctv.type].length;i++){
            int sum = 0; //감시된 구역의 개수
           for(int j = 0 ; j < direction[cctv.type][i].length;j++){ //감시해야되는 방향마다 탐색하여 감시된 구역의 합을 누적한다.
               int selectDirection = direction[cctv.type][i][j];
               sum+=findBlock(selectDirection,cctv.r,cctv.c,tempMap);
           }

            backTracking(cur+1,tempMap,count+sum);
           //방향에 대해서 탐색하고 나면 그 전으로 배열을 돌려주어야한다.
           tempMap = copyMap(tempMap,origin);
        }
    }


    private static int[][] copyMap (int [][]temp ,int [][]map){
        temp = new int[N][M];

        for(int r = 0 ; r <  N ; r ++){
            for(int c = 0 ; c <M ;c++){
                temp[r][c] = map[r][c];
            }
        }

        return temp;
    }

    private static int findBlock (int d ,int nr ,int nc ,int[][]map){
        int count = 0;

        while (true){
             nr += dr[d];
             nc += dc[d];

            //더이상 탐색이 불가능 한경우는 감시된 구역의 개수를 리턴
            if(!isRange(nr,nc)||map[nr][nc]==6){
                return  count;
            }
            // cctv의 위치 였거나 감시했던 구역이였다면 넘긴다.
            if((1<=map[nr][nc] &&map[nr][nc]<=5)||map[nr][nc]==-1){

             continue;
            }
            //그렇지않고 탐색하는 경우라면
            count++;
            map[nr][nc]=-1;
        }
    }
    private static boolean isRange (int r ,int c){
        return  r>=0 && r <N && c>=0 && c<M;
    }
}
