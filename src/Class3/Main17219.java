package Class3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


//비밀번호 찾기  (HashMap 을 이용해서 품)
public class Main17219 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소 수
        int M = Integer.parseInt(st.nextToken()); //비밀번호를 찾으려는 사이트의 주소 수

        HashMap<String, String> hashMap = new HashMap<>(); //  주소와 그에 해당하는 비밀번호를 저장할 hashmap

        while (N -->0){ //(주소 , 비밀번호)
            st = new StringTokenizer(br.readLine(), " ");
            hashMap.put(st.nextToken(), st.nextToken());
        }


        while (M-->0){
            bw.write(hashMap.get(br.readLine())+"\n");
        }

        bw.flush();
        bw.close();



    }
}
