package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4963 {


    static class Dot {
        int r;
        int c;

        public Dot(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int [] dr = {0,-1,-1,-1,0,1,1,1};
    static int [] dc = {-1,-1,0,1,1,1,0,-1};
    static int [][] map;
    static boolean [][] visited;
    static int N,M;
    static Queue<Dot> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        while (true){
             st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            // 0 0 입력일 경우 종료
            if(N+M==0){
                break;
            }

            map = new int[N][M];
            visited = new boolean[N][M];

            int count = 0;
            for(int r = 0 ; r <N;r++){
                 st = new StringTokenizer(br.readLine());
                for(int  c= 0 ; c<M;c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for(int r = 0 ; r <N;r++){
                for(int  c= 0 ; c<M;c++){
                    if(map[r][c]==1&&!visited[r][c]){
                        bfs(r,c);
                        count++;
                    }
                }
            }


            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    public static void bfs (int r ,int c){
        visited[r][c]=true;
        queue.add(new Dot(r,c));

        while (!queue.isEmpty()){

            Dot d = queue.poll();

            for(int i = 0 ; i < 8 ; i++){

                int nr = d.r + dr[i];
                int nc = d.c + dc[i];

                if(inWall(nr,nc)&& !visited[nr][nc] && map[nr][nc]==1){

                    queue.add(new Dot(nr,nc));
                    visited[nr][nc]=true;
                }
            }

        }
    }

    public static boolean inWall(int r ,int c){
        if(r >=0 && r<N && c>=0 &&c<M) return true;
        return false;
    }

}
