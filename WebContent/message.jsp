<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="/template/header.html"></jsp:include>
		<div class="content">
			<div id="box"  class="clearfix">
				<div id="byname">
					<div class="user-status">
						<h3>Sisselogitud kui Einar Kull
						<a href="./" class="avalehele">Avalehele</a>
						</h3>
					</div>
				</div>
				<h3>${message}</h3>
			</div> <!-- box ends -->
		</div> <!-- content ends -->

<jsp:include page="/template/footer.html"></jsp:include>