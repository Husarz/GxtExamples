package app.gxt.client;

import app.gxt.client.infopanel.InfoImpl;
import app.gxt.client.ui.forms.TestForm;
import app.gxt.client.ui.grid.GridImpl;
import app.gxt.client.widgets.RichTabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;

public class MainPanel extends Composite {

	private static MainPanelUiBinder uiBinder = GWT
			.create(MainPanelUiBinder.class);

	interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {
	}

	@UiField BorderLayoutContainer con;
	@UiField TextButton but1, but2, but3, but4;
	@UiField ContentPanel cp;
	
	public MainPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void addAsyncWidget(final IsWidget widget){
		GWT.runAsync(new RunAsyncCallback() {

			@Override
			public void onFailure(Throwable reason) {
				
			}

			@Override
			public void onSuccess() {
				cp.add(widget);
				
			}
			
		});
	}
	public void simpleAddWidget(IsWidget widget){
		cp.add(widget);
	}
	
	@UiHandler({"but1", "but2", "but3", "but4"})
	void clikbut(SelectEvent event){
		Info.display("Click", ((TextButton) event.getSource()).getText() + " clicked");
		TextButton b = (TextButton) event.getSource();
		if ( b==but1 ){
			InfoImpl.getInstInfo().setInfo("info");
			InfoImpl.getInstInfo().setClosealbeWindow(true);
		}
		if ( b==but2 ){
			simpleAddWidget(new RichTabs());
		}
		if ( b==but3 ){
			simpleAddWidget(new GridImpl().asWidget());
		}
		if ( b==but4 ){
			simpleAddWidget(new TestForm());

		}
	}

}
