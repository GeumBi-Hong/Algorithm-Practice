package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13300 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //총 학생 수
        int K = Integer.parseInt(st.nextToken()); // 한 방에 들어갈 최대 인원수


        int [][] student = new int[7][2];
        //학생 정보를 저장
        // 0이면 여자 1이면 남자
        while (N --> 0){
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            student[grade][sex]++;
        }

        int totalRoom =0 ;
        for(int grade = 1; grade <=6;grade++){
            for(int sex = 0 ; sex <2; sex++){
                totalRoom+=student[grade][sex]/K;
                if(student[grade][sex]%K!=0){ //나머지가 있는 경우
                    totalRoom++;
                }
            }
        }

        System.out.println(totalRoom);

    }
}
