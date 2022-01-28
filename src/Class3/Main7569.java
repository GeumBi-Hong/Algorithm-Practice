package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//토마토, 너비우선 탐색 ,3차원배열
public class Main7569 {
    //상 하 좌 우 위 아래
    static int []dx ={-1,1,0,0,0,0};
    static int []dy = {0,0,-1,1,0,0};
    static int []dz = {0,0,0,0,1,-1};

    static int M;
    static int N;
    static int H;
    static int [][][] box ;
    static Queue<Dot> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

         M  = Integer.parseInt(st.nextToken()); //가로칸의 수
         N =  Integer.parseInt(st.nextToken()); //세로칸의 수
         H = Integer.parseInt(st.nextToken());  //높이

        box= new int[H][N][M];
        queue = new LinkedList<>();


        //3차원 배열에 입력값을 저장한다. //int [][][] 배열명 = new int[높이][행][열];
        for (int z=0 ; z<H;z++){ //높이
            for(int i = 0 ; i <N ; i++){ //세로
                st = new StringTokenizer(br.readLine()," ");
                    for (int j= 0; j<M; j++){ //가로
                        box[z][i][j] = Integer.parseInt(st.nextToken());

                        if(box[z][i][j]==1){ //익은 토마토의 좌표들을 큐에 넣는다.
                            queue.add(new Dot(i,j,z));
                        }
                }
            }
        }

        System.out.print(bfs());

    }

    public static  int bfs (){

        while (!queue.isEmpty()){
            Dot d = queue.poll(); //큐에 들어간 좌표값을 꺼낸다.

            int x =d.x;
            int y =d.y;
            int z =d.z;

            for (int i = 0 ; i < 6; i++){ // 상 하 좌 우 위 아래 순으로 다음 좌표를 가져온다.

                int nx = x+dx[i];
                int ny = y+dy[i];
                int nz = z+dz[i];

                if(nx >= 0  && ny >=0 && nz >=0 && nx<N && ny < M && nz < H){ //좌표범위가 3차원 배열 밖의 범위로 가면 안된다.

                       if (box [nz][nx][ny]==0){ //토마토가 익지 않았다면
                           queue.add(new Dot(nx,ny,nz)); //익지 않은 토마토 좌표의 값을 큐에 넣어준다.
                           box[nz][nx][ny]= box[z][x][y]+1; //그 전의 토마토 값의 +1을 더하여 날짜를 계산할 것이다.
                       }

                }
            }


        }


         int date = Integer.MIN_VALUE ; //최대 날짜 찾기

        for (int z=0 ; z<H;z++){ //높이
            for(int i = 0 ; i <N ; i++){ //세로

                for (int j= 0; j<M; j++){ //가로

                    if(box[z][i][j]==0){ //익지 않은 토마토가 존재하면 -1을 출력한다.
                        return -1;
                    }

                    date = Math.max(date,box[z][i][j]); // 익은 토마토 값 중에서 큰값으로 날짜를 갱신한다.
                }
            }
        }

         if(date==1){ //date 가 1이라는것은 토마토가 전부 익었던 상태였으므로 0을 리턴한다.
             return 0;

         }else {//그렇지 않으면 date -1 을 리턴한다. (맨처음 익은 토마토 값이 0이 아니라 1이였기때문에 1을 빼주어야한다)
             return date -1;
         }

    }

    public static class Dot {
        int x ;
        int y ;
        int z ;

        public Dot(int x, int y, int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
}
