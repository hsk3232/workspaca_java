package java_ch13;

/*
 * 625-634 타입제한, wild card
 */
class Bag3<T extends Solid3> {
	private T thing;
	private String name;
	public Bag3(T thing) {
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
	boolean isSameOwner(Bag3<?> obj) {//? wild card 사용 => 어떤 class가 와도 type check 안 할거다.
//	boolean isSameOwner(Bag3<T> obj) {
		if (this.name.equals(obj.getOwner()))
			return true;
		return false;
	}
    // `<? extends Book3>`을 사용하여 Book3 또는 그 하위 타입을 반환하는 메서드 추가
    public static void printBookInfo(Bag3<? extends Book3> bag) { //book3 하위 클래스는 어떤 type이 와도 괜찮
        System.out.println("이 가방은 " + bag.getThing().getClass().getSimpleName() + "을(를) 포함하고 있습니다.");
    }

    // `<? super Pencil3>`을 사용하여 Pencil3 또는 그 상위 타입을 저장하는 메서드 추가
    public static void setPencilThing(Bag3<? super Pencil3> bag, Pencil3 pencil) { //pencil 또는 상위 class에 어떤 type이 와도 괜찮아요
        bag.setThing(pencil);
        System.out.println("Pencil3이(가) Bag에 저장되었습니다.");
    }
}
class Solid3 {}
class Liquid3 {}
class Book3 extends Solid3{}
class Pencil3 extends Solid3{}
class Paper3 extends Solid3{}
class Water3 extends Liquid3 {}
class Coffee3 extends Liquid3 {}


public class BagTest_3_실습대상 {
	public static void main(String[] args) {
		Bag3<Book3> bag = new Bag3<>(new Book3());
		Bag3<Pencil3> bag2 = new Bag3<>(new Pencil3());
		Bag3<Paper3> bag3 = new Bag3<>(new Paper3());
		//Bag3<Water3> bag3 = new Bag3<>(new Water3());
		
        Bag3<Book3> bookBag = new Bag3<>(new Book3());
	    Bag3<Pencil3> pencilBag = new Bag3<>(new Pencil3());
	    Bag3<Solid3> solidBag = new Bag3<>(new Solid3());
	      
		bag.showType();
		bag2.showType();
		bag3.showType();

		//bag = bag2;//error를 발생시킴 - 이유는 다른 타입으로 출력한 결과를 보고 >> 정상적인 코딩이다 
		Book3 book = bag.getThing();
		Pencil3 pc = bag2.getThing();
		Paper3 nb = bag3.getThing();
		bag.setOwner("홍길동");
		bag2.setOwner("홍길동");
		
        bookBag.setOwner("홍길동");
	    pencilBag.setOwner("홍길동");
		bag.isSameOwner(bag2);//에러 메시지를 이해하는 것이 필요 >629페이지 설명
		
		if (bookBag.isSameOwner(pencilBag)) {
	        System.out.println("두 가방의 소유자가 같습니다.");
	    } else {
	        System.out.println("두 가방의 소유자가 다릅니다.");
	    }

	    // `<? extends Book3>` 실습
	    System.out.println("\n--- Book3 상속 관계 테스트 ---");
	    Bag3.printBookInfo(bookBag);
	    // Bag3.printBookInfo(pencilBag); // 컴파일 오류 발생

	    // `<? super Pencil3>` 실습
	    System.out.println("\n--- Pencil3 상속 관계 테스트 ---");
	    Bag3.setPencilThing(solidBag, new Pencil3()); // Solid3이 Pencil3의 부모 타입이므로 가능
	    // Bag3.setPencilThing(bookBag, new Pencil3()); // 컴파일 오류 발생 (Book3은 Pencil3의 부모가 아님)
	}
}