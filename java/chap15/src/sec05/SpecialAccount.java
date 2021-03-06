package sec05;

public class SpecialAccount extends Account {
	String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public SpecialAccount() {}
	public SpecialAccount(String id, String name, int money, String grade) {
		super(id,name,money);
		this.grade=grade;
	}

	@Override
	public boolean deposit(int money) {
		double rate=0;
		switch(grade) {
		case "VIP": rate=0.04; break;
		case "Gold": rate=0.03; break;
		case "Silver": rate=0.02; break;
		case "Normal": rate=0.01; break;
		}
		return super.deposit(money+(int)(money*rate));
	}

	@Override
	public String accInfo() {
		return super.accInfo()+", ���:"+grade;
	}
}
