import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        List<String> listString = new ArrayList<>();
      
        
        HashMap <String ,String > nameMap = new HashMap<>();
        HashMap <String, String > msgMap = new HashMap<>();
        
        msgMap.put("Enter","님이 들어왔습니다.");
        msgMap.put("Leave","님이 나갔습니다.");
  
        
        //1. 최종 반영되는 닉네임을 구한다.
        for(String str : record){
            String split[] = str.split(" ");
            //첫단어가 Enter 이거나 Change의 경우 해당 유저의 닉네임을 변경한다.
            if(split[0].equals("Enter") || split[0].equals("Change")){
                nameMap.put(split[1],split[2]);
            }
            
        }
        
        //2.최종 출력문을 구한다.
        for(String str : record){
              String split[] = str.split(" ");
              if(!split[0].equals("Change")){
             listString.add(nameMap.get(split[1])+msgMap.get(split[0]));
               
              } 
        }
        
        
        
       return  listString.toArray(new String[0]);
    }
}
