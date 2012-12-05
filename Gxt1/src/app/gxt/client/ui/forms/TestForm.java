package app.gxt.client.ui.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextField;

public class TestForm extends Composite {

	private static TestFormUiBinder uiBinder = GWT
			.create(TestFormUiBinder.class);

	interface TestFormUiBinder extends UiBinder<Widget, TestForm> {
	}

	@UiField TextField firstName;
	@UiField Radio radio, radio2;
	
	public TestForm() {
		initWidget(uiBinder.createAndBindUi(this));
		
		ToggleGroup toggle = new ToggleGroup();
		toggle.add(radio); toggle.add(radio2);
		
		if (radio.getValue()) firstName.disable();
		else firstName.enable();
	}

	@UiHandler({"radio", "radio2"})
	void onRadio(ValueChangeEvent<Boolean> e){
		if (radio.getValue()) firstName.disable();
		else firstName.enable();
	}
	
}
