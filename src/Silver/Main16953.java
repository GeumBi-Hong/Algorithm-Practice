package Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *A->B
 *
 * [풀이과정]
 * 2를 곱하는건 짝수가되는거고
 * 1을 붙이는건 홀수가되는거 그리고 0하나를 더 붙이는 격이지 => 그럼 1을 많이 붙일 수 있는게 최소가 되는 경우일까?
 *
 * 2을 여러번 곱해서 원하는 수를 만드는거보다 1을 붙여서 원하는 수로 접근하는 것이 더 빠를것이다.
 * 그러면 A B가 있으면 B의 일의자리 수가 1이면 1을 붙인경우라고 생각하고 때고 그렇지 않고 짝수이면 /2를 해주면서 몇번 연산이 되었는지를 세어준다.
 * 최소방식으로 구하는거니까 최소연산 개수가 되겠지.

 * 예를 들어 100 40021이 있으면
 *
 * 40021 -> 4002(1) -> 2001 (/2) -> 200 (1) -> 100 (/2) 이런식으로 역으로 구해서 들어가서 최소연산방법으로 몇번 연산되었는지 찾아주자.
 *
 * 그럼 안되는 경우는 ?
 * 뭐 일의자리가 1이아닌 홀수인경우는 어떤 경우라도 안되겠지 2를 곱하거나 1자리를 더하는 경우밖에 없으니까.
 *
 *
 */
public class Main16953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;

        while (A < B){

            int num = B % 10;
            //[1] 1의자리가 1을 만나면 땐다.
            if(num == 1){
                B /= 10;
                answer++;
            }else if (num % 2 == 0){
                //[2] 그렇지 않으면 1의자리가 짝수일때  나누기 2를 한다.
                B /= 2;
                answer++;
            }else{
                //[3]다른 경우이면 만들수 없는 경우이므로 -1로 갱신하고 종료한다.
                answer = -1;
                break;
            }
        }

        if(A > B) {
            System.out.println(-1);
        }else{
            System.out.println(answer != -1 ? answer + 1 : -1);
        }

    }
}
