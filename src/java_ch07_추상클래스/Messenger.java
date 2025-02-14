package java_ch07_추상클래스;

public interface Messenger { // 추상 클래스와 유사
	int MIN_SIZE = 1; // 필드를 선언

	public String getMessage(); // 추상메소드
	public void setMessage(String msg);
	
	//추상메소드가 아닐 경우 default로 선언
	public default void setLog(boolean login) {
		if(login)
			System.out.println("로그인");
		else
			System.out.println("로그아웃");
	}
	public static void getConnection() {
		System.out.println("Connection");
		
	}
	
	}
