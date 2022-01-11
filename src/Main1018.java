import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1018 {
    static int min = 64;
    static boolean arr[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

         arr = new boolean[N][M];


        //체스판 배열에 저장
        for(int i = 0;i<N;i++){
            char c[] = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                if(c[j]=='B'){
                    arr[i][j]=true;
                }else{
                    arr[i][j]=false;
                }

            }
        }



        //잘라낸 체스판의 첫번째 좌표값을 큐에 저장한다.
        for (int i =0 ; i<N-7;i++){
            for(int j=0;j<M-7;j++){
                chess(i,j);


            }
        }
        System.out.println(min);

    }

    public static void chess(int x, int y) {
        //마지막 좌표
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        //첫번째 칸 색 판별
        boolean  first_block = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {

                // 올바른 색이 아닐경우 count 1 증가
                if (arr[i][j] != first_block) {
                    count++;
                }

              //칸을 넘어갈때마다 색이 바껴야 하므로
                //값을 매번 true -> false / false -> true 로 변경하여준다.
                first_block = !first_block;
            }
          //맨 끝 칸의 색이 다음칸의 첫번째 칸이 되므로 변경해준다.
            first_block = !first_block;
        }

        //첫번째칸을 기준으로한 count와 첫번째칸의 반대인 색을 기준으로한 count중
        //최소값으로 갱신시킨다..
        count = Math.min(count, 64 - count);

       //최소값 갱신
        min = Math.min(min, count);
    }

}
