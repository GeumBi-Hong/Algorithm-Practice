package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11399 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //줄 서 있는 사람의 수

        int[] array = new int[1001]; //counting sort

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int before=0; //대기시간 누적합
        int sum=0; //총 대기 시간


        for (int i = 0; i < N; i++) {
            array[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 0; i < 1001; i++) {
            while (array[i]-- > 0) {
                sum+=before+i; //대기 시간 누적합 + 현재걸리는 시간
                before +=i; //대기 시간 누적합 갱신

            }

        }
        System.out.print(sum);

    }
}
