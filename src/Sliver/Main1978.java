package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1978 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] num  = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i <N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0 ; i <N;i++){

            //1은 소수가 아님
            if(num[i]==1)continue;

            int count = 0;

            for(int j =2; j<=num[i];j++){
                if(num[i]%j==0){
                    count++;
                }
                if(count>=2)break;
            }
            if(count==1)answer++;

        }
    System.out.println(answer);
    }
}
