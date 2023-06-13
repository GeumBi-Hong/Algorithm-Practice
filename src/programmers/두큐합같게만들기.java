package programmers;

import java.util.*;

//입력이 다음과 같을 때 A = [3, 3, 3, 3], B = [3, 3, 21, 3] 일 경우 두 큐의 합이 같게 되려면 9번 걸리게 되는데 위 코드에서는 두 큐의 길이의 합인 8이상이 되면 -1을 리턴합니다
public class 두큐합같게만들기 {

    class Solution {
        public int solution(int[] q1, int[] q2) {


            Queue<Integer> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();


            int answer = 0;
            long total = 0;
            long sumQueue1 = 0;
            long sumQueue2 = 0;

            for(int i = 0; i < q1.length; i++){
                total += q1[i] + q2[i];
                sumQueue1 += q1[i];
                sumQueue2 += q2[i];
                queue1.add(q1[i]);
                queue2.add(q2[i]);
            }

            if(total % 2 == 1) return -1;

            total = total / 2;

            while(true){

                // System.out.println("2");
                if(sumQueue1 > sumQueue2){
                    int n = queue1.peek();
                    sumQueue1 -= n;
                    sumQueue2 += n;
                    queue2.add(queue1.poll());

                }else if(sumQueue1 < sumQueue2){

                    int n = queue2.peek();
                    sumQueue2 -= n;
                    sumQueue1 += n;
                    queue1.add(queue2.poll());
                }else{

                    break;
                }


                if( answer > (q1.length *2)+1) return -1;

                answer++;
            }
            return answer;
        }
    }
}
