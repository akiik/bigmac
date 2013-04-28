var leaders = [];

function leader_callback(ci){
	var leader = [];
	leader.push(ci.party);
	leader.push(ci.score);
	leaders.push(leader);
}

function initialize()
{
	var locations = [
['Harjumaa', 59.397569,25.229187, 4],
['Hiiumaa', 58.952841,22.584686, 5],
['Ida-Virumaa', 59.327585,27.415466, 3],
['Jõgevamaa', 58.725451,26.394196, 2],
['Lääne-Virumaa', 59.319178,26.32782, 6],
['Pärnumaa', 58.482209,24.69635, 8],
['Põlvamaa', 58.12432,27.207184, 9],
['Raplamaa', 58.860644,24.73526, 10],
['Saaremaa', 58.499435,22.608948, 11],
['Tallinn', 59.438791,24.753456, 12],
['Tartumaa', 58.413223,26.80069, 13],
['Valgamaa', 57.922142,26.160736, 14],
['Viljandimaa', 58.300831,25.580749, 15],
['Läänemaa', 58.904646,23.789978, 16],
['Võrumaa', 57.811115,26.852875, 17],
['Järvamaa', 58.921664,25.493317, 18]
];
	var abbr = ['HR', 'HI', 'IV', 'JG', 'LV',
	            'PA', 'PO', 'RP', 'SA', 'TN',
	            'TA', 'VA', 'VD', 'LA', 'VO', 'JA'];

var j;
for (j = 0; j < abbr.length; j++) {
	loadJSON("./maxvote?region=" + abbr[j], leader_callback);
}

var map = new google.maps.Map(document.getElementById('map'), {
zoom: 7,
center: new google.maps.LatLng(58.884781,25.551739),
mapTypeId: google.maps.MapTypeId.ROADMAP
});
 
var infowindow = new google.maps.InfoWindow({
	maxWidth: 300,
});
 
var marker, i;
 
for (i = 0; i < locations.length; i++) {
marker = new google.maps.Marker({
position: new google.maps.LatLng(locations[i][1], locations[i][2]),
title: locations[i][0],
map: map
});

google.maps.event.addListener(marker, 'click', (function(marker, i) {
return function() {
infowindow.setContent(locations[i][0]);
infowindow.setContent("Valimisringkonnas <b>" + locations[i][0] + 
		"</b> juhib hetkeseisuga <b>" + leaders[i][0] + "</b> " + 
		leaders[i][1] + "-protsendilise häälteenamusega.");
infowindow.open(map, marker);
}
})(marker, i));
}
}
