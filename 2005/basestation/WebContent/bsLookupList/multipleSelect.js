function showRegions() {
	var cnt = 0;
	// Check every super region
	for (var i=0; i < document.all.supregions.options.length; i++) {
		// If region selected
		if (document.all.supregions.options [i].selected) {
			// Show corresponding superregions
			for (var j=0; j < arrayLength; j++) {
				if (regs [j][1] == document.all.supregions.options [i].value) {
					document.all.regions.options [cnt] = new Option(regs [j][2], regs [j][0]);
					cnt++;
				}
			}
		}
	}
	document.all.regions.options.length = cnt;
}

function selectAllItems(selname, state) {
	for (var i=0; i < document.all.item(selname).options.length; i++) {
		document.all.item(selname).options [i].selected = state;
	}
}

function switchSupregSearch(state) {
	if(state) {
		multipleSelectForm.supregions.className = 'editsmalldisabled';
		multipleSelectForm.supregions.disabled = true;
	} else {
		multipleSelectForm.supregions.className = 'editsmallsearch';
		multipleSelectForm.supregions.disabled = false;
	}
}

function reselectRegions() {
	if (document.all.allregions[0].checked) {
			selectAllItems("regions", true);
	} else {
		document.all.regions.options[0].selected = true;
	}
}

function switchSupregSearchAfter(state) {
	if(state) {
		selectAllItems("supregions", true);
		showRegions();
		reselectRegions();
	} else {
		selectAllItems("supregions", false);
		document.all.supregions.options[0].selected = true;
		showRegions();
		reselectRegions();
	}
}

function switchRegionSearch(state) {
	if(state) {
		multipleSelectForm.regions.className = 'editsmalldisabled';
		multipleSelectForm.regions.disabled = true;
	} else {
		multipleSelectForm.regions.className = 'editsmallsearch';
		multipleSelectForm.regions.disabled = false;
	}
}

function switchRegionSearchAfter(state) {
	if(state) {
		selectAllItems("regions", true);
	} else {
		selectAllItems("regions", false);
		document.all.regions.options[0].selected = true;
	}
}

function switchNetzoneSearch(state) {
	if(state) {
		multipleSelectForm.netzones.className = 'editsmalldisabled';
		multipleSelectForm.netzones.disabled = true;
	} else {
		multipleSelectForm.netzones.className = 'editsmallsearch';
		multipleSelectForm.netzones.disabled = false;
	}
}

function switchNetzoneSearchAfter(state) {
	if(state) {
		selectAllItems("netzones", true);
	} else {
		selectAllItems("netzones", false);
		document.all.netzones.options[0].selected = true;
	}
}

function switchPositionSearch(state) {
	if(state) {
		multipleSelectForm.poscode.className = 'editkoddisabled';
		multipleSelectForm.poscode.disabled = true;
	} else {
		multipleSelectForm.poscode.className = 'editkodsearch';
		multipleSelectForm.poscode.disabled = false;
	}
}

function switchPositionSearchAfter(state) {
	if(state) {
		//document.all.allsuperregions[0].checked = false;
		//document.all.allregions[0].checked = false;
		//document.all.allnetzones[0].checked = false;
		//switchSupregSearch(false); switchSupregSearchAfter(false);
		//switchRegionSearch(false); switchRegionSearchAfter(false);
		//switchNetzoneSearch(false); switchNetzoneSearchAfter(false);
	} else {
		document.all.allsuperregions[0].checked = true;
		document.all.allregions[0].checked = true;
		document.all.allnetzones[0].checked = true;
		switchSupregSearch(true); switchSupregSearchAfter(true);
		switchRegionSearch(true); switchRegionSearchAfter(true);
		switchNetzoneSearch(true); switchNetzoneSearchAfter(true);
	}
}

function switchWorkerSearch(state) {
	if(state) {
		multipleSelectForm.respcode.className = 'editkoddisabled';
		multipleSelectForm.respcode.disabled = true;
	} else {
		multipleSelectForm.respcode.className = 'editkodsearch';
		multipleSelectForm.respcode.disabled = false;
	}
}

function switchEndtimeSearch(state) {
	if(state) {
		multipleSelectForm.respmonth.className = 'editsmalldisabled';
		multipleSelectForm.respmonth.disabled = true;
		multipleSelectForm.respyear.className = 'editkoddisabled';
		multipleSelectForm.respyear.disabled = true;
	} else {
		multipleSelectForm.respmonth.className = 'editsmallsearch';
		multipleSelectForm.respmonth.disabled = false;
		multipleSelectForm.respyear.className = 'editkodsearch';
		multipleSelectForm.respyear.disabled = false;
	}
}
