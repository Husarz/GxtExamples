package app.gxt.client.widgets;

import app.gxt.client.bundle.AppBundle;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.event.BeforeCloseEvent;
import com.sencha.gxt.widget.core.client.event.BeforeCloseEvent.BeforeCloseHandler;

public class RichTabs extends TabPanel{
	
	SimplePanel panelplus, lastpanel;
	boolean lastactive = false;
	
	public RichTabs() {
		super();
		AppBundle.INST.app().ensureInjected();
		setTabScroll(true);
		setCloseContextMenu(true);
		setWidth(600);
		setHeight(250);
		
		lastpanel = new SimplePanel();
		lastpanel.add(new Label("label1"));
		add(lastpanel, new TabItemConfig("Tab 1", false));
		TabItemConfig tabPlus = new TabItemConfig("", false);
		tabPlus.setHTML("&nbsp;");
		tabPlus.setIcon(AppBundle.INST.plusIcon());
		
		panelplus = new SimplePanel();
		
		add(panelplus, tabPlus);
		
		addSelectionHandler(new SelectionHandler<Widget>() {
			
			@Override
			public void onSelection(SelectionEvent<Widget> event) {
				if(getActiveWidget() == panelplus){
					if(lastactive){
						lastpanel = (SimplePanel)getWidget(getWidgetCount()-2);
						setActiveWidget(lastpanel);
						
					}
					else{
						lastpanel = new SimplePanel();
						lastpanel.add(new Label("tab num: " +String.valueOf(getWidgetCount())));
						insert(lastpanel,getWidgetCount()-1 , 
								new TabItemConfig("Tab " + String.valueOf(getWidgetCount()), true));
						setActiveWidget(lastpanel);
					}
				}
				lastactive=false;
			}
		});
 
		addBeforeCloseHandler(new BeforeCloseHandler<Widget>() {

			@Override
			public void onBeforeClose(BeforeCloseEvent<Widget> event) {
				lastactive = true;
			}
		});
	}
}
