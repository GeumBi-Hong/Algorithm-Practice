import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine()); //큐 선언
        Queue<Integer> queue = new LinkedList<>();

        //큐에 차례로 카드 수 넣기
        for(int i = 1 ; i<=N ; i++){
            queue.add(i);
        }

        while (queue.size()!=1){

            //첫장은 삭제
            queue.remove();

            //그 다음 맨 앞의 수를 맨 뒤로 넣는다.
            queue.offer(queue.poll());

        }

        System.out.println(queue.poll());

    }
}
