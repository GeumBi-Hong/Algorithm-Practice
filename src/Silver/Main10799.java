package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 쇠 막대기
 */
public class Main10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stack = 0;
        int answer =0;


        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            /**  [  (  ] 일 경우 stack 에 +1 **/

            if (c == '(') stack++;

            /**  [  )  ] 일 경우 stack 에 -1 **/
            else {
                stack --;

                //이때 이전의 값이 ( or ) 에 따라
                if(str.charAt(i - 1) == '(') answer += stack;
                else answer++;
            }
        }


        System.out.println(answer);


    }
}