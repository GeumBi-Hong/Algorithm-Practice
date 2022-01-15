package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();


        while (true){

            int index=0; // stack 위치를 저장하기 위한 변수
            char [] stack = new char[100];
            str = br.readLine();

            if (str.equals(".")){ // "." 입력의 끝
                break;
            }

            for (Byte b : str.getBytes()){

              if(b == '('){
                  stack[index] =')';
                  index++;

              }else if(b == '['){
                  stack[index] = ']';
                  index++;
                }
              else if (b == ')'|| b==']'){
                  if (index > 0 && stack[index-1]==b){
                      index--; //pop
                  }else{
                      index=-1;
                      break;
                  }
              }
                }

            if (index ==0){
                sb.append("yes\n");
            }else {
                sb.append("no\n");
            }


        }
            System.out.print(sb);
        }

    }

