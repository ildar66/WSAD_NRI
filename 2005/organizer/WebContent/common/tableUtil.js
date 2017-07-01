// tableUtil.js

// Выделение / снятие выделения на строке и возможный скроллинг
function selectUnselectScrollToRow(selectedID, isScroll, isRrequiredSet, 
				tableId, curSelectedId, oldRowClassName, selectClassName, beginIndexId) {
	if(document.all[tableId].rows(document.all[curSelectedId].value) != null) {
		if ((document.all[oldRowClassName].value != null) && (document.all[oldRowClassName].value != '')) {
		 		document.all[tableId].rows(document.all[curSelectedId].value,0).className=
					document.all[oldRowClassName].value;
		}	
	}
	if (document.all[tableId].rows(selectedID,0)) {
		if ((document.all[curSelectedId].value != selectedID) || (isScroll) || (isRrequiredSet))  {
			document.all[curSelectedId].value=selectedID;
			document.all[oldRowClassName].value=document.all[tableId].rows(selectedID,0).className;
		
			document.all[tableId].rows(selectedID,0).className=selectClassName;
			if (isScroll) {
				document.all[tableId].rows(selectedID,0).scrollIntoView(true);
			}
		} else {
			if (! isScroll) {
				document.all[curSelectedId].value=beginIndexId;
				document.all[tableId].rows(selectedID,0).className=
					document.all[oldRowClassName].value;
			}	
		}
	}
	if (parent.document.all[curSelectedId]) {
		parent.document.all[curSelectedId].value=document.all[curSelectedId].value;
	}
}
