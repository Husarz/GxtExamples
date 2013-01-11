package app.gxt.shared.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class StoreAppModel implements IsSerializable{

	List<AppModel> storeApps = new ArrayList<AppModel>();
	String textArea = "co jest cholera?";
	
	public StoreAppModel() {
	}
	
	public void addStoreApps(AppModel app){
		storeApps.add(app);
	}
	
	public boolean removeStoreApps(AppModel app){
		return storeApps.remove(app);
	}
 	
	public List<AppModel> getStoreApps() {
		return storeApps;
	}
	public void setStoreApps(List<AppModel> storeApps) {
		this.storeApps = storeApps;
	}
	public String getTextArea() {
		return textArea;
	}
	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}
	
	
}
