package app.gxt.client.bindsforms;

import app.gxt.shared.model.User;

import com.google.gwt.user.client.ui.IsWidget;

public interface UserBindView {
	void setData(User user);
	IsWidget asWidget();
}
