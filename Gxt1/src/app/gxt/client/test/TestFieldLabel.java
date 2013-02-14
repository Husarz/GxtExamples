package app.gxt.client.test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;

public class TestFieldLabel extends Composite {

	private static TestFieldLabelUiBinder uiBinder = GWT
			.create(TestFieldLabelUiBinder.class);

	interface TestFieldLabelUiBinder extends UiBinder<Widget, TestFieldLabel> {
	}

	public TestFieldLabel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
