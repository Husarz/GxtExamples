package app.gxt.client.widgets;

import app.gxt.shared.model.AppModel;
import app.gxt.shared.model.StoreAppModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface TypeData extends PropertyAccess<StoreAppModel>{
	public static final TypeData TYPEDATA = GWT.create(TypeData.class);
	
	@Path("name")
	ModelKeyProvider<AppModel> key();

	ValueProvider<AppModel, String> name();

	@Path("toString")
	ValueProvider<AppModel, String> value();

	LabelProvider<AppModel> label();
	
	@Path("textArea")
	ValueProvider<StoreAppModel, String> textArea();
}
