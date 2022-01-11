import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][2];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());

        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            int kg = array[i][0];
            int cm = array[i][1];

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (kg < array[j][0] && cm < array[j][1]) {
                count ++;
                }

            }

        sb.append(count + " ");

    }
        System.out.print(sb);



    }
}
