package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int start = 665;

       while (true){
           start++;

           int n = start;
           int sixCount = 0;
           while (n != 0){
                if(n%10==6){
                    sixCount++;
                    if(sixCount==3){
                        count++;
                    }
                }else {
                    sixCount=0;
                }

                n=n/10;

           }

        if( count==N) {
            System.out.println(start);
            break;
        }
       }

    }
}
