package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main5635 {

    static class Info {
        String name;
        int count;

        public Info(String name, int count) {
            this.name = name;
            this.count = count;
        }


    }
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        List<Info> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());


            list.add(new Info(name ,year*365 + month*31 +day));
        }

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return Integer.compare(o1.count,o2.count);
            }
        });

        System.out.println(list.get(n-1).name);
        System.out.println(list.get(0).name);


    }
}
