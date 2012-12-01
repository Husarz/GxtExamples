package app.gxt.client.infopanel;



import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
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

	private static final Info INSTANCE = new InfoImpl();
	
	@UiField Window panelWindow;
//	@UiField HTML info;
	@UiField DivElement info;
	@UiField TextButton close;
	
	IsWidget isWidget=null;
	
	Info panel;
	
	HelloTemplate template = GWT.<HelloTemplate>create(HelloTemplate.class);

	
	
	private InfoImpl() {
//		AppBundle.INST.app().ensureInjected();
	}

	public Widget asWidget() {
		isWidget = uiBinder.createAndBindUi(this);
		template = GWT.<HelloTemplate>create(HelloTemplate.class);
		close.disable();
		return (Widget)isWidget;
		
	}
	
	public IsWidget asCloseableWidget() {
		template = GWT.<HelloTemplate>create(HelloTemplate.class);
		return isWidget = uiBinder.createAndBindUi(this);
	}


	@UiHandler("close")
	public void onCloseButtonClicked(SelectEvent event) {
		closeWindowInfo();
	}

	@Override
	public void setInfo(String text) {
		if(isWidget==null)
			asWidget();
		if(isWidget!=null){
			info.setInnerSafeHtml(getUpdatedPanel(text));
			if (!isVisibleWindowInfo())
				panelWindow.show();
		}
	}

	@Override
	public void closeWindowInfo() {
		if(isWidget!=null)
			panelWindow.hide();
		isWidget = null;
	}

	@Override
	public boolean isVisibleWindowInfo() {
		if (isWidget!=null)
			return panelWindow.isVisible();
		return false;
	}
	
	private SafeHtml getUpdatedPanel(String text) {
		return template.setText(text);
	}

	public static Info getInstInfo() {
		return INSTANCE;
	}

	@Override
	public void setClosealbeWindow(boolean b) {
		if (isWidget!=null)
			close.enable();
	}

}
