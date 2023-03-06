package programmers;
import java.util.*;

/**
 * 2023 - 03 - 06 (월)
 * dfs로 풀이
 * 조금 삽질함 . 다시 풀필요가있음
 */
public class 여행경로 {

    //티켓을 사용했는지 여부를 체크하는 배열
    static  boolean []isVisited;
    static ArrayList<String> path = new ArrayList<>();

    static PriorityQueue<String> priorityQueue = new PriorityQueue<>();

    public String[] solution(String[][] tickets) {


        isVisited = new boolean[tickets.length]; //티켓의 개수 만큼 크기 생성

        dfs("ICN",0,tickets);

        return priorityQueue.poll().split(" ");

    }

    private static void dfs (String start , int depth ,String [][] tickets){

        //들어왔을때 경로를 저장한다.
        path.add(start);

        if(depth==tickets.length){ //모든 티켓을 다 사용한 경우라면 경로를 정답에 저장한다.
            //우선 순위 큐를 사용하여 맨 첫번째의 값은 가장 알파벳의 순서가 앞서는 경로가 나온다.
            priorityQueue.add(String.join(" ",path));
            return;
        }

        //티켓을 전부 조회한다.
        for(int i = 0 ; i < tickets.length;i++){
            //티켓이 사용되지 않았고 , 티켓의 출발지점이 start와 같은지 비교한다.
            if(!isVisited[i]&& tickets[i][0].equals(start)){
                isVisited[i] =true; // 티켓 사용체크
                dfs(tickets[i][1],depth+1,tickets);
                isVisited[i]=false; //방문해서 나왔으면 다시 사용체크를 취소한다.
                path.remove(path.size()-1); //이전 경로도 지운다.
            }
        }
    }
}
