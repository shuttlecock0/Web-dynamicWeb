<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
String str1 = request.getParameter("num1");
String str2 = request.getParameter("num2");
int num1 = Integer.parseInt(str1);
int num2 = Integer.parseInt(str2);
%>
	<%=num1%>+<%=num2%>
	=
	<%=num1+num2 %><hr>
	EL 방식 :
	<%-- 보다 깔끔하고 간단한 코드 --%>
	${param.num1 } +${param.num2 }=${param.num1+param.num2 }
</body>
</html>