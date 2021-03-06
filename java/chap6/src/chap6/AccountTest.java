package chap6;

class Account {
	String account_number;
	String name;
	int balance;
	
	public Account() {
		account_number = "100";
		name = "none";
		balance = 0;
	}
	public Account(String account_number, String name, int balance) {
		this.account_number = account_number;
		this.name = name;
		this.balance = balance;
	}
	public Account(String account_number, int balance) {
		this.account_number = account_number;
		this.name = "none";
		this.balance = balance;
	}
	public void deposit(int amount) {
		if (amount>0) {
			balance += amount;
		}
	}
	public void withdraw(int amount) {
		if (balance >= amount) {			
			balance -= amount;
		} else {
			System.out.println("�ܾ� ����");
		}
	}
	public String info() {
		return "���¹�ȣ:"+account_number+", �̸�:"+name+", �ܾ�:"+balance; 
	}
}

public class AccountTest {
	public static void main(String[] args) {
		Account ac1 = new Account();
		Account ac2 = new Account();
		Account ac3 = new Account();
		
		ac1.account_number = "101";
		ac1.name = "ȫ�浿";
		ac1.balance = 100000;
		ac2.account_number = "102";
		ac2.name = "��浿";
		ac2.balance = 200000;
		
		System.out.println(ac1.info());
		System.out.println(ac2.info());
		System.out.println(ac3.info());
		
		ac1.deposit(10000);
		ac2.withdraw(20000);
		
		System.out.println(ac1.info());
		System.out.println(ac2.info());
		
		Account ac4 = new Account("104","���浿",1000000);
		Account ac5 = new Account("105",100);
		
		System.out.println(ac4.info());
		System.out.println(ac5.info());
	}
}