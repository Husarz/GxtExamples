package app.gxt.shared.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class StoreAppModel implements IsSerializable{

	List<Model> storeApps = new ArrayList<Model>();
	String textArea = "co jest cholera?";
	
	public StoreAppModel() {
	}
	
	public void addStoreApps(Model app){
		storeApps.add(app);
	}
	
	public boolean removeStoreApps(AppModel app){
		return storeApps.remove(app);
	}
 	
	public List<Model> getStoreApps() {
		return storeApps;
	}
	public void setStoreApps(List<Model> storeApps) {
		this.storeApps = storeApps;
	}
	public String getTextArea() {
		return textArea;
	}
	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}
	
	
	public static void initSotore(StoreAppModel appModel){
		List<Model> store = appModel.getStoreApps();
		
		store.add(new Model(AppModel.LINE, "line", 3));
		store.add(new Model(AppModel.SNAKE, "qwerty", 5));
		store.add(new Model(AppModel.SQUARE, "qw1234", 5));
		store.add(new Model(AppModel.LINE, "xcz", 4));
		store.add(new Model(AppModel.SNAKE, "vds", 3));
	}
	
}
