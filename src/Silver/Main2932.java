package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2932 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int num[] = new int[1000];
        int arrR[] = new int[1000];
        int arrC[] = new int[1000];
        int numR[] = new int[1000];
        int numC[] = new int[1000];


        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());

            // -1 을 해준 이유는 인덱스를 (0,0)부터 사용하기 위함
            num[i] = Integer.parseInt(st.nextToken()) - 1;
            // 이동해야 되는 좌표
            arrR[i] = Integer.parseInt(st.nextToken()) - 1;
            arrC[i] = Integer.parseInt(st.nextToken()) - 1;

            //num [i] 의 현재 좌표
            numR[i] = num[i] / N;
            numC[i] = num[i] % N;


        }

        //수 이동
        for (int i = 0; i < K; i++) {

            // 도착해야될 인덱스  - 이동해야되는 수 인덱스
            int r = arrR[i] - numR[i];
            int c = arrC[i] - numC[i];


            //음수가 되면 N만큼 더해주면 회전해야될 횟수가 나온다.
            if (c < 0) c += N;
            if (r < 0) r += N;



            //이동 했으니 인덱스를 변경해주어여한다.

            for (int j = 0; j < K; j++) {
                if (numR[j] == numR[i]){
                    numC[j] = (numC[j] + c) % N;
                }

            }

            for (int j = 0; j < K; j++) {
                if (numC[j] == numC[i]){
                    numR[j] = (numR[j] + r) % N;
                }

            }

            sb.append(c+r + "\n");
        }
        System.out.println(sb);
    }
}



