package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소수 구하기
//에라토스테네스의 체
public class Main1929 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean []checkArray = erathosthenes(N);


        for (int i = M ; i<=N;i++){
            if(!checkArray[i]){
                sb.append(i).append("\n");
            }
        }


      System.out.print(sb);


    }

    public static boolean[] erathosthenes(int N){
        boolean[] checkArray = new boolean[N + 1];
        //소수 = false ; 소수가 아닌 숫자 = true;
        checkArray[0] = true;
        checkArray[1] = true;


        for (int i = 2; i<=Math.sqrt(checkArray.length);i++) {
            if(!checkArray[i]) {
                for (int j = i*2; j < checkArray.length; j += i) {
                    checkArray[j] = true;
                }
            }
        }

        return checkArray;
    }
}
