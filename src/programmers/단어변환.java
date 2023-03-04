package programmers;
import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 2023-03-04(토)
 * 시작 :오후 10시 43분
 * 끝 : 오후 11시 32 분
 *
 * [생각 과정 ]
 * 문제를 읽고 처음에 깊이우선 / 너비 우선 탐색으로 진행해서 풀어야 겠다는 생각은 안들었다.
 * 떠오르는 풀이가 생각나지 않아서 완전탐색 기준으로 문제를 접근했다.
 *
 * 간단히 요약하면 begin -> target까지 변경하는데 몇번 변경 할 수 있는지 구하는 문제였다.
 * 조건은 : 알바펫은 딱 1개만 달랐을때 변경가능하다는 점 . 따라서 문자열의 길이가 최대 10이기 때문에 최악의 경우도 10이다.
 *
 *
 * 단어의 개수는 최악의 경우 50개였으며 이를 모두 완전탐색을 하는 경우는
 * hit -> 50개 단어 탐색 ->50개 단어 탐색->탐색... 진짜 최악이라 했을때 50 ^ 50 (가지 치기 안하고)
 * 작은 수의 제약 조건이였지만 완전 탐색을 한다면 시간 초과라고 판단했다.
 *
 * 그래서 begin부터 target까지 갈 수 있는 단어를 선택하면서 최소의 깊이를 구하면 되지않을까 하였다.
 * dfs로 접근했다가 bfs로 접근했다.
 * bfs는 내가 정답을 찾는 순간 (target)을 만나는 순간이 최소의 변경 횟수 일테니까 말이다.
 *
 *
 * 따라서
 * 1. 단어가 변경 하는하는지 판단하는 함수
 * 2. 너비 우선탐색 함수
 *  - 큐에 begin을 넣음 -> begin을 넣고 너비우선탐색 : 즉 변경가능하고 방문하지 않은 단어를 선택하여 큐에 넣음 -> 반복작업 하다가  target을 만나면 depth출력(정답)
 *  -
 * 를 만들어서 정답을 구했다.
 */
public class 단어변환 {

    static class Node {

        String word;
        int depth;


        public Node (String word ,int depth){

            this.word =word;
            this.depth = depth;
        }
    }


    public int solution(String begin, String target, String[] words) {


        return bfs(words.length,begin,target,words);
    }

    private static int bfs (int length , String begin , String target , String []words ){

        Queue <Node>  queue = new ArrayDeque<>();
        boolean [] isVisited = new boolean [length];
        queue.add (new Node (begin ,0));

        int count = 0;

        while(!queue.isEmpty()){

            Node curNode = queue.poll();
            String curWord = curNode.word;
            int curDepth = curNode.depth;

            //만약 target 문자열을 만났다면 depth를 리턴한다.
            if(curWord.equals(target)) return curDepth;



            for(int i = 0 ; i < length; i++){

                String nextWord =  words[i];

                //방문되지 않았고 변경할 수 있는 문자열의 경우만 탐색을 진행한다.
                if(!isVisited[i] && canChange(curWord,nextWord)){
                    queue.add(new Node(nextWord,curDepth+1));
                    isVisited[i]=true;
                }

            }
        }
        return 0;
    }

    //한 개의 알파벳만 다른지 체크 하는  함수
    private static  boolean canChange(String cur, String next){

        int length = cur.length();

        //다른 알파벳의 개수
        int count = 0 ;

        for(int i = 0 ; i < length; i++){
            if(cur.charAt(i) != next.charAt(i)) count++;
        }

        return count == 1? true : false;
    }
}
