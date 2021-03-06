package chap6.pac;

public class Person {
	// 다른 패키지에서 접근 가능하게 하려면 public으로 선언
	// 보통은 은닉하기 위해 public을 붙이지 않음
	// 대신 getter,setter를 이용하여 다른 패키지에서도 변경할 수 있게 함
	
	String name;
	int age;
	
	// getter, setter
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
		if (age>0) {
			this.age = age;			
		}
	}

	
	// 생성자
	public Person() {
		this.name = "none";
		this.age = 0;
	}
	public Person(String name, int age) {
		// 객체의 필드명과 함수의 매개변수명이 같으므로 객체의 필드명 앞에 this를 붙여야 함
		this.name = name;
		this.age = age;
	}
	public Person(String name) {
		this.name = name;
		this.age = 0;
	}
	public Person(int age) {
		this.name = "none";
		this.age = age;
	}
	
 	public String info() {
		return "이름: "+name+", 나이: "+age;
	}
}