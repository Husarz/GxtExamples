package app.gxt.client.layout;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.IconButton;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class MyPanel extends VerticalLayoutContainer{
	
	public interface SampleXTemplates extends XTemplates {
		  @XTemplate("<div>Hello, {name}!</div>")
		  SafeHtml hello(String name);
	}
	
	public MyPanel() {
//		ToolButton button = new ToolButton(ToolButton.PLUS);
//		button.set
		bar = new ToolBar();
		bar.add(new Label("add"), new BoxLayoutData(new Margins(4)));
		panel = new ContentPanel();
		panel.setHeaderVisible(false);
		
//		add(button);
		add(bar);
 		add(panel);
 		collapse();
// 		this.
	}
	
	public ToolButton collapse(){
//		ToolButton button = new ToolButton(ToolButton.PLUS);
		
		cllapse = cllapse ? false: true;
		final ToolButton button = cllapse ? new ToolButton(ToolButton.PLUS): new ToolButton(ToolButton.MINUS);
		button.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(SelectEvent event) {
				bar.remove(button);
				collapse();
			}
		});
		bar.insert(button, 0);
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
	
	boolean cllapse = true;
	ContentPanel panel;
	ToolBar bar;
}
