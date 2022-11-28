package zshe;

public class MemberBean {
	private int no;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public MemberBean(int no) {
		super();
		this.no = no;
	}
	public MemberBean() {
	}

	@Override
	public String toString() {
		return String.valueOf( this.no );
	}






}
