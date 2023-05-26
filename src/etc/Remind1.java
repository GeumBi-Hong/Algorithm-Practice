package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 최소 비용
 * 5
 * cabba -> aabcb
 * 답 : 8
 *
 *
 *
 *
 * 7
 * abcdefg
 * gfedcba
 *
 * 답 : 24
 *
 *
 * 4
 *
 *
 * 4
 * xxxy
 * xyxx
 *
 *
 *
 * 왼쪽에서 오른쪽으로 문자열을 변경하고 자할때 이동시킬 문자의 거리의 최소 비용을 구하는 문제
 */



//문자가 알파벳만 나온다는 가정하에 풀이
// n의 범위 100만
public class Remind1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int alpa = 27;
        int n  = Integer.parseInt(br.readLine());
        String beforeStr = br.readLine();
        String afterStr = br.readLine();



        ArrayList<Integer>[] beforeLists = new ArrayList[alpa];
        ArrayList<Integer>[] afterLists = new ArrayList[alpa];


        //초기화
        for (int i = 0; i < alpa; i++) {
            beforeLists[i] = new ArrayList<>();
            afterLists[i] = new ArrayList<>();
        }

        //해당 알바펫이 언제 나오는지, 인덱스 값을 저장한다.
        //예를들어 b라는 알파벳이 2 6 9 번 인덱스 에서 나온다고 하면
        //beforeLists[ b를 -> 1 로 변경에서 저장] . add(2) , add(6) , add(9) 이런식으로 차례로 저장해둔다.
        //afterLists 도 마찬가지
        for(int i = 0; i < n ; i++){
            beforeLists[beforeStr.charAt(i)-'a'].add(i);
            afterLists[afterStr.charAt(i)-'a'].add(i);

        }


        //최소 비용은
        //문자를 이동시킬때 교차가 발생하지 않는 방식으로 이동시켜야 최소 비용이 든다.
        //따라서 이전의 문자의 인덱스 위치와 변경해야되는 문자의 인덱스 위치의 차를 차례로 구해서 합산을 해야한다.
        int ans = 0 ;
        for(int i = 0; i < alpa; i++){
            for(int j = 0 ; j < beforeLists[i].size();j++){
                int  x = beforeLists[i].get(j);
                int  y = afterLists[i].get(j);

                ans += Math.abs(x-y);
            }
        }

        System.out.println(ans);

    }
}
