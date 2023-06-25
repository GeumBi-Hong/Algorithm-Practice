package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 영단어 암기는 괴로워
 */
public class Main20920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //단어의 개수
        int M = Integer.parseInt(st.nextToken()); // 단어의 길이

        Map<String,Integer> map = new HashMap<>();



        for(int i = 0; i  < N; i++){
            String word = br.readLine();

            //M이상의 길이의 단어만 비교할꺼기 때문
            if(word.length() >= M){
                map.put(word, map.getOrDefault(word,0) + 1);
            }
        }

        List<String> wordList = map.keySet().stream().collect(Collectors.toList());


        wordList.sort(((o1, o2) -> {

            //자주 나오는 단어일수록 앞에 배치한다.
            //해당 단어의 길이가 길수록 앞에 배치한다.
            //알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다

            int wordAFreq = map.get(o1);
            int wordBFreq = map.get(o2);

            //빈도수가 같다면
            if(wordAFreq == wordBFreq){

                //길이 마저 같다면 사전순으로 정렬
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                //단어의 길이가 길수록
                return o2.length() - o1.length();
            }

            //1. 자주 사용된 빈도수를 기준으로 먼저 정렬
            return wordBFreq - wordAFreq;
        }));


        //정답 출력

        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);


    }
}
