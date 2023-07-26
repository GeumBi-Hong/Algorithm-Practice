package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 회의실 배정
 *
 * [문제조건]
 * - 회의의 수 1 <= N <= 100,000
 * - 시작과 끝나느 시간은 2^31 -1 보다 작거나 같은 자연수 또는 0
 * [풀이]
 * -어떻게 하면 빈틈없이 최대로 많은 회의를 사용할 수 있을까?
 * -간격 적고 촘촘하게
 *
 * 1. 끝나는 시간을 기준으로 오름차순 정렬
 * 2. 만약 끝나느 시간이 같다면 시작시간 오름차순정렬
 * 3. 최근에 끝난 회의 시간보다 다음 회의시간이 같거나 크면 그 회의는 가능 => 즉 개수 세기
 *
 *
 * 리스트로 안하고 큐로 바로 정렬때려도 됐을듯..
 */

/**
 * [반례]
 * 5
 * 1 4
 * 9 9
 * 1 9
 * 2 9
 * 3 9
 * 4 9
 * 정답 : 3
 * 오답 : 2
 *
 * endTime이 같을 시에는 startTime 이 작은 순으로 정렬이 되어야함
 *
 *
 */
public class Main1931 {


    static class Room implements Comparable<Room> {
        private int startTime;
        private int endTime;

        public Room(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room other) {
            if(this.endTime == other.endTime) return Integer.compare(this.startTime , other.startTime);
            return Integer.compare(this.endTime, other.endTime);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());// 회의 수


        List<Room> roomList = new ArrayList<>();

        while (N --> 0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            roomList.add(new Room(start,end));
        }

        Collections.sort(roomList);

        int lastTime = -1;

        int answer = 0;

        for (Room room : roomList) {

            if(room.startTime >= lastTime){
                lastTime = room.endTime;
                answer++;
            }

        }

        System.out.println(answer);

    }
}


