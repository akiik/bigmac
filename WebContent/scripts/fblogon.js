/*// Facebook logon functions here.

// Additional JS functions here
window.fbAsyncInit = function() {
	FB.init({
		appId : '245026645637413', // App ID
		channelUrl : '/template/channel.html', // Channel File
		status : true, // check login status
		cookie : true, // enable cookies to allow the server to access the session
		xfbml : true  // parse XFBML
	});
	
	// Additional init code here
	FB.getLoginStatus(function(response) {
		if (response.status === 'connected') {
			// connected
		} else if (response.status === 'not_authorized') {
			// not_authorized
			login();
		} else {
			// not_logged_in
			login();
		}
	});
};


function login() {
	FB.login(function(response) {
		if (response.authResponse) {
			// connected
		} else {
			// cancelled
		}
	});
}

// Load the SDK Asynchronously
(function(d) {
	var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement('script');
	js.id = id;
	js.async = true;
	js.src = "//connect.facebook.net/et_EE/all.js";
	ref.parentNode.insertBefore(js, ref);
}(document));*/