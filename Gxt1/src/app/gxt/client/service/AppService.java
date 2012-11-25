package app.gxt.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("manage")
public interface AppService extends RemoteService {

	void testCall();
	String infoText(String text);
}
