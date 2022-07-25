package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2661 {
    static boolean endCheck = false;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        backTracking(N,1,"");


    }


    private static void backTracking(int finish,int size,String beforeStr){
        if(endCheck){
            return;
        }

        if(size-1==finish){
            System.out.println(beforeStr);
            endCheck = true;
            return;
        }

        //1~3의 숫자를 가지고 만들기 때문
        for(int  n = 1 ; n <=3; n++){
            //일단 만듬 (전의 문자열+ 현재 올 수 있는 숫자(1~3)
            String nextStr = beforeStr+n;
            boolean check = false ; //true면 나쁜수열이 된다는 뜻


            //절반에 대해서만 비교해 주면 됨

            //비교할 문자열 구간 범위
            for(int i = 1 ; i<=size/2;i++){
                String behind = nextStr.substring(size-i,size);
                int index = size-i;
                String front = nextStr.substring(index-i,index);

                if(behind.equals(front)){
                    //같다면 break;
                    check =true;
                    break;
                }

            }//for
            if (check){
                continue;
            }else {
                backTracking(finish,size+1,nextStr);
            }

        }
    }
}
