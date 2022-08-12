package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//요세푸스
public class Main1158 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list  = new LinkedList<>();

        for (int i = 1 ; i <=N; i++){
            list.add(i);
        }
        int index=0;
        sb.append('<');
        while (N>1){
            index = (index + (K-1)) % N;
            sb.append(list.remove(index)).append(",");

            N--;

        }

        sb.append(list.remove()).append('>');
       System.out.print(sb);
    }
}
