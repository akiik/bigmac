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