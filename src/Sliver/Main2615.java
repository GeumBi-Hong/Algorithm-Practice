
package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2615 {

    static int[][] map = new int[20][20];
    static int[] dr = {0, 1, 1, -1};
    static int[] dc = {1, 1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int r = 1; r <=19; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int c = 1; c <= 19; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        for (int r = 1; r <= 19; r++) {
            for (int c = 1; c <= 19; c++) {
                if (map[r][c] != 0){
                    if(checkWhiteOrBlack(r, c)) {
                        System.out.println(map[r][c]);
                        System.out.println(r + " " + c);
                        return;
                    }
                }
            }//c
        }//r

     System.out.println(0);
    }

    private static boolean isRange(int r, int c) {
        return r >= 1 && r <= 19 && c >= 1 && c <= 19;
    }

    private static boolean checkWhiteOrBlack(int r, int c) {


        boolean flag = false;
        for (int i = 0; i < 4; i++) { //4 방향에 대해서 조사
            int count = 1;

            //전 칸 확인
            if (isRange(r - dr[i], c - dc[i]) && map[r][c] == map[r - dr[i]][c - dc[i]]) continue;
            // 끝+1 확인
            if (isRange(r + dr[i] * 5, c + dc[i] * 5) && map[r][c] == map[r + dr[i] * 5][c +dc[i] * 5]) continue;

            for (int k = 1; k <= 4; k++) {
                if (isRange(r + dr[i] * k, c + dc[i] * k) && map[r][c] == map[r + dr[i] * k][c + dc[i] * k]) count++;
            }


            if (count == 5) {


                flag=true;
                break;
            }
            ;
        }

        return flag;
    }

}