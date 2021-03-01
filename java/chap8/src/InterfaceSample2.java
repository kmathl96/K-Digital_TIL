class Button {
	Clickable c;
	DoubleClickable dc;
	public void click() {
		if (c!=null) {
			c.iclick();
		}
		System.out.println("������");
	}
	public void doubleClick() {
		if (dc!=null) {
			dc.idoubleClick();
		}
	}
	public void addClickListenr(Clickable c) {
		this.c=c;
	}
	public void addDoubleClickListenr(DoubleClickable dc) {
		this.dc=dc;
	}
	interface Clickable {
		void iclick();
	}
	interface DoubleClickable {
		void idoubleClick();
	}
}

class LoginButton extends Button {
	@Override
	public void click() {
		super.click();
		System.out.println("�α��� ó��");
	}
}

//class LoginClickable implements Clickable {
//	@Override
//	public void iclick() {
//		System.out.println("�α��� ó��");
//	}
//}
//
//class JoinClickable implements Clickable {
//
//	@Override
//	public void iclick() {
//		System.out.println("ȸ������ ó��");
//	}
//}

public class InterfaceSample2 {

	public static void main(String[] args) {
		Button libtn = new Button();
		libtn.addClickListenr(new Button.Clickable() {
			@Override
			public void iclick() {
				System.out.println("�α��� ó��");
			}
		});
		libtn.click();
		
		Button joinBtn = new Button();
		joinBtn.addClickListenr(new Button.Clickable() {			
			@Override
			public void iclick() {
				System.out.println("ȸ������ ó��");
			}
		});
		joinBtn.click(); // ȸ������ ó��
	}
}