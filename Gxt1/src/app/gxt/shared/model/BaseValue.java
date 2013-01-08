package app.gxt.shared.model;

public abstract class BaseValue {

	BaseValue value;
	
	public BaseValue(){}
	
	public BaseValue(BaseValue val){
		setValue(val);
	}

	public BaseValue getValue() {
		return value;
	}

	public void setValue(BaseValue value) {
		this.value = value;
	}
}
