package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1302 {
    static class BookInfo{
        String bookName;
        int bookCount ;//팔린 책 개수

        public BookInfo(String bookName, int bookCount) {
            this.bookName = bookName;
            this.bookCount = bookCount;
        }
    }
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //하루 동안 팔린 책의 수
        Map<String,Integer> map = new HashMap<>();

        for(int i = 0 ;i < N; i++){
            String s = br.readLine();
            map.put(s,map.getOrDefault(s,0)+1);

        }

        List<BookInfo> list = new ArrayList<>();

       for( String key : map.keySet()){
           list.add(new BookInfo(key,map.get(key)));
       }

        Collections.sort(list, new Comparator<BookInfo>() {
            @Override
            public int compare(BookInfo o1, BookInfo o2) {
                if(o2.bookCount-o1.bookCount<0){
                    return -1;
                }
                else if (o2.bookCount-o1.bookCount>0){
                    return 1;
                }
                else{
                    return o1.bookName.compareTo(o2.bookName);
                }
            }
        });


       System.out.println(list.get(0).bookName);

    }
}
