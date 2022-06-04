package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15686 {
    static class Dot {
        int r;
        int c;

        public Dot (int r ,int c){
            this.r = r;
            this.c = c;

        }
    }

    static List<Dot> chickenList = new ArrayList<>();
    static List<Dot> houseList = new ArrayList<>();

    static int N,M;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j <N;j++){
                int n = Integer.parseInt(st.nextToken());

                if(n==1) houseList.add(new Dot(i,j));
                if(n==2) chickenList.add(new Dot(i,j));

            }
        }


            int []index = new int[M];
            backTracking(0,0,M,index);


        System.out.println(answer);

    }
    private static void backTracking(int depth,int start,int finish,int []index){

        if(depth==finish){
           int total_Distance = 0;

            for(int  h = 0 ; h<houseList.size();h++){ //집

                int  houseR = houseList.get(h).r;
                int  houseC = houseList.get(h).c;
                int minDistance = Integer.MAX_VALUE;

                for(int c = 0 ; c<finish;c++){//치킨

                    int chickR = chickenList.get(index[c]).r;
                    int chickC = chickenList.get(index[c]).c;

                    int d = Math.abs(houseR-chickR)+Math.abs(houseC-chickC);
                    minDistance= Math.min(minDistance,d);

                }
                total_Distance += minDistance;

            }

            answer = Math.min(total_Distance,answer);

            return;
        }

        for(int i =  start; i <chickenList.size();i++){
            index[depth]=i;
            backTracking(depth+1,i+1,finish,index);
        }

    }
}
