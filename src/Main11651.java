import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main11651 {
  public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      StringTokenizer  st;
      StringBuilder sb = new StringBuilder();

      int [][] dot = new int[N][2];


      for ( int i = 0 ; i<N ; i++){

       st = new StringTokenizer(br.readLine()," ");

        dot[i][0]= Integer.parseInt(st.nextToken());
        dot[i][1]= Integer.parseInt(st.nextToken());

      }

     Arrays.sort(dot, new Comparator<int[]>() {
         @Override
         public int compare(int[] o1, int[] o2) {
             if(o1[1]==o2[1]){
                 return o1[0]-o2[0];
             }else {
                 return o1[1]-o2[1];
             }

         }
     });


      for (int i =0 ; i<N;i++){
          sb.append(dot[i][0]+" "+dot[i][1]+"\n");


      }

      System.out.print(sb);



  }
}
