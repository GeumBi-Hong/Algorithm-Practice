package Class2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int []stack = new int[N];

        int number =0;
        int index= 0;

        while (N-->0){

            int stackNum = Integer.parseInt(br.readLine());

            if (number <stackNum){
                for (int i = number+1 ; i <=stackNum;i++){
                    stack[index]= i;
                    index++;
                    sb.append("+\n");
                }
                number = stackNum;

            }else if(stack[index-1]!=stackNum){
                System.out.print("NO");
                System.exit(0);
            }

            index--;
            sb.append("-\n");
        }

        System.out.println(sb);

    }
}