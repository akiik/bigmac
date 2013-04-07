



function getRequestObject() {
    if (window.XMLHttpRequest)
        return new window.XMLHttpRequest();
    if (typeof XMLHttpRequest == "undefined") { // old IE
        XMLHttpRequest = function () {
            try { return new ActiveXObject("Msxml2.XMLHTTP.6.0"); } catch (e) { }
            try { return new ActiveXObject("Msxml2.XMLHTTP.3.0"); } catch (e) { }
            try { return new ActiveXObject("Microsoft.XMLHTTP"); } catch (e) { }
            throw new Error("This browser does not support XMLHttpRequest.");
        };
    }
    else
        return new XMLHttpRequest();
    return XMLHttpRequest();
}



function loadJSON(url,callback) {
    var req = getRequestObject();
    
   
    req.open("GET", url, false); // synchronous request
    req.setRequestHeader('Content-Type', 'Charset=UTF-8');
    req.send("");
   
    //req.responseXML;
    if (!req.responseType || req.responseType == "json") {
        var ci = eval("(" + req.responseText + ")"); // Firefox requires ()
        if (ci) {
			callback(ci);            
        }
    }
    else
        throw new Error("Response was not an JSON document! Response " + req.responseType + " " + req.responseText);

    return false; // for older browsers
}


function search_candidate_callback(ci){
    var options = new Array();
    var candidates = ci.candidates;
    for (var i=0;i<candidates.length;i++){
    	var option = window.document.createElement("option");
    	option.setAttribute("value",candidates[i].id);
    	option.text=candidates[i].person.name;
    	options[i]=option;
    	//cid.appendChild(window.document.createTextNode(candidates[i].person.name));
    	//cid.appendChild(window.document.createElement("br"));
    }
    replaceCandidatesData(options);
}

function replaceCandidatesData(options) {
    var cd = window.document.getElementById("kandidaadid");
    while (cd.hasChildNodes()) {
        cd.removeChild(cd.firstChild);
    }
    for (var i=0;i<options.length;i++){
    	cd.appendChild(options[i]);
    }  
}

function candidate_callback(ci) {
	var cd = window.document.getElementById("info");
	while (cd.hasChildNodes()) {
        cd.removeChild(cd.firstChild);
    }
    var div = window.document.createElement("div");
    div.style.width ="100%";
    div.appendChild(window.document.createTextNode("Nimi: " + ci.person.name));
    div.appendChild(window.document.createElement("br"));
    div.appendChild(window.document.createTextNode("partei: " + ci.party.name));
    div.appendChild(window.document.createElement("br"));
    div.appendChild(window.document.createTextNode("piirkond: " + ci.region.name));
    div.appendChild(window.document.createElement("br")); 
    var input = window.document.createElement("input");
    input.setAttribute('type','hidden');
    input.setAttribute('value',ci.id);
    input.setAttribute('name','id');
    div.appendChild(input);
    var submit = window.document.createElement("input");
    submit.setAttribute('class','submitvote');
    submit.setAttribute('type','submit');
    submit.setAttribute('value',"Hääleta");
    div.appendChild(submit);  
    cd.appendChild(div);
	
}
function hello(ci){
	console.log(ci);

	
}
