package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {

    //좌표 정보를 저장할 class
    static class Dot {
        int r;
        int c;

        public Dot (int r ,int c){
             this.r = r;
             this.c = c;
        }
    }

    static int N,M ;
    static int [][]map;
    static int []dr = {0,0,1,-1};
    static int []dc = {-1,1,0,0};
    static int total_cheeze =0;
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로길이
        M = Integer.parseInt(st.nextToken()); //가로 길이

        map = new int[N][M];


        int totalTime = 0;
        //치즈 정보를 2차원 배열에 저장하기 -> 1:치즈 0:치즈없음
        for(int r = 0 ; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c]==1){
                    total_cheeze++;//다음 과정에서 바로 치즈가 없을수도 있으므로 치즈 개수를 세어준다.
                }
            }
        }





        int cheezeCnt = 0;
        while (total_cheeze!=0){
            cheezeCnt =  total_cheeze; //전의 치즈 개수 저장
            boolean [][]isVisted = new boolean[N][M];
            bfs(isVisted); // 치즈안에있는 공기 제외하고 공기와 맞닿은 치즈 없애기
            totalTime++; // 한 과정이 지났으므로 +1시간

        }


        System.out.println(totalTime);
        System.out.println(cheezeCnt);

    }

    private static boolean isRange (int r ,int c){
        return r>=0 && c>=0 && r<N && c<M;
    }

    private static void bfs (boolean[][] isVisited){

        isVisited[0][0] = true ; //0,0부터 탐색하면 치즈 안에 있는 구멍을 제외한 나머지 구멍들을 전부 탐색 할 수 있다.
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(0,0)); //너비우선 탐색을 할 첫 시작좌표를 큐에 넣어주어야한다.

        //큐가 비어있지 않을때까지 반복하여 너비우선 탐색을 진행한다.
        while (!queue.isEmpty()){

            Dot d = queue.poll();

            for(int i = 0 ; i < 4; i++){
                //현재좌표에 대한 상/하/좌/우 좌표에 대하여
                int nr = d.r+dr[i];
                int nc = d.c+dc[i];

                if(!isRange(nr,nc)||isVisited[nr][nc]){continue;} // 2차원 배열을 넘어서는 범위를 탐색하게되거나 방문했던 좌표면 넘어감
                isVisited[nr][nc]=true; //방문 처리를 해준다.

                if (map[nr][nc]==0){  //치즈가 없는 좌표면
                    queue.add(new Dot(nr,nc)); //큐에 추가하고
                }else { //그렇지 않고 치즈가 있는 좌표를 만나게 된다면
                    map[nr][nc] = 0 ; // 공기와 맞닿은 치즈는 없어저야 하므로 0으로 변경해준다.
                     total_cheeze--; // 총 치즈의 개수에서 -1을 해준다.
                }



            }

        }



    }




}
