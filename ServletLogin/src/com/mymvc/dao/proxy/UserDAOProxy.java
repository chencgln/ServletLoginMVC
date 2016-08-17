package com.mymvc.dao.proxy;

import com.mymvc.dao.UserDAO;
import com.mymvc.dao.impl.UserDAOImp;
import com.mymvc.dbc.DatabaseConnection;
import com.mymvc.vo.User;

public class UserDAOProxy implements UserDAO {

	private DatabaseConnection dbc = null;
	private UserDAO dao = null;

	public UserDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new UserDAOImp(dbc.getConnection());
	}

	@Override
	public boolean findLogin(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = dao.findLogin(user); // 调用真实主题，完成操作
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
}
