package app.gxt.client.bindsforms;

import app.gxt.shared.model.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;

public class UserBindForm implements IsWidget, UserBindView, Editor<User> {

	private static UserBindFormUiBinder uiBinder = GWT
			.create(UserBindFormUiBinder.class);

	interface UserBindFormUiBinder extends UiBinder<Widget, UserBindForm> {}
	
	interface UserDriver extends SimpleBeanEditorDriver<User, UserBindForm>{}

	@UiField FormPanel form;
	@UiField TextField firstName, email;
	@UiField PasswordField password;
	@UiField Window window;
	
	@UiField  @Ignore TextButton resetButton, okButton;
	User user;
	
	private UserDriver driver = GWT.create(UserDriver.class);
	
	public UserBindForm() {
		
	}

	@Override
	public Widget asWidget() {
		uiBinder.createAndBindUi(this);
		return window;
	}
	
	
	@UiHandler("resetButton")
	public void onResetButton(SelectEvent event){
		form.reset();
		driver.edit(user);
	}
	
	@UiHandler("okButton")
	public void onOkButton(SelectEvent event){
		setUser(driver.flush());
	}

	@Override
	public void setData(User user) {
		setUser(user);
		driver.initialize(this);
		driver.edit(user);
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
