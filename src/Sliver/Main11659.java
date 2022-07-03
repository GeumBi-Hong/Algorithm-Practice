package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        int [] arr = new int[N+1];
        int [] prefix = new int[N+1];


        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= N;i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i]= n;
            prefix[i]= prefix[i-1]+arr[i];
        }

        while (M-->0){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());



            sb.append(prefix[e]-prefix[s-1]).append("\n");


        }
        System.out.println(sb);


    }
}
