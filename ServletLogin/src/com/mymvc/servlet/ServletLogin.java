package com.mymvc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mymvc.factory.DaoFactory;
import com.mymvc.vo.User;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class ServletLogin
 */

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = "/login.jsp";
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");

		List<String> info = new ArrayList<String>(); // �ռ�����
		if (userid == null || "".equals(userid)) {
			info.add("�û�id����Ϊ�գ�");
		}
		if (userpass == null || "".equals(userpass)) {
			info.add("���벻��Ϊ�գ�");
		}
		if (info.size() == 0) { // ����û�м�¼�κεĴ���
			User user = new User();
			user.setUserid(userid);
			user.setPassword(userpass);

			try {
				if (DaoFactory.getIUserDAOInstance().findLogin(user)) {
					info.add("�û���½�ɹ�����ӭ" + user.getName() + "���٣�");
				} else {
					info.add("�û���½ʧ�ܣ�������û��������룡");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

		}
		;
		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
