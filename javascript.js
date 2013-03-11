

var ROOT_URI = "http://localhost/BIGMAC/";

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
	
	
	
	/*
	var select_name = $(this).attr("name");
	var selected_value=$(this).find(':selected').val();

	if (select_name == "erakond" && selected_value != "valimata" || select_name == "piirkond" && selected_value == "valimata"){		
		click_loadJSON(ROOT_URI+"/json/findCandidatesByParty.json");
	}
	else if (select_name == "piirkond" && selected_value != "valimata" || select_name == "erakond" && selected_value == "valimata"){
		click_loadJSON(ROOT_URI+"/json/findCandidatesByRegion.json");
	}
	*/
	//alert($(this).find(':selected').val());
	/*
        if ($(this).find(':selected').val() === '5') {
            $('div#custom_proptions').slideDown('slow');
        } else {
            $('div#custom_proptions').slideUp('slow');
        }
        */
    });
 });
 

