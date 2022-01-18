package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//counting sort
public class Main10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int Max = 10001;

        int N = Integer.parseInt(br.readLine());
        int []array = new int[Max];

        for (int i = 0 ; i < N ;  i ++){
            array[Integer.parseInt(br.readLine())] ++;

        }

        for ( int i = 1; i<Max; i++){
            //중복 된 수 만큼 출력해주어야한다.
            while (array[i]>0){
                sb.append(i).append("\n");
                array[i]--;
            }

        }

        System.out.print(sb);
    }
}
