// dialog.js

//window.document.body.onunload:
window.document.body.onunload = onUnloadCheck;
//window.setTimeout('window.onunload=null', 60000 * 10);
dialogArray = new Array();	//дочерние окна
function onUnloadCheck()	{
	//закрываем дочерние окна:
	if(dialogArray != null){
		for(var i = 0; i < dialogArray.length; i++){
			if(dialogArray[i]) {
				try {
					dialogArray[i].close();
				} catch (err) {
				}	
			}	
		}
	}	
}
function openDialog(hrefStr, name, prop){
	var wnd = window.open(hrefStr, name, prop);
	dialogArray[dialogArray.length]=wnd;
	wnd.focus();
	return false;
}
