package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987 {
    static int R,C;
    static char [][] alpa ;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static boolean[] isVisited = new boolean[26];
    static int answer =1;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpa = new char[R][C];

        for(int r = 0 ; r <R ;r++){
            String str = br.readLine();
            alpa[r]= str.toCharArray();
        }



        dfs(0,0,1);
        System.out.println(answer);

    }
    private static void dfs(int r ,int c ,int count){
        isVisited[alpa[r][c]-65]=true;// 알파벳을 사용했다면 사용한걸로 체크
        answer = Math.max(answer,count);

        for(int i = 0 ; i<4;i++){

            int nr = r+dr[i];
            int nc = c+dc[i];
            //다음 이동할 좌표가 배열범위 안에 존재하여야 하고 사용하지 않은 알파벳 칸일 경우만 이동이 가능하다.
            if(isRange(nr,nc)&&!isVisited[alpa[nr][nc]-65]){

                dfs(nr,nc,count+1);
                isVisited[alpa[nr][nc]-65]=false;
            }
        }

    }

    private static boolean isRange (int r ,int c){
        return r >= 0 && r < R && c >=0 &&  c<C;
    }
}
