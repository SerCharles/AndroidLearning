import Base1.MyClass1;
import Base1.Test1;

public class Main {
    public static void main(String args[]) {
        MyClass1 myClass = new MyClass1();
        Test1 t = new Test1(myClass);
        int score = 0;
        try {
            score = t.getScore();
        } finally {
            System.out.println(score);
        }
    }
}