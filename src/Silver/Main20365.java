package Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 블로그 2
 *
 * [문제 조건]
 *
 * 문제 수는 최대 50만개
 *
 * [풀이 과정]
 *
 * 어떻게 하면 최소 과정으로 문제에 색을 칠할수 있을까?
 * 1. 일단 한번씩 칠하는거보단 연속되게 칠하는 것이 좋을꺼임 가장 최악의 케이스는 엇갈리게 계속 칠해져 있는 경우
 * 2. 그러면 일단 파랑과 빨강 문제중에 뭐가 더 많은지 고름 (먼저 같은 색으로 쭉 칠하고)
 * 3. 가장 많은 책으로 먼저 칠하고(파랑이라고 하면) , 빨간색을 다시 칠한다. 칠해야하는 구간만큼 . 이때 연속으로 오는빨강은 1번으로 쳐서 계산
 *
 *
 * [첫 풀이가 틀린이유]
 * 1. 처음에는 전체에서 빨간색 개수 or 파란색 개수 기준으로 더 많은 쪽으로 전체를 칠하려 했음 근데 이렇게 하면 반례가 있음
 *
 * 예를 들어 ) 빨간색이 더 많고 파란색이 작았다. 그럼 빨간색으로 다 칠하고 파란색으로 그 다음 칠하는게 최소 경우이어야하는데 아닌경우
 *
 * BRRRBRBRB
 *
 * 파 빨빨빨 파 빨 파 빨 파  => 빨간색이 많고 파란색이 적으니 빨강으로 모두 칠하기 (1) + 파란구역 칠하기 4 = 5
 * 근데 최소경우는 사실 4임 파랑을 먼저 칠하고 빨강을 칠하면 4다
 *
 * 그러니 연속해서 같은 색이 있는 그룹으로 지어서 그 그룹이 많은 색으로 다 칠해야 그 색을 개당으로 색을 칠하지 않으니 더 최소 경우가 된다.
 */
public class Main20365 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //문제 수
        char[] colors = br.readLine().toCharArray();

        //처음에 더해주지 않으면 첫번쨰 문자의 경우의 수를 뺴먹기 떄문
        int blueArea = colors[0] == 'B' ? 1 : 0;
        int redArea = colors[0] == 'R' ? 1 : 0;


        //파란색 구역 , 빨간색 구역의 개수를 세어준다.
        for (int i = 1; i < N; i++) {
            //붙어있는 색깔이 같은 경우는 같은 구역이므로 넘어간다.
            if (colors[i - 1] == colors[i])
                continue;
            //파란색 구역의 경우
            if (colors[i] == 'B')
                blueArea++;
            //그렇지 않고 다른 색이면 빨강
            else
                redArea++;
        }
        System.out.println(Math.min(blueArea,redArea) + 1);
    }
}


/*
 String[] s = problemsColor.split("R");

        for (String s1 : s) {
            System.out.println(s1);
        }
        int blueArea = problemsColor.split("R").length;
        System.out.println(blueArea);
        int redArea = problemsColor.split("B").length;

        System.out.println(redArea);

        System.out.println(Math.min(blueArea,redArea) + 1);
 */


/*
 //이런방법이..!! 참고 https://today-retrospect.tistory.com/95

        int  blueArea = new StringTokenizer(problemsColor,"R").countTokens();
        int  redArea = new StringTokenizer(problemsColor,"B").countTokens();
 */