<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import = "java.util.*" import = "Model.*"%>
    <%List<ExamDTO> list = (List)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "header.jsp"/>
<div style = "clear:both;">
<table border="1">
	<tr>
		<td colspan="5">학생 정보 목록 조회/수정</td>
	</tr>
	<tr>
		<td>학번</td>
		<td>이름</td>
		<td>주소</td>
		<td>전화</td>
		<td>생년월일</td>
	</tr>
	<%for(int i= 0; i < list.size(); i++){ 
		ExamDTO vo = list.get(i);
	%>
	<tr>
		<td><a href = "javascript:location.href='edit?num=<%=vo.getStubun()%>'"><%=vo.getStubun() %></a></td>
		<td><%=vo.getStuname() %></td>
		<td><%=vo.getStuaddr() %></td>
		<td><%=vo.getStuphone() %></td>
		<td><%=vo.getStubirth() %></td>
	</tr>
	<%} %>



</table>



</div>



<jsp:include page = "footer.jsp"/>
</body>
</html>