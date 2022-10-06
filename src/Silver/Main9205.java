package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
맥주 마시면서 걸어가기
 */
public class Main9205 {

    static class Dot {
        int r;
        int c;

        public Dot(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder() ;


        ArrayList<Dot> arrayList ;
        ArrayList<ArrayList<Integer>> graph;
        //테스트 케이스 수 만큼 반복
        for(int test_case = 0 ; test_case <T; test_case++){
             int N = Integer.parseInt(br.readLine()); //편의점 개수


            arrayList= new ArrayList<>();

            for(int i = 0 ; i < N+2;i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arrayList.add(new Dot(r,c));
            }


            graph = new ArrayList<>();

            for(int i = 0 ; i < N+2;i++){
                graph.add(new ArrayList<>());
            }

            //맨해튼 거리 1000m이하 를 만족하는 두 정점을 찾기
            //맥주 최대 20개 에 하나에 50m 임 따라서 20*50=1000m 까지 이동 할 수 있음
            //맨허튼 거리로 이동 가능 할때만 그래프를 양방향으로 이어준다.

            for(int i = 0 ; i< N+2;i++){
                for(int j = i+1; j<N+2;j++){
                    if(Manhattan(arrayList.get(i),arrayList.get(j))<=1000){
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }


            sb.append((BFS(graph,N)? "happy":"sad")+'\n');

            //시작 지점 (상근)


        }
        System.out.println(sb);


    }
    private static int Manhattan (Dot d1 , Dot d2){
        return  Math.abs(d1.r-d2.r)+Math.abs(d1.c-d2.c);
    }

    private static boolean BFS(ArrayList<ArrayList<Integer>> graph, int N) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visited = new boolean[N + 2];
        visited[0] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == N + 1) {//도착지점에 왔다면 true
                return true;
            }

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return false;
    }
}
