package md.utm.fi.security;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		boolean logged = false;
		if (!session.isEmpty()) {
			logged = session.get("logged") != null && (Boolean) session.get("logged");
		}
		return logged ? invocation.invoke() : "loginUser";
	}
}