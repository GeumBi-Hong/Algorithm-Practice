package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//소인수 분해
public class Main11653 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i =2;i*i<=N;i++){ //i<=sqrt(N)
            while (N%i==0){
                sb.append(i).append("\n");
                N=N/i;
            }

        }

        if(N!=1){
            sb.append(N).append("\n");
    }
        System.out.println(sb);


    }
}
