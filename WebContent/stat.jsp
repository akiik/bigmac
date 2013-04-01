<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<li><a href="#tabs-2" class="no-print">Piirkondade lıikes</a></li>
					<li><a href="#tabs-3" class="no-print">Parteide lıikes</a></li>
					<li><a href="#tabs-4" class="no-print">Kandidaatide lıikes lıikes</a></li>
					</ul>
					<div id="tabs-1">
						<table id="myTable" class="tablesorter"> 
						<thead> 
						<tr> 
							<th>Erkond</th> 
							<th>Reformierakond</th> 
							<th>IRL</th> 
							<th>Keskerakond</th> 
							<th>SDE</th> 
						</tr> 
						</thead> 
						<tbody> 
						<tr> 
							<td>H‰‰lte arv</td> 
							<td>6575</td> 
							<td>5675</td> 
							<td>567657</td> 
							<td>567</td> 
						</tr> 
						<tr> 
							<td>H‰‰lte %</td> 
							<td>23%</td> 
							<td>23%</td> 
							<td>23%</td> 
							<td>23%</td> 
						</tr> 

						</tbody> 
						</table>
					
					</div>
					<div id="tabs-2">
						<img src="css/images/map.png">
					</div>
					<div id="tabs-3">
						<table class="gridtable">
						<tr>
							<th>Erakond</th><th>Reformierakond</th><th>IRL</th><th>Keskerakond</th><th>Keskerakond</th>
						</tr>
						<tr>
							<td>H‰‰lte arv</td><td>Text 1A</td><td>Text 1B</td><td>Text 1C</td><td>Keskerakond</td>
						</tr>
						<tr>
							<td>H‰‰lte protsent</td><td>Text 2A</td><td>Text 2B</td><td>Text 2C</td><td>Keskerakond</td>
						</tr>
						</table>uis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
					</div>
					<div id="tabs-4">
<table id="myTable2" class="tablesorter"> 
						<thead> 
						<tr> 
							<th>Nr.</th> 
							<th>Eesnimi</th> 
							<th>Perekonnanimi</th> 
							<th>Erakond</th> 
							<th>Piirkond</th> 
							<th>H‰‰li</th>
						</tr> 
						</thead> 
						<tbody> 
						<tr> 
							<td>1</td> 
							<td>Jaanus</td> 
							<td>J‰rv</td> 
							<td>Reformierakond</td> 
							<td>J‰rvamaa</td>
							<td>14</td> 
						</tr> 
						<tr> 
							<td>1</td> 
							<td>Jaanus</td> 
							<td>J‰rv</td> 
							<td>Reformierakond</td> 
							<td>J‰rvamaa</td> 
							<td>133</td> 
						</tr>
						<tr> 
							<td>4</td> 
							<td>Peeter</td> 
							<td>Rebane</td> 
							<td>Keskerakond</td>
							<td>J‰rvamaa</td>							
							<td>124</td> 
						</tr>
						<tr> 
							<td>6</td> 
							<td>Peeter</td> 
							<td>Rebane</td> 
							<td>Keskerakond</td> 
							<td>Tartumaa</td>
							<td>124</td> 
						</tr>
						</tbody> 
						</table>
					</div>
					
				</div>
			</div>
			</div>
				
			</div>





<jsp:include page="/template/footer.html"></jsp:include>