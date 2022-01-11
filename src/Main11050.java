import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11050 {

    static int intArray[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        intArray = new int[n+1][r+1];

        System.out.print(Combination(n,r));

    }

    static int Combination(int n , int r){


        if(intArray[n][r]>0){
            return intArray[n][r];
        }

        if (n==r || r==0){
            return intArray[n][r]=1;
        }

        return intArray[n][r]=Combination(n-1,r-1)+Combination(n-1,r);
    }
}
