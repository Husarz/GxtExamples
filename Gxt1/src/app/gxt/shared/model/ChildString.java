package app.gxt.shared.model;

public class ChildString extends BaseValue {
	
	String str;

	public ChildString(String s) {
		super();
		setStr(s);
		setValue(this);
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
