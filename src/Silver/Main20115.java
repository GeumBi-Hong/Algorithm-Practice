package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 에너지 드링크
 *
 * [풀이]
 *
 *  1. 크기 순으로 정렬을 하고
 *  2. 가장 큰 순을 기준으로 가장 큰수와 그 다음 큰수가 있다면 그 다음 큰수/2 + 가장 큰수로 음료수를 합쳐야 최대 용량
 *
 *  [다른 풀이]
 *  더 빠르게 푸는 방법이 있다
 *
 *  그냥 결국엔 가장 큰 수는 살리고 그 나머지들을 반 나눠 붓는거랑 같아서 굳이 큐에 넣고 빼고 해가면서 할필요 없을듯
 */
public class Main20115 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //내림차순 정렬
        PriorityQueue<Double> queue = new PriorityQueue<>(((o1, o2) -> Double.compare(o2
        ,o1)));

        for(int i = 0 ; i < N; i++){
            queue.add(Double.parseDouble(st.nextToken()));
        }

        while (!queue.isEmpty()){

            //가장 큰수
            Double drinkA = queue.poll();

            if(queue.isEmpty()) {
                queue.add(drinkA);
                break;
            }
            //그 다음 큰수
            Double drinkB = queue.poll();

            //가장 큰수 + 그 다음 큰수 / 2 로 연속해서 합쳐야 가장 큰 경우가 나온다.
            queue.add(drinkB / 2 + drinkA);

        }
        System.out.println(queue.poll());
    }
}


//더 빠른 풀이

/**
 *
 public class Main {
 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 static StringTokenizer st;
 static StringBuilder sb = new StringBuilder();
 public static void main(String[] args) throws NumberFormatException, IOException {
 int N = Integer.parseInt(br.readLine());
 int[] list = new int[N];
 st = new StringTokenizer(br.readLine());
 int max = 0;
 for(int i = 0; i < N; i++) {
 list[i] = Integer.parseInt(st.nextToken());
 max = list[i] > max ? list[i] : max;
 }
 double res = max;
 for(int i = 0; i < N; i++) {
 if(list[i] != max) res+=list[i]/2.0;
 }
 System.out.println(res);
 }
 }
 */