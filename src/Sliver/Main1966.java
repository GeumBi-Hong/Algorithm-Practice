package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 풀이시간 :47분
 * 자료구죠 큐를 사용하는 문제
 */
public class Main1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //테스트 케이스 수 만큼 반복한다.
        while (T-->0){

            /**
             *  N 문서의 개수
             *  findIndex 몇 번째로 인쇄되었는지 궁금한 문서의 인덱스 번호
             *  numArray 우선순위가 높은 (수가 큰) 대로 정렬하기 위해 만든 배열
             */
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int findIndex = Integer.parseInt(st.nextToken());
            Integer [] numArray = new Integer[N];

            /**
             Queue<int[]>  int[0] 문서의 우선 순위  int[1] 처음 자기 인덱스 번호
             */
            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N; i++){
                int n = Integer.parseInt(st.nextToken());
                numArray[i]=n;
                queue.add(new int[]{n,i});
            }

            //어떤 문서가 먼저 나와야되는지 알기 위해 내림차순으로 정렬시킴  .
            Arrays.sort(numArray, Collections.reverseOrder());


            /**
             *  index numArray의 다음 인덱스를 가르키기위한 변수
             *  max = 먼저 나와야할 문서의 우선순위
             *  count = 1; 출력된 문서의 개수  (몇번째로 나오는지 체크하기 위해 만듬)
             */

            int index =0;
            int max = numArray[index];
            int count = 1;

                //큐가 비어있지않을때까지 반복
                while (!queue.isEmpty()){
                    //1.맨앞에 있는 문서에 대한 정보를 가져온다.
                    int[] doc = queue.peek();

                    if(doc[0] == max){ //doc[0]이 (우선순위) 가장 높은 우선순위라면 꺼낸다.

                        //답을 찾았으니 꺼낸다.
                        queue.poll();

                        //그 다음에 꺼낼 문서가 없으면 정답을 출력하고 종료
                        if(queue.size()==0){
                            System.out.println(count);
                            break;
                        }else{
                            index++;
                            max = numArray[index]; //numArray는 내림차순을 했음 따라서 그 다음 우선순위를 알 수 있게 한거
                            count++; //그 다음 나올 문서 출력 순서를 갱신
                        }

                        //근데 만약 찾고자 하는 문서였다면 (첫 인덱스 번호와 같은 문서라면)
                        if(doc[1]==findIndex){
                            System.out.println(index);
                            break;
                        }

                    }else { //먼저 나와야할 우선순위 문서가 아니라면
                        queue.add(queue.remove()); //꺼내서 다시 뒤로 보낸다.
                    }
                }//while(!queue.isEmpty)

        } //T


    }
}
