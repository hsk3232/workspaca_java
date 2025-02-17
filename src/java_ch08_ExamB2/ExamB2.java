package java_ch08_ExamB2;

class Item2 { // Item 클래스
	private String name;
	private double price;
	private int stockQuantity;

	public Item2(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	// quantity 계산 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	void reduceStock(int quantity) { // 판매 시 재고 감소 메소드
		stockQuantity -= quantity;
	}

	void increaseStock(int quantity) {
		stockQuantity += quantity;
	}

	@Override
	public String toString() {
		return "name = " + name + ", price = " + price;
	}
}

class Electronics extends Item2 { // Electronics 클래스 (Item 클래스를 상속)
	private int warranty; // 제품 보증 기간

	public Electronics(String name, double price, int stockQuantity, int warranty) {
		super(name, price, stockQuantity);
		this.warranty = warranty;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	// 상품명, 가격 표기 방식 선언 메소드
	@Override
	public String toString() {
		return super.toString() + ", warranty = " + warranty;
	}
}

class Clothing extends Item2 { // Clothing 클래스 (Item 클래스를 상속)

	private String size;
	private String color;

	public Clothing(String name, double price, int stockQuantity, String size, String color) {
		super(name, price, stockQuantity);
		this.size = size;
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + ", size = " + size + ", color = " + color;
	}

}

abstract class Customer2 { // Customer 추상 클래스 정의
	private String cname;
	private String city;
	private int age;

	public Customer2(String cname, String city, int age) {
		this.cname = cname;
		this.city = city;
		this.age = age;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name = " + getCname() + ", city = " + getCity() + ", age = " + getAge();

	}

	abstract double applyDiscount(double totalAmount);

}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
	static final double REGULARDISCOUNT_RATE = 0.03;

	public RegularCustomer(String cname, String city, int age) {
		super(cname, city, age);

	}
	
	

	@Override // 일반 고객 할인 적용
	public double applyDiscount(double totalAmount) {
		return  totalAmount*REGULARDISCOUNT_RATE;

	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	public PremiumCustomer(String cname, String city, int age) {
		super(cname, city, age);

	}

	@Override
	public double applyDiscount(double totalAmount) {
		return  totalAmount*PREMIUMDISCOUNT_RATE;

	}
}

// Order 클래스
class Order2 {
	private Customer2 customer;
	private Item2[] items = new Item2[10];
	private int[] quantities = new int[10];
	private int itemCount = 0;
	
	

	public Order2(Customer2 customer) {
		this.customer = customer;

	}

	public void addItem(Item2 item, int quantity) {
		items[itemCount] = item; // 인덱스에 item(품목) 저장
		quantities[itemCount] = quantity; // 인덱스에 quantities(수량) 저장
		item.reduceStock(quantity);
		itemCount++;

	}

	public double calculateTotal() {
		double totalAmount = 0; // 지역변수는 개발자가 초기화 해줘야 한다. 초기화 자동으로 안됨.
			for (int i = 0; i < itemCount; i++) {
			totalAmount += items[i].getPrice()* quantities[i];
		}

		return totalAmount;
	}

	public double calculateDiscountedTotal() {
		double totalAmount = calculateTotal();
        double discountAmount = customer.applyDiscount(totalAmount);
        return totalAmount - discountAmount;
	}



	

	public void printOrderSummary() {

		System.out.print(customer.toString());
		double totalAmount = calculateTotal();
        double discountAmount = customer.applyDiscount(totalAmount);
        
		if( discountAmount/totalAmount  == PremiumCustomer.PREMIUMDISCOUNT_RATE) {
			System.out.println(", DiscountRate = " + PremiumCustomer.PREMIUMDISCOUNT_RATE);
		}

		// 아이템 목록 출력, 배열이기 때문에 for루프를 이용해서 item 하나 하나를 출력한다.

		for (int i = 0; i < itemCount; i++) {
			System.out.println(items[i].toString());
		}

		// 아이템 총계를 출력한다.
		System.out.println("Total = " + calculateTotal());
		System.out.println("\t" + "=>" + calculateDiscountedTotal() + " [Discount]");

		/*
		 * 할인된 가격의 합계 출력 할인 금액 합계 출력
		 */

	}
}

public class ExamB2 {
	public static void main(String[] args) {

		// 의류 및 전자제품 생성
		Item2 laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

		// 주문 생성
		Order2 order1 = new Order2(premiumCustomer);
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order2 order2 = new Order2(regularCustomer);
		order2.addItem(phone, 1);
		order2.addItem(jacket, 1);

		// 주문 요약 출력
		System.out.println("Premium Customer Order:");
		order1.printOrderSummary();

		System.out.println("Regular Customer Order:");
		order2.printOrderSummary();
	}
}
