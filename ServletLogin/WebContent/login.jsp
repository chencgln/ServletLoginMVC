<%@ page contentType="text/html" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>MyLogin</title>
</head>
<body>
	<script language="javascript">
		function validate(f) {
			if (!(/^\w{5,15}$/.test(f.userid.value))) {
				alert("用户ID必须是5~15位！");
				f.userid.focus();
				return false;
			}
			if (!(/^\w{5,15}$/.test(f.userpass.value))) {
				alert("密码必须是5~15位！");
				f.userpass.focus();
				return false;
			}
		}
	</script>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<%
		List<String> info = (List<String>) request.getAttribute("info");
		if (info != null) { // 有信息返回
			Iterator<String> iter = info.iterator();
			while (iter.hasNext()) {
	%>
	<h4><%=iter.next()%></h4>
	<%
		}
		}
	%>
	<form action="/ServletLogin/mvclogin/ServletLogin" method="post"
		onSubmit="return validate(this)">
		用户ID：<input type="text" name="userid"><br> 密 码：<input
			type="password" name="userpass"><br> <input
			type="submit" value="登陆"> <input type="reset" value="重置">
	</form>
</body>
</html>