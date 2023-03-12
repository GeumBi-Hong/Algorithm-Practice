package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2573 {

    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    static int N,M;

    static int[][] height;

    static class Node {
        int r;
        int c;

        public Node (int r , int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        height = new int[N][M]; //빙산의 높이

        int answer = 0;

        //입력값 저장
        for (int r = 0; r < N; r++) {

            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {

               height[r][c] = Integer.parseInt(st.nextToken());

            }
        }


        while (true){

            //빙산을 녹이기 전 빙산이 두 덩이 이상으로 분리 되어 지는 지 확인한다.
            //확인하는 동시에 빙하의 높이를 줄인다

            int part  = isCheck();
            if(part==2){
                System.out.print(answer);
                break;
            } else if (part == 0) {
                System.out.print(0);
                break;
            }


            //다 줄였다면 -1값은 0으로 다시 바꾼다.
            changeValue();

            answer++;

        }

    }

    private static int isCheck(){


        //방문 배열을 초기화 한다.
       boolean[][] isVisited = new boolean[N][M];

        int count = 0;

        for (int r = 1; r < N-1; r++) {
            for (int c = 1; c < M-1; c++) {

                if(!isVisited[r][c] && height[r][c] > 0){


                    count++;


                    if(count == 2) return 2;



                    bfs(new Node(r,c) ,isVisited);

                }

            }
        }

        return count;
    }

    private static void bfs(Node startNode , boolean[][] isVisited){

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startNode);
        isVisited[startNode.r][startNode.c] = true;


        while (!queue.isEmpty()){

            Node curNode  = queue.poll();
            int count = 0;

            for (int i = 0; i < 4; i++) {

               int nr = curNode.r + dr[i];
               int nc = curNode.c + dc[i];



               if(!isRange(nr,nc)) continue;

               //주위가 0인 경우는 빙산의 높이를 줄인다.
                if(height[nr][nc] == 0) count++;



               //방문되지 않고 빙산의 높이가 0 초과 경우만 너비 우선 탐색을 진행한다.
               if(!isVisited[nr][nc] && height[nr][nc] > 0){
                   queue.add(new Node(nr,nc));
                   isVisited[nr][nc] = true;
               }

            }//for

            //빙하의 높이를 줄였는데 0이거나 0보다 작으면 -1로 초기화 해준다.
            //그 이유는 빙하의 높이가 0으로 되면 다음 빙하의 계산 결과에 영향을 끼치기 때문이다.
            height[curNode.r][curNode.c] =  height[curNode.r][curNode.c] - count > 0 ? height[curNode.r][curNode.c]  -count : -1;

        }

    }

    private static void changeValue(){

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
               if(height[r][c] == -1){
                   height[r][c] = 0;
               }

            }
        }

    }

    private static boolean isRange(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= M ) return false;
        else return true;
    }


}
