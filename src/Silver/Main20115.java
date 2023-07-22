package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 에너지 드링크
 */
public class Main20115 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] nums = new double[N];

        for(int i = 0 ; i < N ;i++){
            nums[i] = Double.parseDouble(st.nextToken());
        }


        for(int i = 0 ; i < N - 1 ;i++){

            //첫번째 경우
            if ( nums[i] / 2 + nums[i] > nums[i] + nums[i + 1] /2){
                nums[i + 1] = nums[i] / 2 + nums[i];
            }else{
                nums[i + 1] = nums[i] + nums[i + 1] /2;
            }

            //두번째 경우


        }

        System.out.println(nums[N-1]);

    }
}
