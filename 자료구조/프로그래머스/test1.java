package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

class Parent{
    String name = "Parent";
    public Parent(){}
    public Parent(String name){
        this.name=name;
        System.out.println("A");
    }
}
class Child extends Parent{
    public Child(String name){
        super(name);
        System.out.println("B");
    }
    void info(){
        System.out.println(name);
    }
}


public class test1 {
    public static void main(String[] args) {
    Parent c = new Child("Child");
        ((Child)c).info();
    }

}
