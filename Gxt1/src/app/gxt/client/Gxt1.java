package app.gxt.client;

import app.gxt.client.infopanel.Info;
import app.gxt.client.infopanel.InfoImpl;
import app.gxt.client.service.AppService;
import app.gxt.client.service.AppServiceAsync;
import app.gxt.client.widgetupload.FileUploadExample;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gxt1 implements EntryPoint {

	AppServiceAsync service = (AppServiceAsync) GWT.create(AppService.class);
	Info info = InfoImpl.getInst();

	public void onModuleLoad() {
		// MessageBox popup = new MessageBox("OK", "Hello World");
		// RootPanel.get().add(popup);
		// popup.show();

		RootPanel.get().add(new FileUploadExample().asWidget());
	}

	String result;
	Timer t = new Timer() {
		@Override
		public void run() {
			if (!result.equalsIgnoreCase("koniec."))
				service.infoText(result, callback);
			
			else {
				info.setClosealbe(true);
			}
		}
	};

	AsyncCallback<String> callback = new AsyncCallback<String>() {

		@Override
		public void onSuccess(String result) {
			info.setTextInfo(result);
			Gxt1.this.result = result;
			t.schedule(3000);
			
		}

		@Override
		public void onFailure(Throwable caught) {
			info.setTextInfo("zawiodlo");

		}
	};

	public Widget asWidget() {

		TextButton btn = new TextButton("Hello World");
		btn.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				
				info.setTextInfo("Sprawdzam ..... !!!");
				service.infoText("Sprawdzam ..... !!!", callback);
				
			}
		});
		// window.setData("open", btn);
		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(10);
		vp.add(btn);
		return vp;
	}

}
