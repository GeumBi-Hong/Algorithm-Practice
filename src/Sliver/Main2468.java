package Sliver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//안전영역 (dfs) = 더 빠름
public class Main2468{
    static int N;
    static int max_H=0;
    static int min_H=101;
    static int [][]array;
    static boolean visited [][];
    static int [] x_dot = {0,0,1,-1};
    static int [] y_dot = {1,-1,0,0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N][N];
        int answer = 1;

        //최대 높이 찾기
        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j< N; j++){
                array[i][j]=Integer.parseInt(st.nextToken());
                max_H = Math.max(array[i][j],max_H);
                min_H = Math.min(array[i][j],min_H);
            }
        }

        for (int i=min_H; i<=max_H;i++){
            answer= Math.max(countSafeZone(i),answer);
        }

        System.out.print(answer);

    }


    public static int countSafeZone(int  h){

        int count = 0;
        visited = new boolean[N][N];
        for (int i = 0 ; i <N ; i++){
            for (int j = 0 ; j< N; j++){
                if(array[i][j]<=h) continue;
                if(!visited[i][j]) {
                    dfs(i,j,h);
                    count++;
                }

            }
        }
        return count;
    }

    public static void dfs(int i,int j,int h){
        visited[i][j]= true;

            for(int k = 0; k <4 ; k++){

                int nx = i+x_dot[k];
                int ny = j+y_dot[k];
                if(nx<0||nx>=N||ny<0||ny>=N)continue;
                if(array[nx][ny]<=h||visited[nx][ny])continue;

                dfs(nx,ny,h);

            }
        }

    }



/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//bfs
public class Main{
    static int N;
    static int max_H=0;
    static int min_H=101;
    static int [][]array;
    static boolean visited [][];
    static int [] x_dot = {0,0,1,-1};
    static int [] y_dot = {1,-1,0,0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N][N];
        int answer = 1;

        //최대 높이 찾기
        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j< N; j++){
                array[i][j]=Integer.parseInt(st.nextToken());
                max_H = Math.max(array[i][j],max_H);
                min_H = Math.min(array[i][j],min_H);
            }
        }

        for (int i=min_H; i<=max_H;i++){
            answer= Math.max(countSafeZone(i),answer);
        }

        System.out.print(answer);

    }


    public static int countSafeZone(int  h){

        int count = 0;
        visited = new boolean[N][N];
        for (int i = 0 ; i <N ; i++){
            for (int j = 0 ; j< N; j++){
                if(array[i][j]<=h) continue;
                if(!visited[i][j]) {
                    bfs(i,j,h);
                    count++;
                }

            }
        }
        return count;
    }

    public static void bfs(int i,int j,int h){
        visited[i][j]= true;
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(i,j));
        while (!queue.isEmpty()){
            Dot d = queue.poll();
            int x = d.x;
            int y = d.y;

            for(int k = 0; k <4 ; k++){
                int nx = x+x_dot[k];
                int ny = y+y_dot[k];
                if(nx<0||nx>=N||ny<0||ny>=N)continue;
                if(array[nx][ny]<=h||visited[nx][ny])continue;

                queue.add(new Dot(nx,ny));
                visited[nx][ny]=true;

            }
        }

    }
    static class Dot {
        int x,y;

        public Dot (int x,int y){
            this.x =x;
            this.y =y;
        }
    }
}



 */