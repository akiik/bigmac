function initialize()
{
var mapProp = {
  center:new google.maps.LatLng(58.726781,25.543213),
  zoom:7,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };
var map=new google.maps.Map(document.getElementById("googleMap")
  ,mapProp);
}
