package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main12101 {
    static  int N,K;
    static int [] num;
    static boolean flag =false;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[N];

        backTracking(0,0);
        if(sb.toString().equals(""))System.out.println(-1);
        else  System.out.println(sb);

    }
    private static void backTracking(int depth,int sum){

        if(depth==N){
            return;
        }

        for(int i = 1 ; i<=3;i++){
            if(flag)return; //정답을 찾은 후 부턴 계속 리턴시켜준다.

            num[depth]=i;
            sum+=i;

            if(sum>N)return;
            if(sum==N){
                count++;
            }
            if(count ==K){
                for(int j= 0 ; j <=depth;j++){
                    if(j==depth)sb.append(num[j]);
                    else sb.append(num[j]).append('+');

                }
                flag=true; //정답을 구했다면 true;
                return;
            }
            backTracking(depth+1,sum);
            sum-=i;


        }

    }

}
