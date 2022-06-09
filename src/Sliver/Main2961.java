package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2961 {

     static int [][]food ;
     static int N;
     static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        food=  new int[N][2];
        for(int i = 0 ; i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            food[i][0]=n1; //신맛은 곱
            food[i][1]=n2; //쓴맛은 합
        }



            recur(0,1,0,0);
        System.out.println(answer);

    }

    private static void recur(int depth ,int s1, int s2 ,int foodCount){

        if(depth==N){
            if(foodCount==0)return;
            answer = Math.min(Math.abs(s1-s2),answer);

            return;
        }

        //고르고
        recur(depth+1,s1*food[depth][0],s2+food[depth][1],foodCount+1);
        //안고르고
        recur(depth+1,s1,s2,foodCount);
    }
}
