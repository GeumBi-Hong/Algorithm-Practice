package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3135 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); //현재 주파수
        int B = Integer.parseInt(st.nextToken()); // 가고 싶은 주파수

        int N = Integer.parseInt(br.readLine()); //미리 지정되어있는 주파수 의 개수
        int [] button = new int[N];

        for(int i = 0 ; i  <  N ; i++){
            button[i]=Integer.parseInt(br.readLine());
        }


        //일단 갈 수 있는 버튼 중에서 B와 가장 거리가 작은 버튼을 찾아준다.
        int min = Integer.MAX_VALUE;
        int index = -1;
        int answer = Integer.MAX_VALUE;

        int buttonCount = 1; //버튼을 누름
        for(int i = 0 ; i < N ;i++){
            //지정된 주파수 중에 가장 주파수 거리가 짧은 버튼의 인덱스 번호를 구한다.
            if(min>Math.abs(button[i]-B)){
                min=Math.abs(button[i]-B);
                index=i;
            }

        }
            //가까운 주파수 버튼과 가고싶은 버튼의 차이를 더한다.
            buttonCount+= Math.abs(button[index]-B);



        //A-B로 한번에 가는 경우와 버튼을 통해서 가는 경우중에 최소값을 정답을 찾으면된다.
        answer=Math.min(buttonCount,Math.abs(A-B));

        System.out.println(answer);


    }
}
