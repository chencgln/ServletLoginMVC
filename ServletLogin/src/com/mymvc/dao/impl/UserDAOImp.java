package com.mymvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mymvc.dao.UserDAO;
import com.mymvc.vo.User;

public class UserDAOImp implements UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;

	public UserDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean findLogin(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "SELECT name FROM user WHERE userid=? AND password=?";

		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserid());
		this.pstmt.setString(2, user.getPassword());

		ResultSet rs = this.pstmt.executeQuery();

		if (rs.next()) {
			user.setName(rs.getString(1)); // 取出一个用户的真实姓名
			flag = true;

		}

		this.pstmt.close();
		return flag;

	}

}
