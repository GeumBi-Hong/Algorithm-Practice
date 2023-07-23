package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 잃어버린 괄호
 *
 *
 * 가장 작게 만드려면
 *
 *  '-' 뒤로 + 연산나오는걸 모두 더하고 거기에 -를 붙여야한다.
 */
public class Main1541 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        // - 기호 기준으로 나누기
        String[] minusSplit = expression.split("-");

        int answer = Integer.MAX_VALUE;

        for (String m : minusSplit) {

            //+ 기호로 나눠져 있으면 그걸 또 다 합해야함.
            String[] plusSplit = m.split("\\+");
            int sum = 0;

            for (String p : plusSplit) {
                sum += Integer.parseInt(p);
            }

            if(answer == Integer.MAX_VALUE) answer = sum;
            else answer -= sum;

        }
        System.out.println(answer == -1 ? 0 : answer);

    }
}
