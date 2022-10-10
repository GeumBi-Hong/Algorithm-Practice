package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17143 {
    static class Info {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Info(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static int R,C,M;
    static int [][]map;
    static Info[] sharkList ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];
        sharkList = new Info[M+1];

        for(int i = 1; i <=M; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());


            map[r][c]=i;
            sharkList[i]= new Info(r,c,s,d,z);

        }

       System.out.println(goFish());
    }
    private static void printMap(){
        for(int r= 1; r <=R;r++){
            for(int c =1 ; c<=C;c++){
               System.out.print(map[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /* 낚시 하기 */
    private static int goFish(){

        //낚시 왕이 오른 쪽으로 한칸 이동한다.
        int kingIndex = 0;
        int totalSharkSize = 0;
        while (kingIndex <C){
            kingIndex++; //한 칸 이동

            //낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
           totalSharkSize+= findShark(kingIndex);


            //상어 이동 후의 정보를 저장하기 위한 배열
            int [][]temp = new int[R+1][C+1];

            //상어 리스트 만큼 반복
           for(int i = 1; i<sharkList.length;i++){

               // 삭제된 상어는 넘어감
               if(sharkList[i]==null)continue;

               //상어 이동 범위
               int range1 = 0;  //방향 전환 되기전까지만 이동하는 범위
               int range2 = 0; // 방향전환 후 이동 되는 범위
               int range3 = 0; // 방향 전환 후 이동되는 범위


               int goCount = 0; // 자기자리로 오는 반복 횟수 제거한 이동 수

                //다음 이동하는 좌표와 방향
               int nr = 0;
               int nc = 0;
               int nd = 4;

               //1위 2아래 3 오른 4 왼
               switch (sharkList[i].d){
                   case 1: //위

                       range1 = sharkList[i].r-1;
                       range2 = range1+R-1;
                       range3 = range2+R-sharkList[i].r;

                       goCount = sharkList[i].s % ((R-1)*2);

                        nr = sharkList[i].r;
                        nc = sharkList[i].c;
                        nd = 1;

                       if(0<= goCount && goCount <=range1){
                           nr = sharkList[i].r-goCount;
                       }else if(range1 < goCount && goCount<=range2){
                           nr =  (goCount-range1)+1;
                           nd = 2; // 이 구간에서는 방향 전환이 이루어짐
                       }else if(range2 < goCount && goCount<=range3){
                           nr = R- (goCount-range2);
                       }

                       break;
                   case 2: //아래
                        range1 = R-sharkList[i].r;
                        range2 = range1+R-1;
                        range3 = range2+sharkList[i].r-1;

                        goCount = sharkList[i].s % ((R-1)*2);

                        nr = sharkList[i].r;
                        nc = sharkList[i].c;
                        nd = 2;

                       if(0<= goCount && goCount <=range1){
                           nr = sharkList[i].r+goCount;
                       }else if(range1 < goCount && goCount<=range2){
                           nr =  R -(goCount-range1);
                           nd = 1;
                       }else if(range2 < goCount && goCount<=range3){
                           nr = 1+ (goCount-range2);
                       }

                       break;
                   case 3://오른

                        range1 = C-sharkList[i].c;
                        range2 = range1+C-1;
                        range3 = range2+sharkList[i].c-1;

                        goCount = sharkList[i].s % ((C-1)*2);

                        nr = sharkList[i].r;
                        nc = sharkList[i].c;
                        nd = 3;//오른


                       if(0<= goCount && goCount <=range1){
                           nc = sharkList[i].c+goCount;
                       }else if(range1 < goCount && goCount<=range2){
                           nc =  C -(goCount-range1);
                           nd = 4;
                       }else if(range2 < goCount && goCount<=range3){
                           nc = 1+ (goCount-range2);
                       }

                      // moveSharkRight(i,temp);
                       break;
                   case 4://왼

                        range1 = sharkList[i].c-1;
                        range2 = range1+C-1;
                        range3 = range2+C-sharkList[i].c;

                        goCount = sharkList[i].s % ((C-1)*2);

                        nr = sharkList[i].r;
                        nc = sharkList[i].c;
                        nd = 4;

                       if(0<= goCount && goCount <=range1){
                           nc = sharkList[i].c-goCount;
                       }else if(range1 < goCount && goCount<=range2){
                           nc = (goCount-range1)+1;
                           nd = 3;
                       }else if(range2 < goCount && goCount<=range3){
                           nc = C-(goCount-range2);
                       }

                       break;
               }

               //상어가 존재하지 않는경우
               if(temp[nr][nc]==0){
                   sharkList[i].r=nr;
                   sharkList[i].c=nc;
                   sharkList[i].d=nd;
                   temp[nr][nc]=i;
               }else { //그렇지 않고 상어가 있었을때
                   int sharkSize = sharkList[temp[nr][nc]].z;
                   if(sharkSize<sharkList[i].z){ //원래 있던 상어보다 크키가 크다면 잡아먹는다
                       sharkList[i].r=nr;
                       sharkList[i].c=nc;
                       sharkList[i].d=nd;
                       //잡아먹은 상어는 null처리
                       sharkList[temp[nr][nc]]=null;
                       //temp에는 이동한 상어의 인덱스번호를 저장
                       temp[nr][nc]=i;
                   }else {
                       //크기가 작다면 현재 상어는 사라진다. (null)
                       sharkList[i]=null;
                   }
               }

           }//for

            //모든 상어를 이동시킨후 원래 map[][]으로 다시 값 복사
            for(int r= 1; r <=R;r++){
                for(int c =1 ; c<=C;c++){
                    map[r][c]=temp[r][c];
                }
            }
        }


        //낚시한 총 상어의 크기를 반환한다.
        return totalSharkSize;
    }

    /* 땅과 가까운 상어 찾기 */
    private static int findShark(int c){
        for(int r = 1; r <=R ;r++){
                if(map[r][c]>0){
                    Info info = sharkList[map[r][c]];
                    sharkList[map[r][c]]=null;
                    map[r][c]=0;
                    return info.z;
                }
        }
        return 0;
    }

}
