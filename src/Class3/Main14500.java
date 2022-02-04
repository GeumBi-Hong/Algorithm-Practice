package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//테트로미노 (브루트포스)
public class Main14500 {

    static boolean [][]visited;
    static int [][]array;
    static int [] x_dot={-1,0,1,0};
    static int [] y_dot={0,-1,0,1};
    static int max = Integer.MIN_VALUE;
    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        array = new int[N][M];

        for (int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j =0; j<M;j++){
                array[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i =0; i<N;i++){
            for(int j =0; j<M;j++){
                search(i,j,0,0,0,0);
            }
        }

        System.out.print(max);

    }

    static void search (int x ,int y,int count,int sum,int before_x,int before_y){


        visited[x][y]=true;
        sum = sum+array[x][y];
        count++;


        if(count==4){
            if(max<sum){
                max=sum;
            }
            return;
        }

        for(int i=0;i<4;i++){
            int nextX=x+x_dot[i];
            int nextY=y+y_dot[i];


            if(nextX>=0&&nextX<N&&nextY>=0&&nextY<M&&!visited[nextX][nextY]){
                search(nextX,nextY,count,sum,x,y);
                visited[nextX][nextY]=false;
            }

            int bx=before_x+x_dot[i];
            int by=before_y+y_dot[i];
            if(bx>=0&&bx<N&&by>=0&&by<M&&!visited[bx][by]){
                search(bx,by,count,sum,before_x,before_y);
                visited[bx][by]=false;
            }
        }
    }
}
