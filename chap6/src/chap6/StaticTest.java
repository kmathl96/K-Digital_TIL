package chap6;

class Product {
	int serialNum = 0; // ��ü �Ҽ�
	static int snum = 100; // Ŭ���� �Ҽ�; ��ü���� �����ϴ� ����
	public Product() {
		snum++;
		serialNum = snum;
		System.out.println("serialNum:"+serialNum+", snum:"+snum);
	}
}

public class StaticTest {
	public static void main(String[] args) {
		Product[] prs = new Product[5];
		for (int i=0; i<prs.length; i++) {
			prs[i] = new Product();
		}
	}
}