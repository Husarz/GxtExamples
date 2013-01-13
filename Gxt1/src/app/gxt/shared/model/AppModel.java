package app.gxt.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum AppModel implements IsSerializable{
	SNAKE("waz"), LINE("linia"), SQUARE("kwadrat");
	
	String label;
	
	AppModel(String label) {
		this.label=label;
	}

	public String getLabel() {
		return label;
	}
}
