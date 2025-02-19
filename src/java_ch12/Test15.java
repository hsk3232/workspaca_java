package java_ch12;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test15 {
	public static void main(String[] args) {
		UserBean user = new UserBean("purum", "오정임", "010-123-4567", "부산");
		
		try(ObjectOutputStream out = 
				new ObjectOutputStream(new FileOutputStream("user.txt"))){
			//ObjectOutputStream 보조 스트림 / user라고 되어 있는 파일을 만들어서 디스크에 써라
			//2진 포멧으로 저장됐기 때문에, 읽을 수 없음.
			
			out.writeObject(user);
			} catch(Exception e) {
				e.printStackTrace();
			}
	}

}