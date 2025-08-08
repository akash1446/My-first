<%@ page import="java.util.* , com.flm.model.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
</head>
<body>
<marquee>Welcome <%= session.getAttribute("email") %></marquee><hr>
<a href="addemployee.jsp">Add New Employee</a><hr>
<table border="1">

<tr> 
<th>Employee ID</th>
<th>Name</th>
<th>Age</th>
<th>Email</th>
<th>Phone Number</th>
<th>Salary</th>
<th>Update</th>
<th>Delete</th>
</tr>

<% List<Employee> empList = (List<Employee>) request.getAttribute("empList"); 
     for(Employee emp: empList){
	 
%>
    <tr>
       <td><%= emp.getEmpid() %> </td>
       <td><%= emp.getName() %> </td>
       <td><%= emp.getAge() %> </td>
       <td><%= emp.getEmail() %> </td>
       <td><%= emp.getPhoneNumber() %> </td>
       <td><%= emp.getSalary() %></td>
       <td><a href="updateEmp.jsp?id=<%= emp.getEmpid()%>">Update Emp</a>
       <td><a href="delete?id=<%= emp.getEmpid() %>">Delete Emp</a></td>
       
   </tr>

<% } %>



</table>
<hr>
</body>
</html>