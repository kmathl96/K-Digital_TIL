package sec05;

import java.util.HashMap;
import java.util.Scanner;

//import acc.SpecialAccount;

public class Bank {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Account> accs = new HashMap<String, Account>();
	
	public void createAccount() {
		System.out.println("--------");
		System.out.println("�Ϲݰ��»���");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�ʱ��Աݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		
		if (accs.containsKey(id)) {
			System.out.println("�̹� �����ϴ� �����Դϴ�.");
		} else {
			accs.put(id, new Account(id, name, money));
			System.out.println("�Ϲݰ��°� �����Ǿ����ϴ�.");
		}	
	}
	public void createSpecialAccount() {
		System.out.println("--------");
		System.out.println("Ư�����»���");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�ʱ��Աݾ�:");
		int money = Integer.parseInt(sc.nextLine());	
		System.out.print("���(VIP:1,Gold:2,Silver:3,Normal:4):");
		int ngrade=Integer.parseInt(sc.nextLine());
		String grade="Normal";
		switch(ngrade) {
		case 1: grade="VIP"; break;
		case 2: grade="Gold"; break;
		case 3: grade="Silver"; break;
		case 4: grade="Normal"; break;
		}

		if (accs.containsKey(id)) {
			System.out.println("�̹� �����ϴ� �����Դϴ�.");
		} else {
			accs.put(id, new SpecialAccount(id, name, money, grade));
			System.out.println("Ư�����°� �����Ǿ����ϴ�.");
		}
	}
	public void accsList() {
		System.out.println("---------------------------");
		System.out.println("1.�Ϲݰ��� | 2.Ư������ | 3.��ü");
		System.out.println("---------------------------");
		System.out.print("����>>");
		int sel= Integer.parseInt(sc.nextLine());
		if (sel==1) {
			System.out.println("--------");
			System.out.println("���¸��");
			System.out.println("--------");
			for (Account acc : accs.values()) {
				if (!(acc instanceof SpecialAccount))
					System.out.println(acc.accInfo());
			}
		} else if (sel==2) {
			System.out.println("--------");
			System.out.println("���¸��");
			System.out.println("--------");
			for (Account acc : accs.values()) {
				if (acc instanceof SpecialAccount)
					System.out.println(acc.accInfo());
			}
		} else if (sel==3){
			System.out.println("--------");
			System.out.println("���¸��");
			System.out.println("--------");
			for (Account acc : accs.values()) {
				System.out.println(acc.accInfo());
			}
		} else {
			System.out.println("1~3�� �Է��� �ּ���.");
		}
	}
	private Account searchAccById(String id) {
		if (accs.containsKey(id))
			return accs.get(id);
		return null;
	}
	public void deposit() {
		System.out.println("--------");
		System.out.println("�Ա�");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("���ݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		if (acc==null) {
			System.out.println("���°� �������� �ʽ��ϴ�.");
		} else {
			if (acc.deposit(money)) {
				System.out.println("���:������ �����Ͽ����ϴ�.");
			} else {
				System.out.println("���:������ �����Ͽ����ϴ�.");
			}
		}
	}
	public void withdraw() {
		System.out.println("--------");
		System.out.println("���");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("��ݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		if (acc==null) {
			System.out.println("���°� �������� �ʽ��ϴ�.");
		} else {
			if (acc.withdraw(money)) {
				System.out.println("���:����� �����Ͽ����ϴ�.");				
			} else {
				System.out.println("���:����� �����Ͽ����ϴ�.");
			}
		}
	}
	public void accInfo() {
		System.out.println("--------");
		System.out.println("������ȸ");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id=sc.nextLine();
		Account acc = searchAccById(id);
		if (acc==null) {
			System.out.println("���°� �������� �ʽ��ϴ�.");
		} else {
			System.out.println(acc.accInfo());
			System.out.println("���:���°� ��ȸ�Ǿ����ϴ�.");
		}
	}	
	public int menu() {
		while (true) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.���»��� | 2.������ȸ | 3.���¸�� | 4.���� | 5.��� | 0.����");
			System.out.println("------------------------------------------------------");
			System.out.print("����>>");
			int sel = Integer.parseInt(sc.nextLine());
			if (sel>=0 && sel<=5) {
				return sel;
			} else {
				System.out.println("1~3�� �Է��� �ּ���.");
			}
		}
	}
	public void accMenu() {
		System.out.println("-------------------");
		System.out.println("1.�Ϲݰ��� | 2.Ư������");
		System.out.println("-------------------");
		System.out.print("����>>");
		int sel= Integer.parseInt(sc.nextLine());
		if(sel==1) {
			createAccount();
		} else if (sel==2){
			createSpecialAccount();
		}
	}
	public static void main(String[] args) {
		Bank bank = new Bank();
		int sel;
		while(true) {
			try {
				sel = bank.menu();
				if (sel==0)
					break;
				switch(sel) {
				case 1: bank.accMenu(); break;
				case 2: bank.accInfo(); break;
				case 3: bank.accsList(); break;
				case 4: bank.deposit(); break;
				case 5: bank.withdraw(); break;
				}
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��� �����մϴ�.");
			}
		}
	}
}