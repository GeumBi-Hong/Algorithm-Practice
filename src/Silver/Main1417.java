package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 풀이시간 :26분
 * 128ms
 */
public class Main1417 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /**
         *  vote -> 각 번호 후보 (인덱스) 에 대한 득표 수를 저장한 1차원 배열
         *  maxVote -> 최대 득표
         *  maxIndex ->최대 득표를 가진 후보의 인덱스 번호
         * */
        int [] vote = new int[N+1];
        int maxVote = -1;
        int maxIndex = -1;

        for(int i = 1 ; i <=N ; i++){
            vote[i] = Integer.parseInt(br.readLine());
            /** 여기서 <= 를 해준 이유는 그냥 <만 하면
             * ex ) 9 (다솜)1 9 9 9라고 했을때
             * 뒤의 내 로직의 경우 다솜이가 최대 득표인지 그리고 최대 득표를 가진 인덱스 번호가 맞는지 판단하여 답을 구한다.
             * 그래서 <를 해주면 다솜이 보다 뒤에 같은 득표 수를 가진 후보가 있는데 다솜이가 최대득표,최대 득표인덱스로 되기때문에 =를해줘야한다.
             */
            if(maxVote<=vote[i]){
                /** 후보들 중 가장 득표를 많이 가진 후보의 득표값(maxVote)와 그 표를 가진 후보의 인덱스 번호를 저장**/
                maxVote=vote[i];
                maxIndex=i;
            }

        }
        /**몇개의 표를 매수 했는지 **/
        int count =0;

        while (true){

            if(maxVote==vote[1]&&maxIndex==1){
                System.out.println(count);
                break;
            }
            /**다솜이의 표는 +1
             * 최대 득표를 한 후보의 표는 -1
             * 매수를 했으니 count +1
             */
            vote[1]++;
            vote[maxIndex]--;
            count++;

            /** 그리고 나서 반드시 최대 득표를 초기화 해주고 다시 찾는다.*/
            maxVote = -1;
            for(int i = 1 ; i <=N ; i++){
                if(maxVote<=vote[i]){
                    maxVote=vote[i];
                    maxIndex=i;
                }

            }

        }//while

    }
}
