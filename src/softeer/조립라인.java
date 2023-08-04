package softeer;

import java.util.*;
import java.io.*;

/**

 *  반조립이 절반의 반인줄 걍 미완성 의미

 * 실행시간 : 81ms 메모리 10.84Mb
 */
public class 조립라인 {


    static class Line {
        private int workPlaceA;
        private int workPlaceB;
        private int moveToB;
        private int moveToA;

        public Line(int workPlaceA, int workPlaceB, int moveToB, int moveToA) {
            this.workPlaceA = workPlaceA;
            this.workPlaceB = workPlaceB;
            this.moveToB = moveToB;
            this.moveToA = moveToA;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 작업장 수


        List<Line> workPlaceInfo = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int workA = Integer.parseInt(st.nextToken());
            int workB = Integer.parseInt(st.nextToken());
            int moveAtoB = Integer.parseInt(st.nextToken());
            int moveBtoA = Integer.parseInt(st.nextToken());

            workPlaceInfo.add(new Line(workA, workB, moveAtoB, moveBtoA));

        }
        st = new StringTokenizer(br.readLine());

        //마지막 AN BN 의 정보 입력하기
        workPlaceInfo.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, 0));


        //Ai작업장으로 갔을 때의 최소 비용과 Bi로 갔을때의 최소비용을 계속 구해준다.
        // Ai작업장으로 가는 경우는 이전의 B에서 오거나 이전의 A
        // Bi작업장으로 가는 경우는 이전의 A에서 오거나 이전의 B  일거다.
        // 이전의 A 이전의 B를 알려면 처음부터(1) 오면서 최소비용을 계속 갱신해 왔다면 이전의 B혹은 이전의 A값을 알아서 해당 값을 이용해서 계속 최솟값을 구할 수 있다.

        int[] dpA = new int[N];
        int[] dpB = new int[N];

        dpA[0] = workPlaceInfo.get(0).workPlaceA;
        dpB[0] = workPlaceInfo.get(0).workPlaceB;


        for (int i = 1; i < N; i++) {

            dpA[i] = Math.min(dpA[i - 1] + workPlaceInfo.get(i).workPlaceA, dpB[i - 1] + workPlaceInfo.get(i - 1).moveToA + workPlaceInfo.get(i).workPlaceA);
            dpB[i] = Math.min(dpB[i - 1] + workPlaceInfo.get(i).workPlaceB, dpA[i - 1] + workPlaceInfo.get(i - 1).moveToB + workPlaceInfo.get(i).workPlaceB);

        }

        System.out.println(Math.min(dpA[N - 1], dpB[N - 1]));


    }
}
