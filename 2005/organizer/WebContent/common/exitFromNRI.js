// exitFromNRI.js

// onbeforeunload:
window.onbeforeunload = unloadCheck;
window.setTimeout('window.onbeforeunload=null', 60000 * 30);
dialogArrayExit = new Array();	//дочерние окна
function unloadCheck()	{
	if(event.clientX > document.body.clientWidth && event.clientY < 0){
		//закрываем дочерние окна:
		if(dialogArrayExit != null){
			for(var i = 0; i < dialogArrayExit.length; i++){
				if(dialogArrayExit[i])
					dialogArrayExit[i].close();
			}
		}	
		return 'Внимание!\nДля выхода из системы \'NRI \' воспользуйтесь пунктом меню \'Выход\'.';
	}else{
		return;
	}
}
