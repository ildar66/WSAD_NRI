document.onmouseover = onmouseover;
document.onmouseout = onmouseout;

function onmouseover()
{
	var e = window.event.srcElement;
	var s = e.title.toString();
	if(s == '' && e.tagName == 'A')
		s = e.innerText;
	if(s != '')
		window.setTimeout('window.status=\''+s.split('\'').join('\\\'')+'\'', 1);
}

function onmouseout()
{
	var e = window.event.srcElement;
	var s = e.title.toString();
	if(s == '' && e.tagName == 'A')
		s = e.innerText;
	if(s != '')
		window.status = '';
}

document.onhelp = onhelp;
function onhelp()
{
	var e = window.event.srcElement;
	openHelp(window.location, e.name!=''?e.name:e.id);
	event.returnValue = false;
	return false;
}

function openHelp(url, id)
{
	var wnd = window.open('/iBank/ibankjsp/help/HELP.jsp?path='+escape(url)+'&id='+escape(id), 'help', 'left='+(window.screen.width-400-10)+',width=400,top=0,height=480,resizable=yes,status=no,toolbar=no,menubar=no,location=no,scrollbars=yes');
	wnd.focus();
}
