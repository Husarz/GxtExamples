package app.gxt.client.service;

import java.util.List;

import app.gxt.shared.model.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AppServiceAsync {

	void testCall(AsyncCallback<Void> callback);

	void infoText(String text, AsyncCallback<String> callback);

	void getChildren(AsyncCallback<List<User>> callback);
	

}
