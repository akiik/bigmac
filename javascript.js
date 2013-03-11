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
			click_loadJSON("json/findCandidatesByParty.json");
		}
	else if (values["asukoht"]!= "valimata") {
			alert (values["asukoht"]);
		}
	else {
		alert ("palun vali erakond ja/või asukoht");
	}
			
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
	loading();
  	//alert("OOK");
    });
 });
 
 
// Javascript

function loading()
{
	document.getElementById("tabs").style.visibility="hidden";
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
        document.getElementById("tabs").style.visibility="visible";
        spinner.stop(); // Stop the spinner
    }, 1000);

}
