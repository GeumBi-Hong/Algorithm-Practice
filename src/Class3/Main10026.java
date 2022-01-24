package Class3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


//bfs
public class Main10026 {


    static int []x_dot = {-1,1,0,0}; // 상 하 좌 우
    static int [] y_dot = {0,0,-1,1};

    static boolean [][]visit_check,visit_checkRGB;
    static char [][]array,arrayRGB;

    static int N ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //배열 크기
        visit_check = new boolean[N][N];
        visit_checkRGB = new boolean[N][N];
        array = new char[N][N];
        arrayRGB = new char[N][N];

        int answer=0,answerRGB =0;

        for(int i = 0 ; i  < N ; i++){ //2차원 배열에 값 넣기
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                char c =  str.charAt(j);
                array[i][j] = c;
                if(c =='R'){
                    arrayRGB[i][j] = 'G'; //적록색약의 경우 빨간색과 초록색 차이를 느끼지 못하니까 같은 색으로 만들어준다.
                }else {
                    arrayRGB[i][j]=c;
                }
            }
        }


        for (int i = 0 ; i < N; i++){
            for (int  j= 0; j<N;j++){
                if(!visit_check[i][j]){
                    bfs(i,j,array[i][j],visit_check,array);
                    answer++;

                }
                if(!visit_checkRGB[i][j]){
                    bfs(i,j,arrayRGB[i][j],visit_checkRGB,arrayRGB);
                    answerRGB++;
                }
            }
        }

            System.out.println(answer);
            System.out.print(answerRGB);
    }
    public static void bfs (int x, int y, char color, boolean[][] vs,char [][] a){

        Queue <Dot> queue = new LinkedList<>();
        queue.add(new Dot(x,y)); //큐에 현재 좌표를 넣는다.
        vs[x][y]=true;


        while (!queue.isEmpty()) {
            Dot d = queue.poll();

            for (int i = 0; i < x_dot.length; i++) {  //큐에서 꺼낸 좌표를 기준으로 상하좌우 칸에 접근한다.
                int new_x = d.x+x_dot[i]; //새로운 x 좌표 = 현재좌표 + (상하좌우)
                int new_y = d.y+y_dot[i];// 새로운 y 좌표 = 현재좌표 + (상하좌우)
                if (new_x > -1 && new_y>-1 && new_x < N && new_y<N&&! vs[new_x][new_y]&& a[new_x][new_y] == color) {
                    //새로운 좌표는 -1 보다 커야하고 배열의 크기보다 작아야 배열에 접근할 수 있다.
                    //방문했던 칸이 아니여야 주변 칸에 접근할 수 있다.
                    //현재 좌표칸의 색과 상하좌우의 칸 색이 같아야 주변 칸에 접근할 수 있다.
                        queue.add(new Dot(d.x+x_dot[i],d.y+y_dot[i]));
                        vs[new_x][new_y]=true; //큐에 들
                }

            }
        }
    }

    public static class Dot {
        int x;
        int y;

        public  Dot (int x ,int y){
            this.x =x;
            this.y =y;
        }
    }
}
