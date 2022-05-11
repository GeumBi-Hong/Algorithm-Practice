package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6131 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = 500;
        int count = 0;

        for(int B =1 ; B<=max-1; B++){//B
            for(int A =B+1; A<=max;A++){//A

                if(Math.pow(A,2)-Math.pow(B,2)==N){
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
