<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h4 style="color:green">${result}</h4>
<h2 style="color: red; text-align: justify">All contact List</h2>
<h4>
	<a href="loadform">+Add New Contact</a>
</h4>
<c:choose>
	<c:when test="${! empty listContact }">
		<table border="1">

			<tr>
				<th>srNo</th>
				<th>contactid</th>
				<th>name</th>
				<th>email</th>
				<th>phoneno</th>
				<th>Action</th>
			</tr>


			<c:forEach var="contact" items="${listContact}">

				<tr>
					<td>${srNo}</td>
					<td>${contact.contactid}</td>
					<td>${contact.contactname}</td>
					<td>${contact.contactemail}</td>
					<td>${contact.contactnumber}</td>
					<td><a href="edit?id=${contact.contactid}">edit</a>&nbsp;&nbsp; 
					<a href="delete?cid=${contact.contactid}" onclick="return confirm('Are you sure you want to delete this item?') ? true : false">delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red">page Not found</h1>
	</c:otherwise>
</c:choose>

