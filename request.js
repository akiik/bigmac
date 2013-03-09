

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
