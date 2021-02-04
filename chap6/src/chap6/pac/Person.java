package chap6.pac;

public class Person {
	// �ٸ� ��Ű������ ���� �����ϰ� �Ϸ��� public���� ����
	// ������ �����ϱ� ���� public�� ������ ����
	// ��� getter,setter�� �̿��Ͽ� �ٸ� ��Ű�������� ������ �� �ְ� ��
	
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

	
	// ������
	public Person() {
		this.name = "none";
		this.age = 0;
	}
	public Person(String name, int age) {
		// ��ü�� �ʵ���� �Լ��� �Ű��������� �����Ƿ� ��ü�� �ʵ�� �տ� this�� �ٿ��� ��
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
		return "�̸�: "+name+", ����: "+age;
	}
}