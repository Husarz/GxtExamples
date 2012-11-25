package app.gxt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.UIObject;

public class Hello2 extends UIObject {

	private static Hello2UiBinder uiBinder = GWT.create(Hello2UiBinder.class);

	interface Hello2UiBinder extends UiBinder<Element, Hello2> {
	}

	@UiField
	SpanElement nameSpan;

	public Hello2(String firstName) {
		setElement(uiBinder.createAndBindUi(this));
		nameSpan.setInnerText(firstName);
	}

}
