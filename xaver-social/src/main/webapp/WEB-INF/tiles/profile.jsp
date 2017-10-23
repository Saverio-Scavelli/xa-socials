<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:url var="img" value="/img" />
<c:url var="editProfileAbout" value="/edit-profile-about" />


<div class="row">
	<div class="col-md-10 col-md-offset-1">
	
		<div class="profile-about">
		
			<div class="profile-image">
					<img src="${img}/avatar3.jpg" alt="" />
			</div>
			<div class="profile-text">
			 	<c:if test="${profile.about==null}" >
			 		print test
			 	</c:if>	
			</div>
		</div>
		
		<div class="profile-about-edit">
			<a href="${editProfileAbout}">Edit</a>
		</div>
		
			
	</div>

</div>
