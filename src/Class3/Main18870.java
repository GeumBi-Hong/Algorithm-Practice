package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//좌표 압축
public class Main18870 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //좌표 개수
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        HashMap <Integer, Integer> hashMap = new HashMap<>();
        int rank = 0;

        int [] x = new int[N];//원래 배열
        int [] x_sorted = new int[N]; //정렬된 배열



        for(int i = 0 ; i <N ; i++){
            x[i] = x_sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x_sorted); // x좌표들을 정렬해준다.
        //정렬한대로 첫번째 수부터 rank = 0이다.


        for (int i = 0 ; i <N ; i++){
            if(!hashMap.containsKey(x_sorted[i])) { //x 좌표가 중복일경우는  put 하지 않는다.
                hashMap.put(x_sorted[i], rank);
                rank++;
            }
        }


        for(int key : x) {
            int r = hashMap.get(key);	//x 배열의 key값으로 순위값을 (rank)를 가져오면된다.
            sb.append(r).append(' ');
        }

     System.out.print(sb);



    }
}
