package programmers;

import java.util.*;

public class 체육복 {

        public int solution(int n, int[] lost, int[] reserve) {
            int answer =0;
            int count = 0; //빌린 학생 수

            Arrays.sort(lost);
            Arrays.sort(reserve);


            for(int i=0; i<lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    //도난 당한 학생과 여벌이 있는 학생이 같다면 빌린거처럼 처리 count+1
                    if(lost[i]==reserve[j]){
                        //-1로 초기화 하여 여분을 가진 학생이 다시 못 빌려주게끔 만듬
                        lost[i] = reserve[j] = -1;
                        count++;
                        break;
                    }
                }
            }


            for(int k : lost){
                for(int j=0; j<reserve.length; j++){
                    if(k == reserve[j]-1 || k == reserve[j]+1){
                        reserve[j] = -1;
                        count++;
                        break;
                    }
                }
            }


            answer = n - lost.length + count;
            return answer;
        }
    }

