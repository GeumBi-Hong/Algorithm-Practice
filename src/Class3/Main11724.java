package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//연결 요소의 개수
public class Main11724 {
    static boolean visited [];
    static ArrayList<Integer> [] arrayLists ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());//정점의 수 6
        int M = Integer.parseInt(st.nextToken());//간선의 수 5
        int answer = 0;

        arrayLists = new ArrayList[N+1]; // 0~6
        visited = new boolean[N+1];

        for (int i =1 ; i< arrayLists.length;i++){
            arrayLists[i] = new ArrayList<>();
        }


        while (M -->0){

            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arrayLists[u].add(v);
            arrayLists[v].add(u);

        }


        for(int i =1; i <=N;i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }

        System.out.print(answer);
    }

    public static void bfs (int start){

        visited[start] = true;
        for (int i =0; i<arrayLists[start].size();i++){
            int num = arrayLists[start].get(i);
            if(!visited[num]){
                bfs(num);
            }
        }

    }

}
