package java_ch13;

//generic 대신 사용 - 618-620페이지
class Bag2 {
	private Object thing;
	public Bag2(Object thing) {
		this.thing = thing;
	}
	public Object getThing() {
		return thing;
	}
	public void setThing(Object thing) {
		this.thing = thing;
	}
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}
class Book2 {
}
class PencilCase2 {
}
class Notebook2 {
}

public class BagTest_2_실습대상 {
	public static void main(String[] args) { 
		Bag2 bag = new Bag2(new Book2());
		Bag2 bag2 = new Bag2(new PencilCase2());
		Bag2 bag3 = new Bag2(new Notebook2());

		bag.showType();
		bag2.showType();
		bag3.showType();

		bag = bag2;//error를 발생시키지 않지만 잘 못된 코드이다
		// bag=> pencilcase2로 치환한 코드가 돼버림
		
//		Book2 book = bag.getThing();//에러 메시지 확인
//		PencilCase2 pc = bag2.getThing();
//		Notebook2 nb = bag3.getThing();
		//*/
		Book2 book = (Book2)bag.getThing();//down casting
		PencilCase2 pc = (PencilCase2)bag2.getThing();
		Notebook2 nb = (Notebook2)bag3.getThing();
	}
}