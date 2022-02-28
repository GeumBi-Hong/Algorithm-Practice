package Class3;
import java.io.*;
import java.util.*;


public class Main16236{

    public static final int max_val = 401, max_int = 21;
    public static int n, shark_x, shark_y, min_dist, min_x, min_y, result, eat_cnt = 0, shark_size = 2;
    public static int [][] array, visited;
    public static int [] dx = {0, 0, 1, -1}, dy = {-1, 1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n + 1][n + 1];
        visited = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());

                if(array[i][j] == 9){
                    shark_x = i;
                    shark_y = j;
                    array[i][j] = 0;
                }
            }
        }

        while(true){
            init_check();

            bfs(shark_x, shark_y);

            if(min_x != max_int && min_y != max_int){
                result += visited[min_x][min_y];

                eat_cnt++;

                if(eat_cnt == shark_size){
                    shark_size++;
                    eat_cnt = 0;
                }

                array[min_x][min_y] = 0;

                shark_x = min_x;
                shark_y = min_y;
            }

            else{
                break;
            }
        }

        System.out.println(result);
    }

    public static void init_check(){
        min_dist = max_val;
        min_x = max_int;
        min_y = max_int;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                visited[i][j] = -1;
            }
        }
    }

    public static void bfs(int x, int y){
        Queue<fish> q = new LinkedList<fish>();
        visited[x][y] = 0;
        q.add(new fish(x, y));

        while(!q.isEmpty()){
            fish f = q.poll();
            x = f.x;
            y = f.y;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if(visited[nx][ny] != -1 || array[nx][ny] > shark_size) continue;

                visited[nx][ny] = visited[x][y] + 1;

                if(array[nx][ny] != 0 && array[nx][ny] < shark_size){

                    if(min_dist > visited[nx][ny]){
                        min_x = nx;
                        min_y = ny;
                        min_dist = visited[nx][ny];
                    }
                    else if(min_dist == visited[nx][ny]){
                        if(min_x == nx){
                            if(min_y > ny){
                                min_x = nx;
                                min_y = ny;
                            }
                        }else if(min_x > nx){
                            min_x = nx;
                            min_y = ny;
                        }
                    }
                }

                q.add(new fish(nx, ny));
            }
        }

    }
}

class fish{
    int x, y;

    fish(int x, int y){
        this.x = x;
        this.y = y;
    }
};