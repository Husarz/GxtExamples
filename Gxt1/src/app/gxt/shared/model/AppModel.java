package app.gxt.shared.model;

public enum AppModel {
	SNAKE("waz"), LINE("linia"), SQUARE("kwadrat");
	
	String label;
	
	private AppModel(String label) {
		this.label=label;
	}

	public String getLabel() {
		return label;
	}
}
