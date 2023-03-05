package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나이트의 이동 -> BFS 풀이
 * 시작:3월 5일 일요일 오후 4시
 * 종료:3월 5일 일요일 오후 4시 32분
 *
 * [풀이 과정]
 * 1. 4방향이 아닌 나이트가 이동할 수 있는 8방향에대하여 dr , dc 설정
 * 2. 너비우선 탐색을 통해서 끝점에 도달 했다면  끝점까지 가는데에 걸린 최소 비용을 출력.
 */
public class Main7562 {

    //나이트의 이동 dr, dc
    static int [] dr = {-1,-2,-2,-1,1,2,2,1};
    static int [] dc = {-2,-1,1,2,2,1,-1,-2};
    static int N;
    static final int MAX_DIRECTION = 8;
    static class Node {
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int testCase = Integer.parseInt(br.readLine());

        //테스트 케이스 수 만큼 반복
        for(int i = 0 ; i < testCase ;i++){

             N = Integer.parseInt(br.readLine()); //격자 판 크기

            boolean [][]isVisited = new boolean[N][N]; //방문 처리 체크

            StringTokenizer st = new StringTokenizer(br.readLine());

            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());



            System.out.println(bfs(startR,startC,endR,endC,isVisited));
        }

    }
    //너비 우선 탐색
    private static  int bfs (int startR ,int startC ,int endR ,int endC , boolean[][]isVisited){

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(startR,startC,0));

        isVisited[startR][startC] =true;

        while (!queue.isEmpty()){

            Node curNode = queue.poll();

            if(curNode.r == endR && curNode.c == endC) return curNode.cost;

            //나이트가 이동할 수 있는 방향으로 모두 탐색한다.
            for(int i = 0 ; i< MAX_DIRECTION; i++){

                //다음 이동할 좌표
                int nr = curNode.r + dr[i];
                int nc = curNode.c + dc[i];

                if(isRange(nr,nc) && !isVisited[nr][nc]){
                    queue.add(new Node(nr,nc,curNode.cost+1));
                    isVisited[nr][nc] = true;
                }

            }
        }

        return 0;

    }
    private static boolean isRange (int r ,int c){
        return r >= 0 && c >= 0 && r  < N  && c <  N;
    }
}
