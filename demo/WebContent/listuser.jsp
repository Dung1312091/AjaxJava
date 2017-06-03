<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <script type=”text/javascript” src=jquery-3.1.1.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<script>
$(document).ready(function() {
	var idtheloai =$("#idtheloai").val();
	 $.ajax({
		 type: 'POST',
		 data:{idtheloai: idtheloai},
		 url:'ajaxloaitin',
		 success:function(result){
			$("#tintuc").html(result);
		 }
	 });		
	$("#idtheloai").change(function(){
	  idtheloai =($(this).val());
		 $.ajax({
			 type: 'POST',
			 data:{idtheloai: idtheloai},
			 url:'ajaxloaitin',
			 success:function(result){
				$("#tintuc").html(result);
			 }
		 });
		});
	$("#buttonid").click(function(){
		var tintuc = $("#tintuc").val();
		alert(tintuc);
		$.ajax({
			 type: 'POST',
			 data:{tintuc: tintuc},
			 url:'ajaxshowdata',
			 success:function(result){
				 $("#content").html(result);
			 }
		 });
	});
	
});
</script>
<style>
	td{
		text-align: center;
		padding: 5px;
	}
</style>
<body>

<center>
<p id="abc"></p>
<form >
	<select name="theloai" id="idtheloai">
	<% ResultSet rs = (ResultSet) request.getAttribute("listuser");
while(rs.next()){ %>
	
  <option value="<%=rs.getString("id") %>"><%=rs.getString("ten") %></option>
  	
<%} %>
</select >	

<select id="tintuc">
  
</select>

</form>
<input type="button" name="but" id="buttonid" value="test">
<table border="1px">
	<thead>
		<th>STT</th>
		<th>Ten</th>
		<th>NgayThang</th>
		<th>Giobatdau</th>
		<th>Gioketthhuc</th>
		<th>Note</th>
	</thead>
	<tbody id="content">
	
	</tbody>
</table>
</center>

</body>
</html>