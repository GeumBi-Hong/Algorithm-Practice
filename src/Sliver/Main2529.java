package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2529 {
    static int N;
    static char[] sign;
    static boolean[] isVisited = new boolean[10];
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sign = new char[N];
       for(int i = 0 ;  i <N ;i++){
           sign[i]= st.nextToken().charAt(0);
       }

        backTracking(0,"");
        Collections.sort(list);

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));


    }

    private static void backTracking(int depth,String str) {

        if (depth == N + 1) {
           list.add(str);
           return;

        }


        for (int i = 0; i <= 9; i++) {
            if (isVisited[i]) continue;
            if (depth == 0 || compareInt(str.charAt(depth-1), (char)(i+'0'), sign[depth - 1])) {
                isVisited[i] = true;
                backTracking(depth + 1,str+i);
                isVisited[i] = false;
            }
        }


    }

    private static boolean compareInt(char a, char b, char c) {

        if (c == '>') {
            if(a>b)return true;

        }else if ( c=='<'){
            if(a<b)return true;
        }
        return false;
    }
}