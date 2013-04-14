package app.gxt.client.service;

import java.util.List;

import app.gxt.shared.model.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("manage")
public interface AppService extends RemoteService {

	void testCall();
	String infoText(String text);
	
	List<User> getChildren();
}
