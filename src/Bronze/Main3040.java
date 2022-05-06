package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3040 {

    static int []nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 9;
        int finish =7;
        nums = new int[n];
        int [] answer = new int[finish];

        //모자 수치 저장
        for(int i = 0 ; i < n; i++ ){
            nums[i] = Integer.parseInt(br.readLine());
        }


        //7명 찾기

        findDwarf(0,0,answer);
        System.out.print(sb);



    }
    private static void findDwarf(int depth,int start,int []answer){
        //7명일때 100인지 판별
        if(depth == 7) {
            int sum = 0 ;
            for(int i = 0 ; i < answer.length;i++){
                //총합 구하기
                sum+=answer[i];
            }

            if(sum==100){ //100이면 7명의 난쟁이 모자 수 출력

                for(int i = 0 ; i <answer.length;i++){
                    sb.append(answer[i]).append("\n");
                }
                return;
            }
            return;
        }


        for(int i = start ; i<nums.length;i++){
            answer[depth]=nums[i];
            findDwarf(depth+1,i+1,answer);
        }

    }
}
