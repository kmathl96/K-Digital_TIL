package sec01;

import sec01.access.Access;

public class ChildAccess extends Access {
	public void method() {
//		pv = 10; // private ������ �ڽĵ� ���� �Ұ�
//		dv = 20; // default ������ �ٸ� ��Ű������ ���� �Ұ�
		rv = 20; // protected ������ ��Ű�� �޶� �ڽ��� ���� ���
		uv = 20;
	}
}