// wscheck.js

function switchCheck(argCheck, argField, argType, argClear) {
  if (document.getElementById(argCheck).checked) {
      document.getElementById(argField).value = 'Номер неизвестен';
  	  document.getElementById(argField).contentEditable = false;
  	  document.getElementById(argField).className = 'editdisabled';
  //	  if (argType == 1) 
  //	    document.getElementById(argField).style.width = '200px';
  //	  else if (argType == 2) 
  //	    document.getElementById(argField).style.width = '100px';
  //	  else if (argType == 3) 
  //	    document.getElementById(argField).style.width = '100px';
  } else {
  	  document.getElementById(argField).contentEditable = true;
  	  if (argClear == 1)
        document.getElementById(argField).value = '';
  	  document.getElementById(argField).className = 'edit';
 // 	  if (argType == 1) 
 // 	    document.getElementById(argField).style.width = '200px';
 // 	  else if (argType == 2) 
 // 	    document.getElementById(argField).style.width = '100px';
 // 	  else if (argType == 3) 
 // 	    document.getElementById(argField).style.width = '100px';
  }
}