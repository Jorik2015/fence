import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;

import com.abner.fence.utils.FacesUtils;

@ManagedBean
@SessionScoped
public class App {
	public String getAppPath() {
		HttpServletRequest req = (HttpServletRequest) FacesUtils.extContext().getRequest();
		String url = req.getRequestURL().toString();
		int end = url.indexOf("/", 8);
		url = url.substring(0, end);
		return FacesUtils.extContext().getRequestContextPath();
	}
}
