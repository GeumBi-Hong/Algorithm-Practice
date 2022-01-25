package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//경로찾기 (플로이드 -와샬)
public class Main11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer  st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //플로이드 - 와샬
        //array[i][j] = array[i][k] -> array[k][j]
        for (int k = 0; k < N; k++) { //거쳐가는점
            for (int i = 0; i < N; i++) { // 출발 노드
                for (int j = 0; j < N; j++) { //도착 노드
                    if (array[i][k] == 1 && array[k][j] == 1) { //이 관계여야 i -> j 가 성립한다.
                        array[i][j] = 1; //경로가 있다면 1
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(array[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}

