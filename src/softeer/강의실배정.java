package softeer;

import java.util.*;
import java.io.*;

/**
 * 강의실 배정
 *
 * - 최대한 강의실 1개에 많은 강의를 배정해야함
 *
 * [풀이]
 *
 * 1. 많이 배정하기 위해서는 연달아서 강의를 할 수 있도록 해야됨
 * -> 끝나는 시간으로 정렬 하고 끝나는 시간이 같다면 시작시간 기준으로 정렬
 *
 * [문제추천]
 * 최소 회의실 개수 골드 5
 * https://www.acmicpc.net/problem/19598
 **/
public class 강의실배정 {

    static class Room implements Comparable<Room> {
        private int startTime;
        private int endTime;

        public Room(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room other) {
            if (this.endTime == other.endTime) {
                return Integer.compare(this.startTime, other.startTime);
            }
            return Integer.compare(this.endTime, other.endTime);
        }

    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Room> queue = new PriorityQueue<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            queue.add(new Room(start, end));
        }

        //정렬된 상태로 강의 시간이 들어있을거다.
        //첫번째 시간을 빼서 그 시간을 기준으로 시작한다.
        int answer = 1;

        int latestTime = queue.poll().endTime;

        while (!queue.isEmpty()) {

            Room room = queue.poll();

            if (latestTime <= room.startTime) {
                answer++;
                latestTime = room.endTime;
            }

        }

        System.out.println(answer);

    }
}
