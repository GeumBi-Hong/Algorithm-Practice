package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


/**
 * 크게 만들기
 *
 * 프로그래머스의  https://school.programmers.co.kr/learn/courses/30/lessons/42883?language=java 와 똑같다.
 *
 * [문제 조건]
 * N과 K는 최소 1부터 50만까지
 *
 */
public class Main2812 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //자릿 수
        int K = Integer.parseInt(st.nextToken()); //삭제해야할 숫자 개수


        char[] number = br.readLine().toCharArray();

        Deque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < N ; i++){
            //삭제해야될 문자 개수가 있다면
            //그리고 이전에 저장된 문자보다 지금 문자가 더 크다면 이전 문자를 지우고 본인 (더 큰거)를 넣음
            while (K > 0 && !deque.isEmpty() && deque.peekLast() < number[i]){
                deque.removeLast();
                K--;
            }
            deque.add(number[i]);
        }

        StringBuilder sb = new StringBuilder();

        //만약에 k만큼 다 못지우는 경우가 생길 수 있음
        //그럼 그 숫자는 지운상태에서 출력해야됨

        while(deque.size() > K){
            sb.append(deque.removeFirst());
        }

        System.out.println(sb);

    }
}
