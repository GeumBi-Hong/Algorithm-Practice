package programmers;
import java.util.*;


    class 게임_맵_최단거리 {
        static int []  dr = {1,-1,0,0};
        static int []  dc = {0,0,1,-1};

        public int solution(int[][] maps) {
            int answer = 0;

            int [][] visitedTime = new int[maps.length][maps[0].length];
            bfs( maps,visitedTime);

            return visitedTime[maps.length-1][maps[0].length-1]==0?-1:visitedTime[maps.length-1][maps[0].length-1];
        }

        public  void bfs (int[][]maps ,int [][]visitedTime){


            Queue<int []> queue = new ArrayDeque<>();
            //처음 좌표를 넣는다.
            queue.add(new int[]{0,0});

            //처음 좌표는 1이다.
            visitedTime[0][0]=1;

            while(!queue.isEmpty()){

                int [] now = queue.poll();

                //상하좌우를 돌면서
                for(int i = 0 ; i < 4 ; i++){

                    int nr = now[0]+dr[i];
                    int nc = now[1]+dc[i];

                    //방문하지 않은 지점이면서 범위를 넘지 않는경우만 가능 그리고 맵의 1만 갈 수 있음
                    if(isRanged(nr,nc,maps.length,maps[0].length)&&visitedTime[nr][nc]==0 &&maps[nr][nc]==1 ){
                        visitedTime[nr][nc]=visitedTime[now[0]][now[1]]+1;
                        queue.add(new int[]{nr,nc});
                    }
                }

            }

        }
        //맵 밖의 범위를 넘어서는지 체크한다.
        public  boolean isRanged (int r ,int c ,int n ,int m){
            return r>=0 && r<n && c>=0 && c<m;
        }
    }

