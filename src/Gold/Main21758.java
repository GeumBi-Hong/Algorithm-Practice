package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/***
 * 꿀 따기 (332ms)
 *
 * [문제]
 * - 연한 회색 : 벌 / 진한 회색 : 꿀통
 *
 * [문제조건]
 * - 3 <= N < 100,000
 * 각 장소의 꿀의 양은 1 이상 10,000이하 정수
 *
 * 꿀 합 합쳣을때 최대 양이 100,0000000 인트형은 넘지 않는듯
 *
 *
 *
 * [풀이 생각]
 * -일단  벌이 있는 장소 두곳과 꿀통의 위치를 놓아야할거같음
 * - 완탐은 당연히 시간때문에 안되고
 * - 어떻게 배치를 해야 꿀벌들이 이동하면서 가장 많은 꿀을 얻을 수 있을까?
 * - 정렬 x
 * - 꿀벌이 이동을 할때 같은 꿀벌의 자리는 못더하게 되어있음
 *
 * - 맨왼쪽에서 시작을 하되, 두번째 꿀벌은 왼쪽에서 가장 작은 애를 찾아야할거같음 거기를 부터 안된다.
 * - 아니면 누적합개념을 이용해서 뭔가 처리를 할 수는 없을까?
 *
 * [풀이]
 *  꿀통 기준으로
 *  1. 왼쪽에서 두마리 출발할때  => 왼쪽 고정에 두번째 마리의 위치 (근데 결국엔 얘는 꿀통 위치가 중요하지 않구나 맨 오른쪽에 있어야 최대 값이 나오니까)
 *  2. 오른쪽에서 두마리 출발할때 => 왼쪽에 꿀통 고정 두번째 마리 위치 찾기
 *  3. 양쪽에서 한마리씩 출발할때 => 이건 그냥 젤 끝에서 오는게 가장 클듯
 *
 * */
public class Main21758 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine()); //장소 수
        int[] prefix = new int[N + 1];
        int[] honey = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        //누적합 배열 만들기
        for(int i = 1 ; i <= N ; i++){
            honey[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + honey[i];
        }
        int maxAnswer =  -1;

        //[1] 오른쪽 꿀통 고정 , 맨 왼쪽 벌 한마리 고정, 두번 째 벌 위치 선정
        for(int i = 2 ; i <= N ;i++){
            //오른쪽 벌 위치 찾기
            int beeFirst = prefix[N] - honey[1] - honey[i];
            int beeSecond = prefix[N] - prefix[i];

           maxAnswer = Math.max(maxAnswer, beeFirst + beeSecond);
        }


        //[2] 왼쪽 꿀통 고정,맨 오른쪽 벌 한마리 고정, 두번째 벌 위치 선정
        for(int i = 2;  i < N  ;i++){

            int beeFirst = prefix[N] -  honey[N] -  honey[i];
            int beeSecond = prefix[i] - honey[i] ;

            maxAnswer = Math.max(maxAnswer, beeFirst + beeSecond);

        }

        //[3] 왼쪽 오른쪽에 꿀벌 고정, 꿀통 위치 찾기
        for(int i = 2; i < N ; i++){

            int left = prefix[i] - honey[1];
            int right =  prefix[N] - prefix[i - 1] - honey[N];

            maxAnswer = Math.max(maxAnswer, left + right);
        }

        System.out.println(maxAnswer);

    }
}
