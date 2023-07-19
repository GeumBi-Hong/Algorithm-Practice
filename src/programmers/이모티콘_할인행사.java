package programmers;

class 이모티콘_할인행사 {

    //서비스 가입자
    static int answerSub = 0;
    //총 판매 금액
    static int answerTotal = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        //i번째의 할인율을 저장할 배열
        int[] rate = new int[emoticons.length];
        decideDiscountRate(0, emoticons.length,rate,users,emoticons);

        return new int[]{answerSub , answerTotal};
    }

    //할인율을 정하고 그 할인율을 바탕으로 가입자 수와 판매금액을 구하는 메서드
    private static void decideDiscountRate (int startIndex , int endIndex ,int[] rate , int[][] users,int[] emoticons){

        //할인율을 전부다 정했다면
        if(startIndex == endIndex) {

            int sub = 0;
            int total = 0;

            for(int[] user : users){

                int userDisCount = user[0];
                int userPrice = user[1];

                int totalPrice = 0;

                for(int i = 0 ; i < emoticons.length; i++){
                    //할인율이 갖거나 클때만 구매
                    if(rate[i] >= userDisCount){
                        totalPrice += (1 - (double)rate[i]/100) * emoticons[i];
                    }
                }

                if(totalPrice >= userPrice) {
                    sub++;
                }
                else total += totalPrice;
            }
            //해당 할인율로 총 가입자 수와 판매수익을 구했다면 최대 우선순위 고려 경우로 최대값을 갱신한다.
            if(sub > answerSub) {
                answerSub = sub;
                answerTotal = total;
            }
            else if (sub == answerSub && answerTotal <= total){
                answerTotal = total;
            }
            return;
        }
        //할인율 10~40 10단위로 증가
        for (int i = 10; i <= 40; i+=10){
            rate[startIndex] = i;
            decideDiscountRate (startIndex +1, endIndex , rate ,  users, emoticons);
            rate[startIndex] = 0;
        }

    }
}