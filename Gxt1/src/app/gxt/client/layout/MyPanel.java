package app.gxt.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.theme.base.client.grid.GroupingViewDefaultAppearance;
import com.sencha.gxt.theme.base.client.grid.GroupingViewDefaultAppearance.GroupingViewResources;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.GroupingView;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class MyPanel extends VerticalLayoutContainer{
	
	public interface SampleXTemplates extends XTemplates {
		  @XTemplate("<div>Hello, {name}!</div>")
		  SafeHtml hello(String name);
	}
	
	public MyPanel() {
//		ButtonGroup b;
//		ToolButton button = new ToolButton(ToolButton.PLUS);
//		button.set
		style.ensureInjected();
		bar = new ToolBar();
		bar.add(new Label("add"), new BoxLayoutData(new Margins(4)));
//		bar.add(b = new ButtonGroup());
		panel = new ContentPanel();
		panel.setHeaderVisible(false);
		
//		b.setHeadingText("add");
//		add(button);
		add(bar);
 		add(panel);
 		collapse();
// 		this.
 		
 		button.getElement().setClassName(style.gridGroup());
 		button.getElement().setClassName(style.cellInner());
 		button.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
//				bar.remove(button);
				button.getElement().setClassName(style.gridGroupCollapsed(), cllapse);
				collapse();
			}
		});
		bar.insert(button, 0);
 		
// 		GroupingViewDefaultAppearance d;
	}
	
	public TextButton collapse(){
//		ToolButton button = new ToolButton(ToolButton.PLUS);
		
		cllapse = cllapse ? false: true;
//		final ToolButton button = cllapse ? new ToolButton(ToolButton.PLUS): new ToolButton(ToolButton.MINUS);
		
		
		
//		cllapse ? panel.collapse():panel.expand();
		
		if(!cllapse)
			panel.expand();
		else
			panel.collapse();
		
		return button;
	}
	
	public ContentPanel getPanel() {
		return panel;
	}
	
	final TextButton button = new TextButton(",");
	static GroupingView.GroupingViewStyle style = GWT.<GroupingViewResources> create(GroupingViewResources.class).style();
	boolean cllapse = true;
	ContentPanel panel;
	ToolBar bar;
}
