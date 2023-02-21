import java.util.*;

class Solution {
    public int solution(int[] topping) {
      
        int answer = 0;
        
        //케이크의 조각은 두 조각으로 나뉜다.
        
        //두 조각으로 나뉘었을때 왼쪽 조각과 오른쪽 조각의 토핑 개수를 구한다.
        //이 때 해쉬맵을 사용하여 중복처리를 해준다.
        HashMap <Integer ,Integer > leftMap = new HashMap<>(); //왼쪽
        HashMap <Integer ,Integer > rightMap = new HashMap<>(); //오른쪽 
        
        int [] leftCount = new int[topping.length];
        int [] rightCount = new int[topping.length];
        
        for(int i = 0 ; i < topping.length;i++){
           
        
            leftMap.put(topping[i],0);
            leftCount[i]= leftMap.size(); // 잘린 왼쪽 조각의 topping개수(중복 x)
            
             //오른쪽 탐색 인덱스 
            int rigthIndex = topping.length -1-i;
            rightMap.put(topping[rigthIndex],0); //// 잘린 오른쪽 조각의 topping개수(중복 x)
            
            rightCount[rigthIndex]= rightMap.size();
        }
        
    
        //같은 토핑의 개수인지 찾는다.
        for(int i = 0 ; i < topping.length-1;i++){
            if(leftCount[i]==rightCount[i+1]) answer++;
        }
        
        
        
        return answer;
    }
}
