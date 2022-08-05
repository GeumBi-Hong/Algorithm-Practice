package Sliver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 누적 합을 이용하여 풀이함.
 * @author 홍금비
 * -슬라이딩 윈도우 기법으로도 풀어볼것
 */
public class Main12891 {

    static final int A =0;
    static final int C =1;
    static final int G =2;
    static final int T =3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        /** 비밀번호 조건 **/
        int [] answer = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <4; i++){
            answer[i]= Integer.parseInt(st.nextToken());
        }

        int [][] sum = new int[S+1][4];
        for(int i = 1 ; i <=S ;i++){
            char c = str.charAt(i-1);


            switch (c){
                case 'A':
                    sum[i][A]=sum[i-1][A]+1;
                    sum[i][C]=sum[i-1][C];
                    sum[i][T]=sum[i-1][T];
                    sum[i][G]=sum[i-1][G];
                    break;
                case 'C':
                    sum[i][C]=sum[i-1][C]+1;
                    sum[i][A]=sum[i-1][A];
                    sum[i][T]=sum[i-1][T];
                    sum[i][G]=sum[i-1][G];
                    break;
                case 'G':
                    sum[i][G]=sum[i-1][G]+1;
                    sum[i][C]=sum[i-1][C];
                    sum[i][A]=sum[i-1][A];
                    sum[i][T]=sum[i-1][T];
                    break;
                case 'T':
                    sum[i][T]=sum[i-1][T]+1;
                    sum[i][C]=sum[i-1][C];
                    sum[i][A]=sum[i-1][A];
                    sum[i][G]=sum[i-1][G];
                    break;
            }
        }


/*
        for(int i =1; i<=S;i++){
            for(int k = 0 ;k <4;k++){
                System.out.print(sum[i][k]+" ");
            }
            System.out.println();
        }
*/
        int count = 0;
        for(int i =0; i<=S-P;i++){

            if(sum[i+P][A]-sum[i][A]>=answer[A]
                    &&sum[i+P][C]-sum[i][C]>=answer[C]
                    &&sum[i+P][T]-sum[i][T]>=answer[T]
                    &&sum[i+P][G]-sum[i][G]>=answer[G]){
                count++;
            }
        }
        System.out.println(count);

    }
}
