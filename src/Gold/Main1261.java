package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;

import java.util.StringTokenizer;

public class Main1261 {
    static int M,N;
    static int [][] map;
    static int [][] countBrokenWall;
    static boolean [][] isVisted;

    static int []dr = {0,0,1,-1};
    static int []dc = {1,-1,0,0};

    static class Dot  implements Comparable<Dot>{
        int r;
        int c;
        int w;


        public Dot (int r , int c,int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }
        @Override
        public int compareTo (Dot d1) {
            return this.w- d1.w;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로 길이 M , 세로 길이 N
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        isVisted = new boolean[N+1][M+1];;



        //입력값 2차원 배열에 저장
        for(int r = 1 ; r <=N ; r++){ //행
          String str = br.readLine(); // 한 라인을 읽어온다.
            for(int c = 1 ; c <=M ; c++){ //열
               map[r][c]= str.charAt(c-1)-'0';
            }
        }


        bfs();

    }
/*  2차원 배열 출력
    private static void printMap(){
        for(int r = 1 ; r <=N ; r++){
            for(int c = 1 ; c <=M ; c++){
            System.out.print(countBrokenWall[r][c]+" ");
            }
            System.out.println();
        }
    }

 */

    private static boolean isRange (int r ,int c){
        return r>=1 && r<=N && c>=1 && c<=M;
    }


    //너비 우선 탐색
    private static void bfs(){
        //우선순위 큐를 이용하여 깨진 벽의 수가 더 적은 좌표가 먼저 올 수 있도록 한다.
        PriorityQueue<Dot> queue = new PriorityQueue<>();
        queue.add(new Dot(1,1,0));
        isVisted[1][1]= true;

        //큐가 비어있지 않을때까지 반복하여 너비우선탐색을 진행한다.
        while(!queue.isEmpty()){


            //큐에서 좌표 값 하나를 꺼낸다.
            Dot d = queue.poll();

            //도착 좌표에 도착했다면 누적 합 해왔던 깨진 벽의 개수를 출력하여준다.
            if(d.r==N && d.c == M) {
                System.out.println(d.w);
                break;
            }
            //상화좌우 4방향에 대하여 탐색한다.
            for(int i = 0 ; i < 4; i++){
                //상화좌우 다음 좌표
                int nr = d.r +dr[i];
                int nc = d.c +dc[i];

                //다음 이동 좌표가  n,m범위 안에 존재한다면
                if(isRange(nr,nc)&&!isVisted[nr][nc]){

                    if(map[nr][nc]==1) { //벽을 만났다면
                        //다음 이동 좌표에 깨트린 벽의 개수에 +1을 합산하여준다.
                        queue.add(new Dot(nr,nc,d.w+1));
                        isVisted[nr][nc]= true;
                    }else {
                        queue.add(new Dot(nr,nc,d.w));
                        isVisted[nr][nc]= true;
                    }

                }
            }

        }

    }
}
