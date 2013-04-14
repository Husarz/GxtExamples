package app.gxt.client.tree;

import java.util.ArrayList;
import java.util.List;

import app.gxt.client.service.AppService;
import app.gxt.client.service.AppServiceAsync;
import app.gxt.shared.model.User;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.data.shared.loader.ChildTreeStoreBinding;
import com.sencha.gxt.data.shared.loader.TreeLoader;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.treegrid.TreeGrid;

public class MyTree implements IsWidget {

	interface TreeBundle extends ClientBundle {
		ImageResource plus();

		ImageResource minus();

		ImageResource folder();

		ImageResource folderOpen();
	}

	interface PropertyUser extends PropertyAccess<User> {
		@Path("hashCode")
		ModelKeyProvider<User> key();

		ValueProvider<User, String> firstName();

		ValueProvider<User, String> email();
	}

	PropertyUser prop = GWT.create(PropertyUser.class);
	final AppServiceAsync sevice = GWT.create(AppService.class);
	TreeBundle bundle = GWT.create(TreeBundle.class);

	RpcProxy<User, List<User>> proxy = new RpcProxy<User, List<User>>() {

		@Override
		public void load(User loadConfig, AsyncCallback<List<User>> callback) {
			sevice.getChildren(callback);
		}
	};

	final TreeLoader<User> loader = new TreeLoader<User>(proxy) {
		@Override
		public boolean hasChildren(User parent) {
			return true;
		};
	};

	FramedPanel cp;
	TreeStore<User> store = new TreeStore<User>(prop.key());
	ColumnModel<User> cm;
	TreeGrid<User> tree;

	public MyTree() {
		loader.addLoadHandler(new ChildTreeStoreBinding<User>(store));
		implTreeGrid();

		cp = new FramedPanel();

		cp.setHeadingText("Async TreeGrid");
		cp.setButtonAlign(BoxLayoutPack.CENTER);
		cp.setPixelSize(600, 300);

		cp.setWidget(tree);
	}

	private void implTreeGrid() {
		List<ColumnConfig<User, ?>> list = new ArrayList<ColumnConfig<User, ?>>();
		list.add(new ColumnConfig<User, String>(prop.firstName(), 100, "Name"));
		list.add(new ColumnConfig<User, String>(prop.email(), 100, "email"));

		cm = new ColumnModel<User>(list);
		tree = new TreeGrid<User>(store, cm, list.get(0));

		tree.setBorders(true);
		tree.setTreeLoader(loader);
		tree.getView().setTrackMouseOver(false);
		tree.getView().setAutoExpandColumn(list.get(0));

		tree.getStyle().setJointCloseIcon(bundle.plus());
		tree.getStyle().setJointOpenIcon(bundle.minus());
		tree.getStyle().setNodeCloseIcon(bundle.folder());
		tree.getStyle().setNodeOpenIcon(bundle.folderOpen());
		tree.getStyle().setLeafIcon(bundle.folderOpen());
	}

	@Override
	public Widget asWidget() {
		return cp;
	}
}
