package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 행이 거꾸로 되어있다는 것에 주의해야함.
 * 그거에 맞게 dr,dc를 알맞게 수정해야함.
 */
public class Main1063 {
        // 우, 좌 ,하,상, 오위,왼위,오른아래 ,왼아래
    static int []dr ={0,0,-1,1,1,1,-1,-1};
    static int []dc ={1,-1,0,0,1,-1,1,-1};
    static int kingR,kingC,rockR,rockC;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        kingR = Character.getNumericValue(king.charAt(1));
        kingC = king.charAt(0)-'A'+1;

        String rock = st.nextToken();

        rockR = Character.getNumericValue(rock.charAt(1));
        rockC = rock.charAt(0)-'A'+1;

        int N = Integer.parseInt(st.nextToken());



        while (N-->0){
            String move = br.readLine();

        /*
            R : 한 칸 오른쪽으로 0
            L : 한 칸 왼쪽으로   1
            B : 한 칸 아래로   2
            T : 한 칸 위로   3
            RT : 오른쪽 위 대각선으로 4
            LT : 왼쪽 위 대각선으로  5
            RB : 오른쪽 아래 대각선으로 6
            LB : 왼쪽 아래 대각선으로 7
         */


            switch (move){
                case "R":
                moveKing(0);
                    break;
                case "L":
                    moveKing(1);
                    break;
                case "B":
                    moveKing(2);
                    break;
                case "T":
                    moveKing(3);
                    break;
                case "RT":
                    moveKing(4);
                    break;
                case "LT":
                    moveKing(5);
                    break;
                case "RB":
                    moveKing(6);
                    break;
                case "LB":
                    moveKing(7);
                    break;
            }

        }
        char k = (char)(kingC+64);
        System.out.println(k+""+kingR);
        char r = (char)(rockC+64);
        System.out.println(r+""+rockR);
    }

    /**
     * 말의 위치를 변경하는 함수
     * @param d -> 움직여야하는 방향의 dr,dc를 가져오기위한 매개변수
     */
        private static void moveKing (int d){
            /**
             * 움직여야하는 방향에 대하여 킹이 이동할 위치 좌표
             */
            int nr =kingR+dr[d];
            int nc =kingC+dc[d];


            /**
             * 다음 킹의 좌표가 배열 범위 안에 있다면
             */
            if(isRange(nr,nc)){
                //그런데 다음 이동할 좌표에 돌이 있다면
                if(nr==rockR && nc==rockC){
                    if(isRange(rockR+dr[d],rockC+dc[d])){ //돌도 이동이 가능하다면
                        //둘다 이동해야하는 방향에 한칸씩 이동
                        kingR+=dr[d];
                        kingC+=dc[d];
                        rockR+=dr[d];
                        rockC+=dc[d];
                    }else {  //그렇지 않고 돌은 이동할 수 없다면 킹을 움직일 수 없으므로 return
                        //돌이 이동이 불가하다면
                        return;
                    }
                }else { //다음 킹이 이동할 좌표에 돌이 없다면 킹만 이동한다.
                    kingR+=dr[d];
                    kingC+=dc[d];
                }
            }

        }

        /** 배열 밖으로 벗어나는지 범위 체크하는 함수 **/
        private static boolean isRange (int r ,int c){
        return r>=1 && r<=8 && c>=1 && c<=8;
        }

    }



