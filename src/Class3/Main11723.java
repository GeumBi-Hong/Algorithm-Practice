package Class3;

import java.io.*;
//집합 (비트 마스킹)
public class Main11723 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine()); //연산
        int bit = 0;//32bit

        while (M -- > 0) {
            String[]str = br.readLine().split(" ");
            int n ;
            switch (str[0]){
                case "add": //원소 넣기
                    n= Integer.parseInt(str[1]);
                    bit |= (1<<(n-1));  // 1이 0번째 자리
                    break;
                case "remove": //원소 제거
                    n = Integer.parseInt(str[1]);
                    bit = bit &~ (1<<(n-1));
                    break;
                case "check": //원소 확인
                    n = Integer.parseInt(str[1]);
                    sb.append((bit & (1 << (n - 1))) !=0 ? "1\n" : "0\n");
                    break;
                case "toggle": //원소를 제거 , 없다면 추가
                    n = Integer.parseInt(str[1]);
                    bit ^=(1<<(n-1));
                    break;
                case "all": //1~20으로 바꾸기
                    bit |= (~0);
                    break;
                case "empty": //비우기
                    bit &= 0;
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
