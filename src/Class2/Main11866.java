package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11866 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> list = new ArrayList<>();


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int index = 0;


        for (int i = 0 ; i < N ; i++){
          linkedList.add(i+1);
        }

      while ( N > 1) {
          index = (index + (K -1)) % N;
          list.add(linkedList.remove(index));
          N--;
      }
        list.add(linkedList.remove());


        String str =list.toString();
        str =str.replace("[","<");
        str =str.replace("]",">");
        System.out.print(str);


    }
}
