import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

5 21
5 6 7 8 9

n: 카드 개수
m: 근접해야하는 수
 */
public class Main2798 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0 ;

        int [] cards= new int[n];

        st=new StringTokenizer(br.readLine()," ");

        //카드 배열에 값 추가
        for (int i = 0; i<n;i++){
            cards[i]=Integer.parseInt(st.nextToken());
        }

        answer= blackJack(cards,n,m);
        System.out.print(answer);

    }

    static int blackJack (int[] card , int n, int m){

        int result =0;



        for (int i = 0 ; i< n-2; i++){

            if(card[i]>m){
                continue;
            }

            for(int j=i+1; j<n-1;j++){

                if(card[i]+card[j]>m){
                    continue;
                }

                for ( int k=j+1;k<n;k++){

                    int total = card[i]+card[j]+card[k];


                    if(total==m){
                       return  total;

                    }

                    if(total <= m && result<total){
                        result=total;
                    }

                }

            }


        }


            return result;
    }
}
