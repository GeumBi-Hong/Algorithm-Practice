import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start =666;
        int count =0;

        while(true){

            if( Integer.toString(start).contains("666")){
                count ++;
                if(n==count){
                    System.out.print(start);
                    break;
                }

            }

         start++;

        }

    }
}
