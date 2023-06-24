package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 영단어 암기는 괴로워
 */
public class Main20920 {

    static class Word implements Comparable<Word>{

        private String word;
        private int freq;


        public Word(String word, int freq){
            this.word = word;
            this.freq = freq;
        }

        //여기가 핵심 정렬 조건을 compareTo를 재정의

        //자주 나오는 단어일수록 앞에 배치한다.
        //해당 단어의 길이가 길수록 앞에 배치한다.
        //알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
        @Override
        public int compareTo(Word o) {
            //만약에 단어의 빈도수가 같다면

            if(this.freq == o.freq){


            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());





    }
}
