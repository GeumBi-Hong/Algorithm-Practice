package Silver;


/**
 * 후위 표기식
 *
 * 연산자가 나오면 ( +, -, / ,*) 앞의 피연산자(여기서는 알파벳에 대응되는 숫자)두개를 선택하여 연산하고 다시 넣어주는 방식으로 풀어야하니
 * stack 이라는 자료구조를 이용하면 쉽게 풀 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1935 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        //해당하는 알파벳에 숫자 매칭
        int[] num = new int[N];

        for(int i = 0 ; i < N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        //Double 형으로 하는 이유는 정답을 소숫점 둘째짜리 까지 출력해야되기때문에 연산하는 과정에서 소숫점이 발생할 수 있음.
        Stack<Double> stack = new Stack<>();

        /** 후위 연산 **/
        for(int i = 0 ; i < str.length(); i++){

            char c = str.charAt(i);
            //알파벳일 경우 피연산자이다.
            if('A' <= c && c <= 'Z'){
                stack.push((double) num[c-65]);
            }else{

                //그렇지 않은 경우는 연산자의 경우이며 pop을 두번하여 연산 이때 +라고 하면 첫번째로 꺼낸 애가 B고 두번째로 꺼낸애가 A라고 하면  A + B로 연산해야됨

                double b = stack.pop();
                double a = stack.pop();

                switch (c){
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                }
            }

        }

        System.out.println(String.format("%.2f",stack.pop()));

    }






}
