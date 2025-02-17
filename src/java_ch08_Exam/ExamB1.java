package java_ch08_Exam;

import java.time.LocalDate;

class Item { // Item 클래스 생성
	private String name; // 필드 선언 1
	private double price; // 필드 선언 2
	private int stockQuantity; // 필드 선언 3

	// 클래스 필드의 생성자 선언 -> 생성한 필드에 초기 값을 설정
	public Item(String name, double price, int stockQuantity) {
		// 필드와 매계변수 명이 같을 때 this.를 사용해 선언
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	// 필드가 private임으로 클래스 밖에서 사용을 위해 getter, setter 생성
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

	// quantity 계산 메소드
	void reduceStock(int quantity) { // int quntitiy는 지역변수
		stockQuantity -= quantity;
	}

	void increaseStock(int quantity) {
		stockQuantity += quantity;
	}

	// 상품명, 가격을 toStrig 정의대로 프린트하는 메소드
	public void show() { // name = ***, price=*** 등으로 출력
		System.out.println(toString());
	}

	// 상품명, 가격 표기 방식 선언 메소드
	@Override
	public String toString() {
		return "name = " + name + ", price = " + price + ", stockQuantity = " + stockQuantity;

	}
}

class Customer { // Customer 클래스 생성
	private String cname; // 클래스 필드1 생성
	private String city; // 클래스 필드2 생성
	private int age; // 클래스 필드3 생성

	// 클래스 필드의 생성자 선언 -> 생성한 필드에 초기 값을 설정
	public Customer(String cname, String city, int age) {
		// 필드와 매계변수 명이 같을 때 this.를 사용해 선언
		this.cname = cname;
		this.city = city;
		this.age = age;
	}

	// 필드가 private임으로 클래스 밖에서 사용을 위해 getter, setter 생성
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

	// 상품명, 가격을 toStrig 정의대로 프린트하는 메소드
	public void show() {
		System.out.println(toString());
	}

	// 고객명, 지역, 나이 표기 방식 선언 메소드
	@Override
	public String toString() {
		return "name=" + cname + ", city=" + city + ", age=" + age;
	}
}

class Order { // Order 클래스 생성
	private Customer customer; // 클래스 필드 생성 1
	private Item[] items = new Item[10]; // 클래스 필드 생성 2
	private int[] quantities = new int[10]; // 클래스 필드 생성 3
	private String[] orderDates = new String[10]; // 클래스 필드 생성 4
	private int count = 0; // 배열[] 인덱스

	// new Order(boy);의 boy 값을 받을 Customer 정보를 담아야 함.
	public Order(Customer customer) {
		// Item은 품목 10개를 담을 칸을 만듦.
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;

	}

	public int[] getQuantities() {
		return quantities;
	}

	public void setQuantities(int[] quantities) {
		this.quantities = quantities;

	}

	public String[] getOrderDates() {
		return orderDates;
	}

	public void setOrderDates(String[] orderDates) {
		this.orderDates = orderDates;

	}

	void addItem(Item item, int orderQuantity) {
		items[count] = item; // 인덱스에 item(품목) 저장
		quantities[count] = orderQuantity; // 인덱스에 quantities(수량) 저장
		orderDates[count] = LocalDate.now().toString();
		item.reduceStock(orderQuantity);
		count++;//
	}


	double calculateTotal() {
		double total=0; // 지역변수는 개발자가 초기화 해줘야 한다. 초기화 자동으로 안됨.
		for (int i = 0; i < count; i++) {
			total += items[i].getPrice()* quantities[i];
		}
			
		return total;	
	}

	

	void printOrderSummary() {
		//고객 명단 출력
		System.out.println(customer.toString());
		
		//아이템 목록 출력, 배열이기 때문에 for루프를 이용해서 item 하나 하나를 출력한다.
		for(int i=0; i <count; i++) {
			System.out.println(items[i].toString());
		}
		
		//아이템 총계를 출력한다.
		System.out.println("Total = " + calculateTotal());
	}

}


public class ExamB1 {

	public static void main(String[] args) {

		// Itme 생성
		Item laptop = new Item("노트북", 1200.00, 10);
		Item tshirt = new Item("티셔츠", 20.00, 50);

		// 고객 생성
		Customer boy = new Customer("홍길동", "부산", 21);
		Customer girl = new Customer("계백", "양산", 22);

		Order order1 = new Order(boy);
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order order2 = new Order(girl);
		order2.addItem(laptop, 2);
		order2.addItem(tshirt, 1);

		order1.printOrderSummary();
		System.out.println("-".repeat(30));
		order2.printOrderSummary();

	}

}
