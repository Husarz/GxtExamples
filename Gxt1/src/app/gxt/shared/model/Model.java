package app.gxt.shared.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Model implements Serializable{

	private static long serialVersionUID = 0;
	
	Long id;
	AppModel app;
	String name;
	Integer count = 0;
	
	public Model() {
		this(AppModel.LINE, "default");
	}
	
	public Model(AppModel app, String name) {
		this.app = app;
		this.name = name;
		this.id = serialVersionUID++;
	}
	public Model(AppModel app, String name, Integer count) {
		this(app, name);
		setCount(count);
	}

	public Long getId() {
		return id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public AppModel getApp() {
		return app;
	}

	public void setApp(AppModel app) {
		this.app = app;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
