package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1260 {
   static int N,M,V;
   static boolean isVisited[];
   static StringBuilder sb = new StringBuilder();
   static ArrayList<Integer> arrayList [];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());



        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());


        arrayList = new ArrayList[N+1];
        isVisited = new boolean[N+1];


        for(int i = 1; i <=N;i++){
            arrayList[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());


            arrayList[from].add(to);
            arrayList[to].add(from);


        }

        for(int i =1; i<arrayList.length ; i++){
            Collections.sort(arrayList[i]);
        }



        //DFS
        Dfs(V);
        sb.append("\n");

        Arrays.fill(isVisited,false);

        //BFS
        Bfs(V);
        System.out.print(sb);
    }

    private static void Dfs (int start){
        isVisited[start]=true;
        sb.append(start+" ");

        for(int i = 0 ; i <arrayList[start].size();i++){
            int nextNode = arrayList[start].get(i);
            if(!isVisited[nextNode]){
                Dfs(nextNode);
            }
        }

    }


    private static void Bfs (int start){
        isVisited[start]=true;

        Queue<Integer> queue = new ArrayDeque<>();
        sb.append(start+" ");


        for(int i = 0; i<arrayList[start].size();i++){
            int next = arrayList[start].get(i);
            if(!isVisited[next]){
                queue.add(next);
            }
        }

        while (!queue.isEmpty()){
            int n = queue.poll();
            if(!isVisited[n]){
                Bfs(n);
            }
        }
        sb.append("\n");

    }
}
