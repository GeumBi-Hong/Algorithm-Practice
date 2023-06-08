package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 레이저 통신
 *
 *
 * [처음 생각]
 * 1. 거울은 어디에 설치해야하는가 -> 움직이는 방향이 바뀔때
 * 2. 최소는 어떻게? (여기가 문제)
 *  [내 생각 ]  :dfs + 가지치기
 *  하나씩 경로 탐색하면서 도착지에 도착하면 해당 경로에 쓰인 거울의 개수를 저장하고
 *  다음에 또 해당 칸에 도착했을때 거울의 개수가 작아야만 그 칸을 탐색할 수 있도록 하려했음.
 *
 *  하지만 가지치기 할라고 하니까 조금 복잡했음.. 방향이 바뀌기 전과 후로 거울의 개수를 계속 갱신하면서 가야되고 이게 맞나 싶었음.
 *
 *
 *  [풀이를 봄 1시간 생각히고]
 *  분류가 다익스트라였다. 왜 다익스트라였을까 생각을 해봤음
 *  최소 거울수를 찾아야함 최소 거울 수를 가지고 경로를 찾아야하는데
 *  이를 다익스트라에서 우선순위 큐를 쓴걸보면 최소 경로를 가지고 계속 탐색을함
 *  여기서 우선순위큐로 최소 거울 수의 경로를 가지고 계속해서 움직여서 그 개수가지고 도착지점 간게 최소 경우다로 푸는거같음
 *
 */
public class Main6087 {

    static class Node implements Comparable<Node>{

        private int r;
        private int c;

        private int mirror;

        private int dir;


        public Node(int r, int c, int mirror, int dir) {
            this.r = r;
            this.c = c;
            this.mirror = mirror;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node o) {
            return this.mirror - o.mirror;
        }
    }

    //가로, 세로
    static int W, H;

    static char[][] map;

    static int startR, startC, endR, endC;

    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};

    static int[][] mirrorMap;

    static List<Node> razerLocationList = new ArrayList<>();

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        mirrorMap = new int[H][W];

        for(int r = 0; r < H; r++){
            String str = br.readLine();
            for(int c = 0; c < W; c++){
                if(str.charAt(c) == 'C'){
                    razerLocationList.add(new Node(r,c,0,-1));
                }
                map[r][c] = str.charAt(c);
                mirrorMap[r][c] = Integer.MAX_VALUE;
            }
        }

        //시작 레이저 , 도착 레이저
        startR = razerLocationList.get(0).r;
        startC = razerLocationList.get(0).c;
        endR = razerLocationList.get(1).r;
        endC = razerLocationList.get(1).c;

        bfs(startR,startC);

        System.out.println(mirrorMap[endR][endC]);

    }

    static private void printMap(){
        for(int r = 0; r < H; r++){
            for(int c = 0; c < W; c++){
              System.out.print(map[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /** 깊이 우선 탐색으로 시작점에서 도착지점까지 감**/
    private static void bfs(int currR,int currC){

        mirrorMap[currR][currC] = 0;


        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(currR,currC,0,-1));


        while (!queue.isEmpty()){

            Node curNode = queue.poll();

            if(curNode.r == endR && curNode.c == endC) break;

            for(int i = 0; i < 4 ;i++){

                //다음 이동할 좌표
                int nr = curNode.r + dr[i];
                int nc = curNode.c + dc[i];
                int nm = curNode.mirror;

                if(!isRange(nr,nc)) break;




                if(curNode.dir != i && curNode.dir != -1) nm++;

                if(mirrorMap[nr][nc] >= nm){
                    mirrorMap[nr][nc] = nm;
                    queue.add(new Node(nr,nc,nm,i));
                }
            }
        }


    }

    private static boolean isRange(int r ,int c){
        return r >= 0 && c >= 0 && r < H && c <  W;
    }
}
