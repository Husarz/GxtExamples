package app.gxt.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.theme.gray.client.panel.GrayContentPanelAppearance;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

public class MyContentPanel extends ContentPanel{
	
	public MyContentPanel() {
		addPanel();
		addPanel();
		addPanel();
		addPanel();
//		DOM.setStyleAttribute(, "border", "1px solid black");
		
		this.add(vc);
	}
	
	void addPanel(){
		VerticalLayoutContainer v = new VerticalLayoutContainer();
		v.add(new HTML("cos tam"), new VerticalLayoutData(0.9, -1));
		v.add(new HTML("cos tam"), new VerticalLayoutData(0.9, -1));
		v.add(new HTML("cos tam"), new VerticalLayoutData(0.9, -1));

		System.out.println(appearance.collapseIcon().getStyle());
		
		MyPanel panel = new MyPanel();
		ContentPanel cp = panel.getPanel();
//		DOM.setStyleAttribute(cp.getBody(), "float", "left !important");
		cp.setCollapsible(true);
//		cp.getBody().set setBodyStyle();
//		cp.getHeader().addStyleName();
		cp.add(v);
		vc.add(panel, new VerticalLayoutData(0.9, -1));
	}
	AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);
	VerticalLayoutContainer vc = new VerticalLayoutContainer();
}
