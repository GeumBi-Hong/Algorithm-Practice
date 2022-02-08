package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//나는야 포켓몬 마스터 이다솜 (해시)
public class Main1620 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 도감에 수록되어 있는 포켓몬 개수
        int M = Integer.parseInt(st.nextToken()); // 내가 맞춰야하는 문제의 개수


        HashMap<String, Integer> strHashMap = new HashMap<>(); //(포켓몬 이름 , 번호 )
        HashMap<Integer,String>  numHashMap = new HashMap<>(); //(번호 , 포켓몬 이름)
        String[] str = new String[N+1];


        for (int i =1;i<=N;i++){
            String name = br.readLine();
            strHashMap.put(name,i);
            numHashMap.put(i, name);
        }

        while (M-->0){//맞춰야하는 문제의 개수 만큼
            String q = br.readLine();
            char c = q.charAt(0); //처음 문자가 숫자인지 대문자인지 판별할것임
            if ('0' <= c && c <= '9') { // 숫자라면
                int num = Integer.parseInt(q);
                sb.append(numHashMap.get(num)).append('\n');
            } else { //문자열이라면
                sb.append(strHashMap.get(q)).append('\n');
            }
        }

        System.out.print(sb);

    }

}
