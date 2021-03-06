package chap5;

public class CopyArySample {

	public static void main(String[] args) {
		int[] ary = new int[] {10,20,30};
		int[] cpy1 = new int[3];
		int[] cpy2 = new int[3];
		
		cpy1 = ary; // 얕은 복사 (주소값 복사)
		System.arraycopy(ary, 0, cpy2, 0, ary.length); // 깊은 복사 (메모리와 분리하여 복사)
		
		ary[0] = 100; // cpy1[0]은 같이 바뀌나, cpy2[0]은 바뀌지 않음
		
		System.out.println("---원본 데이터---");
		for (int i=0; i<ary.length; i++) {
			System.out.println(ary[i]);
		} // 100 20 30
		System.out.println("---얕은 복사---");
		for (int i=0; i<cpy1.length; i++) {
			System.out.println(cpy1[i]);
		} // 100 20 30
		System.out.println("---깊은 복사---");
		for (int i=0; i<cpy2.length; i++) {
			System.out.println(cpy2[i]);
		} // 10 20 30
	}
}