import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
5
abcde

한트: zzz의 해시 값은 26 × 310 + 26 × 311 + 26 × 312 = 26 + 806 + 24986 = 25818이다.
 */
public class Main15829 {

    static final int num = 31;
    static final int mod = 1234567891;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer =0;
        long pow = 1;
        char [] alpa = br.readLine().toCharArray();




        for(int i =0 ; i<n;i++){
            answer += (alpa[i] - 'a' + 1) * (pow % mod) ;
            pow *= n;
        }

            System.out.print(answer%mod);

    }
}
