package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//쿼드 트리  (재귀,분할)
public class Main1992 {

    static  int [][]square ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 한 변의 길이

        square = new int[N][N]; //2차원 배열

        for (int i = 0 ;  i  < N ; i ++){ //2차원 배열에 값 넣기
            String str = br.readLine();
            for (int j = 0 ; j < N; j++){
                square[i][j]= str.charAt(j)-'0';
            }
        }

        QuadTree(0,0,N);
        System.out.print(sb);
    }

    public static void QuadTree(int x, int y, int N) {

        if( checkSquare(x,y,N)){//압축가능하면 그 색의 숫자로 저장한다.
            sb.append(square[x][y]);
            return;
        }

        int divSize = N/2; //압축이 안되는 경우는 변의 길이를 절반으로 나누어 주어야한다.

        //분할
        // 분할 과정에 들어가는 경우 '(' 를 해준다
        sb.append('(');
        QuadTree(x,y,divSize); //왼쪽 위
        QuadTree(x,y+divSize,divSize); //오른쪽 위
        QuadTree(x+divSize,y,divSize); //왼쪽 아래
        QuadTree(x+divSize,y+divSize,divSize); //오른쪽 아래

        //끝났을 경우에는 ')'를 해야한다.

         sb.append(')');

    }

    public static boolean checkSquare (int x, int y, int N){ //해당하는 정사각형이 같은색으로 차 있는지 확인

        int firstBlock = square[x][y]; // 첫 번째칸의 (왼쪽 맨위) 색을기준으로 나머지 칸들이 색이 같은지 확인

        for(int i = x; i<x+N;i++){
            for(int j = y ; j < y+N;j++){
                if(firstBlock!=square[i][j]){
                   return  false; //같이 않으면 false
                }
            }
        }
        return  true;
    }
}
