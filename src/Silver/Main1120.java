package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1120 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");

        String a = st.nextToken(); //얘가 더 작거나 같다.
        String b = st.nextToken();

        int min = a.length();


      for(int i = 0; i <= b.length()-a.length();i++){

            int count = 0;
          for(int j = 0 ; j <a.length();j++){
              if(b.charAt(i+j)!=a.charAt(j)){
                  count++;
              }
          }

          min=Math.min(min,count);

      }
      System.out.println(min);
    }
}
