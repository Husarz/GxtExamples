package app.gxt.client.infopanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class InfoImpl implements IsWidget, Info{

	private static InfoImplUiBinder uiBinder = GWT.create(InfoImplUiBinder.class);

	interface InfoImplUiBinder extends UiBinder<Widget, InfoImpl> {
	}
	
	
	public interface HelloTemplate extends XTemplates{
		@XTemplate("Info: <b> {text}!</b>")
		SafeHtml setText(String text);
	}

	private static final Info INST = new InfoImpl();
	
	@UiField Window window;
//	@UiField HTML info;
	@UiField SpanElement span;
	@UiField TextButton closeButton;
	
	Widget widget=null;
	
	Info panel;
	
	HelloTemplate template = GWT.<HelloTemplate>create(HelloTemplate.class);

	
	
	private InfoImpl() {
//		AppBundle.INST.app().ensureInjected();
	}

	public Widget asWidget() {
		widget = uiBinder.createAndBindUi(this);
		template = GWT.<HelloTemplate>create(HelloTemplate.class);
		closeButton.disable();
		return widget;
		
	}
	
	public Widget asCloseableWidget() {
		template = GWT.<HelloTemplate>create(HelloTemplate.class);
		return widget = uiBinder.createAndBindUi(this);
	}


	@UiHandler("closeButton")
	public void onCloseButtonClicked(SelectEvent event) {
		closeInfo();
	}

	@Override
	public void setTextInfo(String text) {
		if(widget==null)
			asWidget();
		if(widget!=null){
			span.setInnerSafeHtml(getUpdatedPanel(text));
			if (!isVisibleInfo())
				window.show();
		}
	}

	@Override
	public void closeInfo() {
		if(widget!=null)
			window.hide();
		widget = null;
	}

	@Override
	public boolean isVisibleInfo() {
		if (widget!=null)
			return window.isVisible();
		return false;
	}
	
	private SafeHtml getUpdatedPanel(String text) {
		return template.setText(text);
	}

	public static Info getInst() {
		return INST;
	}

	@Override
	public void setClosealbe(boolean b) {
		if (widget!=null)
			closeButton.enable();
	}

}
