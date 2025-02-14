package java_ch07_추상클래스;

public class IPhoneMessenger implements Messenger {

	public String getMessage() {
		return "iPhone";
	}
	
	public void setMessage(String msg) {
		System.out.println("iPhone에서 메시지" + msg);
		
	}

		
}

