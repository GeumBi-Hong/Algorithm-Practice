package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2776 {

    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수


        while (T-->0){
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            List<Integer> list1 = new ArrayList<>();
            for(int i = 0 ;  i < N;  i++){
                list1.add(Integer.parseInt(st.nextToken()));

            }

            //이분 탐색을 하기 위해 반드시 정렬
            Collections.sort(list1);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0 ; i <M;i++){
                list2.add(Integer.parseInt(st.nextToken()));
            }

            //수첩 2의 수에 대해서 수첩1에 존재하는지 수첩1 이분탐색
            for(int num : list2){

                if(binarySearch(list1,list2,0,N-1,num)){//존재한다면
                    sb.append(1).append("\n");
                }else {
                    sb.append(0).append("\n");
                }
            }

        }

        System.out.print(sb);


    }

    private static boolean binarySearch(List<Integer>list1, List<Integer>list2,int lo , int hi,int key){



        if(lo>hi)return false; //key 값을 찾지 못함


            int mid = (lo+hi)/2;

            if(list1.get(mid)==key){ //key값을 찾음
                return true;
            }else if(list1.get(mid)>key){ //mid왼쪽으로 범위를 줄임
               return binarySearch(list1,list2,lo,mid-1,key);
            }else { //mid 오른쪽으로 범위를 줄임
               return binarySearch(list1, list2, mid + 1, hi, key);
            }



    }
}
