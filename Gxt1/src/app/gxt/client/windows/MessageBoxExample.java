package app.gxt.client.windows;

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.box.PromptMessageBox;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class MessageBoxExample implements IsWidget {

	public static class MyButton extends TextButton{
		public MyButton() {
			super("custom");
			
			addHandler(new DoubleClickHandler(){

				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					// TODO Auto-generated method stub
					
				}
				
			}, DoubleClickEvent.getType());
			
//			sinkEvents(Event.ONDBLCLICK);
//			addDomHandler(new DoubleClickHandler(){
//
//				@Override
//				public void onDoubleClick(DoubleClickEvent event) {
//					Window.alert("Double click");
//					
//				}
//				
//			}, DoubleClickEvent.getType());
		}
		
		@Override
		public void onBrowserEvent(Event event) {
			super.onBrowserEvent(event);
//			if (DOM.eventGetType(event) == Event.ONCLICK) {
//				Window.alert("Single click");
//			}
//			if (DOM.eventGetType(event) == Event.ONDBLCLICK) {
//				Window.alert("Double click");
//			}
		}
	}
	
	@Override
	public Widget asWidget() {

		ButtonBar bar = new ButtonBar();

		TextButton b = new TextButton("Confirm");
		b.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				final ConfirmMessageBox box = new ConfirmMessageBox("naglowek",
						"daj potwierdzenie");
				box.getButtonById(PredefinedButton.YES.name()).setText("Tak");
				box.getButtonById(PredefinedButton.NO.name()).setText("Nie");
				box.addHideHandler(new HideHandler() {

					@Override
					public void onHide(HideEvent event) {
						if (box.getHideButton() == box
								.getButtonById(PredefinedButton.YES.name())) {
							new MessageBox("potwierdzenie", "na TAK").show();
						} else if (box.getHideButton() == box
								.getButtonById(PredefinedButton.NO.name())) {
							new MessageBox("potwierdzenie", "na NIE").show();
						}
					}
				});
				box.show();

			}
		});
		

		
		bar.add(b);

		b = new TextButton("Prompt");
		b.addSelectHandler(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				final PromptMessageBox box = new PromptMessageBox("nazwa",
						"podaj nazwe");
				box.getButtonById(PredefinedButton.OK.name()).setText("Dodaj");
				box.getButtonById(PredefinedButton.CANCEL.name()).setText("Anuluj");
				box.setFocusWidget(box.getTextField());
				box.getTextField().setText("cos tam");
				box.addHideHandler(new HideHandler() {

					@Override
					public void onHide(HideEvent event) {
						if (box.getHideButton() == box
								.getButtonById(PredefinedButton.OK.name())) {
							new MessageBox(box.getTextField().getText()).show();
						} else if (box.getHideButton() == box
								.getButtonById(PredefinedButton.CANCEL.name())) {
							new MessageBox(box.getValue()).show();
						}
					}
				});
				box.show();
				
				
			}
		});
		bar.add(b);
		
		b = new TextButton("Double click");
		
		b.addDomHandler(new DoubleClickHandler(){

			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Window.alert("Double click");
				
			}
			
		}, DoubleClickEvent.getType());
		bar.add(b);

		b = new MyButton();
		bar.add(b);
		
		return bar;
	}

}
