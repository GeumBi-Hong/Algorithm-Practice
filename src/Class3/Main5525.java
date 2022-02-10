package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//IOIOI
public class Main5525 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // io수
        int M = Integer.parseInt(br.readLine()); // 길이
        String s = br.readLine();
        char [] str = new char[M+1]; // 밑에 [i+1] 오버플로우 방지

        for (int i = 0 ; i <M;i++){
            str[i]= s.charAt(i);
        }
        int answer = 0 ;
        for (int i =1; i<M;i++){
            int count = 0 ; //IOI반복 횟수
            if(str[i-1]=='I'){ // I 를 먼저 찾는다.
                while (str[i]=='O'&&str[i+1]=='I'){  //그 뒤로 OI가 있는지 계속 찾는다. i=i+2
                    count++;
                    i=i+2;

                    if(count==N){ //반복횟수가 N 과 같다면
                        answer++;
                        count--;
                    }

                }
            }
        }
        System.out.print(answer);


    }
}
