package com.mymvc.dao;

import com.mymvc.vo.User;

public interface UserDAO {

	public boolean findLogin(User user) throws Exception;

}
