package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//마법사 상어와 비바라기
public class Main21610 {

    static class Dot {
        int r;
        int c;

        public Dot(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N,M;
    static int[][] map ;
    static boolean[][] cloud ;
    static int [][]ds;
   // 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int [] dr = {0,0,-1,-1,-1,0,1,1,1};
    static int [] dc = {0,-1,-1,0,1,1,1,0,-1};
    static Queue<Dot>queue;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N=Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        map = new int[N][N];
        cloud = new boolean[N][N];
        ds = new int[M][2];

        for(int i = 0; i <N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j <N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i <M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            ds[i][0] = Integer.parseInt(st.nextToken());
            ds[i][1]= Integer.parseInt(st.nextToken());
        }

        //처음 구름 만들기
        makeCloud(N);

        for(int i = 0 ;  i <M;i++){

            //구름이동 및 +1
            moveCloud(ds[i][0],ds[i][1]);
            //대각선 체크
            checkDiagonal();
            //2만큼 빼기
            minusTwo();
        }


        System.out.println(total());
    }
/*
    public  static void printCloud(){
        for(int i = 0 ; i  <N ; i++){
            for(int j = 0 ; j<N;j++){
                System.out.print(cloud[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("@@@@@@@@@@@@@");
    }

    public  static void printMap(){
        for(int i = 0; i  <N ; i++){
            for(int j = 0 ; j<N;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("@@@@@@@@@@@@@");
    }
    */
    public static void makeCloud(int n){

        queue = new LinkedList<>();
        queue.add(new Dot(n-1,0));
        queue.add(new Dot(n-1,1));
        queue.add(new Dot(n-2,0));
        queue.add(new Dot(n-2,1));

    }
    public static void moveCloud(int d ,int s){

        int size = queue.size();

            for(int j = 0 ; j<size;j++){
                Dot cur = queue.poll();

                int nr = divide(cur.r + dr[d] * s);
                int nc = divide(cur.c + dc[d] * s);

                map[nr][nc]++;
                queue.add(new Dot(nr,nc));


            }


    }

    public static int divide(int num){
        while (num < 0)	num += N;
        return num % N;

    }
    public static boolean inWall(int r , int c){
        if(r >=N || c>=N || r<0 || c<0) return false;
        else {
            return true;
        }
    }

    public static void checkDiagonal(){
     while (!queue.isEmpty()){

            Dot d = queue.poll();
            cloud[d.r][d.c]=true;
            int count =0;

            for(int j=2 ; j<=8; j+=2){
                int nr =d.r+dr[j];
                int nc= d.c +dc[j];
                if(inWall(nr,nc) && map[nr][nc]>0){
                    count++;
                }

            }
            map[d.r][d.c]+=count;
        }
    }

    public static void minusTwo(){

        for(int r =0 ; r<N; r++){
            for(int c= 0;  c<N;c++){

                if(cloud[r][c]){
                    cloud[r][c]=false;
                }
                else {
                    if(map[r][c]>=2) {
                        map[r][c]-=2;
                        queue.add(new Dot(r,c));
                    }
                }
            }
        }
    }

    public static int total(){
        int answer=0;

        for(int r =0; r <N;r++){
            for(int c =0; c<N;c++){
                answer+=map[r][c];
            }
        }
        return answer;
    }
}
