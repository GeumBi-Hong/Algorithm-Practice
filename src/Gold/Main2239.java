package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
  스도쿠
 */
public class Main2239 {
    static class Dot {
        int r ;
        int c;

        public Dot(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static int [][] map ;
    static boolean endFlag;
    static ArrayList<Dot> arrayList = new ArrayList<Dot>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        map = new int[9][9]; // 9x9

        /*입력값 받기 */
        for(int r  = 0 ;  r < 9 ; r++){
            String str = br.readLine();
            for(int c = 0 ; c < 9 ; c++){
                map[r][c] = str.charAt(c) - '0';
                if(map[r][c]==0){
                    arrayList.add(new Dot(r,c));
                }

            }
        }

        //스도쿠 시작
        sudoku(0);

        for(int r  = 0 ;  r < 9 ; r++){
            for(int c = 0 ; c < 9 ; c++){
              sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);




    }
    /*스도쿠 함수 */
    private static void sudoku(int idx){

        //첫 번째 답이 가장 작다
        if(idx ==arrayList.size()){
            endFlag=true;
            return;
        }

        Dot dot = arrayList.get(idx);

        for(int i  = 1 ; i <= 9 ; i++){
            map[dot.r][dot.c]=i;
            //스도쿠 3가지 성립 조건 1.행에 중복되는 숫자가 없어여함 2. 열에 중복되는 숫자가 없어야함 3. 3x3 에 중복되는 숫자가 없어야함
            if(checkHorizontal(dot.r,dot.c)&& checkVertical(dot.r,dot.c)&& checkSquare(dot.r, dot.c)){
                sudoku(idx+1);
            }
            if(endFlag){
                return;
            }
            map[dot.r][dot.c]=0;
        }

    }
    //행 검사 (가로)
    private static boolean checkHorizontal(int r,int c){
        for(int i = 0 ; i < 9 ; i ++){
            if(i!=c){
                if(map[r][i]==map[r][c]){
                    return false;
                }
            }
        }
        return true;
    }

    //열 검사 (세로)
    private static boolean checkVertical(int r,int c){
        for(int i = 0 ; i < 9 ; i ++){
            if(i!=r){
                if(map[i][c]==map[r][c]){
                    return false;
                }
            }
        }
        return true;
    }

    //3x3검사
    private  static boolean checkSquare(int r,int c){
        int startR = (r/3)*3;
        int startC = (c/3)*3;

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3; j++){
                if(r!=startR+i||c!=startC+j){
                    if(map[startR+i][startC+j]==map[r][c]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
