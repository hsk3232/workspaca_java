package java_ch08;

class AClass {}
class BClass extends AClass {}
class CClass extends BClass{}

public class Test30 {
	
	public static void main(String[] args) {
		AClass c = new CClass();
		
		if(c instanceof CClass) System.out.println("CClass"); // 1줄 안에 작성할 때는 중괄호 안 써도 작동 됨.
		else if (c instanceof BClass) System.out.println("BClass");
		else if (c instanceof AClass) System.out.println("AClass");
		
		System.out.println(c.getClass().getName());
	}
}
