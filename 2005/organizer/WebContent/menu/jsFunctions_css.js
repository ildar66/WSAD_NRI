// Assign the last modified date to the variable lastmoddate
var lastmoddate = document.lastModified;

// Create an if statement to test the value of lastmoddate
if(lastmoddate == 0)  { 
	var pageData = "Lastmodified: Unknown<br>&copy; 2002 Copyright";
}
else  {
	var pageData = "<font class=\"copyrightText\">Lastmodified:" + lastmoddate + "<br>&copy; 2002 Copyright </font>";
}


// Creating Image Objects for Rollovers
if (document.images)
{
MainGraphOn=new Image(95, 20);
MainGraphOn.src="/menu/images/main_on.gif";
MainGraphOff=new Image(95, 20);
MainGraphOff.src="/menu/images/main_off.gif";

DictionaryOn=new Image(95, 20);
DictionaryOn.src="/menu/images/dictionary_on.gif";
DictionaryOff=new Image(95, 20);
DictionaryOff.src="/menu/images/dictionary_off.gif";

ArendaOn=new Image(95, 20);
ArendaOn.src="/menu/images/task_on.gif";
ArendaOff=new Image(95, 20);
ArendaOff.src="/menu/images/task_off.gif";

/*
TrainingOn=new Image(75, 33);
TrainingOn.src="images/training_on.gif";
TrainingOff=new Image(75, 33);
TrainingOff.src="images/training_off.gif";

CommonOn=new Image(157, 33);
CommonOn.src="images/common_on.gif";
CommonOff=new Image(157, 33);
CommonOff.src="images/common_off.gif";

NewsOn=new Image(98, 33);
NewsOn.src="images/news_on.gif";
NewsOff=new Image(98, 33);
NewsOff.src="images/news_off.gif";

AboutOn=new Image(106, 33);
AboutOn.src="images/about_on.gif";
AboutOff=new Image(106, 33);
AboutOff.src="images/about_off.gif";
*/

}

var over = 'no';
var lastMenu = ' ';
var styleSheetElement;
var oldElement;

function menuOn(currentMenu) {
	over = 'yes';
	if ((browser == 'Netscape') && (version < 5)) {
		if (lastMenu != ' ')  {
			document.images[lastMenu].src = eval(lastMenu + 'Off.src');	
			eval('document.' + lastMenu + 'Menu.visibility = "hidden"');		
		}
		document.images[currentMenu].src = eval(currentMenu + 'On.src');
		eval('document.' + currentMenu + 'Menu.visibility = "visible"');	
		lastMenu = currentMenu;			
	}
	else {
		if (lastMenu != ' ') {
			eval('document.images[lastMenu].src = ' + lastMenu + 'Off.src');
			lastMenu = lastMenu + 'Menu';
			oldElement = document.getElementById(lastMenu);
			oldElement.style.visibility = "hidden";
		}
		eval('document.images[currentMenu].src = ' + currentMenu + 'On.src');
		var layerName = currentMenu + 'Menu';
		styleSheetElement = document.getElementById(layerName);
		styleSheetElement.style.visibility = "visible";
		lastMenu = currentMenu;		
	}

}

function overChecker(currentMenu) {
	over = 'no';
	lastMenu = currentMenu;
	setTimeout("menuOff()", 100);
}

function menuOff() 
{
	if (over == 'no')  {	
			if ((browser == 'Netscape') && (version < 5)) {
				document.images[lastMenu].src = eval(lastMenu + 'Off.src');
				eval('document.' + lastMenu + 'Menu.visibility = "hidden"');	
			}
			else {
			eval('document.images[lastMenu].src = ' + lastMenu + 'Off.src');
			styleSheetElement.style.visibility = "hidden";
			
		}
	}	
}


// Creating Image Objects for Product Banners
if (document.images)
{
product1Banner=new Image(71, 33);
product1Banner.src="images/product_banners/product_banner_1.gif";

product2Banner=new Image(71, 33);
product2Banner.src="images/product_banners/product_banner_2.gif";

product3Banner=new Image(71, 33);
product3Banner.src="images/product_banners/product_banner_3.gif";

product4Banner=new Image(71, 33);
product4Banner.src="images/product_banners/product_banner_4.gif";

product5Banner=new Image(71, 33);
product5Banner.src="images/product_banners/product_banner_5.gif";
}


// First Generate a Random number that will be used to choose the intitial product banner displayed on the page


var prodStart = Math.random()*4+1;
prodStart = Math.round(prodStart);

// Product Banner Randomizer
function bannerChanger()  {
	prodStart = Math.random()*4+1;
	prodStart = Math.round(prodStart);
	document.images['prodBanner'].src = eval("product" + prodStart + "Banner.src");
	setTimeout("bannerChanger()", 20000);
}

//setTimeout("bannerChanger()", 20000);

// Pull-Down Menu Navigation Function
function PageChanger(page) {           
    document.NavForm.PullDown.options[0].selected=true;
	document.location= page;       
    
}