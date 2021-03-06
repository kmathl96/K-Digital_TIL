package problem20;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static  Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택> ");
			
			// 1~5가 아닌 숫자나 다른 문자열이 들어오는 경우를 처리하기 위해 nextLine()으로 입력 받음
			String selectNo = scanner.nextLine();
			
			if (selectNo.equals("1")) {
				createAccount();
			} else if (selectNo.equals("2")) {
				accountList();
			} else if (selectNo.equals("3")) {
				deposit();
			} else if (selectNo.equals("4")) {
				withdraw();
			} else if (selectNo.equals("5")) {
				run = false;
			} else { // 1~5가 아닌 문자열인 경우
				System.out.println("다시 입력해 주세요.");
			}
			
//			// switch문으로 처리하는 경우
//			switch(selectNo) {
//			case 1: createAccount(); break;
//			case 2: accountList(); break;
//			case 3: deposit(); break;
//			case 4: withdraw(); break;
//			case 5: run = false; break;
//			default: System.out.println("다시 입력해 주세요.");
//			}
		}
		System.out.println("프로그램 종료");
	}
	
	// 계좌 생성하기
	private static void createAccount() {
		System.out.println("------");
		System.out.println("계좌생성");
		System.out.println("------");

		System.out.print("계좌번호: ");
		String ano = scanner.next();
		System.out.print("계좌주: ");
		String owner = scanner.next();
		System.out.print("초기입금액: ");
		int balance = scanner.nextInt();
		
		accountArray[Account.num] = new Account(ano, owner, balance);
		Account.num++;
		System.out.println("결과: 계좌가 생성되었습니다.");
	}
	
	// 계좌 목록 보기
	private static void accountList() {
		System.out.println("------");
		System.out.println("계좌목록");
		System.out.println("------");
		for (int i=0; i<Account.num; i++) {
			System.out.println(accountArray[i].getAno()+'\t'+accountArray[i].getOwner()+'\t'+accountArray[i].getBalance());
		}
	}
	
	// 예금하기
	private static void deposit() {
		System.out.println("------");
		System.out.println("예금");
		System.out.println("------");

		System.out.print("계좌번호: ");
		String ano = scanner.next();
		System.out.print("예금액: ");
		int amount = scanner.nextInt();
		
		if (findAccount(ano) != null) {
			int balance = findAccount(ano).getBalance();
			findAccount(ano).setBalance(balance+amount);
			System.out.println("결과: 예금이 성공되었습니다.");
		} else {
			System.out.println("해당 계좌는 존재하지 않습니다.");
		}
	}
	
	// 출금하기
	private static void withdraw() {
		System.out.println("------");
		System.out.println("출금");
		System.out.println("------");

		System.out.print("계좌번호: ");
		String ano = scanner.next();
		System.out.print("출금액: ");
		int amount = scanner.nextInt();
		
		if (findAccount(ano) != null) {
			int balance = findAccount(ano).getBalance();
			if (balance >= amount) {
				findAccount(ano).setBalance(balance-amount);
				System.out.println("결과: 출금이 성공되었습니다.");			
			} else {
				System.out.println("결과: 출금이 실패되었습니다.");			
			}
		} else {
			System.out.println("해당 계좌는 존재하지 않습니다.");
		}
	}
	
	// Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		Account ac = null;
		for (int i=0; i<Account.num; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				ac = accountArray[i];
			}
		}
		return ac;
	}
}
