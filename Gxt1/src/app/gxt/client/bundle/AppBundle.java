package app.gxt.client.bundle;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface AppBundle extends ClientBundle {
	
	public static final AppBundle INST = GWT.create(AppBundle.class);
	
	interface AppCss extends CssResource{
		String content();
	}

	@Source("app/gxt/client/bundle/images/ajax-loader-big.gif")
	ImageResource ajaxLoaderBig();

	@Source("app/gxt/client/bundle/images/loading-indicator.gif")
	ImageResource loadingIndicator();

	@Source("app/gxt/client/bundle/images/app.css")
	AppCss app();

	@Source("app/gxt/client/bundle/images/progress_transparent.gif")
	ImageResource progress_transparent();

	@Source("app/gxt/client/bundle/images/ajax-loader-1.gif")
	ImageResource ajaxLoader1();

}
