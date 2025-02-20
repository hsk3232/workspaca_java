package java_ch13;

/*
 * 교재 614-621 실습
 */
class Bag<T> { //벽돌 형틀 => template / generic
	private T thing;
	private String name;
	public Bag(T thing) {
		this.thing = thing;
	}
	public T getThing() {
		return thing;
	}
	public void setThing(T thing) {
		this.thing = thing;
	}
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
	public String getOwner() {
		return name;
	}
	public void setOwner(String owner) {
		name = owner;
	}

}
class Solid {}
class Liquid {}
class Book extends Solid{}
class Pencil extends Solid{}
class Paper extends Solid{}
class Water extends Liquid {}
class Coffee extends Liquid {}

public class BagTest_1_실습대상 {
	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>(new Book());
		Bag<Pencil> bag2 = new Bag<>(new Pencil());
		Bag<Paper> bag3 = new Bag<>(new Paper());
		Bag<Water> bag4 = new Bag<>(new Water());

		bag.showType();
		bag2.showType();
		bag3.showType();
		bag4.showType();
		
		//bag = bag2;//error를 발생시킴 - 이유는 다른 타입으로 출력한 결과를 보고 >> 정상적인 코딩이다 
		Book book = bag.getThing();
		Pencil pc = bag2.getThing();
		Paper nb = bag3.getThing();
		bag.setOwner("홍길동");
		bag2.setOwner("홍동");
		bag3.setOwner("김홍동");
		bag4.setOwner("홍이");
		
//		bag = bag2;//에러 발생
	}
}