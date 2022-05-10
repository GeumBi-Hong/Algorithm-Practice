package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  []dwarf = new int[9];
        int sum = 0; //9명 난쟁이 모자 총합

        for(int i = 0 ; i < 9 ;i++){
            int n = Integer.parseInt(br.readLine());
            dwarf[i]=n;
            sum+=n;
        }

        //오름차순으로 정답을 출력해 주여야하므로 미리 정렬을 시켜준다.
        Arrays.sort(dwarf);
        int fake1=0;
        int fake2=0;
        //9명중 2명을 뺄 난쟁이를 선택한다. (완탐)
        for(int i = 0 ; i < dwarf.length-1;i++){
            for(int j =i+1; j <dwarf.length;j++){
                if(sum - dwarf[i]- dwarf[j]==100){
                    //2명의 난쟁이 인덱스 번호를 저장한다.
                    fake1=i;
                    fake2=j;
                }
            }
        }

        for(int i = 0 ; i < dwarf.length;i++){
            //가짜는 출력하지 않는다.
            if(i==fake1||i==fake2)continue;
            System.out.println(dwarf[i]);
        }

    }
}
