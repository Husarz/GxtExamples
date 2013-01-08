package app.gxt.client.ui.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
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

	@UiField
	TextField firstName;
	@UiField
	Radio radio, radio2;
	@UiField
	Label label;

	public TestForm() {
		initWidget(uiBinder.createAndBindUi(this));

//		sinkEvents(Event.ONCLICK | Event.ONDBLCLICK);

//		addDomHandler(new DoubleClickHandler(){
//
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				Window.alert("Double click");
//				
//			}
//			
//		}, DoubleClickEvent.getType());
		ToggleGroup toggle = new ToggleGroup();
		toggle.add(radio);
		toggle.add(radio2);

		if (radio.getValue())
			firstName.disable();
		else
			firstName.enable();
	}

//	@Override
//	public void onBrowserEvent(Event event) {
//		super.onBrowserEvent(event);
//		if (DOM.eventGetType(event) == Event.ONCLICK) {
//			Window.alert("Single click");
//		}
//		if (DOM.eventGetType(event) == Event.ONDBLCLICK) {
//			Window.alert("Double click");
//		}
//	}

	@UiHandler({ "radio", "radio2" })
	void onRadio(ValueChangeEvent<Boolean> e) {
		if (radio.getValue())
			firstName.disable();
		else
			firstName.enable();
	}

}
