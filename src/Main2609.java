import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2609 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());


        int max = Math.max(n1,n2);//두 수중에 최대값
        int min = Math.min(n1,n2);//두 수중에 최소값


        //두 수가 같을경우 (최대공약수와 최소공배수는 그 수이다)
        if(n1==n2 && min!=1){
            System.out.println(n1);
            System.out.println(n1);
        }else if(n1 ==1 || n2 ==1){ //두 수 중에 하나가 1일 경우 (최대공약수는 1이고 최소공배수는 1이 아닌 수이다.)
            System.out.println(1);
            System.out.println(max);

        }else { //그렇지 않을 경우
            solution(max,min);

        }

    }

    //n1>n2
    public static void solution (int n1 ,int n2){

        int max=1 ; //최대 공약수
        int min=1;  //최소 공배수

     for ( int i = n2;i>=1;i--){ //나눠지는 수는 n2 보다 클수가 없다.
         if(n1%i==0 && n2%i==0 ){ //두 수를 나누는 수가 존재할 경우
             n1=n1/i;
             n2=n2/i;

             max=max*i;
             min=min*i;


         }
     }

     min=min*n1*n2;

     System.out.println(max);
     System.out.println(min);
    }
}
