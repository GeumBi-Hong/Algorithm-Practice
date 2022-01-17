package Class2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int max=0;

        int [] count =  new int[8001]; // [0] = -4000  [4000] = 0 [8000] =4000
        double sum = 0;

        for (int i = 0; i <N ; i ++){
            int v = Integer.parseInt(br.readLine());
            num[i]=v;
            count[v+4000] ++; //수가 몇번 나왔는지 세어준다.

            if(count[v+4000]>max){
                max=count[v+4000];
            }

            sum += num[i];
        }

        Arrays.sort(num);

        int c =0;
        int index =-1;
        for(int i = 0 ;i <count.length;i++){
            if(count[i]==max){
                index=i;
                c++;
            }

            if( c ==2){ //여러개 최빈값중 두번쨰로 작은 값을 만나면 index 값을 저장하고 빠져나간다.
                index=i;
                break;
            }

        }


        sb.append(String.format("%.0f",sum/N)).append("\n"); //산술평균 (소수 첫재짜리 반올림)
        sb.append(num[N/2]).append("\n"); //중앙값
        sb.append(index-4000).append("\n"); //최빈값
        sb.append(num[num.length - 1] - num[0]); // 범위

        System.out.print(sb);


    }
}

