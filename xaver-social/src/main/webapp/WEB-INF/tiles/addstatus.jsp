<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.io.*,java.util.*" %>

<%
  
/*
   Enumeration headerNames = request.getHeaderNames();
   while(headerNames.hasMoreElements()) {
      String paramName = (String)headerNames.nextElement();
      out.print("<tr><td>" + paramName + "</td>\n");
      String paramValue = request.getHeader(paramName);
      out.println("<td> " + paramValue + "</td></tr>\n");
   }
   */
%>

     <div class="row">
 	<div class="col-md-8 col-md-offset-2">
<%--  	RequestType: <%= response.toString() %> <br /> --%>
<%--  	Request statusUpdate Attribute: <%= request.getAttribute("statusUpdate") %> <br /> --%>
<%--  	Request statusUpdate Attribute ID: <%= request.getAttribute("id") %> <br /> --%>
<%--  	JSP Object: <%= this %> <br /> --%>
<%--  	JSP Class: <%= this.getClass() %> <br /> --%>

 		<div class="panel panel-default">
 			<div class="panel-heading">
 				<div class="panel-title">Add a status Update</div>	
 			</div>
 			
				
				<form:form modelAttribute="statusUpdate">
					<div class="errors">
						<form:errors path="text" />
					</div>
					<div class="form-group">
						<form:textarea path="text" name="text" id="" cols="50" rows="10"></form:textarea>
						<input type="submit" value="Add Status" name="subit" />
					</div>
				</form:form>				
 		</div>
 		
 		<div class="panel panel-default">
 			<div class="panel-heading">
 				<div class="panel-title"><fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:ss" value="${latestStatusUpdate.added}"/></div>	
 			</div>
 			<div class="panel-body">
					${latestStatusUpdate.text}
					
				
					
			</div>
 		</div>
 		
 	</div>
 
 </div>   
 
 <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
 <script>
 	tinymce.init({
 		selector:'textarea',
 		plugins:'link'
 	});
 </script>
    