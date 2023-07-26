package programmers;

import java.util.Stack;
public class 큰수만들기 {
//처음에 문제를 잘못이해함... number에서 k개의 수를 제거하고 남은 수를 가지고 수를 만들어서 가장 최대의 수를 만들라는 줄 알았음
//문제가 그냥 제거하고나서 만들어지는 수의 최대 크기를 알으라는의미.. 그러니 순서를 바꾸면 안됨

    /**
     [풀이과정]
     일단 number의 길이가 최대 100만이기때문에 완탐으로 모든 경우의 수를 구하는건 안됨
     그럼 어떻게 최적화를 좀 해볼 수 있을까 ?
     맨앞에 큰 수가 오면 좋을텐데..

     [1] 가장 크게 시작할 수 있는 인덱스 번호를 알아낸다.
     -> 대신  만들 수 있는 문자의 길이가 되는 곳 부터 시작해야한다.

     [2] 그 인덱스 번호로 부터 시작해서 하나씩 문자를 더할껀데 만약 현재문자가 이전 문자보다 크면 k가 남아있다면 그 문자를 지우고 자기 자신이 들어간다.
     -> 이를 스택에 저장을 한다.
     -> 가장 이전의 값(peek) 과 계속 비교해서 이전의 값들보다 자기가 크면 앞에 수들을 지우고 자신이 들어가야한다. 이때 주의할건  k의 수를 갱신해주어야한다.(문자를 제거해줬으니까)
     **/
    class Solution {
        public String solution(String number, int k) {

            int numberSize = number.length();

            //number 문자열을 int[] 배열로 만들기 위함
            int[]numberArray = new int[numberSize];

            for(int i = 0; i < numberSize; i++){
                numberArray[i] = number.charAt(i) - '0';
            }

            //가장 크게 만들 수 있는 첫 시작 인덱스
            int maxStartIndex = -1;
            //최대값을 비교하기 위한 변수
            int max = -1;

            //[1] 크게 시작할 수 있는 문자 시작 위치 구한다.
            for(int i = k; i >= 0 ; i--){

                if(max <= numberArray[i]) {
                    maxStartIndex = i;
                    max = numberArray[i];
                }
            }

            //남은 삭제할 수 있는 수 개수
            int deleteCount = k -maxStartIndex;
            //스택을 이용하여 수를 저장
            Stack<Integer> stack = new Stack<>();
            stack.push(numberArray[maxStartIndex]);

            for(int i = maxStartIndex + 1; i < numberSize; i++){
                //모든 문자를 전부 제거 했을시 제거할 문자가 없으므로 스택에 더한다.
                if(deleteCount == 0) {
                    stack.push(numberArray[i]);
                    continue;
                }

                //이전 문자보다 큰 경우면 앞의 숫자를 제거하고 push한다.
                while(!stack.isEmpty() && stack.peek() < numberArray[i]){
                    stack.pop();
                    deleteCount--;
                    if(deleteCount == 0) break;
                }

                stack.push(numberArray[i]);
            }

            //만들어야하는 문자길이 만큼 수를 붙인다.
            int time = numberSize - k;
            int stackSize = stack.size();

            //만약 내가 만들어야할 문자열 개수보다 stack의 개수가 크다면 그 개수 만큼 pop을 해주어야한다.
            while(stackSize > time){
                stack.pop();
                stackSize --;
            }

            StringBuilder answer = new StringBuilder();
            while(time --> 0){
                answer.insert(0,stack.pop());
            }

            return answer.toString();
        }

    }
}
