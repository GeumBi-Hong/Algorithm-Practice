package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class 폰캣몬 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            HashSet<Integer> hashSet = new HashSet<>();

            //중복 포켓몬 제거
            for (int n : nums) {
                hashSet.add(n);
            }

            // N/2 보다 서로 다른 포켓몬 종류보다 더 크거나 같다고 하면  한다면 =>  포켓몬 수가 최대가 된다.
            // N/2 보다 서로 다른 포켓몬 종류가 더 작다고 한다면 => N/2 가 최대가 된다.
            return nums.length / 2 >= hashSet.size() ? hashSet.size() : nums.length / 2;
        }
    }
}
