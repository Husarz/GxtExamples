package app.gxt.client;

import app.gxt.client.ui.grid.MenuGroupGrid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

public class MainPanel extends Composite {

	private static MainPanelUiBinder uiBinder = GWT
			.create(MainPanelUiBinder.class);

	interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {
	}

	@UiField BorderLayoutContainer con;
//	@UiField TextButton but1, but2, but3, but4, but5, but6, but7, but8, but9, but10;
	@UiField ContentPanel cp;
	@UiField MenuGroupGrid menu;
	
	
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
	
//	@UiHandler({"but1", "but2", "but3", "but4", "but5", "but6", "but7", "but8", "but9", "but10"})
//	void clikbut(SelectEvent event){
//		Info.display("Click", ((TextButton) event.getSource()).getText() + " clicked");
//		TextButton b = (TextButton) event.getSource();
//		if ( b==but1 ){
//			InfoImpl.getInstInfo().setInfo("info");
//			InfoImpl.getInstInfo().setClosealbeWindow(true);
//		}
//		if ( b==but2 ){
//			simpleAddWidget(new RichTabs());
//		}
//		if ( b==but3 ){
//			simpleAddWidget(new GridImpl().asWidget());
//		}
//		if ( b==but4 ){
//			simpleAddWidget(new TestForm());
//		}
//		if ( b==but5 ){
//			simpleAddWidget(new MessageBoxExample().asWidget());
//		}
//		if ( b==but6){
//			simpleAddWidget(new RichTabs());
//		}
//		if ( b==but7){
//			simpleAddWidget(new verticalPanel());
//		}
//		if ( b==but8){
//			new AreaTextWidget().showWindow();
//		}
//		if ( b==but9){
//			simpleAddWidget(new Grid2());
//		}
//		if ( b==but10){
//			simpleAddWidget(new TestFieldLabel());
//		}
//	}

}
