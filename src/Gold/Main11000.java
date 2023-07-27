package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 강의실 배정
 *
 * [문제조건]
 *
 * 수업 개수 1 <= N <= 200,000
 * 시간은 0 <= Si < Ti <= 10^9
 *
 *
 * [생각]
 * 흠.. 회의실 배정처럼 끝나는 시간순으로 정렬 , 시작시간으로 정렬해야하나 ..
 *
 * 최소 강의실... 그렇다는건 연달아서 엄청 많이 했으면 좋겠다는 거같은데
 * 즉 한 강의실에 최대한 많은 수업을 해야된다는것
 * 그럼 강의실 개수는 어떻게 세냐..
 *
 * 개인적인 생각인데
 * 종료시간으로 먼저 정렬하고 시작순으로 정렬하는 방법으로는 문제 조건 시간 복잡도 안에 풀 수 있는 풀이가 없어서 이지 않을까...?
 * 나는 이제 위와같은 정렬방식으로 하면 강의실에 최대로 강의를 넣을 수 있으니까 그렇게 넣어서 남은건 또 그 방식대로 강의를 배정해서
 * 강의실 개수를 구하려고 했는데 이건 시간 복잡도가 너무 큼
 *
 * 그래서 시작시간기준으로 정렬하고 종료시간으로 종료하는 방식을 사용하면
 * n logn 만에 풀 수있는거같다.
 *
 * [풀이과정]
 *1. 강의 시간을 시작시간 , 종료시간 순으로 오름차순 정렬
 * 2. 우선순위 큐를 이용 하여 종료시간 오름차순으로 정렬 , 처음에 첫값 넣기
 * 3. 큐에서 가장 작은 값과 현재의 시작값을 비교하여 시작값이 같거나 큰 경우에는 강의실에 배정할 수 있기때문에
 * 큐에서 poll을 해줌 그리고 현재 본인의 값을 넣어줌
 * 4. 그렇지 않는다고 하면 그냥 넣어주기만 하면됨
 * 5. 큐에 남은게 강의실 배정한 수이기때문에 사이즈만 출력해주면됨
 *
 */
public class Main11000 {
    static class ClassTime implements Comparable<ClassTime>{
        private int startTime;
        private int endTime;

        public ClassTime(int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(ClassTime other){
            if(this.startTime == other.startTime) {
                return Integer.compare(this.endTime,other.endTime);
            }
            return Integer.compare(this.startTime,other.startTime);
        }
    }


    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        ClassTime[] classTimesList = new ClassTime[N];

        for (int i = 0;  i < N; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            classTimesList[i] = new ClassTime(start,end);
        }

        //[1]시작 시간을 기준으로 오름 차순 정렬, 시작 시간이 같다면 끝나는 시간 기준 오름 차순 정렬
        Arrays.sort(classTimesList);


        //[2] 우선순위 큐에는 종료 시간만 들어가며 , 오름 차순으로 자동 정렬
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(classTimesList[0].endTime);



        for(int i = 1; i < N; i++){
            //우선순위 큐에서 가장 작은 종료 시간과
            //현재의 시작 시간을 비교힌다.

            if(priorityQueue.peek() <= classTimesList[i].startTime){
                priorityQueue.poll();
            }

            priorityQueue.add(classTimesList[i].endTime);
        }

        System.out.println(priorityQueue.size());
    }

}



    /*static int answer = 0;

    static class ClassTime implements Comparable<ClassTime>{
        private int startTime;
        private int endTime;

        public ClassTime(int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(ClassTime other){
            if(this.endTime == other.endTime) {
                return Integer.compare(this.startTime,other.startTime);
            }
            return Integer.compare(this.endTime,other.endTime);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());


        PriorityQueue<ClassTime> priorityQueue = new PriorityQueue<>();


        while (N --> 0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            priorityQueue.add(new ClassTime(start,end));
        }

        while (!priorityQueue.isEmpty()){
            ClassTime classTime = priorityQueue.poll();
            System.out.println(classTime.startTime + " "+ classTime.endTime);
        }
        //solution(priorityQueue);


        System.out.println(answer + 1);

    }

    private static void solution(PriorityQueue<ClassTime> priorityQueue) {

        PriorityQueue<ClassTime> leftClass = new PriorityQueue<>();

        int lastTime = -1;
        while (!priorityQueue.isEmpty()) {

            ClassTime classTime = priorityQueue.poll();

            if (lastTime > classTime.startTime) {
                leftClass.add(classTime);
            } else {
                lastTime = classTime.endTime;
            }
        }

        if (leftClass.size() != 0) {
            solution(leftClass);
            answer++;
        }
    }*/