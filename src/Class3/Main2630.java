package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//색종이 만들기 (재귀 ,분할)
public class Main2630 {

    static int [][] square;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine()); // 정사각형 한 변의 길이
        square =  new int[N][N];

        for (int i = 0 ; i <N;i++){ //2차원 배열에 값 넣기
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0;j <N ; j++){
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideSquare(0,0,N);
        System.out.print(white+"\n"+blue);

    }

    public static void divideSquare(int x, int y, int N){


        boolean check = true;

        if(N==0){
            return;
        }
        int first_color = square[x][y]; //첫번째 칸의 색을 가지고 기준을 세워 다른 칸들과 색이 같은지 다른지 판별

        for(int i=x;i<x+N;i++){
            for(int j =y; j<y+N;j++){
                if(square[i][j]!=first_color){
                    check=false; //색이 같지않음.
                }
            }
        }

        if (check){ //모두 색이 같았을 경우만
            if(square[x][y]==1){
                blue++;
            }else {
                white++;
            }
            return;
        }


        int size = N/2;
        divideSquare(x,y,size);//왼쪽 위
        divideSquare(x,y+size,size);//오른쪽 위
        divideSquare(x+size,y,size); //왼쪽 아래
        divideSquare(x+size,y+size,size);//오른쪽 아래

    }
}
