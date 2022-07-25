package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2589 {
    static class Dot{
        int R ;
        int C ;
        int T ;

        public Dot(int r, int c, int t) {
            R = r;
            C = c;
            T = t;
        }
    }
    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};
    static int R,C;
    static char [][] map;
    static int answer = -1; //최대 길이 찾아야하니까 -1로 초기화
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

       map = new char[R][C];

        //2차원 배열에 보물지도 정보 저장
        for(int r = 0 ;  r < R ;r++){
            String str = br.readLine();
            for(int c = 0 ;  c<C;c++){
                map[r][c] = str.charAt(c);
            }
        }


      for(int r = 0 ; r < R ; r ++){
          for(int c = 0;  c<C;c++){
              if(map[r][c]=='L'){
                  answer=Math.max(answer,bfs(r,c));
              }
          }
      }

        System.out.println(answer);

    }
    private static int bfs(int r,int c){

        boolean[][]isVisited = new boolean[R][C];
        Queue<Dot> queue = new LinkedList<>();
        isVisited[r][c]=true;
        queue.add(new Dot(r,c,0));
        int count = 0;

        while (!queue.isEmpty()){

            Dot d = queue.poll();

            for(int i = 0 ; i < 4; i++){
                int nr = d.R + dr[i];
                int nc = d.C + dc[i];


                if(isRange(nr,nc)&&map[nr][nc]!='W'&&!isVisited[nr][nc]){
                    queue.add(new Dot(nr,nc,d.T+1));
                    isVisited[nr][nc]=true;
                    count = d.T+1;
                }
            }//for

        }//while

            return count;

    }
    private static boolean isRange(int r ,int c){
        return r>=0 && r<R  && c>=0 && c<C;
    }
}
