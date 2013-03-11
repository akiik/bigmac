function runFormValid() {
	var formValid = true;
	var elements = document.forms["run_info"].elements;
	
	for (var i = 0; i < (elements.length-2); i++) {
		var hid_str="hid_"+i;
		if (elements[i].value == "null" || elements[i].value == "Sisesta tegevusala")
		{
			formValid = false;
			elements[i].setAttribute("class", "error");
			document.getElementById(hid_str).style.display="block";
		}
		else if (elements[i].getAttribute("class") == "error")
		{
			elements[i].setAttribute("class", "");
			document.getElementById(hid_str).style.display="none";
		}
	}
	if (formValid == true)
		return true;
	else
		return false;
}
