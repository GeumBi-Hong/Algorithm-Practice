package Gold;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3055 {

    static class Dot {
        int r;
        int c;

        public Dot(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int R,C ;
    static int [][]map;
    static int []dr = {0,0,1,-1};
    static int []dc = {1,-1,0,0};

    static boolean [][] isWater; // 물이 찼는지 확인

    static int endR = 0;
    static int endC = 0;
    static boolean isFlag = false; //동굴에 도착했는지 안했는지 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); //행
        C = Integer.parseInt(st.nextToken()); //열

        map = new int[R][C];
        isWater = new boolean[R][C];

        Queue<Dot> waterIndex = new LinkedList<>(); //물이 찰 좌표를 가진 큐
        Queue<Dot> hedgehogIndex = new LinkedList<>(); //고슴도치가 이동할 좌표를 가진 큐

        for(int r = 0;  r <R ;r++){
            String str = br.readLine();
            for(int c = 0 ; c< C;c++){
                if(str.charAt(c)=='*'){ //물이면 -3

                    isWater [r][c]= true;
                    waterIndex.add(new Dot(r,c));


                }else if(str.charAt(c)=='D'){ //도착 지점이면 -2

                    endR=r;
                    endC=c;
                    map[r][c]=-2;

                }else if(str.charAt(c)=='X'){ //돌이면 -1
                    map[r][c]=-1;
                }else if(str.charAt(c)=='S'){//고슴도치면 1

                    hedgehogIndex.add(new Dot(r,c)); //고슴도치
                    map[r][c]=1;
                }
            }
        }

        while (!isFlag){

            spreadWater(waterIndex);
            // printMapWater(); 물이 잘 찼나 확인
            moveHedgehog(hedgehogIndex);
            //  printMap(); 고슴도치가 잘 이동하나 확인
            if(hedgehogIndex.isEmpty()){ // 더이상 이동할 좌표가없다면
                System.out.println("KAKTUS");
                break;
            }
        }

        if(isFlag)System.out.println(map[endR][endC]-1);

    }

    private static void spreadWater (Queue<Dot> waterList){

        int size = waterList.size() ; //큐 사이즈만큼만 반복하기 위해.
        while (size-->0){ //사이즈 만큼 반복

            Dot d  = waterList.poll();

            for(int i = 0 ; i < 4; i++){
                //다음 이동할 좌표
                int nr = d.r +dr[i];
                int nc = d.c +dc[i];

                //맵 범위 안에 존재해야 하고 물이 차있는 곳은 다시 x , 동굴은 물이 찰 수 없음 ,돌도 x
                if(isRange(nr,nc)&&!isWater[nr][nc]&&map[nr][nc]!=-2&&map[nr][nc]!=-1){
                    isWater[nr][nc]=true ; //물이 찬곳 방문 처리
                    waterList.add(new Dot(nr,nc));
                }
            }

        }

    }
    private static void moveHedgehog(Queue<Dot>hedgehogIndex ){

        int size = hedgehogIndex.size() ; //큐 사이즈만큼만 반복하기 위해.


        while (size-->0){ //사이즈 만큼 반복

            Dot d  = hedgehogIndex.poll();

            for(int i = 0 ; i < 4; i++){
                //다음 이동할 좌표
                int nr = d.r +dr[i];
                int nc = d.c +dc[i];


                //맵 범위 안에 존재해야 ,물이 있는곳이면 안됨 , 돌도 안됨
                if(isRange(nr,nc)&&!isWater[nr][nc]&&(map[nr][nc]==0||map[nr][nc]==-2)){

                    hedgehogIndex.add(new Dot(nr,nc));
                    map[nr][nc]= map[d.r][d.c]+1; //거리 갱신

                    if(nr==endR && nc ==endC){//도착 지점에 왔다면
                        isFlag=true; //정답을 찾음
                        break;
                    }

                }
            }

        }

    }
    private static void printMap(){
        for(int r = 0;  r <R ;r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c]+" ");
            }
            System.out.println();
        }
    }
    private static void printMapWater (){
        for(int r = 0;  r <R ;r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(isWater[r][c]+" ");
            }
            System.out.println();
        }
    }
    private static boolean isRange(int r ,int c){
        return r >=0  && r<R && c>=0 && c<C;
    }
}
