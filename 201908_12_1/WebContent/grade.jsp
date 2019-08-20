<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import = "java.util.*" import = "Model.*"%>
<!DOCTYPE html>
<html>
<%List<ExamDTO> list = (List)request.getAttribute("list"); %>
<style>
td{text-align:center;}
</style>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "header.jsp"/>
<div style="clear:both;">

<table border="1">
	<tr>
		<td colspan="5">�л� ���� ��ȸ</td>
	</tr>
	<tr>
		<td>�й�</td>
		<td>�̸�</td>
		<td>�������</td>
		<td>����</td>
		<td>���</td>
	</tr>
	<%for(int i= 0; i<list.size();i++){
		ExamDTO vo = list.get(i);
		%>
		<tr>
		<td><%=vo.getStubun() %></td>
		<td><%=vo.getStuname() %></td>
		<td><%=vo.getStubirth() %></td>
		<td><%=vo.getTotal() %></td>
		<td><%float f = vo.getTotal()/3.0f;
			out.print(String.format("%.2f",f));%></td>
		</tr>
	<%} %>

</table>




</div>


<jsp:include page = "footer.jsp"/>

</body>
</html>