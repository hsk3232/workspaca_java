package java_ch11;

//catch된 객체를 출력하는 실습
public class Test01_실습대상 {

	public static void main(String[] args) {
		int arr2[] = new int[3];
		arr2[3] = 0;

		String st = "hello";
		//st = null;
		System.out.println(st.length());

		try {
			String s = new String("java");
			int len = s.length();
			s = null;
			s.length(); // new NullPointerException()
			int arr[] = new int[3];
			arr[3] = 30; // new ArrayIndexOutOfBoundsException()
			System.out.println("OK");
		}
		/*
		 * catch(Exception e) { //unreachable - 상위 클래스로서 모두 여기서 capture하기 때문이다
		 * System.out.println("Exception 처리"); }
		 */
		catch (ArrayIndexOutOfBoundsException e1) { //try 처리하다가 오류가 나면, e1 변수를 실행하는데, 
			// 그 타입이 ArrayIndexOutOfBoundsException게 맞으면 실행, 아니면 다음 catch로 이동
			
			e1.printStackTrace();// 교재 542
			System.out.println(e1.getMessage());// 교재 542
		} catch (NullPointerException e2) {
			e2.printStackTrace();
			System.out.print(e2.getMessage());
			System.out.println();
		} catch (Exception e) {// 순서상 마지막에 와야
			System.out.println("오류 발생 : " + e);// e.toString()
		} finally {//
			System.out.println("GOOD");
		}
	}
}