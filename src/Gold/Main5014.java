package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//스타트링크 (너비우선 탐색)
public class Main5014 {

    static int[] floor;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int []updown = new int[2];
        updown[0]= Integer.parseInt(st.nextToken());
        updown[1]=-Integer.parseInt(st.nextToken());

        floor = new int[F+1];
        floor[S] =1; //1로 해주지않으면 틀린다....

        bfs(F,S,G,updown);
        System.out.print( floor[G]!=0 ? floor[G]-1:"use the stairs");

    }

    public static void bfs(int F,int S,int G,int[]updown) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if(x==G){
                break;
            }
            for (int i = 0; i < 2; i++) {
                int next = x + updown[i];

                if (next < 1 || next > F) continue;
                if (floor[next]!=0) continue;

                floor[next] = floor[x] + 1;
                queue.add(next);
            }

        }
    }
}


