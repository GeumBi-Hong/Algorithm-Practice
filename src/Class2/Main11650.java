package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11650 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Dot [] d =new Dot[N];

       for (int i = 0 ; i< N; i++){
            st = new StringTokenizer(br.readLine()," ");
           d[i] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }

        Arrays.sort(d);
       for (Dot dot : d){
           sb.append(dot.x+" "+dot.y).append("\n");
       }

        System.out.print(sb);
    }

    static class Dot implements Comparable<Dot>{
        int x;
        int y;
         public Dot (int x, int y){
             this.x= x;
             this.y= y;
         }

         @Override
        public int compareTo (Dot d){
             if(this.x ==d.x){
                 return this.y - d.y;
             }
             else {
                 return this.x -d.x;
             }
         }
    }
}
