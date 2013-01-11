package app.gxt.client.widgets;

import java.util.ArrayList;
import java.util.List;

import app.gxt.client.richtext.RichTextArea;
import app.gxt.shared.model.AppModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.core.client.resources.ThemeStyles.Styles;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class AreaTextWidget implements IsWidget, Editor<TypeData> {

	private static AreaTextWidgetUiBinder uiBinder = GWT
			.create(AreaTextWidgetUiBinder.class);

	interface AreaTextWidgetUiBinder extends UiBinder<Widget, AreaTextWidget> {
	}

	interface StoreAppModelDriver extends
			SimpleBeanEditorDriver<TypeData, AreaTextWidget> {}


	@UiField(provided = true)
	@Ignore
	Styles themeStyles = ThemeStyles.getStyle();

	@UiField
	@Ignore
	Window window;

	@UiField
	@Ignore
	RichTextArea textArea;

	Widget widget;

	TypeData typeData = TypeData.TYPEDATA;
	
	private StoreAppModelDriver driver = GWT.create(StoreAppModelDriver.class);

	@UiField(provided = true)
	@Ignore
	ListStore<AppModel> typeStore = new ListStore<AppModel>(typeData.key());

	@UiField(provided = true)
	@Ignore
	LabelProvider<AppModel> typeLabelProvider = GWT.<TypeData> create(
			TypeData.class).label();

	@UiField
	@Ignore
	ColumnModel<AppModel> cm;

	@UiField
	@Ignore
	ListStore<AppModel> store;

	@UiField
	@Ignore
	Grid<AppModel> grid;

	public AreaTextWidget() {
		impl();
		widget = uiBinder.createAndBindUi(this);
		
		driver.initialize(this);
		driver.edit(typeData);
	}

	private void impl() {
		List<ColumnConfig<AppModel, ?>> list = new ArrayList<ColumnConfig<AppModel, ?>>();
		list.add(new ColumnConfig<AppModel, String>(typeData.name(), 50,
				"Model"));
		cm = new ColumnModel<AppModel>(list);
		store = new ListStore<AppModel>(typeData.key());

		for (AppModel model : AppModel.values()) {
			typeStore.add(model);
		}
	}

	@UiFactory
	ColumnModel<AppModel> createColumnModel() {
		return cm;
	}

	@UiFactory
	ListStore<AppModel> createListStore() {
		return store;
	}

	public void showWindow() {
		window.show();
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

}
