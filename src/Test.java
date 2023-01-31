import java.io.*;
import java.util.*;


class Employee {
    void work(){
        System.out.println("w1");
    }
}

class Employee1 extends Employee {
    void work(){
        super.work();
    }
}
 class Test {


     public static void main(String[] args) throws IOException {
Employee a = new Employee1();
a.work();
     }
 }