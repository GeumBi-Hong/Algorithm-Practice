package programmers;

import java.util.*;

class 모의고사 {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();


        int [] patternA = {1,2,3,4,5};
        int [] patternB = {2,1,2,3,2,4,2,5};
        int [] patternC = {3,3,1,1,2,2,4,4,5,5};

        int sizeA = patternA.length;
        int sizeB = patternB.length;
        int sizeC = patternC.length;

        int []score = new int [3];

        int max =0;
        for(int i = 0 ; i < answers.length;i++){


            if(patternA[i%sizeA]==answers[i]){
                score[0]++;
                max= Math.max(max,score[0]);
            }
            if(patternB[i%sizeB]==answers[i]){
                score[1]++;
                max= Math.max(max,score[1]);
            }
            if(patternC[i%sizeC]==answers[i]){
                score[2]++;

                max= Math.max(max,score[2]);
            }

        }

        for(int i = 0 ; i<3;i++){
            if(max==score[i]){
                answer.add(i+1);
            }
        }

        return answer;
    }
}