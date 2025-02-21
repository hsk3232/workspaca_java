package java_ch15;
//여기까지 공부해라

import java.util.ArrayList;
import java.util.Optional;
class Member {
	private String name;
	private int age;
	private String phoneNum;
	private String address;

	public Member() {
	}

	public Member(String name, int age, String phoneNum, String address) {
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return name + " " + age + " " + phoneNum + " " + address;
	}
}

public class Test02_실습대상 {

	public static void main(String[] args) {

		ArrayList<Member> members = new ArrayList<>();
		members.add(new Member("김푸름", 25, "010-123-4562", "서울"));
		members.add(new Member("김하늘", 30, "010-803-6356", "부산"));
		members.add(new Member("오정임", 29, "010-264-4872", "대전"));

		Optional<Member> mem1 = members.stream().filter((m) -> m.getAge() > 20).findFirst();
		//여기까지 실행해서 꼭 봐라

		if (mem1.isPresent())
			System.out.println(mem1.get());

		members.stream().filter((m) -> m.getAge() > 20).findFirst().ifPresent(System.out::println);

		Member mem2 = members.stream().filter((m) -> m.getAge() > 30).findFirst().orElseGet(Member::new);

		System.out.println(mem2);
	}
}