package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int []lan = new int[K]; //가지고 있는 랜선 수 개

        long max = 0;

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine()); //길이 값들을 저장시키고
            if(max < lan[i]) {  //최대길이를 찾아준다.
                max = lan[i];
            }
        }

        max ++; //찾은 최대 길이 값에 +1을 해준다.


        long min = 0;
        long mid =0;

        while (min <max){

            mid = (min+max)/2 ; //중간 길이

            long count =0;// 잘라지는 lan개수
            for (int i = 0; i < lan.length; i++) {
                count += (lan[i] / mid);
            }


            if(count <N){ //잘라야하는 길이 개수보다 작을경우
                max =mid;
            }else { //그렇지 않을경우 mid에 1을 증가시켜 min 값을 바꾼다.
                min = mid+1;
            }
        }

            System.out.print (min -1);

    }
}
