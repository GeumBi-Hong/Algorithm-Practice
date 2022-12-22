package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1439 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s = br.readLine();


        //0의 구간 , 1의 구간의 개수를 세어준다.
        //두 값중 작은 값이 다솜이가 하는 최소 횟수 ,  값이 같으면 둘 중 하나의 값으로 출력



        //[0] = 0의 구간 개수
        //[1] = 1의 구간 개수
        int [] count = new int[2];
        //첫번째 문자가 기준문자 ,
        char c = s.charAt(0); //기준문자
        //첫번째 문자의 구간이 있으니 해당문자의 구간 개수  +1
        count[c-'0']++;

        for(int i = 0 ; i <s.length();i++){
            //기준 문자랑 다르다면 다른 숫자의 구간으로 시작됨을 의미
            if(c!=s.charAt(i)){
                //해당 문자로 구간 개수를 +1
                count[s.charAt(i)-'0']++;
                //기준 문자를 변경
                c= s.charAt(i);
            }
        }



        System.out.println(count[0]>count[1]? count[1]:count[0]);



    }
}
