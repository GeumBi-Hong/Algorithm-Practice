import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {

    /*
    4 6
    110110
    110110
    111111
    111101
     */

    static int array1[][];
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array1 = new int[N][M];
        visited =  new boolean[N][M];

        //이차원 배열에 값 추가 하기
        for (int i = 0; i < N; i++) {
            char c[] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                visited[i][j]=false;
                array1[i][j] = Character.getNumericValue(c[j]);

            }

        }
        miro(0,0);
        System.out.print(array1[N-1][M-1]);





    }
    //bfs
     public static void miro(int r , int c){

        //좌표를 넣어줄 큐 생성
        Queue<Dot> queue = new LinkedList<>();
        //방문기록(방문함)
        visited[r][c]=true;
        //큐에 현재 좌표 넣기
        queue.add(new Dot(r,c));


        while(!queue.isEmpty()){
            //큐에 있는 좌표 값을 가져온다.
                Dot d= queue.poll();

                //인접 좌표값 가져오기
                for (int i =0 ; i<4; i++){
                    int nx = d.x + dx[i];
                    int ny = d.y +dy[i];
                    //배열 인덱스 범위를 넘어가지 않는 선에서만 가능하다.
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M ){
                        //방문할 노드가 방문된적이 없고 1이였을때만 인접한 노드로 접근할수있다.
                        if(!visited[nx][ny] && array1[nx][ny]==1){
                            queue.add(new Dot(nx,ny));
                            visited[nx][ny]=true;
                            array1[nx][ny]= array1[d.x][d.y]+1;
                        }
                    }

                }


        }

    }


   static class Dot {
        int x;
        int y;
        Dot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
