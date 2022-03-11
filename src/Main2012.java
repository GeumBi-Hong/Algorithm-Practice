import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//등수 매기기
public class Main2012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int rank = 1;
        long answer= 0; // 합을 구하는 과정에서  int 범위를 넘을 수있음

        int [] array = new int[500001];

        while (N-->0){
            array[Integer.parseInt(br.readLine())]++;
        }


        for(int i = 1 ; i<=500000;i++){
            for(int j = 0 ;j<array[i];j++){
                if(rank==N+1) break;
                answer+= Math.abs(i-rank);

                rank++;
            }
        }

        System.out.print(answer);
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//등수 매기기 2012 (그리디).
public class Main2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long answer = 0 ;
        int [] array = new int[N];

        for (int i = 0 ; i<N;i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        for (int i = 0 ; i<N ; i++){
            answer = answer + Math.abs(array[i]-i-1);
        }

        System.out.print(answer);



    }
}
*/
