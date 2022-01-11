import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 121
1231
12421
0
*/

public class Main1259 {
     public static void main(String[] args) throws IOException {

          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringBuffer sb ;
          StringBuilder stringBuilde = new StringBuilder();
          String str ="";


          while(true){
                str = br.readLine();
                if( str.equals("0")){
                     break;
                }
                sb = new StringBuffer(str);
               if(str.equals(sb.reverse().toString())) {
                    stringBuilde.append("yes\n");
               }
               else {
                   stringBuilde.append("no\n");
               }
          }


          System.out.print(stringBuilde);

     }
}
