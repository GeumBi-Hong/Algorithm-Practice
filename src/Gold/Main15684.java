package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15684 {
    static int N,M,H;
    static int[][]map ;
    static boolean flag=false;
    static int answer = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][N+1];

        for(int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine()," ");

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1; //1은  오른쪽 가로줄
            map[r][c+1] =2 ; //2는 왼쪽 가로줄
        }

        //정답은 최대 3
        for(int i = 0 ; i <4; i++){
            backTracking(0,i,1);
            if(flag)break;

        }

        System.out.println(answer);



    }
    private static void backTracking(int depth ,int finish,int height){
        if(flag)return;
        if(depth==finish){

            //세로 i번째가 i번으로 도착했는지 확인
            if(solution()){
                flag=true;
                answer =  finish;
            }
            return;

        }


        for(int i =height; i <=H;i++){
            for(int j = 1; j<N;j++){

                if(map[i][j]!=0||map[i][j+1]!=0)continue;
                map[i][j]=1;
                map[i][j+1]=2;
                backTracking(depth+1,finish,height);
                //다시 원상 복구
                map[i][j]=0;
                map[i][j+1]=0;
            }
        }

    }
    private static boolean solution(){

        boolean isFlag = true;
        for(int i = 1 ; i <=N;i++){
            //출발점
            int curR= 1;
            int curC =i;

            while (curR<H+1){
                if(map[curR][curC]==1) curC++;
                else if(map[curR][curC]==2)curC--;
                curR++;

            }

            if(curC!=i){
                isFlag=false;
                break;
            }

        }
        return isFlag;
    }
}
