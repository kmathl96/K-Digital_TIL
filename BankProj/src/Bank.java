import java.util.Scanner;

import acc.Account;
import acc.SpecialAccount;
import exp.AccountException;
import exp.BankExpCode;

public class Bank {
	Scanner sc = new Scanner(System.in);
	Account[] accs = new Account[100];
	int accCnt;
	
	public int getAccCnt() {
		return accCnt;
	}
	public void createAccount() throws AccountException {
		System.out.println("--------");
		System.out.println("�Ϲݰ��»���");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�ʱ��Աݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		
		try {
			searchAccById(id);
			throw new AccountException(BankExpCode.EXIST_ACC);
		} catch (AccountException e) {
			if (e.getErrCode()==BankExpCode.EXIST_ACC)
				throw e;
			accs[accCnt++] = new Account(id,name,money);
			System.out.println("���:�Ϲݰ��°� �����Ǿ����ϴ�.");
		}		
	}
	public void createSpecialAccount() throws AccountException {
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

		try {
			searchAccById(id);
			throw new AccountException(BankExpCode.EXIST_ACC);
		} catch (Exception e) {
			accs[accCnt++] = new SpecialAccount(id,name,money,grade);
			System.out.println("���:Ư�����°� �����Ǿ����ϴ�.");
		}
	}
	public void accsList() throws AccountException {
		System.out.println("---------------------------");
		System.out.println("1.�Ϲݰ��� | 2.Ư������ | 3.��ü");
		System.out.println("---------------------------");
		System.out.print("����>>");
		int sel= Integer.parseInt(sc.nextLine());
		if (sel==1) {
			System.out.println("--------");
			System.out.println("���¸��");
			System.out.println("--------");
			for(int i=0; i<accCnt; i++) {
				if (!(accs[i] instanceof SpecialAccount))
					System.out.println(accs[i].accInfo());
			}
		} else if (sel==2) {
			System.out.println("--------");
			System.out.println("���¸��");
			System.out.println("--------");
			for(int i=0; i<accCnt; i++) {
				if (accs[i] instanceof SpecialAccount)
					System.out.println(accs[i].accInfo());
			}
		} else if (sel==3){
			System.out.println("--------");
			System.out.println("���¸��");
			System.out.println("--------");
			for(int i=0; i<accCnt; i++) {
				System.out.println(accs[i].accInfo());
			}
		} else {
			throw new AccountException(BankExpCode.LIST_MENU);
		}
	}
	private Account searchAccById(String id) throws AccountException {
		for(int i=0; i<accCnt; i++) {
			if(accs[i].getId().equals(id)) {
				return accs[i];
			}
		}
		throw new AccountException(BankExpCode.NOT_ACC);
	}
	public void deposit() throws AccountException {
		System.out.println("--------");
		System.out.println("�Ա�");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("���ݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		acc.deposit(money);
		System.out.println("���:������ �����Ͽ����ϴ�.");
	}
	public void withdraw() throws AccountException {
		System.out.println("--------");
		System.out.println("���");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("��ݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		acc.withdraw(money);
		System.out.println("���:����� �����Ͽ����ϴ�.");
	}
	public void accInfo() throws AccountException {
		System.out.println("--------");
		System.out.println("������ȸ");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String id=sc.nextLine();
		Account acc = searchAccById(id);
		System.out.println(acc.accInfo());
		System.out.println("���:���°� ��ȸ�Ǿ����ϴ�.");
	}	
	public int menu() throws AccountException {
		System.out.println("------------------------------------------------------");
		System.out.println("1.���»��� | 2.������ȸ | 3.���¸�� | 4.���� | 5.��� | 0.����");
		System.out.println("------------------------------------------------------");
		System.out.print("����>>");
		int sel = Integer.parseInt(sc.nextLine());
		if (sel>=0 && sel<=5) return sel;
		throw new AccountException(BankExpCode.MAIN_MENU);
	}
	public void accMenu() throws AccountException {
		System.out.println("-------------------");
		System.out.println("1.�Ϲݰ��� | 2.Ư������");
		System.out.println("-------------------");
		System.out.print("����>>");
		int sel= Integer.parseInt(sc.nextLine());
		if(sel==1) {
			createAccount();
		} else if (sel==2){
			createSpecialAccount();
		} else {
			throw new AccountException(BankExpCode.ACC_MENU);
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
			} catch (AccountException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}