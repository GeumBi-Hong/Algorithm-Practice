package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2628 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        boolean [] rVisited = new boolean[R];
        boolean [] cVisited = new boolean[C];


        for(int i = 0 ; i  <N ; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            //잘린 행이나 열 번호에 true체크
            if(type==0) rVisited[num-1]=true;
            else cVisited[num-1]=true;
        }

        //행과 열의 맨끝은 잘려있다고 처리 (끝을 만났을때 면적 값을 구해줘야 하기때문이다.)
        rVisited[R-1]=true;
        cVisited[C-1]=true;


        int max=0;

        int startR = 0;
        int startC = 0;

        for(int c = 0 ; c < C ;c++){

            if(cVisited[c]){ //잘린 구역을 만났을때 (열)
                for(int r = 0 ; r<R;r++){
                    if(rVisited[r]){ //잘린 구역을 만났을때 (행)
                        int area = (c+1-startC)*(r+1-startR); // 넓이 계산
                        max = Math.max(area,max);
                        startR=r+1; //다음 시작 행을 갱신

                    }
                }

                startC=c+1; //다음 시작 열을 갱신
                startR=0; //다시 다른 잘린 열이 있으니 행은 다시 0으로 초기화

            }
        }

        System.out.println(max);

    }
}
