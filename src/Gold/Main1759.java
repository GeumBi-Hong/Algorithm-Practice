package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1759 {

    static int L,C;
    static List<Character> alpaList = new ArrayList<>();
    static char [] answer  ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer = new char[L];

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0  ; i <C ;i++){
            alpaList.add(st.nextToken().charAt(0));
        }

        Collections.sort(alpaList);
        backTracking(0,0);
        System.out.println(sb);


    }

    private static void backTracking(int depth,int start){
        if(depth==L){
         if(check(answer)){
             sb.append(answer).append("\n");

         }
         return;
        }

        for(int i = start ; i <C;i++){
            answer[depth]=alpaList.get(i);
            backTracking(depth+1,i+1);

        }
    }
    private static boolean check (char[] c){
        int vowels = 0 ;
        int consonants = 0 ;
        for(int i = 0 ; i <L;i++){

            if(answer[i]=='a'||answer[i]=='e'||answer[i]=='i'||answer[i]=='o'||answer[i]=='u')vowels++;
            else consonants++;

        }
        if(vowels>=1 && consonants>=2)return true;

        return false;
    }
}
