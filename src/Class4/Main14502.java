package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//연구소 (너비우선 탐색 , 완전 탐색)
public class Main14502 {

    static  int [][] a ,virus_array ;
    static int N,M;
    static int [] dot_X = {0,0,1,-1};
    static int [] dot_Y = {-1,1,0,0};
    static List<virus> list = new ArrayList<>();
    static int answer = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N][M];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j  <M ;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j]==2){ //바이러스의 위치 정보를 저장한다.
                    list.add(new virus(i,j));
                }
            }
        }


        wall(0,0);
        System.out.print(answer);

    }

    public static void wall (int start ,int depth){

        if(depth==3){//벽을 3개 세웠다면 너비우선 탐색으로 바이러스를 퍼트린다.
            copyArray();
            for (virus v : list) { //바이러스를 퍼트린다.
                Bfs(v.x,v.y);
            }
            safeZone(virus_array); //0의 개수를 세어준다.
            return;
        }

        for (int i = start; i <N * M; i++) {
            int x = i / M;  // 행
            int y = i % M;  // 열

            if (a[x][y] == 0) {
                a[x][y] = 1;
                wall(i + 1, depth + 1);
                a[x][y] = 0;
            }
        }
    }

    public static void copyArray (){
        virus_array = new int[N][M];

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ;  j <M ;j++){
                virus_array[i][j]=a[i][j];
            }
        }
    }
    public static void Bfs(int x, int y){

            for(int i = 0 ; i < 4 ; i++){
                int next_X = x+dot_X[i];
                int next_Y = y+dot_Y[i];


                if(next_X < N && next_X >= 0 && next_Y < M && next_Y >=0 ){
                    if(virus_array[next_X][next_Y]==0){
                        virus_array[next_X][next_Y]=2;
                       Bfs(next_X,next_Y);

                    }
                }
            }

    }
    public static void safeZone (int [][] array){ //안전한 벽의 개수를 세어주고 최대값을 찾는다.

        int count =0;

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j  <M ;j++){
                if(array[i][j]==0){
                    count++;
                }

            }
        }

        answer =Math.max(count,answer);
    }

    static class virus{ //바이러스 위치 좌표
        int x,y;

        public virus(int x,int y){
            this.x=x;
            this.y=y;
        }

    }

}

