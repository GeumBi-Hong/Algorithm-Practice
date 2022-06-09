package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9417 {
    static int max;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        while (T-->0){

            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int N = st.countTokens();
            int []num = new int[N];
            int []index = new int[2];
             max =1;

            for(int i = 0 ; i<N;i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            recur(0,0,num,index,N);

            sb.append(max).append("\n");



        }
        System.out.println(sb);

    }
    private static void recur(int depth,int start,int []num,int []index,int N){
        if(depth==2){
            max= Math.max(max,gcd(num[index[0]],num[index[1]]));

            return;
        }

        for(int i = start; i<N;i++){
            index[depth]=i;
            recur(depth+1,i+1,num,index,N);
        }

    }
    //최대 공약수
    private static int gcd(int a, int b){
        if(b==0)return a;
        //GCD(a,b)=GCD(b,r) ;  r= a mod b
        return gcd(b,a%b);
    }
}
