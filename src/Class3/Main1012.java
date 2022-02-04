package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//유기농 배추
//너비우선탐색으로 배추가 심어진 구역을 찾는 문제
public class Main1012 {
    static int cabbage[][];
    static boolean visited[][];
    static int [] x_dot={-1,0,1,0};
    static int [] y_dot={0,-1,0,1};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수




        while (T -->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
             M = Integer.parseInt(st.nextToken()); // 가로길이
             N = Integer.parseInt(st.nextToken()); //세로 길이
            int K = Integer.parseInt(st.nextToken()); //심어진 배추 개수
            int count = 0; //최소 지렁이 개수

            cabbage = new int[N][M];
            visited = new boolean[N][M];

            while (K-->0){
                st = new StringTokenizer(br.readLine()," ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                cabbage[x][y]=1; //배추 위치 저장
            }

            for(int i =0 ; i < N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j]&&cabbage[i][j]==1){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y){

        for(int i=0;i<4;i++){
            int nextX=x_dot[i]+x;
            int nextY=y_dot[i]+y;
            if(nextX>=0&&nextX<N &&nextY>=0&&nextY<M&&!visited[nextX][nextY]&&cabbage[nextX][nextY]==1){
                visited[nextX][nextY]=true;
                bfs(nextX,nextY);
            }
        }

    }
}
