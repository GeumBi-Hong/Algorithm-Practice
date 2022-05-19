package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18111 {
    static int minH = Integer.MAX_VALUE;
    static int maxH = -1;
    static int N,M,B;
    static int []countBlock;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       countBlock =  new int[257]; //층에 몇개의 블록이 존재하는지

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


        for(int i = 0 ; i <N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j<M;j++){
                int num =Integer.parseInt(st.nextToken());


                countBlock [num]++;

                //최소 , 최대 높이 갱신
                minH = Math.min(minH,num);
                maxH = Math.max(maxH,num);
            }
        }


        int []answer = soultion(minH,maxH);

        System.out.println(answer[0]+" "+answer[1]);

    }
    private static int[] soultion(int min, int max){

        int totalTime = Integer.MAX_VALUE;
        int height = 0;

        for(int h =max; h>=min;h--){ // i에 대한 높이로 만드려고 할때


            int t = 0;
            int b = B;

            for(int i = min ; i<=max;i++){

                if(h > i){//만드려고하는 높이보다 작은 경우 인벤토리의 블록을 하나 씀 (+1초)
                    int dif = (h-i) * countBlock[i];
                    t+= dif;
                    b-=dif;

                }else if(h<i){//만드려고하는 높이보다 큰 경우 인벤토리에 넣음 (+2초)
                    int dif = (i-h) * countBlock[i];
                    t+=dif*2;
                    b+=dif;

                }
            }

            //만약 블록이 음수면 불가능함
            if(b<0)continue;
            else {

                if(totalTime>t){
                    totalTime=t;
                    height =h;

                }
            }

        }

        return new int[]{totalTime,height};

    }
}
