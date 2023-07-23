package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * 서강 근육맨
 *
 *
 * [문제 조건]
 * 운동 기구 개수는 만개 이하
 * 근손실 정도는 ti < 10^18 => long형 범위 안 (int로 하면 터짐주의)
 *
 * [풀이 과정]
 * 어떻게 하면 하루 최소 할 수 있는 M 을 구할 수 있을까
 * => 그니까 둘을 더했을때 가장 작은 경우
 *
 * N의 홀수인경우랑 짝수인 경우를 어떻게 처리할 것인가..
 *
 * [풀이 생각]
 * 1.M을 이탐으로 찾는다 해도 그게 다 되는지 판별할 수가 없음 ..시간제한 ㅠ
 * 2. 적어도 N^2에 끝내야하는디..?
 *
 * 합을 가장 작게 만들려고 하면 결국엔 가장 큰값+가장 작은 값을 더해야 뭔가 중간이 딱 올꺼임
 * 근데 이제 예를 들어 7 + 25 가 문제에서 원하는 값에 해당이 되냐는것.
 * 최소값을 구하려고하면 양쪽 끝에서 하나씩 더하면서 들어와야됨
 * 그러다가 7 + 25 보다 19 + 20 이 더 큰 경우가 있음 그러면 19 + 20으로 최소값이 갱신
 *
 * 각 운동기구의 근손실 정도가 최소가 나오려면, 주어진 값들 중 최대값 + 최소값을 더해 비교해나가면 된다.
 *
 * 7 19 20 25
 *
 *
 */
public class Main20300 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine()); // 운동기구 개수
        ArrayList<Long> arrayList = new ArrayList<>();

        //홀수 개라면 0을 넣어 짝수개로 맞춰준다.
        if(N % 2 != 0) arrayList.add(0L);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ;i++){
            arrayList.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(arrayList);

        int size = arrayList.size() / 2;

        long min = 0;
        //시작 인덱스
        int startIndex = 0;
        //끝 인덱스
        int endIndex = arrayList.size() - 1;

        while (size --> 0){

            //이전 의 합보다 더 크면 그게 최소 근손실 값이 됨
            min = Math.max(min, arrayList.get(startIndex) +  arrayList.get(endIndex));
            startIndex++;
            endIndex--;

        }

        System.out.println(min);

    }
}
