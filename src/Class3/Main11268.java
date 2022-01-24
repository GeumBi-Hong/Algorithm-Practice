package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main11268 {
    public static void main(String[] args) throws IOException {

        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)){ //절대값이 같을때
                    return o1 - o2; //더 작은 수를 리턴한다.
                }else {
                    return Math.abs(o1)- Math.abs(o2); //절대값이 같지않으면 절대값이 더 작은 수를 리턴한다.
                }
            }
        });


        while (N -- > 0 ){
            int num = Integer.parseInt(br.readLine());

            if (num !=0){
                queue.add(num);
            }else{

               if(queue.isEmpty()){
                   sb.append("0\n");
               }else {
                   sb.append(queue.poll()).append("\n");
               }

            }


        }

        System.out.print(sb);

    }
}
