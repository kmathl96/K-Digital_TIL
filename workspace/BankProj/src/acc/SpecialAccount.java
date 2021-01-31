package acc;

public class SpecialAccount extends Account{
	String grade;

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public SpecialAccount() {}
	public SpecialAccount(String ano, String owner, int balance, String grade) {
		super(ano, owner, balance);
		this.grade = grade;
	}
	
	@Override
	public String getAno() {
		// TODO Auto-generated method stub
		return super.getAno();
	}
	@Override
	public void setAno(String account_number) {
		// TODO Auto-generated method stub
		super.setAno(account_number);
	}
	@Override
	public String getOwner() {
		// TODO Auto-generated method stub
		return super.getOwner();
	}
	@Override
	public void setOwner(String name) {
		// TODO Auto-generated method stub
		super.setOwner(name);
	}
	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return super.getBalance();
	}
	@Override
	public void setBalance(int balance) {
		// TODO Auto-generated method stub
		super.setBalance(balance);
	}
	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		double rate = 0;
		switch(grade) {
		case "VIP": rate = 0.04; break;
		case "Gold": rate = 0.03; break;
		case "Silver": rate = 0.02; break;
		case "Normal": rate = 0.01; break;
		}
		super.deposit(amount+(int)(amount*rate));
	}
	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		super.withdraw(amount);
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info();
	}
	
	
}