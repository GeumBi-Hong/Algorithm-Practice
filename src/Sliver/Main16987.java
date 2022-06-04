package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main16987 {
    static class Egg {
        int dur;//내구도
        int weight ;//무개

        public Egg (int dur ,int weight){
            this.dur = dur;
            this.weight= weight;
        }
    }
    static int N ;
    static List<Egg> eggList = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            eggList.add(new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        backTracking(0,0);
        System.out.println(answer);
    }

    private  static void backTracking(int depth,int breakEgg){

        if(depth==N){
          answer= Math.max(breakEgg,answer);
            return;
        }
        //손에 쥔 계란이 깨져있는 경우 넘어감  or 다른 모든 계란이 깨진경우 넘어감
        if(eggList.get(depth).dur<=0||breakEgg==N-1){
            backTracking(depth+1,breakEgg);
            return;
        }


        int count = breakEgg;
            for(int i = 0 ; i <N;i++){
                if(i==depth)continue; //자기 자신치는건 넘어가야함
                if(eggList.get(i).dur<=0)continue;//깨야할 계란의 내구도가 없는경우도 넘어감

                eggList.get(depth).dur -= eggList.get(i).weight;
                eggList.get(i).dur -= eggList.get(depth).weight;

                if( eggList.get(depth).dur<=0)breakEgg++;
                if( eggList.get(i).dur<=0)breakEgg++;
                backTracking(depth + 1,breakEgg);

                //다시 돌려 놓음
                eggList.get(depth).dur += eggList.get(i).weight;
                eggList.get(i).dur += eggList.get(depth).weight;
                breakEgg = count;
            }



    }
}
