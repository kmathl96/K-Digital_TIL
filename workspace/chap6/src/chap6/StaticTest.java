package chap6;

class Product {
	int serialNum = 0; // 객체 소속
	static int snum = 100; // 클래스 소속; 객체들이 공유하는 변수
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