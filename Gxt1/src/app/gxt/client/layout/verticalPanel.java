package app.gxt.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.core.client.resources.ThemeStyles.Styles;
import com.sencha.gxt.widget.core.client.Composite;

public class verticalPanel extends Composite {

	private static verticalPanelUiBinder uiBinder = GWT
			.create(verticalPanelUiBinder.class);

	interface verticalPanelUiBinder extends UiBinder<Widget, verticalPanel> {
	}

	@UiField(provided = true)
	Styles themeStyles = ThemeStyles.getStyle();

	public verticalPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
}
