var builder = require('botbuilder');

 

var connector = new builder.ConsoleConnector().listen();

var bot = new builder.UniversalBot(connector, function (session) {

    var msg = session.message.text;

    var back = "Here's a link to the FAQ: www.hackUTD.com/FAQ";

    if(msg == "I need help") {

        back = "Call 911"

    }
	
	if(msg == "How do i reset my password?"){
		back = "To reset your password click Login and click on the reset password link"
	}
	
	if(msg == "How do i login?") {
		back = "You can login to Aviall.com by clicking on the blue 'Login' button on the top right"
	}
	
	if(msg == "How do i search for a product?") {
		back = "You can search for a product by typing the name of the product in the search bar near top of the page"
	}
	
    session.send("%s", back);

});
