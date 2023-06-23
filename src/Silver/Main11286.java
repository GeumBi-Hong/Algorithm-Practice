package Silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main11286 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                //절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하라했으니
                if(Math.abs(o1) == Math.abs(o2)){
                    return Integer.compare(o1,o2);
                }
                //절대값이 가장 작은 애를 기준으로 정렬
                return Integer.compare(Math.abs(o1),Math.abs(o2));
            }
        });


        for(int i =  0 ; i <N;i++){
            int n = Integer.parseInt(br.readLine());
            //0이 아닌 정수라면 큐에 삽입
            if(n != 0){
                queue.add(n);
            }else {
                //큐에 제거할것이 없다면
                if(queue.isEmpty()){
                    sb.append(0).append("\n");
                }else {
                    sb.append(queue.remove()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
