<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<jsp:include page="/template/header.html"></jsp:include>

<div class="content">
	<div id="box"  class="clearfix">
		<div id="byname">
			<div class="nonrelevant">
				
				<label for="tags">Otsi nime: </label>
				<input id="tags" class="searchbyname" />
				<a href="" id="searchbyname" class="search">Otsi</a>
				<a href="./" class="avalehele">Avalehele</a>
			</div>
		</div>
		<!--<p>Otsi erakonnast ja/vi valimisringkonnast<p>-->
		<div id="searchby">
		<div id="searchform">

			<div class="searchform_part">	
			<p class="searchform_label">Vali erakond</p>		
			<select size="10" name="erakond" style="width:200px;" >
				<option selected>valimata</option>
				 <c:forEach var="party" items="${partys}">
			        <option>${party}</option>
     			 </c:forEach>
			</select>
			</div>
			<div class="searchform_part">
			<p class="searchform_label">Vali piirkond</p>	
			<select size="10" id="region" name="piirkond" style="width:120px;">
				<option selected>valimata</option>
				<c:forEach var="region" items="${regions}">
			        <option>${region}</option>
     			 </c:forEach>
			</select>
			</div>
			<div class="searchform_part" >	
				<p class="searchform_label">Kandidaadid</p>
			<select size="10" id="kandidaadid" name ="candidates">
			</select>
			</div>		
			<div class="searchform_part" id="chosen_candidate">
				<p class="searchform_label">Sinu poolt valitud kandidaat on:</p>
			<form action="./dovote" method="post">
				<div id="info" >
				
					Palun vali kandidaat.
	
				</div>
			</form>
			</div>

				<form  action="./dropvote" method="post">
				<input type="submit" class="submitvote" value="Loobu">
			</form>
			</div>
		</div>
	</div>

</div> <!-- content ends -->

<jsp:include page="/template/footer.html"></jsp:include>
