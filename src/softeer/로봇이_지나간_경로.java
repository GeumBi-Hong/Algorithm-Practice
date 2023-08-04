package softeer;

import java.util.*;
import java.io.*;

public class 로봇이_지나간_경로 {

    static int R, C;

    static boolean[][] canGo;
    static boolean[][] isVisited;

    static int startR, startC;

    //상 우 하 좌 (시계방향)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static StringBuilder sb = new StringBuilder();

    static class Dot {
        private int r;
        private int c;
        private int d;


        public Dot(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //로봇이 갔던 곳
        canGo = new boolean[R][C];
        //해당 칸을 방문했는지 체크하기 하기 위함
        isVisited = new boolean[R][C];


        //로봇이 갔던 곳은 True로 체크한다.
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == '#') canGo[i][j] = true;
            }
        }


        /**[1]어디서 출발할껀지를 찾는다. **/
        //처음엔 #이 있는 모든 곳에서 완전탐색을 진행하려했지만
        //최소 비용을 구하려면 #중에서 주위 4방으로 #이 가장 적은 곳이 최소비용으로 갈 수 있는 출발지이다.
        findStartPoint();

        /**[2] 찾을 출발지로 최소 비용을 찾는다. */
        moveRobot();
        /**[3] 최소 비용, 즉 정답을 출력한다. */
        System.out.println(sb);


    }

    //해당 좌표가 2차원 배열안의 범위에 있는지 확인하는 메서드
    private static boolean isRange(int r, int c) {

        return r >= 0 && c >= 0 && r < R && c < C;

    }

    //최소 비용으로 갈 수 있는 출발 지점을 찾는 메서드
    private static void findStartPoint() {

        int maxSize = 4;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                //해당 칸이 '#'인 경우, 즉 갈 수 있는 칸일때만 확인한다.
                if (canGo[r][c]) {

                    //해당 칸 주위로 '#'이 몇개있는지 체크, 즉 갈 수 있는 경로가 몇개인지 구한다.
                    int dirCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        //갈 수 있는 곳이면
                        if (isRange(nr, nc) && canGo[nr][nc]) {
                            dirCount++;
                        }

                    }

                    //가장 작은 경우의 dirCount가 나오면 그 좌표로 계속 갱신한다.
                    if (dirCount < maxSize) {
                        maxSize = dirCount;
                        startR = r;
                        startC = c;
                    }
                }
            }
        }

    }

    //찾은  출발지점에서 최소 비용 (최소 경로를 구한다)
    private static void moveRobot() {

        //[1] 출발지의 좌료를 저장한다.
        sb.append((startR + 1) + " " + (startC + 1)).append("\n");

        //현재 로봇의 방향
        int nowDir = -1;


        //출발하는 칸에서 어느 방향으로 이동하는지에 대한 방향을 찾고 방향을 저장한다.
        for (int d = 0; d < 4; d++) {
            int nr = startR + dr[d];
            int nc = startC + dc[d];

            if (isRange(nr, nc) && canGo[nr][nc]) {
                addFirstCommand(d);
                nowDir = d;
                break;
            }

        }
        //[2] 첫 시작점을 큐에 넣고 BFS를 진행한다. 최소 경로로 이동할 수 있기 때문이다.
        Queue<Dot> queue = new ArrayDeque<>();

        isVisited[startR][startC] = true;
        queue.add(new Dot(startR, startC, nowDir));


        while (!queue.isEmpty()) {

            Dot dot = queue.poll();

            //현재 좌표에서 두 칸 앞으로 전진한 칸 좌표
            int nr = dot.r + dr[dot.d] * 2;
            int nc = dot.c + dc[dot.d] * 2;

            //A를 할 수 있는 경우인지 체크 후 갈 수 있으면 queue에 좌표 넣기
            if (isRange(nr, nc) && canGo[nr][nc] && canGo[dot.r + dr[dot.d]][dot.c + dc[dot.d]]) {
                sb.append("A");

                isVisited[nr][nc] = true;
                isVisited[dot.r + dr[dot.d]][dot.c + dc[dot.d]] = true;

                queue.add(new Dot(nr, nc, dot.d));
            } else { //A를 할 수 없는 경우 방향을 변경해야한다.
                //현재 좌표의 반대로를 이동할 필요가 없다. 그러면 최소 경로가 나오지 않기때문
                //앞으론 이동할 수 없으니 "왼쪽" 혹은 "오른쪽"만 확인해주면된다.

                //오른쪽의 경우로 돌린다.
                int rightR = dot.r + dr[(dot.d + 1) % 4];
                int rightC = dot.c + dc[(dot.d + 1) % 4];

                //왼쪽 방향으로 돌려본다.
                int leftR = dot.r + dr[((dot.d - 1) + 4) % 4];
                int leftC = dot.c + dc[((dot.d - 1) + 4) % 4];


                //오른쪽의 경우면 왼쪽 방향으로 로봇을 큐에 삽입
                if (isRange(rightR, rightC) && canGo[rightR][rightC]) {
                    queue.add(new Dot(dot.r, dot.c, (dot.d + 1) % 4));
                    sb.append("R");
                    continue;
                }

                //오른쪽 경우면 오른쪽 방향으로 로봇을 큐에 삽입
                if (isRange(leftR, leftC) && canGo[leftR][leftC]) {
                    queue.add(new Dot(dot.r, dot.c, ((dot.d - 1) + 4) % 4));
                    sb.append("L");
                }
            }


        }
    }

    //해당 방향에 대한 문양 저장 메서드
    private static void addFirstCommand(int d) {

        switch (d) {
            case 0:
                sb.append("^");
                break;
            case 1:
                sb.append(">");
                break;

            case 2:
                sb.append("v");
                break;

            case 3:
                sb.append("<");
                break;

            default:
                break;

        }
        sb.append("\n");
    }
}
