package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2304 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []height = new int[1001];

        int minX = 1001; // 시작점 x
        int maxX = -1;  // 끝점 x
        int maxHighX=0; // 높이가 가장 높은 x좌표
        int maxHighY=-1; // 최대 높이

        for(int i = 0 ; i <N;i++){

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            maxX = Math.max(x,maxX);
            minX = Math.min(minX,x);

            if(maxHighY<y){
                maxHighY=y;
                maxHighX=x;
            }
            height[x]=y;
        }

        //왼쪽 -> 오른쪽 ( 가장 큰 높이의  x 전까지)
        int h = height[minX];//가장 큰 y의 값
        for(int start= minX; start<maxHighX;start++){

            if(height[start]>h){ //h보다 큰 높이의 값이 존재하면 h값을 변경
                h=height[start];
            }else {
                //h보다 높이가 작다면 h로 높이를 변경시켜줌
                height[start]=h;
            }

             }


        //오른쪽  ->  왼쪽 (가장 큰 높이의 x전까지)
        h = height[maxX];
        for(int end = maxX; end>maxHighX;end--){
            if(height[end]>h){
                h=height[end];
            }else {
                height[end]=h;
            }

        }

        int answer = (maxX-minX)*maxHighY;

        //빈 공간의 넓이 만큼 뺴줌
        for(int i = minX;i<=maxX;i++){
            answer -= maxHighY-height[i];
        }

        System.out.println(answer+maxHighY);
    }
}
