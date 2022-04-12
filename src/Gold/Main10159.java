package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10159 {
    static ArrayList<Integer>[] list1 ;
    static ArrayList<Integer>[] list2 ;
   static boolean  [] visited;
   static int count = 0;
   //static int A,B;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list1 = new ArrayList[N+1];
        list2 = new ArrayList[N+1];
        visited  =  new boolean[N+1];

        for(int i = 1 ; i<=N; i++){
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }


        for (int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list1[start].add(end);
            list2[end].add(start);
        }


        for(int i = 1 ; i<=N;i++){
            Arrays.fill(visited,false);
            count=0;
            dfs(i,list1,visited);
            Arrays.fill(visited,false);
            dfs(i,list2,visited);

            sb.append(N - count - 1).append("\n");


        }

        System.out.println(sb);
    }
    public static void dfs(int n,ArrayList<Integer>[] list,boolean []v){

        v[n] = true;

        for(int next : list[n]){
            if(!v[next]){
                count++;
                dfs(next,list,v);
            }
        }
    }
}
