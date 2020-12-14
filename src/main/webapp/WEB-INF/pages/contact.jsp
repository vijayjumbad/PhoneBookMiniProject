<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
    
<frm:form  action="savecontact?contactid=${contact.contactid}" modelAttribute="contact" method="POST">
	<h1 style="color: red; text-align: left">contact info</h1>

	<table>
		<tr>
			<td>contact name</td>
			<td><frm:input path="contactname" /></td>
		</tr>
		<tr>
			<td>contact email</td>
			<td><frm:input path="contactemail" /></td>
		</tr>
		<tr>
			<td>contact number</td>
			<td><frm:input path="contactnumber" /></td>
		</tr>
		<tr>
		<td> </td>
			<td><input type="submit" value="save contact" /></td>
		</tr>
		<tr>
		      <td><a href="view_contact">view All Contact</a></td>
		<tr>
	</table>
	
</frm:form>




