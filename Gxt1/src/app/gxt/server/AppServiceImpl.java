package app.gxt.server;

import java.util.Timer;

import app.gxt.client.service.AppService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AppServiceImpl extends RemoteServiceServlet implements AppService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String [] Tab = {"1...", "2...", "3...", "koniec."};
	
	Timer time = new Timer();
	long timeout = 2000;
	@Override
	public void testCall() {
		try {
			time.wait(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	@Override
	public String infoText(String text) {
		int i = checkText(text);
//		try {
//			time.wait(timeout);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		if (i<Tab.length-1)
			return Tab[i+1];
		return Tab[i];
	}

	private int checkText(String txt){
		for (int i=0; i<Tab.length; i++) {
			if (txt.equalsIgnoreCase(Tab[i]))
				return i;
		}
		return 0;
		
	}

}
