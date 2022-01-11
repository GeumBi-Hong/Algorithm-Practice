import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main10845 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb =  new StringBuilder();
        Deque<Integer> q = new LinkedList<>();

        while (N --> 0){

            String[] str = br.readLine().split(" ");

            switch (str[0]){
                case "push":{
                    q.offer(Integer.parseInt(str[1]));
                    break;
                }
                case "pop":{
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(q.poll()).append("\n");
                    }
                    break;
                }
                case "size":{
                    sb.append(q.size()).append("\n");
                    break;
                }
                case "empty":{
                    if(q.isEmpty()){
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;

                }
                case "front": {
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;
                }
                case "back" : {
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;

                }
            }
        }

        System.out.print(sb);
    }
}
