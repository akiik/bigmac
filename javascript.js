

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
$('#searchform select').change(function() {
	
	
	var $selects = $("#searchform select");
    // not sure if you wanted this, but I thought I'd add it.
    // get an associative array of just the values.
    var values = {};
    $selects.each(function() {
        values[this.name] = $(this).val();
    });
	
	if ((values["erakond"]!= "valimata") && (values["piirkond"] != "valimata")) {
			loadJSON(ROOT_URI+"/json/findCandidatesByPartyAndRegion.json",search_candidate_callback);
		}
	else if (values["erakond"] != "valimata") {
			loadJSON(ROOT_URI+"/json/findCandidatesByParty.json",search_candidate_callback);
		}
	else if (values["piirkond"] != "valimata") {
			loadJSON(ROOT_URI+"/json/findCandidatesByRegion.json",search_candidate_callback);
		}
	else {
		replaceCandidatesData("");
	}
	if (values["candidates"]) {
		loadJSON(ROOT_URI+"/json/candidate.json",candidate_callback);
		
	}
	return false; 
			
});
});

$(document).ready(function() 
    { 
        $("#myTable").tablesorter(); 
		$("#myTable2").tablesorter(); 
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
        console.log("bouh");
        //document.getElementById("tabs").style.visibility="visible";
        spinner.stop();
        $( "#tabs div" ).each(function( index ) {
     this.style.visibility="visible";  
    }); // Stop the spinner
    }, 1000);

}
