package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//학생번호
public class Main1235 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        String str[] = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }


        //이분탐색을 이용해서 k를 구해봅시다.

        //1먼저 이분 탐색의 범위를 구해봅시다

        int left = 0; //최소 1자리는 되야하고
        int right = str[0].length()-1; //문자열의 길이 만큼이 최대
        int length = str[0].length();

        int answer = -1;
        while (left <= right) {

            int mid = (left + right) / 2;


            if (canDiff(mid,length,str)) {
                //서로 고유 번호라면

                left = mid + 1;
                answer = mid;
            }else {

                right= mid -1;
            }
        }

        System.out.println(length-answer);

    }

    private static boolean canDiff (int k , int l,String []number) {

        //핵심로직

        //substring정리좀 하자.
        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i < number.length;i++){
            map.put(number[i].substring(k),0);
        }

        if(map.size()==number.length)return true;
        else return false;



    }
    }