package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 문제 추천 시스템 Version 1
 *
 * [문제 조건]
 * - recommend 1 : 추천 문제 리스트에서 가장 어려운 문제 번호 출력 -> 만약 그 문제가 여러개라면 문제 번호가 큰것 출력
 * - recommend -1 : 추천 문제 리스트에서 가장 쉬운 문제 번호 출력 -> 만약 그 문제가 여러개라면 문제 번호가 작은것 출력
 *
 * - add P L : 추천 문제 리스트에 난이도가 L인 문제 번호 P를 추가 , (이때 추천 문제 리스트에 없는 문제번호 P만 입력으로 주어짐, 이전에 있던 문제번호가 다른 난이도로 올 수 있음)
 *
 * [풀이]
 * - 걍 정렬 조건 대로 구현
 * - 처음에 어떤 자료구조 쓸까 고민 -> TreeMap ->TreeSet
 *
 *
 * [다른풀이]
 * - 우선순위 큐 두개를 써서 하는 방법도 좋은거같음
 */
public class Main21939 {

    static class Problem implements Comparable<Problem>{

        private int no;
        private int level;

        public Problem(int no, int level){
            this.no = no;
            this.level = level;
        }
        //난이도 높은게 제일먼저 , 같은게 여러개라면 문제번호가 큰거순으로 정렬
        public int compareTo(Problem problem) {

            if (this.level == problem.level) {
                return problem.no - this.no;
            } else {
                return problem.level - this.level;
            }
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        TreeSet<Problem> questionSet = new TreeSet<>();
        Map<Integer,Integer> map = new HashMap<>();

        //[1] 추천 문제 리스트에 있는 문제 담기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken()); //문제번호
            int L = Integer.parseInt(st.nextToken()); //난이도

            questionSet.add(new Problem(P,L));
            map.put(P,L);
        }
        //[2] 명령어 실행하기
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("recommend")) {
                //print

                int num = Integer.parseInt(st.nextToken());
                if(num == 1)  sb.append(questionSet.first().no);
                else sb.append(questionSet.last().no);

                sb.append("\n");

            } else if (command.equals("solved")) {
                //remove
                int number = Integer.parseInt(st.nextToken());
                questionSet.remove(new Problem(number,map.get(number)));
                map.remove(number);
            } else {
                //add
                int no = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                questionSet.add(new Problem(no, level));
                map.put(no,level);
            }

        }

        System.out.println(sb);

    }
}


/*
 *public class Main21939 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer,Integer> questionMap = new TreeMap<>(new Comparator<Integer>() {

            //문제 난이도가 어려운 순으로 정렬 , 그리고 그게 같은게 있다면 문제 번호가 큰거
            @Override
            public int compare(Integer o1, Integer o2) {

                int levelA = questionMap.get(o1);
                int levelB = questionMap.get(o2);

                //만약 난이도가 같다면 , 문제 번호가 큰걸로
                if (levelA == levelB){
                    return o2 - o1;
                }

                return levelB - levelA;
            }
        });

        //[1] 추천 문제 리스트에 있는 문제 담기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken()); //문제번호
            int L = Integer.parseInt(st.nextToken()); //난이도

            questionMap.put(P,L);
        }
        //[2] 명령어 실행하기
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("recommend")) {
                //print

                int num = Integer.parseInt(st.nextToken());
                if(num == 1)  sb.append(questionMap.firstKey());
                else sb.append(questionMap.lastKey());

                sb.append("\n");

            } else if (command.equals("solved")) {
                //remove
                questionMap.remove(Integer.parseInt(st.nextToken()));
            } else {
                //add
                questionMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

        }

    }
}

*오늘의 삽질 : comparator로 value정렬이 안되는구나 value를 가져오려면 map.get을 해야되는데 이게 안됨 -> Variable 'questionMap' might not have been initialized 요론게 뜸
 */
