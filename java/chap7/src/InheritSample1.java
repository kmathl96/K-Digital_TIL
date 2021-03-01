class Person {
	int age;
	String name;
	
	public Person() {}
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public String info() {
		return "�̸�:"+name+", ����:"+age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Student extends Person {
	String major;

	public Student(int age, String name,String major) {
		super(age, name);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String info() {
		return super.info()+", ����:"+major;
	}
}

class Professor extends Person {
	String department;
	public Professor() {}
	public Professor(int age, String name, String department) {
		super(age, name);
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String info() {
		return super.info()+", �μ�:"+department;
	}
}

public class InheritSample1 {
	static Person[] pers = new Person[10];
	
	public static void main(String[] args) {
//		Student s = new Student(26,"���浿","���а�");
//		System.out.println(s.info());
//		Person p = new Student(26,"���浿","���а�"); // upcasting : �ڽ� ��ü�� �θ� Ÿ�� ������ ���� �� ����
//		Student s2 = (Student)p; // downcasting : �θ� Ÿ���� ��ü�� �ڽ� Ÿ�� ������ ����
		
		// ������
		// ��Ӱ� �������̵��� �� �ڽ� Ŭ������ �����Ͽ� �θ� ������ �־��� ��,
		// �θ��� ������ ���� �������̵� �� �޼ҵ带 ȣ���� ��� �ڽ� �޼ҵ尡 ȣ���
//		Person p = new Student(20,"���浿","����");
//		System.out.println(p.info());
		
		pers[0] = new Student(20,"���浿","����");
		pers[1] = new Student(30,"�ϱ浿","��ǻ�Ͱ���");
		pers[2] = new Professor(50,"������","�������к�");
		
		for (int i=0; i<3; i++) {
			System.out.println(pers[i].info());
		}
		
		for (int i=0; i<3; i++) {
			if (pers[i] instanceof Student) {
//				System.out.println(pers[i].info());
				Student s = (Student)pers[i];
				System.out.println(s.getMajor());
			}
		}
	}
}