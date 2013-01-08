package app.gxt.shared.model;

public class ChildBool extends BaseValue {

	Boolean b;

	public ChildBool(Boolean b) {
		super();
		setB(b);
		setValue(this);
	}
	
	public Boolean getB() {
		return b;
	}

	public void setB(Boolean b) {
		this.b = b;
	}
	
}
