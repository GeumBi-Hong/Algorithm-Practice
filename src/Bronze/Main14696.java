package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 딱지 놀이 (13 분)
 * 걍 구현임
 */
public class Main14696 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb =new StringBuilder();
        int N = Integer.parseInt(br.readLine()) ; //총 라운드 수


        //라운드 수 만큼 반복
        while (N-->0){
                //별 4 동그라미 3 네모2 세모 1
            //A 카드 정보 저장
            st = new StringTokenizer(br.readLine());
            int countA = Integer.parseInt(st.nextToken());
            int [] personA = new int[5];
            //모형 개수 저장
            for(int i = 0 ; i<countA;i++){
                personA[Integer.parseInt(st.nextToken())] ++;
            }

            //B 카드 정보 저장
            st = new StringTokenizer(br.readLine());
            int countB = Integer.parseInt(st.nextToken());
            int [] personB = new int[5];

            // 모형 개수 저장
            for(int i = 0 ; i <countB ;i++){
                personB[Integer.parseInt(st.nextToken())]++;
            }

            //별의 개수부터 탐색
            char answer = '0';
            for(int i = 4; i>=1;i--){

                if(personA[i]==personB[i]){ //해당하는 모형 개수가 같다면
                    continue;
                }else if(personA[i]>personB[i]){//A가 승리라면
                    answer ='A';
                    break;
                }else { //B 가 승리라면
                    answer = 'B';
                    break;
                }
            }

            if(answer=='0'){ //무승부라면
                answer='D';
            }

            sb.append(answer).append("\n");

        }
        System.out.println(sb);

    }
}
