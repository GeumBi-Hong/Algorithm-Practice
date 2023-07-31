package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * 행복 유치원
 *
 * [문제조건]
 * - 유치원에 있는 원생수 N 은 최대 300,000
 * - 나누려고 하는 조의 개수 또한 최대 N
 * - 원생의 키는 10^9승을 넘지않음
 * - 어느 한 조에 혼자있으면 비용을  안내나봄
 *
 * [문제풀이]
 * - 비용을 적게하려면 두 원생의 키 차이를 가장 작게 가져가야함
 * - 문제에서 "각 조에는 원생이 적어도 한 명 있어야 하며, 같은 조에 속한 원생들은 서로 인접해 있어야 한다" <<이게 뭔소린가 했는데 그룹나눌떄
 * - 붙어있게 해야된다는거같음
 *
 * - 그래서 3그룹을 만든다하면 칸막이라 생각하고 두개로 나누면 3그룹이 나오는데 가장 큰 차이가 나는 구간을 나누면됨
 * - 나누어야하는 구간 개수는 K - 1
 *
 *
 * ex)   1  2   5  6  7  8  9 30 40 100 200  가 있고 3그룹을 만들어야한다고 치자 이 학생끼리의 키차이를 구하면
 *
 *     =>  100 60 10 21 1 1 1 1 3 1 이렇게 일꺼고 가장 크게 차이가 나누는 곳을 기준으로 그룹화하면 그 큰 차이를 없앨 수 있음
 *     따라서 내림 차순 정렬하면 100 60 21 10 3 1 1 1 1...이니까 2차이를 제외하고 나머지를 더하면됨
 *     21 10 3 1 1 1 1 더하는게 결국 그 그룹안에서 가장 큰 애와 작은애의 차이를 구할 수 있다.
 *
 *     1  2   5  6  7  8  9 30 40 | 100 | 200
 *
 *
 *     우선순위 큐를 내림차순으로 정렬되게끔 한 후 힙에 넣어주면서 K-1개의 원소를 뺴고 나머지 원소를 더하는 풀이가 조금 더 빠른듯하다.
 */
public class Main13164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] studentTall = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i <N ; i++){
            studentTall[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> tallDiff = new ArrayList<>();

        //인접해 있는 학생의 키 차이 저장
        for (int i = 0 ; i < N - 1; i++){
            tallDiff.add(studentTall[i + 1] - studentTall[i]);
        }
        //내림 차순으로 정렬 -> 가장 큰 차이가 나는 구간은 세어주면 안되기때문

        Collections.sort(tallDiff);

        int answer = 0;
        //가장 큰 키차이를 K - 1 개를 제외하고 나머지를 더하면 됨
        for (int i = 0 ; i < N - K ; i++){
            answer += tallDiff.get(i);
        }

        System.out.println(answer);

    }
}
