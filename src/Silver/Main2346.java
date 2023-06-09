package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


/**
 * 풍선 터뜨리기
 *
 * [첫 풀이]
 * 큐를 일단 써서
 *  풍선의 종이 값과 터진 유무를 가진 객체 형식으로 값을 저장해서 값만큼 계속 큐에서 꺼내고 넣는 방식으로 진행
 *  큐를 떠올리게 된 이유: 풍선을 터트리지 않았을때 다시 그 풍선순서대로 조회를
 *
 *  종이에는 -N <=  풍신 <=  N
 *
 *
 *  이미 터진 풍선은 빼고 이동한다.
 *
 *  큐가 아니라 덱은 사용해서 맨 앞 맨 뒤를 이용
 *
 *  [두번째 ]
 *  음수로 이동하는 경우를 생각 못했음
 *
 *  그래서 덱을 사용해서 왼쪽 오른쪽으로 이동하는 경우를 생각해줘야됨
 *
 *  음수일경우는 끝의 요소를 앞으로 배치, 양수일 경우는 맨 앞의 요소를 맨 뒤로 배치하여 순환할 수 있도록 함
 *
 *  여기서 최적화를 더한다면 얘를들어
 *
 *  종이의 값은 1000인데 남아있는 요소가 3개이다 이때 3개를 1000번 움직일 필요는 없을것이다.
 *  이를 큐사이즈를 이용해서 딱 핵심적으로 이동할 횟수를 구해 이동시킨다면 효율적으로 필요한 이동만 할 수 있을 것이다.
 *  이는 특히 N 의 사이즈가 커질 수록 더욱 그러지 않을까.
 */
public class Main2346 {

    static class Balloon{
        private int index;
        private int move;

        public Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }
    }


    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> queue = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            queue.add(new Balloon(i+1,Integer.parseInt(st.nextToken())));
        }

        //큐가 비어있지 않을 떄까지 계속 반복한다.
        while (!queue.isEmpty()){

            Balloon balloon = queue.poll();
            sb.append(balloon.index+" ");

            if(queue.size() == 0) break;

            if( balloon.move < 0){
                // 음수면 왼쪽으로 이동
                int move = balloon.move ;

                for(int i = 0 ; i < Math.abs(move); i++){
                    queue.addFirst(queue.removeLast());
                }
            }else{
                //양수면 오른쪽으로 이동
                int move = balloon.move - 1;
                for(int i = 0 ; i < move; i++){
                    queue.add(queue.poll());
                }
            }
        }
        System.out.println(sb);
    }
}
