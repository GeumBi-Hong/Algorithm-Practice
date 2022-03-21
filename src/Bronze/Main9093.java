package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9093 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N -- > 0){ //n
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            while (st.hasMoreTokens()){
                StringBuffer sf = new StringBuffer(st.nextToken());
                sb.append(sf.reverse()).append(" ");

            }

            sb.append("\n");
        }
            System.out.print(sb);
    }
}
