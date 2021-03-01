package acc;

import java.io.Serializable;

import exp.AccountException;

/* SpecialAccount
 * grade : VIP,Gold,Silver,Normal
 * ����: ��޺� �Աݽø��� �Աݾ��� �߰��Ѵ�.(VIP:0.04,Gold:0.03,Silver:0.01,Normal:0.01)
 *      ��, ����� VIP�� ��� 10000�� �Աݽ� 10400�� �Աݵȴ�.
 */
public class SpecialAccount extends Account implements Serializable {
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
	public boolean deposit(int money) throws AccountException {
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
		// TODO Auto-generated method stub
		return super.accInfo()+", ���:"+grade;
	}
}