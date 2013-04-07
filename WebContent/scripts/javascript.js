

var ROOT_URI = "http://ec2-23-21-6-189.compute-1.amazonaws.com/bigmac/";




//login popup
$(function() {
    $('#dialog').dialog({
        autoOpen: false
    });
    $('#login').click(function() {
        $('#dialog').dialog('open');
    });
});




//nime autocomplete

 $(function() {

	$( "#tags" ).autocomplete({
		source: function(request, response) {
		    $.getJSON("./autocomplete", { foo: request.term }, response);
		  }
	});
});

//statistika tabid
 $(function() {
	$( "#tabs" ).tabs();
});


 $(function() {
$('#searchform select').change(function() {

	
	var $selects = $("#searchform select");
    // not sure if you wanted this, but I thought I'd add it.
    // get an associative array of just the values.
    var values = {};
    $selects.each(function() {
        values[this.name] = $(this).val();
    });
	
	if ((values["erakond"]!= "valimata") && (values["piirkond"] != "valimata")) {
			url= "./candidates/partyAndregion/"+values["erakond"]+"/"+values["piirkond"];
			loadJSON(url,search_candidate_callback);
		}
	else if (values["erakond"] != "valimata") {
			url = "./candidates/party/"+values["erakond"];
			loadJSON(url,search_candidate_callback);
		}
	else if (values["piirkond"] != "valimata") {
		url = "./candidates/region/"+values["piirkond"];
			loadJSON(url,search_candidate_callback);
		}
	else {
		replaceCandidatesData("");
	}
	if (values["candidates"]) {
		loadJSON("./candidate/"+values["candidates"],candidate_callback);
		
	}
	return false; 
			
});
});

$(document).ready(function() 
    { 
        $("#myTable").tablesorter(); 
		$("#myTable2").tablesorter(); 
		$("#myTable1").tablesorter(); 
    } 
); 

 $(function() {
$('#tabs li').click(function() {
  $( "#tabs div" ).each(function( index ) {
     this.style.visibility="hidden";  
    });
	loading();
  	//alert("OOK");
    });

 });
 
 
// Javascript

function loading()
{
	//document.getElementById("tabs").style.visibility="hidden";
	var spinner = new Spinner({
	lines: 12, // The number of lines to draw
	length: 7, // The length of each line
	width: 5, // The line thickness
	radius: 10, // The radius of the inner circle
	color: '#000', // #rbg or #rrggbb
	speed: 1, // Rounds per second
	trail: 100, // Afterglow percentage
	shadow: true // Whether to render a shadow
}).spin(document.getElementById("stat_table"));
	
	setTimeout(function() {
        //console.log("bouh");
        //document.getElementById("tabs").style.visibility="visible";
        spinner.stop();
        $( "#tabs div" ).each(function( index ) {
     this.style.visibility="visible";  
    }); // Stop the spinner
    }, 1000);

}


$(function() {
	$('#searchbyname').click(function() {
		var value = $(".searchbyname").val();
		loadJSON("./candidate/name/"+value,candidate_callback);
		return false;
	});
});



