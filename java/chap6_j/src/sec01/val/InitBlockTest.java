package sec01.val;

class InitTest {
	int iv=1;
	static int sv = 10;
	static int[] sarr = new int[10];
//	sarr[0] = 1; // 명령어는 메소드 안에서만 쓸 수 있음
	
	{ // instance 초기화 block
		System.out.println(iv); // 1
		iv = 2;
		System.out.println(iv); // 2
	}
	static { // static 초기화 block
		// 객체 생성보다 먼저 됨 => 10 20이 먼저 출력됨
		// 객체 여러 번 생성해도 또 실행되지 않음 (맨 처음 한번만 실행됨)
		System.out.println(sv);
		sv = 20;
		System.out.println(sv);
		
		// 코드로 여러 개를 초기화 할 때 static block 사용
		for (int i=0; i<sarr.length; i++) {
			sarr[i] = 10;
		}
	}
	InitTest() {
		iv = 3;
		System.out.println(iv); // 3
	}
}

public class InitBlockTest {

	public static void main(String[] args) {
		InitTest it1 = new InitTest();
		InitTest it2 = new InitTest();
	}
}