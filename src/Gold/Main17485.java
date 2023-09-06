package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 진우의 달 여행(Large)
 * <p>
 * [문제풀이]
 */
public class Main17485 {


    static int N, M;

    static int[][] cost;

    //왼쪽 대각선 / 아래 /오른쪽 대각선
    static int[] dr = {1, 1, 1};
    static int[] dc = {-1, 0, 1};

    static int[][][] dp; //i j (좌표) k는 어느 방향에서 왔는지

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = new int[N][M];// 맨 위 , 맨 아래 패딩

        final int MAX = 100_000_001;

        dp = new int[N][M][3];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], MAX);
            }
        }

        //첫째 줄은 그 값 자체가 최소 값이니까 초기화
        for (int i = 0; i < M; i++) {
            for (int k = 0; k < 3; k++) {
                dp[0][i][k] = cost[0][i];
            }
        }

        //첫재쭐 (0) 이후로 시작
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (j == 0) {
                    //위치가 0이면 아래 (1),오른쪽 대각선 (2)로 이동할 수 밖에 없다.
                    //오른쪽 대각선에서 왔다고 하면 아래에서 오거나 왼쪽 위에서 온 경우와 고려
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][0]) + cost[i][j];

                    //아래로 이동했다고 하면 이전에 칸에서 아래로 오는경우 빼고 오른쪽 대각선 오는 경우 만 고려
                    dp[i][j][1] = dp[i - 1][j][2] + cost[i][j];

                }
                //왼쪽 끝인경우는 이동할 수 있는 경우가 아래 혹은 왼쪽 대각선이다.
                else if (j == M - 1) {
                    //아래로 온 경우라면  왼쪽 대각선에서 온 경우와 고려
                    dp[i][j][1] = dp[i - 1][j][0] + cost[i][j];

                    //왼쪽 대각선에서 왔을 경우는 : 이전에 아래거나 오른쪽에서 온 경우와 고려
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + cost[i][j];
                } else { //나머지 경우는 왼쪽 아래 오른쪽 대각선으로 가능

                    //왼쪽 대각선에서 온 경우 : 오른쪽 대각이랑 위에서 온경우와 고려
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][2], dp[i - 1][j - 1][1]) + cost[i][j];

                    //아래에서 온 경우 :  이전 칸의 왼쪽 대각 오른쪽 대각에서 온 경우만 고려
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + cost[i][j];

                    //오른쪽 대각선에서 온 경우 : 위와 왼쪽 대각선에서 온 경우만 고려
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][0]) + cost[i][j];

                }


            }


        }


        //최종 최소 값 찾기
        int min = Integer.MAX_VALUE;
        //마지막 줄만 비교해주면되고 해당 칸에 왼쪽으로 위로 아래로 온경우를 모두 고려해주면된다.
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                min = Math.min(min, dp[N - 1][j][k]);
            }
        }

        System.out.println(min);
    }

}


/**
 * 첫 풀이가 안되는 이유
 * <p>
 * 3 3
 * 1 2 2
 * 9 1 9
 * 9 9 1
 * <p>
 * 일때 1 -> 1 이면 2가 되서 그 칸이 최소값 2를 가지게 되는데
 * 그렇게 되버리면 무조건 9를 더하는 방법밖에없음
 * 차라리 2 -> 1로 간다음에 1로 가는 방법이 가장 최선의 선택임
 * // 그래서 뭔가 모든 방향으로 다 갔었을때의 경우중에서 최소의 값을 탐색해야될거같음.
 * 그니까 3가지 경우를 모두 돌려봤는데 첫번째 방향경우가 최소라고 해서 그 이후에 최소를 보장하지 않는다는 의
 * <p>
 * 글고 애초에 시간초과발생....ㅠㅠ
 * <p>
 * <p>
 * <p>
 * public class Main17485 {
 * <p>
 * <p>
 * static int N,M;
 * <p>
 * static int[][] cost;
 * <p>
 * //왼쪽 대각선 / 아래 /오른쪽 대각선
 * static int[] dr = {1,1,1};
 * static int[] dc = {-1,0,1};
 * <p>
 * static int[][] dp;
 * public static void main(String[] args) throws IOException {
 * <p>
 * <p>
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * StringTokenizer st = new StringTokenizer(br.readLine());
 * <p>
 * N = Integer.parseInt(st.nextToken());
 * M = Integer.parseInt(st.nextToken());
 * <p>
 * cost = new int[N + 2][M] ;// 맨 위 , 맨 아래 패딩
 * <p>
 * final int MAX = 100_000_000;
 * <p>
 * dp = new int[N + 1][M];
 * <p>
 * <p>
 * for(int i = 1; i <= N; i++){
 * st = new StringTokenizer(br.readLine());
 * for(int j = 0 ; j < M; j++){
 * cost[i][j] = Integer.parseInt(st.nextToken());
 * }
 * }
 * <p>
 * for(int i = 1 ; i <= N ;i++){
 * for(int j = 0 ;j < M; j++){
 * if(i == 1) dp[i][j] = cost[1][j];
 * else dp[i][j] = MAX;
 * }
 * }
 * for(int i = 0 ; i < M ; i++){
 * <p>
 * for(int d = 0; d < 3; d++){
 * if(!isRange(1 + dr[d],i + dc[d]))continue;
 * dfs(1,i,d);
 * }
 * <p>
 * //첫재쭐 부터 시작해서 dfs로 최소 비용을 갱신한다.
 * //이때 계속 탐색해서 들어가는 것이 아니라 내가 어떤 칸에 도착했을때 기존의 비용보다 작다고하면 나오기
 * }
 * <p>
 * <p>
 * int min = MAX;
 * for(int i = 0; i < M ; i++){
 * System.out.println(dp[N][i]+" ");
 * min = Math.min(dp[N][i],min);
 * }
 * <p>
 * for(int i = 0 ;  i <= N; i++){
 * for(int j = 0 ; j < M; j++){
 * System.out.print(dp[i][j]+ " ");
 * }
 * System.out.println();
 * }
 * <p>
 * System.out.println(min);
 * <p>
 * }
 * private static void dfs (int startR, int startC, int d){
 * <p>
 * int curR = startR + dr[d];
 * int curC = startC + dc[d];
 * <p>
 * if(!isRange(curR,curC)) return;
 * <p>
 * //만약
 * if(dp[startR][startC] + cost[curR][curC] < dp[curR][curC]){
 * dp[curR][curC] = dp[startR][startC] + cost[curR][curC];
 * }else{
 * return;
 * }
 * <p>
 * <p>
 * //다음 타고 들어가야할 거
 * for(int next = 0 ; next < 3; next++){
 * if(d == next) continue;
 * dfs(curR,curC,next);
 * }
 * <p>
 * }
 * <p>
 * private static boolean isRange(int r,int c){
 * return r <= N && c >= 0 && c < M ;
 * }
 * }
 */

/**
 * public class Main17485 {
 *
 *
 *     static int N,M;
 *
 *     static int[][] cost;
 *
 *     //왼쪽 대각선 / 아래 /오른쪽 대각선
 *     static int[] dr = {1,1,1};
 *     static int[] dc = {-1,0,1};
 *
 *     static int[][] dp;
 *     public static void main(String[] args) throws IOException {
 *
 *
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         StringTokenizer st = new StringTokenizer(br.readLine());
 *
 *         N = Integer.parseInt(st.nextToken());
 *         M = Integer.parseInt(st.nextToken());
 *
 *         cost = new int[N + 2][M] ;// 맨 위 , 맨 아래 패딩
 *
 *         final int MAX = 100_000_000;
 *
 *         dp = new int[N + 1][M];
 *
 *
 *         for(int i = 1; i <= N; i++){
 *             st = new StringTokenizer(br.readLine());
 *             for(int j = 0 ; j < M; j++){
 *                 cost[i][j] = Integer.parseInt(st.nextToken());
 *             }
 *         }
 *
 *         for(int i = 1 ; i <= N ;i++){
 *             for(int j = 0 ;j < M; j++){
 *                 if(i == 1) dp[i][j] = cost[1][j];
 *                 else dp[i][j] = MAX;
 *             }
 *         }
 *         for(int i = 0 ; i < M ; i++){
 *
 *             for(int d = 0; d < 3; d++){
 *                 if(!isRange(1 + dr[d],i + dc[d]))continue;
 *                 dfs(1,i,d);
 *             }
 *
 *             //첫재쭐 부터 시작해서 dfs로 최소 비용을 갱신한다.
 *             //이때 계속 탐색해서 들어가는 것이 아니라 내가 어떤 칸에 도착했을때 기존의 비용보다 작다고하면 나오기
 *         }
 *
 *
 *         int min = MAX;
 *         for(int i = 0; i < M ; i++){
 *             System.out.println(dp[N][i]+" ");
 *             min = Math.min(dp[N][i],min);
 *         }
 *
 *         for(int i = 0 ;  i <= N; i++){
 *             for(int j = 0 ; j < M; j++){
 *                 System.out.print(dp[i][j]+ " ");
 *             }
 *             System.out.println();
 *         }
 *
 *         System.out.println(min);
 *
 *     }
 *     private static void dfs (int startR, int startC, int d){
 *
 *         int curR = startR + dr[d];
 *         int curC = startC + dc[d];
 *
 *         if(!isRange(curR,curC)) return;
 *
 *         //만약
 *         if(dp[startR][startC] + cost[curR][curC] < dp[curR][curC]){
 *             dp[curR][curC] = dp[startR][startC] + cost[curR][curC];
 *         }else{
 *             return;
 *         }
 *
 *
 *         //다음 타고 들어가야할 거
 *         for(int next = 0 ; next < 3; next++){
 *             if(d == next) continue;
 *             dfs(curR,curC,next);
 *         }
 *
 *     }
 *
 *     private static boolean isRange(int r,int c){
 *         return r <= N && c >= 0 && c < M ;
 *     }
 * }
 */