package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호의 값
 */
public class Main2504 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ex ) (()[[]])([])
        String str = br.readLine();

        //정답을 출력할 변수
        int answer = 0;


        // 계산값을 저장할 변수
        int preCount = 1;

        Stack<Character> stack = new Stack<>();

        //str 문자열 길이만큼 반복한다.
        for (int i = 0; i < str.length(); i++) {

            //i번째 문자
            char bracket = str.charAt(i);

            // 여는 괄호 기호일경우
            if (bracket == '(' || bracket == '[') {
                //스택에 넣는다.

                stack.push(bracket);

                preCount *= bracket == '(' ? 2 : 3;

                //닫는 괄호
            } else if (bracket == ')') {

                //안되는 경우를 먼저 처리
                if (stack.isEmpty() || stack.peek() != '(') {
                    //계산해 놨던 값 0
                    answer = 0;
                    break;
                }

                //올바른 괄호가 들어왔다면 누적합
                if (i - 1 >= 0 && str.charAt(i - 1) == '(') {
                    answer += preCount;
                }
                stack.pop();
                preCount /= 2;

            } else {
                //안되는 조건 처리
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }

                //올바른 괄호 [
                if (i - 1 >= 0 && str.charAt(i - 1) == '[') {
                    answer += preCount;
                }
                stack.pop();
                preCount /= 3;
            }

        }

        if(!stack.isEmpty()) answer = 0;

        System.out.println(answer);

    }

}
