package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 우체국
 *
 * [문제조건]
 * - N 최대 10만개
 *  마을위치는 -10억 +10억
 *  마을 사람 수는  1~10억
 *  -우체국 세워서 최소 비용구하기
 *
 *  [풀이 생각]
 *  - 문제 ㅈㄴ 설명 불친절하네
 *  - 어디로 세워야 최소 비용일까 좌표가 -10~ + 10억이라 완탐은 힘들고 뭔.. 최소가 되는 상황을 찾아야될거같ㅇ므
 *  - 뭔가 사람 많은 마을 사람이 멀게 가면 안될거같음  그게 거리에 x 사람 수 까지 연산이 되어버리니까 엄청 커지겠지..
 *  - 근데 이거 가지곤 안될거같은데
 *  - 거리도 생각해야되고 사람도생각해야됨 지금
 *  - (우체국 - 마을) x 사람수 이건가 지금
 *  -
 *
 *  [정답풀이]
 *   우체국 위치를 P라 하고 마을 인구 합을 T라고하면
 *  P를 T왼쪽에 있다가정하고 P를 계속 오른쪽으로 이동하면 비용이 줄겠지?
 *  반대로 T가 이번엔 왼쪽에있고 P가 오른쪽에 있다고 하면 P를 왼쪽으로 당길수록 비용을 줄을 꺼임
 *   그래서 이걸 "중간위치로 잡는게 가장 최소비용이 든다" 이런 뉘앙스같음..
 *
 *   1. 마을 위치 순으로 먼저 정렬 시키고 , 총 인구 수를 구한다.
 *   2. 첫 마을 부터 쭉 돌면서 (총 인구수 + 1 ) / 2 즉 중간값과 같거나 더 커지는 그 순간의 마을 좌표를 구한다.
 *   2 - 1 . (총 인구수 +1 ) / 2 를 하는 이유는 중간 값을 구해주고 싶기때문
 *   총 인구수가 7명이면 4가 나와야하고
 *   총 인구수가 8명이면 4.5인데 4가 나옴
 *   3. 이렇게 위치를 구해주면 최소비용으로 우체국을 설치할 수 있다.
 *
 *  [시간 복잡도]
 *  각 마을의 위치를 정렬하는데 O(NlogN)의 시간이 걸리고 각 마을을 탐색하는데 O(N)의 시간이 걸리므로 시간복잡도는 O(NlogN)이다. (N = 100,000)
 */
public class Main2141 {

    static class Village implements Comparable<Village>{

        private int location;
        private int people;


        public Village(int location, int people) {
            this.location = location;
            this.people = people;
        }

        @Override
        public int compareTo(Village other) {
            return Integer.compare(this.location,other.location);
        }
    }

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 마을 수

        PriorityQueue<Village> villages = new PriorityQueue<>();


        long totalPopulation = 0L;
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //마을 위치
            int a = Integer.parseInt(st.nextToken()); //마을 인구 수

            villages.add(new Village(x,a));

            totalPopulation += a;
        }

        long curPopulation = 0L;

        int answerLocation = 0;

        while (!villages.isEmpty()){

            Village village = villages.poll();

            curPopulation += village.people;

            if(curPopulation >= (totalPopulation + 1) / 2) {
                answerLocation = village.location;
                break;
            }
        }

        System.out.println(answerLocation);
    }
}
