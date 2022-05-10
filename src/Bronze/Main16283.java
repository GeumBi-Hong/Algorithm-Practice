package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16283 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int count = 0;

        int ans1 = 0;
        int ans2 = 0;



    for(int i = 1; i<n;i++){
        if((a*i)+(b*(n-i))==w){
            count++;
            ans1=i;
            ans2=n-i;
        }
        if(count==2)break; //두개의 해를 가지면 종료
    }

        if(count!=1){
            System.out.println(-1);
        }else {
            System.out.println(ans1+" "+ans2);
        }
    }
}
