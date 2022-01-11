/*
7 :지도의 크기
0110100
0110101
1110101
0000111
0100000
0111110
0111000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2차원 배열을 돌면서 1을 만나면 넢이 우선 탐색을 해서 인접한개수를 구하고 리턴한다.
public class Main2667 {
    static int n=0;
    static int array[][];
    static boolean visited[][];
    static int count =1;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine()); //지도의 크기
        array = new int[n][n]; //지도의 크기만큼 2차원 배열 생성
        visited = new boolean[n][n];

        ArrayList<Integer> a = new ArrayList<>();


        //2차원 배열에 지도 값 넣기
        for (int i=0;i<n;i++){
            char [] c = br.readLine().toCharArray();
            for (int j =0 ;j<n;j++){
                array[i][j]= c[j]-'0';
                visited[i][j]=false;
            }
        }


        for (int i=0;i<n;i++){
            for (int j =0 ;j<n;j++){
                if(!visited[i][j] && array[i][j]==1){
                    int answer = bfs(i,j);
                    a.add(answer);
                    count =1;
                }

            }
        }


        System.out.println(a.size());
        Collections.sort(a);
        for (int i =0 ;i<a.size();i++){
            System.out.println(a.get(i));
        }


    }

    static int bfs (int r, int c){

        //좌표 값을 넣어줄 큐 생성
        Queue<Dot> queue = new LinkedList<>();
        //방문체크
        visited[r][c]=true;
        //count 증가

        //큐에 현재 좌표 값 넣기
        queue.add(new Dot(r,c));


        while (!queue.isEmpty()){
            Dot d = queue.poll();
            for (int i=0; i<4;i++){
                int nx=d.x+dx[i];
                int ny=d.y+dy[i];
                if(nx >=0 && ny >=0 && nx <n && ny<n){
                    if(!visited[nx][ny] && array[nx][ny]==1){
                        count++;
                        queue.add(new Dot(nx,ny));
                        visited[nx][ny]=true;

                    }
                }

            }

        }

        return count;

    }

    static class Dot {
        int x;
        int y;
        Dot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
