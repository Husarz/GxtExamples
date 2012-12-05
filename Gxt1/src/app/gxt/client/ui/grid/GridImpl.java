package app.gxt.client.ui.grid;

import java.util.ArrayList;
import java.util.List;

import app.gxt.shared.model.AppModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridViewConfig;

public class GridImpl implements IsWidget {

	private static GridImplUiBinder uiBinder = GWT
			.create(GridImplUiBinder.class);

	interface GridImplUiBinder extends UiBinder<Widget, GridImpl> {
	}
	
	interface GridStyle extends CssResource{
		String grayrow();
	}

	@UiField GridStyle style;
	
	@UiField
	ColumnModel<AppModel> cm;

	@UiField
	ListStore<AppModel> store;

	@UiField
	Grid<AppModel> grid;
//
//	@UiField
//	GridView<AppModel> view;

	ModelProp prop = GWT.create(ModelProp.class);

	interface ModelProp extends PropertyAccess<AppModel>{
		@Path("name")
		ModelKeyProvider<AppModel> key();
		
		ValueProvider<AppModel, String> name();
		
		@Path("toString")
		ValueProvider<AppModel, String> value();
		
		ValueProvider<AppModel, String> label();
	}
	  
	public GridImpl() {}
	
	@Override
	public Widget asWidget() {
		implGird();
		Widget widget = uiBinder.createAndBindUi(this);
		grid.getView().setViewConfig(new GridViewConfig<AppModel>() {
			
			@Override
			public String getRowStyle(AppModel model, int rowIndex) {
				if (rowIndex == 1)
					return style.grayrow();
				return null;
			}
			
			@Override
			public String getColStyle(AppModel model,
					ValueProvider<? super AppModel, ?> valueProvider, int rowIndex,
					int colIndex) {
				
				return null;
			}
		});
		return widget;
	}

	@UiFactory
	ColumnModel<AppModel> createColumnModel() {
		return cm;
	}

	@UiFactory
	ListStore<AppModel> createListStore() {
		return store;
	}
	

	private void implGird(){
		ColumnConfig<AppModel, String> nameCol = 
				new ColumnConfig<AppModel, String>(prop.name(), 50, "Model");
		ColumnConfig<AppModel, String> valCol = 
				new ColumnConfig<AppModel, String>(prop.value(), 50, "value");
		ColumnConfig<AppModel, String> labCol = 
				new ColumnConfig<AppModel, String>(prop.label(), 50, "value");
		
		List<ColumnConfig<AppModel, ?>> list = new ArrayList<ColumnConfig<AppModel, ?>>();
		list.add(nameCol);
		list.add(valCol);
		list.add(labCol);
		cm = new ColumnModel<AppModel>(list);
		
		store = new ListStore<AppModel>(prop.key());
		for(AppModel model: AppModel.values()){
			store.add(model);
		}
		
		
		
	}

}
