package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//9012번 괄호
public class Main9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N--> 0){

            int count = 0;

            for(Byte b : br.readLine().getBytes()){
                if (b=='('){
                     count++;
                }
                else {
                     count --;
                }
                if(count < 0){
                    break;
                }
            }
            if(count==0){
                sb.append("YES").append("\n");

            }else {
                sb.append("NO").append("\n");
            }

        }

        System.out.print(sb);

    }
}
