package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 달이 차오른다 가자
 * BFS , 비트마스킹
 */
public class Main1194 {

    static class Info {

        int r ;
        int c;
        int dist;
        int key;

        public Info(int r, int c, int dist, int key) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.key = key;
        }
    }
    static int N,M;
    static char [][] miro;
    static int [] dr = {0,0,1,-1};
    static int [] dc = {1,-1,0,0};
    static int  answer ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new char[N][M];


        int startR = 0 ;
        int startC = 0;

        answer = Integer.MAX_VALUE;

        // 입력값 저장
       for(int i = 0 ; i < N; i++){
            String str = br.readLine();
            for(int j = 0 ; j <M;j++){
                miro[i][j]= str.charAt(j);

                //민석의 좌표를 저장한다.
                if(miro[i][j]=='0'){
                    startR = i;
                    startC = j;
                }
            }
        }


       //민식이 좌표
       bfs(startR,startC);


       System.out.println(answer==Integer.MAX_VALUE? "-1":answer);
    }
    /*
     BFS
     */
    private static void bfs (int r, int c){
        boolean [][][]isVisited = new boolean[N][M][1<<6];//1000000
        Queue<Info> queue = new ArrayDeque<>();
        isVisited[r][c][0] = true;
        queue.add(new Info(r,c,0,0));


        while (!queue.isEmpty()){
            Info info = queue.poll();

            int curR = info.r;
            int curC = info.c;
            int curDist = info.dist;
            int curKey = info.key;

            //도착 지점에 왔다면
            if(miro[curR][curC]=='1'){
                // 현재 curDist가 더 짧은 경로 였다면 curDist로 정답을 갱신한다.
                answer = answer > curDist ? curDist : answer;
                continue;

            }
            //4방 탐색
            for(int i = 0 ; i < 4 ; i++){
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                //다음 좌표가 2차원 배열 범위 안에 존재하고 방문 하지 않은 곳이였을때
                if(isRange(nr,nc)&& !isVisited[nr][nc][curKey]){



                    //벽인 경우에는 이동하지 않는다,
                    if(miro[nr][nc]=='#')continue;

                    //민식이가 원래 있던곳 , 빈 곳 , 도착지 일 경우
                    if(miro[nr][nc]=='.'||miro[nr][nc]=='1'||miro[nr][nc]=='0'){
                        isVisited[nr][nc][curKey]=true;
                        queue.add(new Info(nr,nc,curDist+1,curKey));



                    }//열쇠인 경우
                    else if(miro[nr][nc]>='a' && miro[nr][nc]<='f'){
                        int temp = curKey;
                        temp = temp | (1<<(miro[nr][nc]-'a'));
                        isVisited[nr][nc][temp]=true;
                        queue.add(new Info(nr,nc,curDist+1,temp));
                    }
                    else if( miro[nr][nc]>='A'&& miro[nr][nc]<='F'){
                        int door = (1<<miro[nr][nc]-'A'); //문 정보
                        //해당하는 문에 맞는 키가 있는지 확인
                        if((curKey & door)==door){
                            isVisited[nr][nc][curKey]=true;
                            queue.add(new Info(nr,nc,curDist+1,curKey));

                        }
                    }

                }





            }
        }


    }
    private static boolean isRange (int r ,int c ){
        return r>=0 && r <N && c>=0 && c< M ;
    }
}
