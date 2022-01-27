package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//누적합
public class Main11659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //  수의 개수 N
        int M = Integer.parseInt(st.nextToken());// 합을 구해야 하는 횟수 M

        int [] array = new int[N];
        int [] sum =  new int [N+1]; //누적 합을 저장할 배열
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i< N;i++){ //N개의 수 배열에 저장하기.
            array[i] = Integer.parseInt(st.nextToken());
        }

        sum[1]=array[0]; // sum[1] =1~1까지의 합 .. sum[3]은 1~3까지 합

        for (int i = 2; i<N+1;i++){ // 구간합 구해주기
            sum[i]=sum[i-1]+array[i-1];
        }


        while (M-->0){
            st = new StringTokenizer(br.readLine() , " ");

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(sum[j]-sum[i-1]).append("\n");
        }

        System.out.print(sb);

    }
}
