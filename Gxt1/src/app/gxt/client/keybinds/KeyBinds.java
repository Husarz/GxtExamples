package app.gxt.client.keybinds;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HTML;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.widget.core.client.Composite;

public class KeyBinds extends Composite  implements HasKeyDownHandlers {
	
	public interface LabelXTemplates extends XTemplates {
		@XTemplate("<table><tr><td> keyCode </td> <td>{keyCode}</td> </tr>" +
				"<tr><td> x,y </td> <td>{xy}</td> </tr>" +
				"</table>")
		SafeHtml hello(String keyCode, String xy);
	}
	HTML label;
	LabelXTemplates info = GWT.create(LabelXTemplates.class);
	
	public KeyBinds() {
		label = new HTML("look");
		initWidget(label);
		setHeight(300);
		setWidth(300);
		
		sinkEvents(Event.KEYEVENTS);
	}

	@Override
	public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
		return null;
	}

//	@Override
//	public void onKeyDown(KeyDownEvent event) {
//		if (event.isControlKeyDown()){
//			String keyCode = String.valueOf(event.getNativeEvent().getKeyCode());
//			String xy = String.valueOf(event.getNativeEvent().getClientX()) + ","
//					+ String.valueOf(event.getNativeEvent().getClientY());
//			label.setHTML(info.hello(keyCode,xy));
//			return;
//		}
//		String keyCode = String.valueOf(event.getNativeEvent().getKeyCode());
//		String xy = String.valueOf(event.getNativeEvent().getClientX()) + ","
//				+ String.valueOf(event.getNativeEvent().getClientY());
//		label.setHTML(info.hello(keyCode,xy));
//
//	}
}
