package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//곱셈 (분할 정복)
public class Main1692 {

    static long C;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());


        System.out.print(pow(A,B));


    }

    public static long pow(Long A , Long B){

        if(B == 0){
            return 1;
        }

        long temp = pow(A,B/2);


        if(B %2 ==1){
            return (temp * temp % C) * A%C;
        }

        return temp * temp% C;
    }
}
