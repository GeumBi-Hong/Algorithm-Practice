package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [1번] 풀이 (최적화x)
 * 풀이시간 : 2시간 ..  정답이 나오게끔 접근하기까지 오래걸렸고 생각하고나서는 구현은 쉬웠음.
 * 처음 풀었던 풀이와 이에 최적화 시킨 풀이에 대해서 설명하고자 함
 *
 */


/**
 * 완전탐색방법으로 한 사람의 점수를 가지고 모든 사람들과 비교해가며 1,2차 점수가 자기보다 높은(3,4 ->1,2) 경우가 존재하면 총인원에서 -1 을 해보려고 했음
 * 근데 완탐으로 for문 두 번 돌려서 접근하면 N이 10만에다가 테스트케이스가 최대 20이기 때문에 시간초과가 발생함.
 * 그러면 결국 O(N^2) 보다는 낮은 시간복잡도를 가진 방식을 가지고 풀어야한다는거임
 * 여기서 어떻게 줄여볼까 하다가... 뭔가 정렬을 해서 우선순위? 성적순으로 나열해서 뭔가 접근을 해보려고 했음 (다른 알고리즘을 적용할만한게 생각나지않았음)
 *
 * 그렇게 한~두시간 고민하다가 알게 된것
 *
 * 먼저 처음 1차 서류 점수에 대해서만 오름 차순 정렬을 시켜보았음.
 * 테케2번에 대해서 예를 들어보겠음.
 *
 * <정렬 전> <정렬 후>
 * 3 6    ->  1 4
 * 7 3    ->  2 5
 * 4 2    ->  3 6
 * 1 4    ->  4 2
 * 5 7    ->  5 7
 * 2 5    ->  6 1
 * 6 1    ->  7 3
 *
 *
 * 여기서 1차 점수에 대해서 정렬해보았는데 한가지 발견한 사실은
 * 정렬하면 자기 앞사람보다 반드시 1차 서류점수가 낮다는 점임 -> 결국  점수 1차점수가 다른 사람보다 점수가 낮으니 2차 점수를 가지고 내가 탈락할 사람인지 아닌지 판단할 수 있어짐
 *
 *따라서 자기보다 앞에 있는 사람들의 2차 점수에 따라 결과가 나옴
 * 그럼 어떻게 판단하냐 (이걸 깨닫는데 오래걸림 ㅠ)
 *
 * => 첫번째 사람부터 탐색을 하면서 , 자기 보다 앞에 있는 사람들의 2차 점수의 최소값을 매번 갱신하여 자신의 2차점수와 비교하면 되는것.
 *
 * 처음 사람 1,4 (최소값 :MAX)  => 최소값보다 자신의 2차 점수가 더 낮다면 합격가능 ,그리고 나서 최소값을 4로 갱신해야됨
 * 다음 사람 2,5  (최소값 : 4) =>  정렬했기때문에 1차 서류 점수가 앞사람보다 반드시 낮음, 그리고 자기보다 앞에있는 사람들의 2차 최소 점수가 4였으니 당사자는 탈락
 * 따라서 2차점수에 대한 최소값을 갱신할때마다 정답+1을 해줘서 답을 찾으면되고 했다면 최소값을 갱신해야됨.
 *
 * 이 풀이에서 Collection.sort를 이용했기때문에 시간복잡도는 O(nlog(n))  *20
 *  1600ms
 *
 *  최적화
 *  배열인덱스 번호를 1차 서류 점수로 이용하여 따로 정렬하지 않게 풀수있음
 */

public class Main1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            // 인덱스 번호를 1차 서류 점수로 이용할꺼임 그럼 해당하는 1차점수의 인덱스에 2차 점수를 가진 사람의 점수에 대해서 저장할 수 있음
            //이렇게 되면 알아서 정렬한거처럼 배열로 접근할 수 있음
            int [] score = new int[N+1];

            for(int i = 1;  i <=N; i++){

                StringTokenizer st = new StringTokenizer(br.readLine());

                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                score[f]=s;
            }
            //그럼 굳이 정렬 안하고도 바로 N 번만에 답 찾을 수 있음
            int count = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 1 ; i<=N;i++){
                if(score[i] < min){
                    count++;
                    min=score[i];
                }
            }
            System.out.println(count);
        }//while
    }
  }
