package 프로그래머스;

abstract class A {
    abstract int absMethod();

    protected int aVal = 100;

    static void staticA() {
        System.out.println("A");
    }
}

class P extends A {
    public int x = 1;

    private void privateShow() {
        System.out.println("P1");
    }

    public void callParentPrivate() {
        privateShow();
    }

    public static void staticShow() {
        System.out.println("P2");
    }

    void show() {
        System.out.println(x);
    }

    @Override
    int absMethod() {
        return x + aVal;
    }

    int changeAndReturn() {
        x += 10;
        System.out.println("P3");
        return x;
    }
}

class C extends P {
    public int x = 2;

    private void privateShow() {
        System.out.println("C1");
    }

    public void callChildPrivate() {
        privateShow();
    }

    public static void staticShow() {
        System.out.println("C2");
    }

    @Override
    void show() {
        System.out.println(x);
    }

    @Override
    int changeAndReturn() {
        x += 20;
        System.out.println("C3");
        return x;
    }
}

class G extends C {
    public int x = 3;

    @Override
    void show() {
        System.out.println(x);
    }

    @Override
    int changeAndReturn() {
        x += 30;
        System.out.println("G");
        return x;
    }
}

public class Extends {
    public static void main(String[] args) {
        P p = new G();

        p.show();
        System.out.println(p.x);
        System.out.println(((C) p).x);
        System.out.println(((G) p).x);
        p.staticShow();
        ((C) p).staticShow();
        G.staticShow();
        p.callParentPrivate();
        ((C) p).callChildPrivate();

        int ret = p.changeAndReturn();
        System.out.println(ret);

        System.out.println(p.x);
        System.out.println(((C) p).x);
        System.out.println(((G) p).x);

        System.out.println(p.absMethod());

        A.staticA();
    }
}
