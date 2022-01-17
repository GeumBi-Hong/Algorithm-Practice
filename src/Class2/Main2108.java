package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        int [] count =  new int[8001]; // [0] = -4000  [4000] = 0 [8000] =4000
        double sum = 0;
        int mode_max=0;
        int max= Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <N ; i ++){
            int v = Integer.parseInt(br.readLine());
            num[i]=v;
            count[v+4000] ++; //수가 몇번 나왔는지 세어준다.

            if( max <v){
                max =v;
            }
            if (min > v){
                min = v;
            }

            if(count[v+4000]>mode_max){
                mode_max=count[v+4000];
            }

            sum += num[i];
        }



        int c =0;
        int mid_index=0;
        int mode =0;
        int mid =0;
        for(int i = min +4000 ;i <=max +4000;i++){

           if(count[i]>0) {

               if (count[i] == mode_max) { //최빈값 찾기
                  if(c<2){
                      c++;
                      mode = i -4000;
                  }
               }

               if ( mid_index == N/2){ //중앙값 찾기
                   mid = i-4000;
               }
               mid_index++;
           }
        }


        sb.append(String.format("%.0f",sum/N)).append("\n"); //산술평균 (소수 첫재짜리 반올림)
        sb.append(mid).append("\n"); //중앙값
        sb.append(mode).append("\n"); //최빈값
        sb.append(max -min); // 범위

        System.out.print(sb);


    }
}
