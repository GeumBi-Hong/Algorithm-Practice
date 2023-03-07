import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1520 {

    static int R , C;

    static int [][]map;

    static int []dr = {0,0,1,-1};
    static int []dc = {1,-1,0,0};

    //해당 좌표를 갈 수 있는 경로의 수
    static int [][]dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1.입력값 저장
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dp = new int[R][C];
        map = new int[R][C];



        for(int r = 0 ; r < R ; r++){
             st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++){
                map[r][c]= Integer.parseInt(st.nextToken());

                // 처음에 -1로 초기화를 해주어야한다.
                // 그 이유는 갈 수 있는 경로의 수가 0일 수도 있기 때문이다. 이는 0도 방문했다는 의미가 될 수 있기때문에 방문하지 않은경우를
                //뚜렸하게 표현하기 위해 -1로 설정한다.
                //이 dp의 값이 -1이면 방문하지 않았다는 의미를 내포하고 있으며 0이상이면 방문했다는 의미이다.
                dp[r][c] = -1;
            }
        }

        //깊이 우선 탐색을 하지만 모든 경우를 다 탐색하면 시간초과가 발생한다.
        //핵심은 경로를 구했던 곳은 다시 가지 않는다는 점이다.
        //문제의 예시에서 32 ->  30 -> 25 -> 20 -> 17 -> 15 -> 10인 경로로 먼저 갔다고 하자
        // 다음 번에 32 에서 20을 가는 경우였을때  20에서 10으로 가는 경우는 이미 앞서서 구해졌을것이다.
        //하지만 일반적인 DFS로 한다면 20을 들어왔을때 20으로 출발할 수 있는 모든 경로를 또 방문한다는 점이다. 여기서 시간초과가 발생한다.
        //따라서 20에 대한 모든 경로의 수가 구해졌다면 다음 어떠한 경로로 20에 왔었을때는 20의 경로의 수만 리턴해서 최종 경로의 수를 합산해서 오면된다.

        //본인은 dfs로 했다가 시간초과 발생 ㅎㅎ . 구해진 경로를 다시 방문한다는 점에서 시간초과가 발생한다는것을 발견했고 , 그러면
        // 들렸던 경로의 경수의 수를 구해서 이를 이용해서 경로의 수를 갱신해야겠다는 생각까지는 했지만... 구현에서 좀 막힌듯. 확신도 없엇음

        dfs(0,0);

        System.out.println(dp[0][0]);

    }
    private static int dfs(int startR ,int startC){

        // 목적지에 도착하면 처음 경로의 수는 1이다.
        if(startR == R-1 && startC == C-1) return 1;
        //만약 방문했던 좌표라면 경로의 수를 리턴한다. 한다.
        if(dp[startR][startC]!=-1) return dp[startR][startC];

        //방문하지 않은 경우라면 dp[startR][startC] 의 값을 0으로 변경해준다.
        // 경로의 수를 더해서 누적할껀데 -1부터하면 값이 이상해지니까 0으로 해서 값을 구해야함

        dp[startR][startC] = 0;

        for(int i = 0  ; i < 4 ; i++){

            int nextR = startR+dr[i];
            int nextC = startC+dc[i];

            //다음 이동할 좌표는 2차원 배열 범위를 벗어나면 안된다.
            if ( nextR < 0 || nextR >=R || nextC < 0 || nextC >=C) continue;

                //높이 이동할 수 있는 경우에만 이동
                if(map[startR][startC]>map[nextR][nextC]) {

                    //다음 이동할 좌표에 대하여 깊이우선 탐색을 한다.
                    dp[startR][startC] += dfs(nextR,nextC);
                }

            }
        

        //해당 좌표에 대한 4방향 모든 경우의 수를 구했다고하면 dp[startR][startC]는 startR, startC까지 오는 총 경로의 수가 저장되게 된다.
        //이를 return 해주어서 이전 좌표의 값에 또 합산하는 식으로 총 경로의 수를 구한다.
        return dp[startR][startC];
        
    }

}
