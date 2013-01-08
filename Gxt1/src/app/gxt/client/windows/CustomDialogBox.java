package app.gxt.client.windows;

import app.gxt.shared.model.BaseValue;
import app.gxt.shared.model.ChildBool;
import app.gxt.shared.model.ChildString;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

@SuppressWarnings("rawtypes")
public class CustomDialogBox extends Dialog  {

	IsWidget widget;
	final HasValue value;
	final BaseValue model;


	public CustomDialogBox(BaseValue val) {
		
		super();
//		this.widget = this;
		setHeadingText("Wartość");
		setBodyStyleName("pad-text");
		getBody().addClassName("pad-text");
		setHideOnButtonClick(true);
		setWidth(300);
		setModal(true);
		
		setPredefinedButtons(PredefinedButton.CANCEL, PredefinedButton.YES);
		getButtonById(PredefinedButton.YES.name()).setText("Zapisz");
		getButtonById(PredefinedButton.CANCEL.name()).setText("Anuluj");
		final TextButton b = getButtonById(PredefinedButton.YES.name());
		this.model = val;
		final BaseValue value = val.getValue();
		if ( value instanceof ChildString)
		{
			final ChildString v = (ChildString)value;
			TextField field = new TextField();
			field.setValue(v.getStr());
			field.setAllowBlank(false);
			field.setAutoValidate(true);
			add(new FieldLabel(field, "Podaj wartość"));
			this.value = field;
			
		}else if (value instanceof ChildBool){
			this.value = null;
			
		}else{
			this.value = null;
		}
		
		addHideHandler(new HideHandler() {
			
			@Override
			public void onHide(HideEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
	}


	
	public HasValue getValue() {
		return value;
	}



}
