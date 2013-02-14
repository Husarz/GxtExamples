package app.gxt.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum AppModel implements IsSerializable{
	SNAKE("waz"), LINE("linia"), SQUARE("kwadrat");
	
	String label;
	Boolean bool = false;
	
	AppModel(String label) {
		this.label=label;
	}

	public String getLabel() {
		return label;
	}
	
	public Boolean isBool(){
		return bool;
	}
}
