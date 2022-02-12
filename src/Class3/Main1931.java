package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//회의실 배정( 정렬 ,그리디)
public class Main1931 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전체 회의 수
        StringTokenizer st ;
        int endTime=0;
        int answer=0;

        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); //시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); //끝나는 시간
        }


        Arrays.sort(time, new Comparator<int []>() { //끝나는 시간순으로 정렬시킨다.
            @Override
            public int compare(int[] o1, int[] o2) { //만약 끝나는 시간이 같다면 시작 시간이 작은 순으로 정렬한다.
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });


        for (int i = 0; i <N ; i++){
            if(endTime<=time[i][0]){
                answer++;
                endTime=time[i][1];
            }
        }
      System.out.print(answer);
    }
}
