package com.ruby.java_ch06;

public class Armor {
	private String name; //private는 같은 클래스 안에서만 사용가능, 외부 클래스에서 접근이 안 됨.
	private int height; //private으로 선언된 필드 값을 반환하는 메서드를 'getter(게터)' 부름
	
	public String getName() { 
		return name;
	}
	public void setName(String name) {//여기 값을 '세터'라고 한다. 생성 단축키 "alt +shift + s"
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	

}
	
