package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토 (너비우선)
public class Main7576 {

    static int [][] tomato;
    static int [] x_dot = {-1,0,1,0}; //상좌하우
    static int [] y_dot = {0,-1,0,1};
    static Queue<Dot> queue = new LinkedList<>();
    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // 가로 칸 수
        N = Integer.parseInt(st.nextToken()); // 세로 칸 수

        tomato = new int[N][M];

        for (int i = 0 ; i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0 ; j <M;j++){
                int n = Integer.parseInt(st.nextToken());
                tomato[i][j]=n;
               if ( n ==1){ //익은 토마토의 위치 좌표를 얻는다.
                   queue.add(new Dot(i,j));
               }
            }
        }

            bfs();


    }

    static void bfs (){

        while (!queue.isEmpty()){
           Dot d  =queue.poll();

           for (int i = 0 ; i < 4 ; i++){ //상하좌우로 이동할 좌표
               int nextX = d.x+ x_dot[i];
               int nextY = d.y + y_dot[i];

               //2차원 배열 밖에 인덱스번호를 접근하면 안됨
               //이동할 좌표가 방문했던 좌표면 안됨
               //이동할 좌표가 -1 이면 안됨 (토마토가 없는칸)
               if(nextX>=0&&nextX<N&&nextY>=0&&nextY<M&&tomato[nextX][nextY]==0){
                   queue.add(new Dot(nextX,nextY));
                   tomato[nextX][nextY] = tomato[d.x][d.y]+1; //전의 칸의 +1
               }
           }


        }

        //최소 날짜 찾기
        int min = Integer.MIN_VALUE;

        for(int i = 0 ; i <N; i++){
            for(int j = 0 ; j <M;j++){
                if(tomato[i][j]==0){ //0이 있다면 익지않은 토마토가 존재하기 때문에 -1을 출력한다.
                    System.out.print(-1);
                    return;
                }

                if(tomato[i][j]>min){
                    min=tomato[i][j];
                }

            }
        }

        if(min==1){ //원래 부터 토마토가 전부 다 익었음
            System.out.print(0);
        }else { // 최소 날짜 출력 해주면된다. (처음의 토마토값이 1이므로 -1을 해준다)
            System.out.print(min-1);
        }

    }
    public static class Dot {
        int x;
        int y;

        public Dot(int x,int y){
            this.x= x;
            this.y=y;
        }
    }
}
