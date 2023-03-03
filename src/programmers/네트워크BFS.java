package programmers;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

public class 네트워크BFS {

    static ArrayList <Integer> graph[];

    public int solution(int n, int[][] computers) {
        int answer = 0;


        graph = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        //인접 리스트 만들기
        for(int r = 0 ; r < n; r++){
            for(int c = 0 ; c < n; c++){

                if(computers[r][c]==1){
                    graph[r].add(c);
                    graph[c].add(r);

                }

            }
        }

        boolean [] isVisited = new boolean[n];
        for(int i =  0; i < n; i++){
            if(!isVisited[i]) {
                bfs(i,isVisited);
                answer++;
            }
        }


        return answer;
    }

    private static void bfs(int start, boolean[] isVisited) {

        Queue<Integer> queue = new ArrayDeque<>();
        isVisited[start] =true; //처음 들어온 노드는 방문처리한다.
        queue.add(start);

        while(!queue.isEmpty()){

            int curNode = queue.poll();


            //꺼낸 노드에서 너비 우선탐색으로 가능 한 노드들을 큐에 넣는다.
            for(int i =  0; i < graph[curNode].size();i++){

                int nextNode = graph[curNode].get(i);
                //방문된 노드는 탐색하지 않는다.
                if(isVisited[nextNode])continue;

                queue.add(nextNode);
                isVisited[nextNode]=true;

            }
        }


    }
}
