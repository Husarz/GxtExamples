package app.gxt.client.widgets;

import app.gxt.client.richtext.RichTextArea;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.core.client.resources.ThemeStyles.Styles;
import com.sencha.gxt.widget.core.client.Window;

public class AreaTextWidget implements IsWidget {

	private static AreaTextWidgetUiBinder uiBinder = GWT
			.create(AreaTextWidgetUiBinder.class);

	interface AreaTextWidgetUiBinder extends UiBinder<Widget, AreaTextWidget> {
	}

	@UiField(provided = true)
	Styles themeStyles = ThemeStyles.getStyle();

	@UiField
	Window window;
	
	@UiField
	RichTextArea textArea;
	
	Widget widget;

	public AreaTextWidget() {
		widget = uiBinder.createAndBindUi(this);
	}

	public void showWindow() {
		window.show();
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

}
