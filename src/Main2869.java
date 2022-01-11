import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2 1 5

A: 낮에 올라가는 높이
B: 밤에 내려가는 높이
V: 나무 총 높이

 */
public class Main2869 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());


        int answer = (V-B)/(A-B);

        if(V%(A-B)!=0){
            answer++;
        }


        System.out.print(answer);
    }
}
