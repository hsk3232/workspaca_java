package 프로그래머스;

public class Equal {
    public static void check(int[] a, int[] b){
        if(a==b)
            System.out.println("같음");
        else
            System.out.println("다름");
    }

    public static void check(int a, int b){
        if(a==b)
            System.out.println("같음");
        else
            System.out.println("다름");
    }

    public static void check(String a, String b){
        if(a==b)
            System.out.println("같음");
        else
            System.out.println("다름");
    }

    public static void main(String[] args) {
        int a[] = new int[] {1, 2, 3, 4};
        int b[] = {1, 2, 3, 4};
        int c[] = new int[] {1, 2, 3};
        int d[] = a;

        int x = 3;
        int y = 3;

        String k = "a";
        String v = "a";
        String w = new String("a");

        Equal  e = new Equal();
        Equal  h = new Equal();
        Equal  i = new Equal();

        e.check(a,b);
        h.check(a,c);
        i.check(b,c);
        e.check(a,d);
        check(x,y);
        check(v,k);
        check(w,v);
    }
}
