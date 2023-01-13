package programmers;
import java.util.*;
public class 기능개발 {
        static class Info{

            int progress;
            int speed;

            public Info(int progress ,int speed){
                this.progress =progress;
                this.speed = speed;
            }
        }
        public List<Integer> solution(int[] progresses, int[] speeds) {

            List<Integer> answer = new ArrayList<>();
            Queue<Info> queue = new LinkedList<>();

            for(int i = 0 ; i < progresses.length;i++){
                queue.add(new Info(progresses[i],speeds[i]));
            }

            //큐가 비어 있을 때 까지 반복
            while(!queue.isEmpty()){

                Info now = queue.poll();

                int count = 1;

                int diff = 100-now.progress;


                int date = diff/now.speed;
                if(diff%now.speed!=0)date++;


                if(diff==0)continue;


                while(!queue.isEmpty()){
                    Info next = queue.peek();

                    if(next.progress+(next.speed*date)>=100){
                        queue.poll();
                        count++;
                    }else{break;}

                }

                answer.add(count);

            }
            return answer;
        }
    }


