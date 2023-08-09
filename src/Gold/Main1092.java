package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 배
 *
 * [풀이과정]
 *
 * 최소 시간을 구하려면
 * 가장 무거운 화물을 들수있는 크레인이 가장 무거운걸 들게끔하는게 아닐까 하고 품
 */
public class Main1092 {

    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st ;

            int N = Integer.parseInt(br.readLine()); // 크레인 개수

            ArrayList<Integer> craneList = new ArrayList<>(); // 크레인
            ArrayList<Integer> weightList = new ArrayList<>(); // 화물


            st = new StringTokenizer(br.readLine());

            for(int i = 0 ; i  < N ; i++){
                craneList.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < M ; i++){
                weightList.add(Integer.parseInt(st.nextToken()));
            }


            //[1]최소 시간 구하기
            // 1. 먼저 내림 차순으로 정렬 -> 높은 중량(?)을 들 수 있는 크레인이 젤 무거운 화물부터 배에 옮기게 끔 하기 위함
            Collections.sort(craneList, Collections.reverseOrder());
            Collections.sort(weightList, Collections.reverseOrder());

            //2 옮길 수 없는 경우가 먼저 있는가 ?  ->  젤 높은 중량 기준을 가진 크레인 보다 더 무거운 수화물이 존재하는 경우는 배에 화물을 옮길 수 없는 경우
            if(craneList.get(0)<weightList.get(0)) System.out.println(-1);

            else {
                int time = 0 ; //걸린 시간

                //3 화물이 비어있지 않을때까지 반복한다
                while (!weightList.isEmpty()){

                    int index = 0;

                    for(int i = 0 ; i < craneList.size();) {

                        if (index == weightList.size()) break;

                        else if (craneList.get(i) >= weightList.get(index)) { //들 수 있는 수화물이면 제거
                            weightList.remove(index);
                            i++;
                        } else index++;


                    }
                    time++; // 한 턴 지났으시까 시간 +1
                }

                System.out.print(time);
            }

    }
}
