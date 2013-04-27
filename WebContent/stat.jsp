<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="/template/header.html"></jsp:include>


<div class="content">
			<div id="box"  class="clearfix">
				<div id="byname">
					<div class="nonrelevant">
						<h3>Kandideerimise statistika
						<a href="./" class="avalehele">Avalehele</a>
						</h3>
					</div>
				</div>
				<div id="stat_table">
					<div id="tabs">
					<ul>
					<li><a href="#tabs-1" class="no-print">Kogu riigis</a></li>
					<li><a href="#tabs-2" class="no-print" onclick=initialize()>Piirkondade lõikes</a></li>
					<li><a href="#tabs-3" class="no-print">Parteide lõikes</a></li>
					<li><a href="#tabs-4" class="no-print">Kandidaatide lõikes</a></li>
					</ul>
					<div id="tabs-1">
						<table id="myTable" class="tablesorter"> 
						<thead> 
						<tr> 
							<th>Erakond</th> 
							<th>Reformierakond</th> 
							<th>IRL</th> 
							<th>Keskerakond</th> 
							<th>SDE</th> 
						</tr> 
						</thead> 
						<tbody> 
						<tr> 
							<td>Häälte arv</td> 
							<td>6575</td> 
							<td>5675</td> 
							<td>567657</td> 
							<td>567</td> 
						</tr> 
						<tr> 
							<td>Häälte %</td> 
							<td>23%</td> 
							<td>23%</td> 
							<td>23%</td> 
							<td>23%</td> 
						</tr> 

						</tbody> 
						</table>
					
					</div>
					<div id="tabs-2">
						<div id="googleMap" style="width:900px;height:400px;"></div>
					</div>
					<div id="tabs-3">
						<table id="myTable1" class="tablesorter"> 
						<thead> 
						
						<tr> 
							<th>Erakond</th>
							<th>Häälte arv</th>
							<th>Häälte protsent</th>
						</tr>
						</thead> 
						<tbody> 
						<tr>
							<td>Kesk</td>
							<td>2</td>
							<td>10</td>

						</tr>

						</table>
					</div>
					<div id="tabs-4">
					<table id="myTable2" class="tablesorter"> 
						<thead> 
						<tr> 
							<th><div>Nr.</div></th> 
							<th><div>Nimi</div></th> 
							<th><div>Erakond</div></th> 
							<th><div>Piirkond</div></th> 
							<th><div>Hääli</div></th>
						</tr> 
						</thead> 
						<tbody> 
						<c:forEach var="candidate" items="${candidates}">
							<tr>
								<td><div>${candidate.id}</div></div></td>
								<td><div>${candidate.person.name}</div></td>
								<td><div>${candidate.party.name}</div></td>
								<td><div>${candidate.region.name}</div></td>
								<td><div>${candidate.votes}</div></td>
							</tr>
	     			 	</c:forEach>


						</tbody> 
						</table>
					</div>
					
				</div>
			</div>
			</div>
				
			</div>





<jsp:include page="/template/footer.html"></jsp:include>