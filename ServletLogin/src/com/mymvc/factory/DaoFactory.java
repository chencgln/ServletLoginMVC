package com.mymvc.factory;

import com.mymvc.dao.UserDAO;
import com.mymvc.dao.proxy.UserDAOProxy;

public class DaoFactory {

	public static UserDAO getIUserDAOInstance() {
		return new UserDAOProxy();
	}
}
