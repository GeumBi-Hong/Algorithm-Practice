package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11725 {
    static int[] parent;
    static ArrayList<Integer>[]arrayList;

    static int N;
    public static void main(String[] args)  throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());

        // 인접 리스트 생성
        arrayList = new ArrayList[N + 1];
        parent = new int[N + 1];

        //1부터 N까지 정점
        for (int i = 1; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        //간선 관계
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList[a].add(b);
            arrayList[b].add(a);
        }
        //너비 우선탐색을 하면서 해당 노드의 부모 저장
        bfs(1);

        for (int i =2 ; i<=N;i++){
            sb.append(parent[i]+"\n");
        }

        System.out.print(sb);
    }

    public static void bfs (int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        parent[start] = 1;

        while (!queue.isEmpty()){
            int p = queue.poll();

            for(int data : arrayList[p]){
                if(parent[data]==0) {
                    queue.add(data);
                    parent[data] = p;
                }
            }
        }

    }
}
