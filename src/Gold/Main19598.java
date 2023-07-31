package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 최소 회의실 개수
 *
 * 11000번 강의실 배정과 비슷한 문제아닌가?
 * 다시 풀어보지뭐
 *
 */
public class Main19598 {

    static class Room implements Comparable<Room>{

        private int startTime;
        private int endTime;

        public Room (int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room other) {
             if(this.startTime == other.startTime){
                return Integer.compare(this.endTime, other.endTime);
            }
             return Integer.compare(this.startTime , other.startTime);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Room> queue = new PriorityQueue<>();

        while (N --> 0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Room(start,end));
        }

        //끝나는 시간을 기준으로 우선순위 큐 하나 설정

        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        endTimeQueue.add(queue.poll().endTime);


        while (!queue.isEmpty()){

            Room room = queue.poll();
            if(endTimeQueue.peek() <= room.startTime){

                endTimeQueue.poll();


            }
            endTimeQueue.add(room.endTime);
        }


        System.out.println(endTimeQueue.size());
    }
}
