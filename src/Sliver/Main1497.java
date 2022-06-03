package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1497 {
    static int N,M;
    static String [] gitar;
    static int [] index;
    static int answer = -1;
    static boolean flag ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gitar = new String[N];

        for(int i = 0 ; i <N; i++){
            st = new StringTokenizer(br.readLine()," ");
            st.nextToken();
            gitar[i]= st.nextToken();
        }

        int maxSong = 0;

     //최대로 몇개의 곡을 연주할 수 있는지 구한다.
            for(int k = 0 ; k<M;k++){
                for(int i = 0 ; i <N ;i++){
                    if(gitar[i].charAt(k)=='Y') {
                        maxSong++;
                        break;
                    }

                }
            }

    if(maxSong>0){
        for(int i = 1; i<=N;i++){
            index = new int[i];
            backTracking(0,i,0,maxSong);
            if(flag)break;
        }
    }


        System.out.println(answer);

    }
    private static void backTracking(int depth,int finish,int start,int maxSong ){

        if(depth==finish){
            int count = 0;

            for(int k = 0 ; k<M;k++){
                for(int i = 0 ; i <finish ;i++){
                    if(gitar[index[i]].charAt(k)=='Y') {
                        count++;
                        break;
                    }

                }
            }
            //선택한 기타만으로 최대로 연주할수있는 곡 수를 연주할 수 있다면
            //그 기타의 개수를 정답으로 저장한다.
            if(count==maxSong){
                answer =finish;
                flag=true;
            }
            return;
        }

        for(int i = start ; i <N;i++){
            if(flag)return;
            index[depth]=i;
            backTracking(depth+1,finish,i+1,maxSong);
        }

    }
}
