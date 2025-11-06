package 프로그래머스;

public class WhileP {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
//        while (i < 10) {
//            i++;
//            if(i%2==1)
//                continue;
//            sum+=i;
//
//        }
        for(i = 0; i < 10; i++) {
            if(i % 2 == 1)
                continue;
            sum += i;

        }
        System.out.println(sum);
    }
}
