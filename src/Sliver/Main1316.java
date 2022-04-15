package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1316 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;


        while (N-->0){
            //알파벳이 바뀌었을때 전에 사용했던 알파벳인지 체크하기 위한 배열
            boolean [] alpa =  new boolean[26];
            char [] c =br.readLine().toCharArray();

            //그룹단어
           boolean isWord =true;

            for(int i = 1 ; i < c.length;i++){

                if(alpa[c[i]-97]) { //전에 사용했던 알파벳이였는 경우
                    isWord= false;
                    break;
                }


                if(c[i]==c[i-1])continue; //이전의 알파벳과 지금의 알파벳이 같을경우는 넘어간다.
                else {
                    alpa[c[i-1]-97]=true; //다르다면 다른 알파벳이 나오므로 전의 알파벳을 사용했다는것을 체크해준다.
                }



            }

            if(isWord) answer++;


        }

        System.out.print(answer);

    }
}
