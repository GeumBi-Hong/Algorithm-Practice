package programmers;

public class 카펫 {

        public int[] solution(int brown, int yellow) {


            int[] answer = new int[2];

            int total_block = brown+yellow;


            //i = 가로 길이
            for(int i = 1; i<=total_block;i++){
                //나누어 떨어지는 경우와 가로와 세로의 길이가 같거나 세로보다 긴경우만 구하기
                if(total_block%i ==0 && i >= total_block/i){

                    int width = i;
                    int height =total_block/i;

                    int edge = (width*2) + (height *2) -4;
                    if( edge ==brown )  {
                        answer[0]=width;
                        answer[1]=height;
                        break;
                    }

                }
            }

            return answer;
        }
    }

