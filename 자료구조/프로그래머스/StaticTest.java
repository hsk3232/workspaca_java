package 프로그래머스;

public class StaticTest {
    public static void main(String[] args) {
        System.out.println(StaticTest.check(1));
    }
    static String check(int a){
        return (a >=0) ? "Positive" : "Negative";
    }
}
