package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2635 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) ; //첫 번째 양의 정수

        int answer = 0; //최대로 만들 수 있는 개수

        int answerIndex = -1; // 최대로 만들 수 있는 두번째 수
        for(int i = 1 ; i<=N;i++){ //첫번째 수에서 양의 정수를 택한다
            int firstNum= N; //첫번째 수
            int count =1; // 맨 처음 첫번째 수 에 대한 count =1
            int secondNum = i; //두번째 수

            while (firstNum-secondNum>=0){ //첫번째 수 - 두번째 수가 음수가 나오기전까지 수만들기
                    int dif= firstNum-secondNum; //차이
                    //첫번째 수와 두번째 수 갱신
                    firstNum=secondNum;
                    secondNum=dif;
                    count++; //수를 만들었으니 +1
            }
            count++; //마지막 수에 대한 +1

           if(answer<count){ //최대로 만들수있는 개수를 찾았다면
               answer=count;
             answerIndex=i; //그 두번째 수를 저장한다.
           }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n"); //개수
        sb.append(N+" "); //첫번째 수
        sb.append(answerIndex+" "); //두번 째 수


        //만들 수 있는 수 차례로 출력
        int firstNum= N;
        int secondNum = answerIndex;

        while (firstNum-secondNum>=0){
            int dif= firstNum-secondNum;
            firstNum=secondNum;
            secondNum=dif;
            sb.append(secondNum+" ");
        }

        System.out.print(sb);
    }
}
