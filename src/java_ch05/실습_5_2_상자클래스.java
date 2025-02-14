package java_ch05;

class Box { // 필드 (속성)
	double width; 
	double height;
	double depth;

	public Box() { // 기본 생성자 = 선언이 자동으로 될 때도 있음. ◆확인◆
	}

	public Box(double width, double height, double depth) { // 생성자
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	
	double getVolume() { // 부피 계산 메소드
		return width * height * depth;
	}

	
	double getPerimeter() { // 둘레 길이 계산 메소드
		return (width + height) * 2;
	}

	// 박스 크기 조정 (메소드 오버로딩) //새로 넘어온 파라메타(newWidth 등)의 값을 현제 값으로 바꾸는 생성자
	public void resize(double newWidth, double newHeight, double newDepth) {
		this.width = newWidth;
		this.height = newHeight;
		this.depth = newDepth;
		// 박스의 가로,세로,높이를 변경
	}

	public void resize(double scale) {
		width *= scale;
		height *= scale;
		depth *= scale; // 박스의 가로,세로,높이를 scale 비율로 변경
	}

	public void show() {
		System.out.println(toString());
	}

	@Override
	public String toString() { // 출력값을 숫자에서 글자로 바꾸기 위해서 사용
		return "width=" + width + ", height = " + height + ", depth = " + depth;
	}
}

public class 실습_5_2_상자클래스 {
	public static void main(String[] args) {

		Box box1 = new Box(10, 5, 3);
		box1.show(); // 박스 정보 출력
		System.out.println(box1.getVolume());

		box1.resize(15, 8, 5); // 박스 크기 변경
		box1.show(); // System.out.println(box1); 이것과 같음

		System.out.println(box1.getPerimeter());

		box1.resize(0.5); // 박스를 2배 확대
		box1.show();

		Box box2 = new Box(4, 7, 3);
		box2.show();
		System.out.println(box2); //

		box2.resize(9, 3, 8); // 박스 크기 변경
		box2.show();
		System.out.println(box2.getPerimeter()); //

		box2.resize(1.5); // 박스를 2배 확대
		box2.show();
		System.out.println(box2); //

	}
}
