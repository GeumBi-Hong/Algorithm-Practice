package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//리모콘 (부르트 포스)
public class Main1107 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine()); // 이동할 체널
        int M = Integer.parseInt(br.readLine()); //고장난 버튼의 개수
        boolean []  button = new boolean[10]; //0~9 true = 고장난 버튼

        if(M!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (M-->0){
                button[Integer.parseInt(st.nextToken())]=true;
            }
        }
        int min = Math.abs(N-100); // 초기 최소 값

        for (int i = 0 ; i <=999999;i++){ //0부터 999999까지 눌러본다.
            String str= String.valueOf(i);
            int len = str.length(); //버튼을 누른 수

            boolean isBroken =false;
            for (int j= 0 ; j<len;j++){
                if(button[str.charAt(j)-'0']){//고장난 버튼을 눌렀다면 반복문을 빠져나간다.
                    isBroken=true;
                    break;
                }
            }

            if(!isBroken){ //i를 눌렀을때 고장난 버튼 없이 눌렀다면
                int n = Math.abs(N-i)+len; // 총 버튼을 누른 횟수 = |이동할 채널 - 버튼을 누른후 채널| + 버튼 누른 수
                min = Math.min(min,n);

            }
        }
        System.out.print(min);
    }
}
