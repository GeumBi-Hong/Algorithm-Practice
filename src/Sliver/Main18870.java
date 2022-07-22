package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 풀이시간:41분
 * 첫 풀이에 시간 초과 발생 -> 이중 포문 이용해서 완탐으로 자기보다 작은 숫자 세어주려했음....  N 이 1,000,000이라 시간초과
 */

public class Main18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         *  N 좌표 개수
         *  numList 좌표 정렬하기 위해서 리스트에 저장
         *  nums 처음 입력 받은 순서대로 저장되어있는 배열
         */
        int N = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] nums= new int[N];


        for(int i = 0 ; i < N ;i++){
            int n = Integer.parseInt(st.nextToken());
            nums[i]=n;
            numList.add(n);
        }

        /**
         * Collections.sort 최악 ,평균 시간 복잡도 O(nlog(n))Arrays.sort()보다 빠름.
         * Arrays.sort()는 평균 O(nlog(n)) 최악 O(n^2)
         * 그래서 그냥 Collections.sort씀
         */
        Collections.sort(numList);

        /**
         * 수를 오름 차순으로 정렬해서
         * 내 앞번호 인덱스는 결국 자신보다 작은 수들이 올테니까 이 점을 이용해서 개수를 세어줄거임
         * 근데 똑같은 수는 하나로 보기때문에 hashMap을 이용하여 중복을 피해 count 변수를 이용하여 중복인 애들은 개수를 세주지 않음
         * count  자기보다 작은 숫자들이 몇개인지 (중복 x)
         * hashMap ( 좌표 값 , 자기 자신보다 작은 수 의 개수 (중복된 수는 하나로 보는것에 주의할것))
         */
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < numList.size();i++){
            if(!hashMap.containsKey(numList.get(i))){
                hashMap.put(numList.get(i),count);
                count++;
            }
        }

        /**
         * hashMap.get(key)를 이용해서 순서대로 저장되어있는 nums배열의 값들을 차례로 value값을 찾아서 정답을 출력
         */

        StringBuilder sb = new StringBuilder();
        for(int key : nums) {
            int r = hashMap.get(key);
            sb.append(r).append(' ');
        }
        System.out.println(sb);

    }
}
