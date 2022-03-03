package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//미세먼지 안녕!( 구현 ,시뮬레이션)
public class Main17144 {
    static int R,C,T;
    static int [][]array,new_array;
    static int [] dot_X = {0,0,1,-1};
    static int [] dot_Y = {-1,1,0,0};
    static int cleaner_dot =-1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken()); //행
        C = Integer.parseInt(st.nextToken()); //열
        T = Integer.parseInt(st.nextToken()); //초
        array =  new int[R][C];
        new_array = new int[R][C];


        //2차원 배열 초기화
        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j< C;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(cleaner_dot==-1 && array[i][j]==-1){
                   cleaner_dot=i; //공기청정기 (위) 위치
                }
            }
        }

        while ( T -->0){
            spreadDust(); //미세먼지 확산
            cleanDust(); //공기청정기 돌리기
        }
        System.out.print(totalDust()); //총 미세먼지 합

    }
    public static void copyArray(){

        for(int i=0; i<R ;i++){
            for(int j=0; j<C; j++){
                new_array[i][j]=array[i][j];
            }
        }
    }

    public static void spreadDust(){//미세먼지 확산

        copyArray();

        for(int i = 0 ; i<R; i++) {
             for (int j = 0 ; j<C;j++) {
              if(array[i][j]>0){
                  if(array[i][j]/5 <0)continue;
                   int spread = new_array[i][j]/5;
                   int count = 0;

                  for (int k = 0; k < 4; k++) {
                      int next_X = i + dot_X[k];
                      int next_Y = j + dot_Y[k];

                      if (next_X < 0 || next_X >= R || next_Y < 0 || next_Y >= C) continue;
                      if (array[next_X][next_Y] == -1) continue;

                      array[next_X][next_Y] += spread;
                      count++;
                  }
                  array[i][j] -= spread * count;
              }

    }
}
    }

    public static void cleanDust(){


        int up = cleaner_dot;
        int down =cleaner_dot+1;
        //반시계
        for(int i= up -1; i >0;i--){
            array[i][0]=array[i-1][0];
        }
        for(int i=0;i<C-1;i++){
            array[0][i]=array[0][i+1];
        }
        for(int i =0;i<up;i++){
            array[i][C-1]=array[i+1][C-1];
        }
        for(int i = C-1; i>1;i--){
            array[up][i]=array[up][i-1];
        }
        array[up][1]=0; //공기청정기에서 나오는 바람

        //시계
        for(int i= down+1;i<R-1;i++){
            array[i][0]= array[i+1][0];
        }

        for(int i = 0;  i<C-1;i++){
            array[R-1][i] =array[R-1][i+1];
        }

        for(int i= R-1; i>down;i--){
            array[i][C-1]=array[i-1][C-1];
        }
        for(int i=C-1; i>1;i--){
            array[down][i]=array[down][i-1];
        }
        array[down][1]=0;// 공기청정기에서 나오는 바람

    }


    public static int totalDust(){

        int sum =0;
        for(int i = 0; i<R ; i++){
            for(int j = 0 ; j <C;j++){
                if(array[i][j]!=-1){
                    sum+=array[i][j];
                }
            }

        }
        return sum;
    }

}
