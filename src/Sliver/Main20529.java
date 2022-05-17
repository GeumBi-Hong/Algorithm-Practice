package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main20529 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            int N = Integer.parseInt(br.readLine());
            String []str = br.readLine().split(" ");

            //비둘기 집 원리
            //n+1개의 물건을 n개의 상자에 넣을 때 적어도 어느 한 상자에는 두 개 이상의 물건이 들어 있다는 원리
            if(N>32) { //32명 초과인 경우 같은 mbti인사람 3명이 반드시 존재함
                sb.append(0).append("\n");
                continue;
            }


            //N명 중에 3명
            int min = Integer.MAX_VALUE;
            for(int i = 0 ; i< N;i++){
                for(int j =i+1; j<N;j++){
                    for(int k= j+1; k<N;k++){
                        min = Math.min(min, findMin(str[i],str[j],str[k]));
                    }

                }
            }

            sb.append(min).append("\n");

        }

        System.out.println(sb);

    }

    private static int findMin (String a , String b ,String c){

        int ab = calDistance(a,b);
        int bc = calDistance(b,c);
        int ca = calDistance(c,a);


        return ab+bc+ca;
    }

    private static int calDistance(String s1,String s2){
        int count = 0 ;
        for(int i = 0 ; i <4;i++){
            if(s1.charAt(i)!=s2.charAt(i)) count++;
        }

        return count;
    }
}
