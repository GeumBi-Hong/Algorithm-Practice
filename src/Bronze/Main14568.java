package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 1; i<=N;i++){
            for(int j =1; j<=N-i;j++){//영훈
                int k = N-i-j;
                if(i%2!=1 &&k>=j+2){
                    System.out.println(i+" "+j+" "+k);
                   count++;
                }

            }
        }

        if(count==0){
            System.out.println(0);
        }else {
            System.out.println(count);
        }

    }
}
