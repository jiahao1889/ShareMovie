<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<title>Register</title>
	</head>
	<body>
	<s:form action="register" namespace="/">
		<s:textfield label="username" cssClass="input_list" name="username" />
		<s:password label="password" cssClass="input_list" name="password" />
		<s:submit value="register" />
	</s:form>
	</body>
</html>