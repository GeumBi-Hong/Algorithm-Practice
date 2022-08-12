package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1065 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int answer = 99;
        if(N<100) {
            System.out.println(N);
            return;
        }
        else {

            for(int i =100 ; i<=N;i++){
                int n = i;
                List<Integer> list  = new ArrayList<>();
                while (n!=0){

                    int unit = n%10;
                    list.add(unit);
                    n=n/10;

                }


                boolean flag =true;
                for(int k = 1 ; k<list.size()-1;k++){

                    if(list.get(k)-list.get(k-1)!=list.get(k+1)-list.get(k)){
                       flag=false;
                    }
                }

                if(flag) answer++;

            }
        }

        System.out.println(answer);
    }
}
