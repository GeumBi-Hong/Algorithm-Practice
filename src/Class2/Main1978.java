package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()){

            boolean flag =true;

            int num = Integer.parseInt(st.nextToken()); //하나 씩 수를 가져온다.

            if(num ==1){//숫자1은 검사해줄 필요가없다.
                continue;
            }

            for (int i =2; i< Math.sqrt(num);i++){
                if (num % i == 0){
                    flag =false;
                    break;
                }

            }
            if(flag){
                answer++;
            }

        }
        System.out.println(answer);


    }
}
