package app.gxt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AppServiceAsync {

	void testCall(AsyncCallback<Void> callback);

	void infoText(String text, AsyncCallback<String> callback);
	

}
