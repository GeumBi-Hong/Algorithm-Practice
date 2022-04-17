package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2583 {

    static int M,N,K;
    static boolean [][] map;
    static int [] dr = {0,0,1,-1};
    static int [] dc = {-1,1,0,0};
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> answer = new ArrayList<>();

         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());

         map = new boolean[M][N];


        while (K-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int leftC = Integer.parseInt(st.nextToken());
            int leftR = Integer.parseInt(st.nextToken());
            int rightC = Integer.parseInt(st.nextToken()) -1;
            int rightR = Integer.parseInt(st.nextToken())  -1;


            //직사각형 칠하기
            for (int i = leftR; i <= rightR; i++) { //세로
                for (int j = leftC; j <= rightC; j++) { //가로
                    map[i][j] = true;
                }
            }

        }

            //넓이 구하기

            for(int i = 0; i<M;i++){
                for(int j = 0 ; j<N;j++){
                    if(!map[i][j]){

                        answer.add(bfs(i,j));

                    }
                }
            }
            //빈 면적 오름차순 정렬
        Collections.sort(answer);

        sb.append(answer.size()).append("\n");

        for(int n : answer){
            sb.append(n+" ");
        }
        //정답 출력
        System.out.println(sb);

    }

    public  static int bfs (int r, int c ){

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        int count =1;


        while (!queue.isEmpty()){
            int [] n = queue.poll();

            int currR = n[0];
            int currC = n[1];
            map[currR][currC]=true;

            for(int i = 0 ; i <4;i++){
                int nr =  currR+dr[i];
                int nc = currC+dc[i];

                if(inWall(nr,nc)&&!map[nr][nc]){
                    count++;
                    map[nr][nc]=true;
                    queue.add(new int[]{nr,nc});
                }
            }
        }

        return count;
    }

    public static boolean inWall (int r,int c){
        if(r>=0 && r<M&&c>=0&&c<N)return true;
        return false;
    }
}
