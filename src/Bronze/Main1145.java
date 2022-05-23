package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1145 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int []num = new int[5];



        for(int i = 0 ; i < 5 ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int index = 1;

        while (true){
            int count  = 0 ; //나누어 떨어지는 수

            for(int i = 0 ; i < 5 ; i++){
              if (index % num[i]==0) count++;
            }


            //나누어지는 수가 3개 이상이면
            if(count>=3)break;

            index++;
        }

        System.out.println(index);
    }
}
