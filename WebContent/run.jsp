<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<form method="POST" action="./dorun" id="run_info" onsubmit="return runFormValid(); return false;">
				<div id="row1">
					<h3>Isikuandmed:</h3>
					<p>Nimi: Eesnimi Perekonnanimi</p>
					<p>Sünniaeg: PP-KK-AA</p>
					<p>Isikukood: 1234567890</p>
				</div>				
				<div class="row2">
					<h3>Kandideerimise andmed:</h3>
					
					<label class="hid_err" id="hid_0">Palun vali partei!</label>
					<select name="erakonnad">
					<option selected value="null">Vali Partei</option>
					 <c:forEach var="party" items="${partys}">
				        <option value=${party.id}>${party.name}</option>
	     			 </c:forEach>
	     			 </select>
					<br>
					
					<label class="hid_err" id="hid_1">Palun vali piirkond!</label>
					<select name="piirkond">
					<option selected value="null">Vali Piirkond</option>
					 <c:forEach var="region" items="${regions}">
				        <option value=${region.id}>${region.name}</option>
	     			 </c:forEach>
	     			 </select>
					<br>
					
					<label class="hid_err" id="hid_2">Palun vali haridustase!</label>
					<select name="haridus">
					<option value="null">Vali haridustase:</option>
					<option value="alg">algharidus</option>
					<option value="pohi">põhiharidus</option>
					<option value="kesk">keskharidus</option>
					<option value="korg">kõrgharidus</option>
					</select>
					<br>
					<label class="hid_err" id="hid_3">Palun vali tegevusala!</label>
					<input type="text" class="c1" value="Sisesta tegevusala" onfocus="this.value = this.value=='Sisesta tegevusala' ? '' : this.value; this.style.color='#000';">
					
				</div>
				
				<div id="row2">
					<h3>Sõnum valijale:</h3>
					<p>Kirjuta, miks peaks inimene just sind valima:</p>
					<textarea name="run_message" rows="4" cols="30"></textarea>
				</div>
				
				<input type="submit" class="run" value="Kandideeri!"/>
				</form>
				
			</div> <!-- box ends -->
		</div> <!-- content ends -->

<jsp:include page="/template/footer.html"></jsp:include>
