<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
var temp = 'test';
var str = `temp 변수 값 : \${temp}`;
console.log(str);
</script>
</head>
<body>
	정수형 : ${10} <br>
	실수형 : ${5.6} <br>
	문자열형 : ${"성윤정"} <br>
	논리형 : ${true} <br>
	null : ${null} <br>
</body>
</html>