package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main16457 {
    static int n , m, k;
    static int [][]quest ;
    static int [] index ;
    static int answer = 0;
    static  int maxSkill=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        quest = new int[m][k];
        index= new int[n];

        maxSkill = n*2;

        for(int i = 0 ; i <m;i++){
             st = new StringTokenizer(br.readLine()," ");
             for(int j  = 0 ; j<k ;j++) {
                 int n = Integer.parseInt(st.nextToken());
                 quest[i][j]=n;

             }
        }
        backTracking(0,1);
        System.out.println(answer);

    }
    private static void backTracking(int depth,int start){
        if(depth ==n){
            answer=Math.max(answer,countCompleteQuest(index));
            return;
        }

        for(int i =start ; i<=maxSkill;i++){
            index[depth]=i;
            backTracking(depth+1,i+1);

        }
    }
    private static int countCompleteQuest(int [] index){
        int count = 0 ;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<n;i++){
            list.add(index[i]);
        }

        for(int r = 0 ; r<m;r++){
            int c = 0;
            for(int i = 0 ; i<n;i++){
                for(int  j =0;j<k;j++){
                    if(index[i]==quest[r][j]) c++;
                }
            }
            if(c==k) count++;

        }

      return count;
    }
}
