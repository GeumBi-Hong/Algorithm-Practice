package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//뱀과 사다리 게임 (너비 우선 탐색) *다시 한번 풀어보자
public class Main16928 {

    static boolean visited[] = new boolean[101]; //칸 방문 확인
    static int count[] = new int[101]; // 최단거리 수
    static int block[] = new int[101]; //뱀과 사다리 관계

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());//사다리
        int M = Integer.parseInt(st.nextToken()); //뱀



       for(int i = 0 ; i <N+M;i++){ //사다리와 뱀의 정보들을 저장한다.
         st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           block[start]=end; //시작과 끝의 관계를 나타내어준다.
       }


      bfs();

    }

   static void bfs (){

       Queue<Integer> queue = new LinkedList<>();
       queue.add(1);
       visited[1]=true;

       while (!queue.isEmpty()){
           int x = queue.poll();


           if(x==100){ //100번째 칸에 왔다면 끝이다.
               System.out.print(count[100]);
               return;
           }

           for (int i = 1; i<=6; i++){ //주사위 1~6
               int next = x + i;
               if(next>100||visited[next])continue; //100을 넘기거나 갔던 노드라면 continue

               visited[next]=true;

               if(block[next] != 0){ //사다리거나 뱀이면
                   if(!visited[block[next]]) { //방문체크
                       queue.offer(block[next]);
                       visited[block[next]] = true;
                       count[block[next]] = count[x] + 1;
                   }
               }
               else {
                   queue.offer(next);
                   count[next] = count[x] + 1;
               }
           }

       }
   }


}
