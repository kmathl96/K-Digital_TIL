import java.util.Scanner;

import acc.Account;
import acc.SpecialAccount;

public class Bank {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("------------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("------------------------------------------");
			System.out.print("����> ");
			
			// 1~5�� �ƴ� ���ڳ� �ٸ� ���ڿ��� ������ ��츦 ó���ϱ� ���� nextLine()���� �Է� ����
			String selectNo = scanner.nextLine();
			
			if (selectNo.equals("1")) {

				System.out.println("------------------");
				System.out.println("1.�Ϲݰ��� | 2.Ư������");
				System.out.println("------------------");
				System.out.print("����> ");
				String sel = scanner.nextLine();
				if (sel.equals("1")) {
					createAccount();
				} else if (sel.equals("2")) {
					createSpecialAccount();
				} else {
					System.out.println("��;;");
				}
				
			} else if (selectNo.equals("2")) {
				accountList();
			} else if (selectNo.equals("3")) {
				deposit();
			} else if (selectNo.equals("4")) {
				withdraw();
			} else if (selectNo.equals("5")) {
				run = false;
			} else { // 1~5�� �ƴ� ���ڿ��� ���
				System.out.println("�ٽ� �Է��� �ּ���.");
			}
			
//			// switch������ ó���ϴ� ���
//			switch(selectNo) {
//			case 1: createAccount(); break;
//			case 2: accountList(); break;
//			case 3: deposit(); break;
//			case 4: withdraw(); break;
//			case 5: run = false; break;
//			default: System.out.println("�ٽ� �Է��� �ּ���.");
//			}
		}
		System.out.println("���α׷� ����");
	}
	
	// ���� �����ϱ�
	private static void createAccount() {
		System.out.println("----------");
		System.out.println("�Ϲݰ��� ����");
		System.out.println("----------");

		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("������: ");
		String owner = scanner.next();
		System.out.print("�ʱ��Աݾ�: ");
		int balance = scanner.nextInt();
		
		accountArray[Account.num++] = new Account(ano, owner, balance);
		System.out.println("���: ���°� �����Ǿ����ϴ�.");
	}
	// ����� ���� �����ϱ�
	private static void createSpecialAccount() {
		System.out.println("----------");
		System.out.println("Ư������ ����");
		System.out.println("----------");

		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("������: ");
		String owner = scanner.next();
		System.out.print("�ʱ��Աݾ�: ");
		int balance = scanner.nextInt();
		scanner.nextLine();
		System.out.print("���(VIP:1, Gold:2, Silver:3, Normal:4): ");
//		String ngrade = scanner.next();
		int ngrade = Integer.parseInt(scanner.nextLine());
		String grade = "Normal";
		switch(ngrade) {
		case 1: grade = "VIP"; break;
		case 2: grade = "Gold"; break;
		case 3: grade = "Silver"; break;
		case 4: grade = "Normal"; break;
		}
		accountArray[Account.num++] = new SpecialAccount(ano, owner, balance, grade);
		System.out.println("���: ���°� �����Ǿ����ϴ�.");
	}
	// ���� ��� ����
	private static void accountList() {
		System.out.println("--------------------------");
		System.out.println("1.�Ϲݰ��� | 2.Ư������ | 3.��ü");
		System.out.println("--------------------------");
		
		System.out.print("����> ");
		String sel = scanner.nextLine();
		if (sel.equals("1")) {
			System.out.println("----------");
			System.out.println("�Ϲݰ��� ���");
			System.out.println("----------");
			for (int i=0; i<Account.num; i++) {
				Account ac = accountArray[i];
				if (!(ac instanceof SpecialAccount)) {					
					System.out.println(accountArray[i].getAno()+'\t'+accountArray[i].getOwner()+'\t'+accountArray[i].getBalance());
				}
			}
		} else if (sel.equals("2")) {
			System.out.println("----------");
			System.out.println("Ư������ ���");
			System.out.println("----------");
			for (int i=0; i<Account.num; i++) {
				Account ac = accountArray[i];
				if (ac instanceof SpecialAccount) {					
					System.out.println(accountArray[i].getAno()+'\t'+accountArray[i].getOwner()+'\t'+accountArray[i].getBalance());
				}
			}
		} else if (sel.equals("3")) {
			System.out.println("-------");
			System.out.println("���� ���");
			System.out.println("-------");
			for (int i=0; i<Account.num; i++) {
				System.out.println(accountArray[i].getAno()+'\t'+accountArray[i].getOwner()+'\t'+accountArray[i].getBalance());
			}
		} else {
			System.out.println("^^;");
		}
		
	}
	
	// �����ϱ�
	private static void deposit() {
		System.out.println("------");
		System.out.println("����");
		System.out.println("------");

		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("���ݾ�: ");
		int amount = scanner.nextInt();
		
		if (findAccount(ano) != null) {
			int balance = findAccount(ano).getBalance();
			findAccount(ano).setBalance(balance+amount);
			System.out.println("���: ������ �����Ǿ����ϴ�.");
		} else {
			System.out.println("�ش� ���´� �������� �ʽ��ϴ�.");
		}
	}
	
	// ����ϱ�
	private static void withdraw() {
		System.out.println("------");
		System.out.println("���");
		System.out.println("------");

		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("��ݾ�: ");
		int amount = scanner.nextInt();
		
		if (findAccount(ano) != null) {
			int balance = findAccount(ano).getBalance();
			if (balance >= amount) {
				findAccount(ano).setBalance(balance-amount);
				System.out.println("���: ����� �����Ǿ����ϴ�.");			
			} else {
				System.out.println("���: ����� ���еǾ����ϴ�.");			
			}
		} else {
			System.out.println("�ش� ���´� �������� �ʽ��ϴ�.");
		}
	}
	
	// Account �迭���� ano�� ������ Account ��ü ã��
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