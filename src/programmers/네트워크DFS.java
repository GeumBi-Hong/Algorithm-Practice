package programmers;

import java.util.ArrayList;

public class 네트워크DFS {
    static ArrayList <Integer> map [] ;
    public int solution(int n, int[][] computers) {
        int answer = 0;

        //깊이 우선 탐색(DFS) 를 진행하면서 노드 1~N까지 방문하는데 방문할 수 있는 처음 입장하는 노드의 개수가 정답이다.
        //예를들어 1-3-4관계가 있었을 경우 1-3-4는 visited처리를 하고 3,4를 다시 방문할때는 방문되었으니 Count를 해주지 않는것이다.

        //1. 인접리스트를 생성한다.
        map = new ArrayList[n];


        //2 . 인접리스트를 초기화
        for(int i = 0 ; i < n ; i++){
            map[i] = new ArrayList<>();
        }

        //2.연결관계를 생성한다.
        for(int r = 0 ; r <  n ; r++){
            for(int c = 0 ; c <  n ; c++){

                //2-1.양방향 연결 , 1인경우 네트워크로 연결되어있다.
                if(computers[r][c]==1){
                    map[r].add(c);
                    map[c].add(r);
                }
            }
        }

        boolean[] isVisited = new boolean[n];
        //3. 깊이 우선 탐색으로 노드를 방문한다.
        for(int i = 0 ; i < n ;i++){
            //방문했던 노드는 탐색하지 않는다.
            if(isVisited[i])continue;

            //방문하지 않은 노드는 새 네트워크를 의미한다.
            //따라서 정답 + 1을 해준다.그리고 깊이 우선 탐색을 진행한다.
            answer ++;
            dfs(isVisited,i);

        }



        return answer;
    }

    //깊이 우선 탐색
    private static void dfs (boolean []isVisited ,int start){
        //들어 온 노드는 방문처리 한다.
        isVisited[start] = true;


        //start에 연결된 노드를 탐색한다.
        for(int i = 0 ; i < map[start].size(); i++ ){

            int next = map[start].get(i);
            //방문하지 않은 경우에 탐색을 깊이 우선 탐색을 진행한다.
            if(!isVisited[next]){
                dfs(isVisited , next);
            }
        }
    }

}
