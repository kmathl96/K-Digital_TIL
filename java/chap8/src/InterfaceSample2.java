class Button {
	Clickable c;
	DoubleClickable dc;
	public void click() {
		if (c!=null) {
			c.iclick();
		}
		System.out.println("눌러짐");
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
		System.out.println("로그인 처리");
	}
}

//class LoginClickable implements Clickable {
//	@Override
//	public void iclick() {
//		System.out.println("로그인 처리");
//	}
//}
//
//class JoinClickable implements Clickable {
//
//	@Override
//	public void iclick() {
//		System.out.println("회원가입 처리");
//	}
//}

public class InterfaceSample2 {

	public static void main(String[] args) {
		Button libtn = new Button();
		libtn.addClickListenr(new Button.Clickable() {
			@Override
			public void iclick() {
				System.out.println("로그인 처리");
			}
		});
		libtn.click();
		
		Button joinBtn = new Button();
		joinBtn.addClickListenr(new Button.Clickable() {			
			@Override
			public void iclick() {
				System.out.println("회원가입 처리");
			}
		});
		joinBtn.click(); // 회원가입 처리
	}
}
