package sec01;

import sec01.access.Access;

public class ChildAccess extends Access {
	public void method() {
//		pv = 10; // private 변수는 자식도 접근 불가
//		dv = 20; // default 변수는 다른 패키지에서 접근 불가
		rv = 20; // protected 변수는 패키지 달라도 자식은 접근 허용
		uv = 20;
	}
}
