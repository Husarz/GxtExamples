package app.gxt.client.ui.grid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import app.gxt.shared.model.AppModel;
import app.gxt.shared.model.Model;
import app.gxt.shared.model.StoreAppModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.Store;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridViewConfig;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;

public class Grid2 extends Composite implements Editor<Model>{

	private static Grid2UiBinder uiBinder = GWT.create(Grid2UiBinder.class);

	interface Grid2UiBinder extends UiBinder<Widget, Grid2> {
	}

	interface GridStyle extends CssResource{
		String grayrow();
	}
	
	interface ModelDriver extends SimpleBeanEditorDriver<Model, Grid2>{
	}
	
	interface ModelPropetries extends PropertyAccess<Model>{
		@Path("name")
		ModelKeyProvider<Model> key();
		
		ValueProvider<Model, String> name();
		
		@Path("app.name")
		ValueProvider<Model, String> app();
		
//		ValueProvider<Model, Integer> count();
		
	}

	@UiField @Ignore
	GridStyle style;
	
	@UiField @Ignore
	ColumnModel<Model> cm;

	@UiField @Ignore
	ListStore<Model> store;

	@UiField @Ignore
	Grid<Model> grid;
	
	
	@UiField(provided = true)
	NumberField<Integer> count = new NumberField<Integer>(new NumberPropertyEditor.IntegerPropertyEditor());
	@UiField TextField name;
	@Path("app.label") @UiField TextField appName;
	@UiField(provided = true) @Ignore 
	NumberField<Integer> count2 = new NumberField<Integer>(new NumberPropertyEditor.IntegerPropertyEditor());
	
	ModelPropetries prop = GWT.<ModelPropetries>create(ModelPropetries.class);
	ModelDriver driver = GWT.create(ModelDriver.class);
	StoreAppModel appStore;

	public Grid2() {
		implGird();
		initWidget(uiBinder.createAndBindUi(this));
		
		appStore = new StoreAppModel();
		StoreAppModel.initSotore(getAppStore());
		putData();
		
		driver.initialize(this);
		
		grid.getSelectionModel().addSelectionChangedHandler(new SelectionChangedHandler<Model>() {

			@Override
			public void onSelectionChanged(SelectionChangedEvent<Model> event) {
				driver.edit(event.getSelection().get(0));
			}
		});
	}
	
	private void implGird(){
		List<ColumnConfig<Model, ?>> list = new ArrayList<ColumnConfig<Model, ?>>();
		
		list.add(new ColumnConfig<Model, String>(prop.name(), 150, "Name"));
		list.add(new ColumnConfig<Model, String>(prop.app(), 150, "NameApp"));
		cm = new ColumnModel<Model>(list);
		store = new ListStore<Model>(prop.key());
	}
	
	private void putData(){
		store.clear();
		store.addAll(getAppStore().getStoreApps());
	}
	
	private void showChanges(){
		final Collection<Store<Model>.Record> collect = store.getModifiedRecords();
		grid.getView().setViewConfig(new GridViewConfig<Model>() {
			
			@Override
			public String getRowStyle(Model model, int rowIndex) {
				if(collect.contains(model.getName()))
					return style.grayrow();
				return null;
			}
			
			@Override
			public String getColStyle(Model model,
					ValueProvider<? super Model, ?> valueProvider, int rowIndex,
					int colIndex) {
				
				return null;
			}
		});
	}
	
	private void resetView(){
		grid.getView().refresh(true);
	}
	
	@UiFactory
	ColumnModel<Model> createColumnModel() {
		return cm;
	}

	@UiFactory
	ListStore<Model> createListStore() {
		return store;
	}
	
	@UiHandler("del")
	void onDel(final SelectEvent event){
		store.remove(grid.getSelectionModel().getSelectedItem());
	}
	
	@UiHandler("add")
	void onAdd(final SelectEvent event){
		Model model = new Model(AppModel.LINE, name.getCurrentValue(), count.getCurrentValue());
		if (store.findModel(model)== null)
			store.add(model);
		else
			name.markInvalid("change name");
	}
	
	@UiHandler("changes")
	void onChanges(final SelectEvent event){
		count2.setValue(store.getModifiedRecords().size());
		showChanges();
	}
	
	@UiHandler("commit")
	void onCommit(final SelectEvent event){
		store.commitChanges();
		resetView();
		showChanges();
	}
	
	@UiHandler("init")
	void onInit(final SelectEvent event){
		resetView();
	}
	
	public StoreAppModel getAppStore() {
		return appStore;
	}

	public void setAppStore(StoreAppModel appStore) {
		this.appStore = appStore;
	}
	
}
