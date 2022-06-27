package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2217 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] rope = new int[N];

       for(int i = 0 ; i < N; i++){
           int n = Integer.parseInt(br.readLine());
           rope[i]= n;
       }


        Arrays.sort(rope);


       int  min = rope[0];
       int answer = -1;

       int len = rope.length;
       for(int i = 0 ; i <N;i++){
           int n = rope[i];
           answer = Math.max(answer,n*len);
           len--;

       }

    System.out.println(answer);

    }
}
