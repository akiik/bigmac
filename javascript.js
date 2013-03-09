//login popup
$(function() {
    $('#dialog').dialog({
        autoOpen: false
    });
    $('#login').click(function() {
        $('#dialog').dialog('open');
    });
});
//vali erakond
$(function() {
$( "#selectable" ).selectable({
stop: function() {
var result = $( "#select-result" ).empty();
$( ".ui-selected", this ).each(function() {
var index = $( "#selectable li" ).index( this );
result.append( " #" + ( index + 1 ) );
});
}
});
});

//nime autocomplete

 $(function() {
	var availableTags = [
	"Jaan Põld",
	"Jaanus Murakas",
	"Janar Kokk",
	"Priit Punane",
	"Peeter Karvane"

	];
	$( "#tags" ).autocomplete({
	source: availableTags
	});
});

//statistika tabid
 $(function() {
	$( "#tabs" ).tabs();
});

$(function() {
$('#jsonsearch').submit(function() {
    // get all the inputs into an array.
    var $inputs = $("#jsonsearch select");
    // not sure if you wanted this, but I thought I'd add it.
    // get an associative array of just the values.
    var values = {};
    $inputs.each(function() {
        values[this.name] = $(this).val();
    });
	
	if (values["erakond"]!= "valimata" && values["asukoht"]!= "valimata") {
			alert (values["erakond"]+values["asukoht"]);
		}
	else if (values["erakond"]!= "valimata") {
			alert (values["erakond"]);
			click_loadJSON("https://courses.cs.ut.ee/MTAT.03.230/2013_spring/uploads/Main/findCandidatesByParty.json");
		}
	else if (values["asukoht"]!= "valimata") {
			alert (values["asukoht"]);
		}
	else {
		alert ("palun vali erakond ja/või asukoht");
	}
			
});
});


function getRequestObject() {
    if (window.XMLHttpRequest)
        return new window.XMLHttpRequest();
    if (typeof XMLHttpRequest == "undefined") { // old IE
        XMLHttpRequest = function () {
            try { return new ActiveXObject("Msxml2.XMLHTTP.6.0"); } catch (e) { }
            try { return new ActiveXObject("Msxml2.XMLHTTP.3.0"); } catch (e) { }
            try { return new ActiveXObject("Microsoft.XMLHTTP"); } catch (e) { }
            throw new Error("This browser does not support XMLHttpRequest.");
        };
    }
    else
        return new XMLHttpRequest();
    return XMLHttpRequest();
}

function replaceCourseData(newdatael) {
    var cd = window.document.getElementById("courseData");
    while (cd.hasChildNodes()) {
        cd.removeChild(cd.firstChild);
    }
    cd.appendChild(newdatael);
}
function click_loadJSON(url) {
    var req = getRequestObject();
    req.open("GET", "findCandidatesByParty.json", false); // synchronous request
    alert("OK");
    req.send("");alert("NOOT");
    //req.responseXML;
    if (!req.responseType || req.responseType == "json") {
        var ci = eval("(" + req.responseText + ")"); // Firefox requires ()
        if (ci) {
        	alert("OK");
            var cid = window.document.createElement("div");
            cid.setAttribute("id", "courseinfo");
            var cih = window.document.createElement("h2");
            cih.appendChild(window.document.createTextNode(ci.kood + " " + ci.nimi));
            cid.appendChild(cih);
            var cil = window.document.createElement("ol");
            cid.appendChild(cil);
            ci.teemad.forEach(function (it) {
                var cit = window.document.createElement("li");
                cil.appendChild(cit);
                cit.appendChild(window.document.createTextNode(it));
            });
            var cip = window.document.createElement("p");
            cid.appendChild(cip);
            cip.appendChild(window.document.createTextNode("Loengu toimumine: " + ci.loeng.paev + " " + ci.loeng.kell));
            cip.appendChild(window.document.createElement("br"));
            cip.appendChild(window.document.createTextNode("Ruum: " + ci.loeng.ruum));
            cip.appendChild(window.document.createElement("br"));
            cip.appendChild(window.document.createTextNode("Allikas: JSON"));
            replaceCourseData(cid);
        }
    }
    else
        throw new Error("Response was not an JSON document! Response " + req.responseType + " " + req.responseText);

    return false; // for older browsers
}
