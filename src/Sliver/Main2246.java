package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2246 {
    static class Condo {
        int dis ;
        int fee ;

        public Condo(int dis, int fee) {
            this.dis = dis;
            this.fee = fee;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Condo> list = new ArrayList<>();
        while (N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int distance = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());

            list.add(new Condo(distance,fee));
        }

        Comparator<Condo> comparator = new Comparator<Condo>() {
            @Override
            public int compare(Condo o1, Condo o2) {

                if(o1.dis==o2.dis){
                    return o1.fee-o2.fee;
                }
                return o1.dis-o2.dis;
            }
        };

        Collections.sort(list,comparator);

        int count = 0;
        int nowD = 0 ;
        int nowF= 10001;
        for(int i = 0 ; i <list.size();i++){

            int  dis = list.get(i).dis;
            int  fee = list.get(i).fee ;
            if(dis>nowD && fee<nowF){

                nowD=dis;
                nowF=fee;
                count++;
            }else if(dis==nowD) continue;
        }


        System.out.println(count);
    }
}
