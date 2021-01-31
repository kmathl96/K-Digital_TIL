package acc;

public class Account {
	String ano;
	String name;
	int balance;
	public static int num;
	
	public Account() {
		ano = "100";
		name = "none";
		balance = 0;
	}
	public Account(String account_number, String name, int balance) {
		this.ano = account_number;
		this.name = name;
		this.balance = balance;
	}
	public Account(String account_number, int balance) {
		this.ano = account_number;
		this.name = "none";
		this.balance = balance;
	}
	
	public String getAno() {
		return ano;
	}
	public void setAno(String account_number) {
		this.ano = account_number;
	}
	public String getOwner() {
		return name;
	}
	public void setOwner(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
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
		return "���¹�ȣ:"+ano+", �̸�:"+name+", �ܾ�:"+balance; 
	}
}