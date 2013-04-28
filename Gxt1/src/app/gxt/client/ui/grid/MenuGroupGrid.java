package app.gxt.client.ui.grid;

import java.util.ArrayList;
import java.util.List;

import app.gxt.client.ui.forms.TestForm;
import app.gxt.client.widgets.RichTabs;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GroupingView;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;

public class MenuGroupGrid implements IsWidget {

	interface LazyLoader{
		Widget run();
	}
	
	interface Link{
		LazyLoader getLoader();
		String getName();
		String getGroup();
	}
	
	interface LinProperties extends PropertyAccess<Link>{
		@Path("name")
		ModelKeyProvider<Link> key();
		
		 ValueProvider<Link, String> name();
		 ValueProvider<Link, String> group();
	}
	
	LinProperties prop = GWT.create(LinProperties.class);
	ListStore<Link> store = new ListStore<Link>(prop.key());
//	ContentPanel panel = new ContentPanel();
	Grid<Link> grid;
	Widget widget;
	
	public MenuGroupGrid() {
		implGrid();
//		panel.setHeadingHtml("Grouping Example");
//	    panel.setSize("700", "450");
//	    panel.add(grid);
	    
	    grid.getSelectionModel().addSelectionChangedHandler(
	    		new SelectionChangedHandler<MenuGroupGrid.Link>() {

			@Override
			public void onSelectionChanged(SelectionChangedEvent<Link> event) {
//				event.getSelection().get(0).getLoader().run();
			}
	    	
		});
	    
	    implStoreMenu();
	    widget = grid;
	}

	
	void implGrid(){
		List<ColumnConfig<Link, ?>> list = new ArrayList<ColumnConfig<Link, ?>>();
		
		ColumnConfig<Link, String> name = new ColumnConfig<Link, String>(prop.name(),100,"Nazwa" );
		list.add(name);
		
		ColumnConfig<Link, String> group = new ColumnConfig<Link, String>(prop.group(),100,"Grupa" );
		list.add(group);
		
		ColumnModel<Link> cm = new ColumnModel<Link>(list);
		
		final GroupingView<Link> view = new GroupingView<Link>();
		view.setShowGroupedColumn(false);
	    view.setForceFit(true);
	    
	    grid = new Grid<Link>(store, cm);
	    
	    grid.setView(view);
	    view.groupBy(group);
	    
	    grid.setHideHeaders(true);
	}
	
	private void implStoreMenu(){
		addtoStore("Grid2", "admin", new LazyLoader() {
			
			@Override
			public Widget run() {
				return new Grid2();
			}
		});
		addtoStore("Grid2", "admin", new LazyLoader() {
			
			@Override
			public Widget run() {
				return new RichTabs();
			}
		});
		addtoStore("Grid2", "user", new LazyLoader() {
			
			@Override
			public Widget run() {
				return new TestForm();
			}
		});
	}
	
	private void addtoStore(final String name, final String group, final LazyLoader loader){
		
		Link link = new Link() {
			
			@Override
			public String getName() {
				return name;
			}
			
			@Override
			public LazyLoader getLoader() {
				return loader;
			}
			
			@Override
			public String getGroup() {
				return group;
			}
		};
		store.add(link);
	}
	
	@Override
	public Widget asWidget() {
		return widget;
	}


}
