package programmers;

public class 입국심사 {

    static final int MAX= 1_000_000_000;
    public long solution(int n, int[] times) {



        long answer = 0;

        long left = 1;
        long right = (long)MAX *MAX; //연산하는과정에서 int * int= overflow가 발생할 수 있음에 유의

        while (left <= right){
            long mid = (left+right)/2;


            //mid 분 만에 가능하다면 범위를 줄인다.
            if(isPossible(mid,n,times)) {
                answer = mid;
                right = mid-1;
            }else{

                left = mid+1;
            }
        }


        return answer;
    }
    private  static boolean isPossible (long time, long people, int[]times){
        //people 도  int overflow 가 될 수 있음에 유의
        for (int min : times){
            people -= time/min;

            if(people <= 0)return true;

        }

        return false;

    }
}
