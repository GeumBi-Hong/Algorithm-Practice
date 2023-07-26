package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 민겸 수
 *
 * 민겸 숫자는 0 이상의 정수 N에 대해 10N 또는 5 × 10N 꼴의 십진수를 대문자 M과 K로 이루어진 문자열로 표기한다.
 * 10 ^ N => N + 1  ex ) 1000 = 10^3 => 3 + 1 => M
 * 5 x 10^N = 꼴의 십진수는 N개의 M 뒤에 1개의 K를 이어붙인 문자열
 *
 * [풀이 과정]
 *
 *  MKKMMK
 *
 * (1)최소로 만들 수 있는 경우는 어떤 경우?
 *
 *  =>1로 먼저 끊어치는 경우
 *   K를 만나면 K를 만나기 이전까지의 수로 붙여야함
 *
 * (2)최대로 만들 수 있는 경우는 어떤 경우?
 *
 *  => 5로 끊어치는 경우
 *  => 5로 끊어치려면 MMM을 쭉만나다가 K나오면 바로 그 수로 붙여야함
 *
 *[주의]
 * 글자 수가 최대 3천자 이다. 연산할때 값이 int값이 넘어가는지를 확인하자 3000자니까 long도 넘어가겠구나 ㅎ..
 *
 * 처음에 안된 반례 케이스
 * MMM 하면 100/100 이 나왔음 최대의 경우에 MMMM으로 K를 만나지 않으면 10^N 으로 처리하는게 아니라 하나씩 끊어서 해주는게 최대 케이스가됨
 */
public class Main21314 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int size = input.length();


        System.out.println(findMax(input,size));
        System.out.println(findMin(input,size));
    }
    //최대값을 반환하는 메서드
    private static String findMax(String input,int size){

        int mCount = 0;
        StringBuilder maxAnswer = new StringBuilder();

        for(int i = 0 ; i < size; i++){
            //k를 만나면 5 x 10^N 으로 계산
            if(input.charAt(i) == 'M') mCount++;
            else{
                plusNumber(true,maxAnswer,mCount,"0");
                mCount = 0;
            }
        }
        if(mCount > 0)  plusNumber(false,maxAnswer,mCount -1,"1");
        return maxAnswer.toString();
    }
    //최소값을 반환하는 메서드
    private static String findMin(String input,int size){

        int mCount = 0;
        StringBuilder minAnswer = new StringBuilder();

        for(int i = 0 ; i < size; i++){

            if(input.charAt(i) == 'M') mCount++;
            else{
                if(mCount != 0) {
                     plusNumber(false,minAnswer,mCount -1,"0");
                }
                minAnswer.append("5");

                mCount = 0;
            }
        }

        if(mCount > 0) {
             plusNumber(false,minAnswer,mCount -1,"0");
        }

        return minAnswer.toString();
    }

    private static void plusNumber(boolean isWithK ,StringBuilder original,int count,String s){

        if(isWithK) original.append("5");
        else original.append("1");

        while (count --> 0){
            original.append(s);
        }

    }
}
