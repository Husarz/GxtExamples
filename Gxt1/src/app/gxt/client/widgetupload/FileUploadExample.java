package app.gxt.client.widgetupload;

import app.gxt.client.bundle.AppBundle;
import app.gxt.client.infopanel.Info;
import app.gxt.client.infopanel.InfoImpl;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FileUploadField;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.FormPanel.Encoding;
import com.sencha.gxt.widget.core.client.form.FormPanel.Method;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.RegExValidator;

public class FileUploadExample implements IsWidget {

	private FramedPanel panel;
	Info info = InfoImpl.getInst();
	RegExValidator myEmailValidator = new RegExValidator(
			"^(\\w+)([-+.][\\w]+)*@(\\w[-\\w]*\\.){1,5}([A-Za-z]){2,4}$", 
			"zly format Email");
	RegExp validator = RegExp.compile("^(\\S+)(\\.xsd)$");

	private void getMsg(String header, String txt){
		MessageBox box = new MessageBox(header, txt);
//		box.setIcon(MessageBox.ICONS.info());
		box.setIcon(AppBundle.INST.progress_transparent());
		box.show();
	}
	
	@Override
	public Widget asWidget() {
		if (panel == null) {
			panel = new FramedPanel();
			panel.setHeadingText("File Upload");
			panel.setButtonAlign(BoxLayoutPack.CENTER);
			panel.setWidth(350);
			panel.getElement().setMargins(10);

			final FormPanel form = new FormPanel();
			form.setAction("myurl");
			form.setEncoding(Encoding.MULTIPART);
			form.setMethod(Method.POST);
			panel.add(form);

			VerticalLayoutContainer p = new VerticalLayoutContainer();
			form.add(p);
			TextField firstName = new TextField();
			firstName.setAllowBlank(false);
			firstName.addValidator(myEmailValidator);
//			firstName.addv
			p.add(new FieldLabel(firstName, "Name"), new VerticalLayoutData(
					-18, -1));

			final FileUploadField file = new FileUploadField();
			file.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					if(!validator.test(file.getValue())){
						getMsg("Info", "zly format pliku: "+ file.getValue());
//						info.setTextInfo("zly format :'"+file.getValue()+"'");
//						info.setClosealbe(true);
						file.reset();
					}
					else{
						info.setTextInfo("plik :'"+file.getValue()+"'");
						info.closeInfo();
					}

				}
			});
			file.setName("uploadedfile");
			file.setAllowBlank(false);
		
			p.add(new FieldLabel(file, "File"), new VerticalLayoutData(-18, -1));

			TextButton btn = new TextButton("Reset");
			btn.addSelectHandler(new SelectHandler() {

				@Override
				public void onSelect(SelectEvent event) {
					form.reset();
					// TODO needs to be part of form panel, ie a Field interface
					file.reset();
				}
			});
			panel.addButton(btn);

			btn = new TextButton("Submit");

			btn.addSelectHandler(new SelectHandler() {

				@Override
				public void onSelect(SelectEvent event) {
					if (!form.isValid()) {
						return;
					}
					// normally would submit the form but for example no server
					// set up to
					// handle the post
					// panel.submit();
					getMsg("Info", "Plik zaladowany");
				}
			});
			panel.addButton(btn);

		}
		return panel;
	}

}
