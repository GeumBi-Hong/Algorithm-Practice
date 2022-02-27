package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//Ac
public class Main5430 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수

        while (T-->0){ //테스트 케이스 수 만큼 반복
            String p = br.readLine(); //실행할 함수
            int len = Integer.parseInt(br.readLine()) ; //배열 길이
            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();


            for(int i = 0 ; i<len;i++){ // Deque에 배열의 원소값을 넣어준다.
                arrayDeque.add(Integer.parseInt(st.nextToken()));
            }

            AC(p,arrayDeque);
        }
        System.out.print(sb);

    }

    public static void AC(String p ,ArrayDeque<Integer> arrayDeque){

        boolean isFlag = true; //  true = 정방향 ,  false = 역방향
        for(char c : p.toCharArray()) { //실행할 함수를 한 글자씩 실행한다.

            if (c == 'R') {
                isFlag = !isFlag; //방향 전환
                continue;
            }


            if (isFlag) { //반환된 요소가 없다면 종료시킨다.
                if (arrayDeque.pollFirst() == null) {
                    sb.append("error").append("\n");
                    return;
                }

            } else {
                if (arrayDeque.pollLast() == null) {
                    sb.append("error").append("\n");
                    return;
                }
            }
        }
            //모든과정을 마치면 가지고있는 원소들로 배열문자열을 만들어 준다.
        printArray(isFlag,arrayDeque);


    }
    public static void printArray(boolean isFlag,ArrayDeque<Integer>arrayDeque) {

        sb.append("[");
        if(arrayDeque.size()>0){ // arrayDeque 의 원소가 1이상일때 ("[]")경우도 있기 때문


            if(isFlag){ //정방향

                sb.append(arrayDeque.pollFirst());

                while (!arrayDeque.isEmpty()){
                    sb.append(",").append(arrayDeque.pollFirst());
                }
            }else {//역방향
                sb.append(arrayDeque.pollLast());

                while (!arrayDeque.isEmpty()){
                    sb.append(",").append(arrayDeque.pollLast());
                }
            }

        }

        sb.append("]").append("\n");

    }
}
