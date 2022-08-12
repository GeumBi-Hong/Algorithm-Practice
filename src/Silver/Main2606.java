package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2606 {
    static boolean []isVisited ;

    static ArrayList<Integer>[] arrayLists ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       int M = Integer.parseInt(br.readLine());
        //컴퓨터 번호가 1부터 주어 지니까 패딩(N+1)

        isVisited = new boolean[N+1];


        //인접 리스트
        arrayLists = new ArrayList[N+1];
        for(int i = 1; i<=N;i++){
            arrayLists[i]= new ArrayList<>();
        }

        for(int i = 0 ; i < M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            //양 방향 관계 설정
            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }


        dfs(1);

        int answer = 0;
        for(int i = 1 ; i <isVisited.length;i++){
            if(isVisited[i]){
                System.out.print(i+" ");
                answer++;
            }
        }
        System.out.println(answer-1); //1 번 컴퓨터는 제외하고 출력

    }

    private static void dfs (int start){

        //방문한 컴퓨터는 체크해줌 (true => 방문했다는 의미)
        isVisited[start]=true;

        for(int i = 0 ; i<arrayLists[start].size();i++){
            int nv = arrayLists[start].get(i);
            if(isVisited[nv])continue;
            isVisited[nv]=true;
            dfs(nv);
        }
    }
}
