package emp;

public class PartTime extends Employee implements IBusinessTrip {
	int time;
	int payPerTime;
	public PartTime(String id, String name, int time, int payPerTime) {
		super(id, name);
		this.time = time;
		this.payPerTime = payPerTime;
	}
	@Override
	public int getPay() {
		return time*payPerTime;
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+", �޿�:"+getPay();
	}
	@Override
	public void goBusinessTrip(int day) {
		time += day*24;
	}
}