<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
<head>
<%
	String error = request.getParameter("error");
	if(error!=null)
		if(error.equals("1")){%>
			<script>
				alert("잘못입력하셨습니다.");
				frm.bun.focus();
			</script>
	<%	}
%>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<jsp:include page = "header.jsp"/>
<script>
function check(){
	var bun = frm.bun.value;
	var name = frm.name.value;
	var addr = frm.addr.value;
	var phone = frm.phone.value;
	var birth = frm.birth.value;
	var bool = true;
	if(bun==""){
		alert("학번입력");
		frm.bun.focus();
		return;
	}

	if(name==""){
		alert("이름입력");
		frm.name.focus();
		return;
	}
	var ptest1 = /^[0-9]{9,11}$/;
	var ptest2 = /^010-[0-9]{3,4}-[0-9]{4}$/;
	if(!ptest1.test(phone)){
		if(!ptest2.test(phone)){
			bool = false;
		}
	}else{
		var formatNum = phone.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
		frm.phone.value = formatNum;
	}
	if(!bool){
		alert("전화번호 오류");
		return;
	}
	bool = true;
			
			
			
	var btest1 = /^[0-9]{6}$/;
	var btest2 = /^[0-9]{2}.[0-9]{2}.[0-9]{2}$/;
	var btest3 = /^[0-9]{2}-[0-9]{2}-[0-9]{2}$/;
	var val = 0;
	if(!btest1.test(birth)){
		if(!btest2.test(birth)){
			if(!btest3.test(birth)){
				bool = false;
			}
		}
	}
	var str = birth.replace(/[^0-9]/g,"");
	frm.birth.value = str;
	
	if(!bool){
		alert("생년월일 오류");
		return;
	}
	frm.method = "post";
	frm.action = "insert";
	frm.submit();
	
}


</script>
<body>
<div style = "clear:both">
<form name = frm>
	<table border="1">
		<tr align = center><td>학생정보 등록</td>
		</tr>
		<tr>
			<td>학번</td><td><input type = text name = bun></td>
		</tr>
		<tr>
			<td>이름</td><td><input type = text name = name></td>
		</tr>
		<tr>
			<td>주소</td><td><input type = text name = addr></td>
		</tr>
		<tr>
			<td>전화</td><td><input type = text name = phone maxlength =13></td>
		</tr>
		<tr>
			<td>생년월일</td><td><input type = text name = birth></td>
		</tr>
		<tr align = center>
			<td colspan="2"><a href = "javascript:check()">등록</a>&nbsp;<a href = "list.jsp">조회</a></td>
		</tr>
	</table>

</form>

</div>
</body>

<jsp:include page = "footer.jsp"/>
</html>