package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//dslr(너비우선)
public class Main9019 {
    static StringBuilder sb = new StringBuilder();
    static boolean []visited;
    static String[] answer;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-->0){ //테스트 케이스 수만큼
            st = new StringTokenizer(br.readLine()," ");
            queue = new LinkedList<>();
            answer = new String[10000];
            visited = new boolean[10000];
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            Arrays.fill(answer,  ""); //정답을 기록할 배열을 "" <로 초기화를 시켜준다.

            //처음 수를 넣어주고 방문체크한다.
            queue.add(before);
            visited[before]=true;
            bfs(after);
        }

        System.out.print(sb);
    }
    public static void bfs(int after){

        while (!queue.isEmpty() && !visited[after]){
            int now = queue.poll(); //현재 좌표값을 가져온다.


            //연산이 핵심!!//
            int D = (2 * now) % 10000;
            int S = now == 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            //방문하지않았다면 연산을 수행해본다.
            if (!visited[D]) {
                queue.add(D); // 큐에 넣는다
                visited[D] = true; // 방문처리한다
                answer[D] = answer[now] + "D"; // 명령어를 추가한다
            }

            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                answer[S] = answer[now] + "S";
            }

            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                answer[L] = answer[now] + "L";
            }

            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                answer[R] = answer[now] + "R";
            }
        }
        sb.append(answer[after]).append("\n");
        }
    }

