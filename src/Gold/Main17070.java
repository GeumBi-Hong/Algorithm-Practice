package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dp 로 푸는게 더 빠름
 */
public class Main17070 {
    static int [][]map;
    static int N;
    static int count = 0;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        /**
         * 2차원 배열에 입력값 저장
         */
        for(int r = 1; r <= N;r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N ; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        //첫파이프의 위치는 (1.1)(1,2) 처음엔 가로로 위치

        recur(1,2,0);
        System.out.println(count);


    }
    private static void recur (int pipeR ,int pipeC,int direction){
        if(pipeR==N&&pipeC==N){
            count++;
            return;
        }
        //파이프 상태에 따라 실행이 달라짐
        // 0: 가로 상태 , 1: 세로 상태 , 2: 대각선 상태
        switch (direction){
            case 0://가로인경우 => 오른쪽,대각선으로만 이동가능
                if(canGoNext(pipeR,pipeC+1)){//오른쪽으로 갈 수 있다면 오른쪽으로 이동
                    recur(pipeR,pipeC+1,0);
                }
                //대각선으로 갈 수 있다면
                if(canGoNext(pipeR+1,pipeC+1)&&canGoNext(pipeR+1,pipeC)&&canGoNext(pipeR,pipeC+1)){//대각선으로 갈 수 있다면
                    recur(pipeR+1,pipeC+1,2);
                }
                break;


            case 1: //세로 상태였을 경우 세로 또는 대각선으로 갈 수 있음
                //세로로 갈 수 있다면
                if(canGoNext(pipeR+1,pipeC)){
                    recur(pipeR+1,pipeC,1);
                }
                //대각선으로 갈 수 있다면
                if(canGoNext(pipeR+1,pipeC+1)&&canGoNext(pipeR+1,pipeC)&&canGoNext(pipeR,pipeC+1)){
                    recur(pipeR+1,pipeC+1,2);
                }

                break; //세로인 경우

            case 2: //대각선 상태의 경우 오른쪽 , 아래 , 대각선 모두 이동 가능
                //세로로 갈 수 있다면
                if(canGoNext(pipeR+1,pipeC)){
                    recur(pipeR+1,pipeC,1);
                }

                if(canGoNext(pipeR,pipeC+1)){//오른쪽으로 갈 수 있다면 오른쪽으로 이동
                    recur(pipeR,pipeC+1,0);
                }
                //대각선으로 갈 수 있다면
                if(canGoNext(pipeR+1,pipeC+1)&&canGoNext(pipeR+1,pipeC)&&canGoNext(pipeR,pipeC+1)){
                    recur(pipeR+1,pipeC+1,2);
                }
                break; // 대각선인 경우


        }


    }
    private static boolean canGoNext(int r ,int c){
        return r >=1 && c >= 1 && r<=N && c<=N &&map[r][c]!=1;
    }

}
