package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13305 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //주유소 개수

        int [] distance = new int[N-1];
        int [] price = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N-1;i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N;i++){
            price[i] = Integer.parseInt(st.nextToken());
        }


        //첫번째 주유소에서 기름이 없으므로 기름을 무조건 채워야한다.

        long totalPrice = 0;




        long minPrice = price[0];



        for(int i = 0; i <N-1;i++){
           if(minPrice>price[i]){
               minPrice=price[i];
           }
           totalPrice+=minPrice*distance[i];

        }

        System.out.println(totalPrice);

    }
}
