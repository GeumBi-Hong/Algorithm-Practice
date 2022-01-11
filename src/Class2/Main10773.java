package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;



public class Main10773 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer =0;
        int count =0;

        for (int i = 0 ; i < N ; i++){

            int num = Integer.parseInt(br.readLine());
            // 수가 0 이였을 경우 가장 최근의 수를 빼준다.
            if (num ==0){
                if(count!=0) { // 가장 최근의 수가 없을 수도 있음
                    count--;
                    answer -= stack.pop();
                }
            }else {//수가 0 이 아니였을 경우는 수를 더해준다.
                stack.push(num);
                count ++;
                answer+=num;
            }
        }

        System.out.println(answer);

    }
}
