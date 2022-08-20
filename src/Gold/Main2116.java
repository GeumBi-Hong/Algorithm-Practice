package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2116 {

    static int answer = 0;
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  N = Integer.parseInt(br.readLine());

        int [][]dice = new int[N][6];

        for(int i = 0  ; i <N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;  j <6; j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0 ; i<6;i++){
            diceSoultion(i,findOpposite(i),0,dice,N);

        }

        System.out.println(answer);

    }
    private static void diceSoultion(int top ,int down,int cur,int[][]dice,int N){

        int sum = 0;
        int max = 0;
        //윗면과 아랫면을 제외한 최대값 찾기 (첫 주사위)
        for(int i = 0 ; i <6; i++){
            if(i==top||i==down)continue;
            max=Math.max(max,dice[cur][i]);

        }

        sum+=max;

        while (cur<N-1){
             max = 0; //매 주사위 마다 옆면의 최대값을 찾아 줄 꺼니까 0으로 초기화 해줌

            //아래에 있는 주사위를 설정하고 다음 부터는 아래에 있던 주사위에 윗면이 다음 주사위의 아랫면이 됨
            down =findIndex(dice[cur][top],cur+1,dice);
            cur++;
            top= findOpposite(down); //해당 아랫면의 윗면을 찾음


            for(int i = 0 ; i <6; i++){
                if(i==top ||i==down) continue; //윗면과 아랫면을 제외하면 옆면의 최대값을 찾아준다.
                max=Math.max(max,dice[cur][i]);
            }

            sum+=max; //최대 수를 가진 옆면의 값을 더함

        }

        answer = Math.max(sum,answer);
    }

    private static int findOpposite(int n){
        //문제에서 주어진 도면에 따라 반대면에있는 인덱스를 접근할 수 있도록 하는 함수
            switch (n){
                case 0 :
                    return 5;
                case 1:
                    return 3;
                case 2:
                    return 4;
                case 3:
                    return 1;
                case 4:
                    return 2;
                case 5:
                    return 0;
            }
            return -1;
    }

    private static int findIndex (int n ,int cur ,int [][]dice ){
        //해당하는 숫자를 가진 면의 인덱스 번호를 반환하는 함수
        for(int i = 0 ; i <6;i++){
            //해당 면의 숫자를 가진 인덱스를 찾는다.
            if(dice[cur][i]==n){
                return i;

            }
        }
        return -1;
    }
}

