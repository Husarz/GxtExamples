package app.gxt.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor;

public class HTMLWidgets extends Composite {

	private static HTMLWidgetsUiBinder uiBinder = GWT
			.create(HTMLWidgetsUiBinder.class);

	interface HTMLWidgetsUiBinder extends UiBinder<Widget, HTMLWidgets> {
	}

	@UiField(provided = true) 
	DateField df1, df2;
	@UiField(provided = true) 
	NumberField<Integer> num;
	
	DateTimePropertyEditor t1, t2;
	NumberPropertyEditor<Integer> n;
	
	public HTMLWidgets() {
		t1 = new DateTimePropertyEditor(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT));
		t2 = new DateTimePropertyEditor(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT));
		n = new NumberPropertyEditor.IntegerPropertyEditor() ;
		df1 = new DateField(t1);
		df2 = new DateField(t2);
		num = new NumberField<Integer>(n);
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	

}
