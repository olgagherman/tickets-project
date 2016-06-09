package md.utm.fi.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.User;

public class LoginAuthAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private UserDAO userDAO;
	// public Singleton log = Singleton.getInstance();

	private Boolean error;
	public Map<String, Object> sessionMap;
	private User user;

	@Override
	public String execute() {
		if (email.equals("")) {
			addActionError("Please Enter user email.");
			error = true;
		} else if (password.equals("")) {
			addActionError("Please Enter password.");
			error = true;
		} else if (findUser() == null) {
			error = true;
		} else {
			error = false;
			sessionMap.put("userName", user.getName());
			sessionMap.put("userId", user.getId());
			sessionMap.put("logged", true);
			sessionMap.put("admin", user.isAdmin());

		}

		if (error) {
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	public String logOut() {
		if (sessionMap.containsKey("userName")) {
			sessionMap.remove("userName");
			sessionMap.remove("userId");
			sessionMap.put("logged", false);
			sessionMap.put("admin", false);
		}
		return SUCCESS;
	}

	private User findUser() {
		user = userDAO.findUser(email, password);
		return user;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

}
