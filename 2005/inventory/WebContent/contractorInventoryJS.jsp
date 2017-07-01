<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.inventory.formbean.*"%>


<%
	ContractorInventoryForm frm2 = (ContractorInventoryForm)request.getSession().getAttribute("ContractorInventoryForm");
	
	int bsC = frm2.getBSCount();
    int acC = frm2.getACCount();
	int bpC = frm2.getBPCount();
	int vbpC = frm2.getVBPCount();
	int baC = frm2.getBACount();
	int soC = frm2.getSOCount();
	int poC = frm2.getPOCount();
	int muC = frm2.getMUCount();
	int cdC = frm2.getCDCount();
	int cbC = frm2.getCBSCount();
	int cbP = frm2.getCBPCount();
	int rpC = frm2.getRPCount();
	int anC = frm2.getANCount();
	int afC = frm2.getAFTCount();
	int proC = frm2.getPROCount();
%>

<script language="javascript">

function checkFictionSerial(group,index) {
	if(document.all.action.value == 'Add' || document.all.action.value == 'Edit') {
		var sn = group + "[" + index + "].sn";	
		if(document.all[group + "["+index+"].fictionSerial"][0].checked) {
			document.all[sn].style.background = '#DCDCDC';
			document.all[sn].disabled = true;
			document.all[sn].readonly = true;
		} else {
			document.all[sn].style.background = '#D6EBFF';
			document.all[sn].disabled = false;
			document.all[sn].readonly = false;
		}
	}
}

function toggleDetail(tabid) {
	if(document.all[tabid].style.display == "none"){
		document.all[tabid].style.display = "";
	}else{
		document.all[tabid].style.display = "none";
	}
}

function contains(arr,it) {
	var b = false;
	for(var i = 0; i < arr.length; i++) {
		if(arr[i] == it) { b = true; }
	}
	return b;
}

function refresh(typetmp,categtmp,arr) {
	var typeSelect = document.all.item(typetmp);
	var nameSelect = document.all.item(categtmp);

	nameItems = new Array();
	var si = 0;
	for(var i = 0; i < nameSelect.length; i++) {
		if(nameSelect.options[i].selected) {
			nameItems[si++] = nameSelect.options[i].value;
		}
	}
	var count = 0;
	var opt;
	typeSelect.length = arr.length;
	for(var i = 0; i < arr.length; i++) {
		if(contains(nameItems,arr[i][1])) {
			opt = typeSelect[count];
			opt.text = arr[i][2];
			opt.value = arr[i][0];
			count++;
		}
	}
	typeSelect.options.length = count;		
}

function refreshRow(typetmp,categ,arr) {
	var typeSelect = document.all.item(typetmp);
	var count = 0;
	var opt;
	var selecteditem;
	typeSelect.length = arr.length + 1;

	for(var i = 0; i < typeSelect.length; i++) {
		if(typeSelect[i].selected){
			selecteditem = typeSelect[i].value;
		}
	}
	
	opt = typeSelect[count];
	opt.text = "";
	opt.value = 0;
	count++;

	for(var i = 0; i < arr.length; i++) {
		if(categ == arr[i][1]) {
			opt = typeSelect[count];
			opt.text = arr[i][2];
			opt.value = arr[i][0];
			count++;
		}
	}

	typeSelect.options.length = count;		

	for(var i = 0; i < typeSelect.length; i++) {
		if(typeSelect[i].value == selecteditem){
			typeSelect[i].selected = true;
		}
	}
}

var curBLine = 3;
var maxBLine = <%= bsC %>;

var curALine = 3;
var maxALine = <%= acC %>;

var curBPLine = 3;
var maxBPLine = <%= bpC %>;

var curVBPLine = 3;
var maxVBPLine = <%= vbpC %>;

var curBALine = 3;
var maxBALine = <%= baC %>;

var curSOLine = 3;
var maxSOLine = <%= soC %>;

var curPOLine = 3;
var maxPOLine = <%= poC %>;

var curMULine = 3;
var maxMULine = <%= muC %>;

var curCDLine = 3;
var maxCDLine = <%= cdC %>;

var curCBSLine = 3;
var maxCBSLine = <%= cbC %>;

var curCBPLine = 3;
var maxCBPLine = <%= cbP %>;

var curRPLine = 3;
var maxRPLine = <%= rpC %>;

var curANLine = 3;
var maxANLine = <%= anC %>;

var curAFTLine = 3;
var maxAFTLine = <%= afC %>;

var curPROLine = 3;
var maxPROLine = <%= proC %>;

function changeVis(tarr, aspan, ares) {

	if ( (tarr [ares.value] == 'b') || (tarr [ares.value] == 'B') ) {
		aspan [1].style.cssText = "visibility:hidden; display:none;";
		aspan [0].style.cssText = "visibility:visible; display:inline;";
		if(aspan [2]) { aspan [2].style.cssText = "visibility:visible; display:inline;"; }
	} else if ( (tarr [ares.value] == 'p') || (tarr [ares.value] == 'P') ) {
		aspan [1].style.cssText = "visibility:visible; display:inline;";
		aspan [0].style.cssText = "visibility:hidden; display:none;";
		if(aspan [2]) { aspan [2].style.cssText = "visibility:visible; display:inline;"; }
	} else if ( (tarr [ares.value] == 's') || (tarr [ares.value] == 'S') ) {
		aspan [1].style.cssText = "visibility:visible; display:inline;";
		aspan [0].style.cssText = "visibility:hidden; display:none;";
		if(aspan [2]) { aspan [2].style.cssText = "visibility:visible; display:inline;"; }
	} else {		
		aspan [1].style.cssText = "visibility:hidden; display:none;";
		aspan [0].style.cssText = "visibility:hidden; display:none;"; 
		if(aspan [2]) { aspan [2].style.cssText = "visibility:hidden; display:none;"; }
	}
}

function changeBIS(index) {
	changeVis(BIS1ResourcesList_arr, document.all["bissp"+index], document.getElementById('bis['+index+'].type'));
}

function changeACC(index) {
	changeVis(ACCResourcesList_arr, document.all["accsp"+index], document.getElementById('acc['+index+'].type'));
}

function changeBP(index) {
	changeVis(BPResourcesList_arr, document.all["bipsp"+index], document.getElementById('bip['+index+'].type'));
}

function changeVBP(index) {
	changeVis(VBPResourcesList_arr, document.all["vbipsp"+index], document.getElementById('vbip['+index+'].type'));
}

function changeBA(index) {
	changeVis(BAResourcesList_arr, document.all["biasp"+index], document.getElementById('bia['+index+'].type'));
}

function changeSO(index) {
	changeVis(SOResourcesList_arr, document.all["siosp"+index], document.getElementById('sio['+index+'].type'));
}

function changePO(index) {
	changeVis(POResourcesList_arr, document.all["piosp"+index], document.getElementById('pio['+index+'].type'));
}

function changeMU(index) {
	changeVis(MUResourcesList_arr, document.all["miosp"+index], document.getElementById('mio['+index+'].type'));
}

function changeCD(index) {
	changeVis(CDResourcesList_arr, document.all["ciosp"+index], document.getElementById('cio['+index+'].type'));
}

function changeCBS(index) {
	changeVis(CBSResourcesList_arr, document.all["cbissp"+index], document.getElementById('cbis['+index+'].type'));
}

function changeCBP(index) {
	changeVis(CBPResourcesList_arr, document.all["cbipsp"+index], document.getElementById('cbip['+index+'].type'));
}

function changeRP(index) {
	changeVis(RPResourcesList_arr, document.all["ripsp"+index], document.getElementById('rip['+index+'].type'));
}

function changeAN(index) {
	changeVis(ANResourcesList_arr, document.all["ainsp"+index], document.getElementById('ain['+index+'].type'));
}

function changeAFT(index) {
	changeVis(AFTResourcesList_arr, document.all["aifsp"+index], document.getElementById('aif['+index+'].type'));
}

function changePRO(index) {
	var policy = document.all["prio["+index+"].policy"].value;
	var span = document.all["priosp"+index];

	if ( (policy == 'b') || (policy == 'B') ) {
		span [1].style.cssText = "visibility:hidden; display:none;";
		span [0].style.cssText = "visibility:visible; display:inline;";
		if(span [2]) { span [2].style.cssText = "visibility:visible; display:inline;"; }
	} else if ( (policy == 'p') || (policy == 'P') ) {
		span [1].style.cssText = "visibility:visible; display:inline;";
		span [0].style.cssText = "visibility:hidden; display:none;";
		if(span [2]) { span [2].style.cssText = "visibility:visible; display:inline;"; }
	} else if ( (policy == 's') || (policy == 'S') ) {
		span [1].style.cssText = "visibility:visible; display:inline;";
		span [0].style.cssText = "visibility:hidden; display:none;";
		if(span [2]) { span [2].style.cssText = "visibility:visible; display:inline;"; }
	} else {
		span [1].style.cssText = "visibility:hidden; display:none;";
		span [0].style.cssText = "visibility:hidden; display:none;"; 
		if(span [2]) { span [2].style.cssText = "visibility:hidden; display:none;"; }
	}
}

function delBS() {	
	document.all.bstable.deleteRow(curBLine);
}

function delAC() {
	document.all.actable.deleteRow(curALine);
}

function delBP() {
	document.all.bptable.deleteRow(curBPLine);
}

function delVBP() {
	document.all.vbptable.deleteRow(curVBPLine);
}

function delBA() {
	document.all.batable.deleteRow(curBALine);
}

function delSO() {
	document.all.sotable.deleteRow(curSOLine);
}

function delPO() {
	document.all.potable.deleteRow(curPOLine);
}

function delMU() {
	document.all.mutable.deleteRow(curMULine);
}

function delCD() {
	document.all.cdtable.deleteRow(curCDLine);
}

function delCBS() {
	document.all.cbstable.deleteRow(curCBSLine);
}

function delCBP() {
	document.all.cbptable.deleteRow(curCBPLine);
}

function delRP() {
	document.all.rptable.deleteRow(curRPLine);
}

function delAN() {
	document.all.antable.deleteRow(curANLine);
}

function delAFT() {
	document.all.afttable.deleteRow(curAFTLine);
}

function delPRO() {
	document.all.protable.deleteRow(curPROLine);
}

function saveBIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curBLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveAIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curALine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveBPIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curBPLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveVBPIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curVBPLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveBAIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curBALine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveSOIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curSOLine=window.event.toElement.parentElement.rowIndex;
	}
}

function savePOIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curPOLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveMUIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curMULine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveCDIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curCDLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveCBSIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curCBSLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveCBPIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curCBPLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveRPIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curRPLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveANIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curANLine=window.event.toElement.parentElement.rowIndex;
	}
}

function saveAFTIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curAFTLine=window.event.toElement.parentElement.rowIndex;
	}
}

function savePROIndex() {
	if (window.event.toElement.parentElement.tagName == 'TR') {
		curPROLine=window.event.toElement.parentElement.rowIndex;
	}
}

function addBSS() {
	var num = parseInt(document.all.bscnttmp.value);
	var table = document.all.bstable;
	var type = document.all.bstypetmp;
	var compid = document.all.complectbs;
	var compname = document.all.complectbsname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  add(table,type,maxBLine,'Базовая<br>станция',null,'bis',
			  BIS1ResourcesList_arr,'delBS',saveBIndex,'20','9',compid,compname);
		  maxBLine = maxBLine + 1;
		}
	}
}

function addACC() {
	var num = parseInt(document.all.accnttmp.value);
	var table = document.all.actable;
	var type = document.all.actypetmp;
	var compid = document.all.complectac;
	var compname = document.all.complectacname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  addmsu(table,type,maxALine,'Акуумулятор',null,'acc',ACCResourcesList_arr,'delAC',saveAIndex,'9','9',compid,compname);
		  maxALine = maxALine + 1;
		}
	}
}

function addBPP() {
	var num = parseInt(document.all.bpcnttmp.value);
	var table = document.all.bptable;
	var type = document.all.bptypetmp;
	var compid = document.all.complectbp;
	var compname = document.all.complectbpname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  add(table,type,maxBPLine,'Источник питания',null,'bip',
			  BPResourcesList_arr,'delBP',saveBPIndex,'20','9',compid,compname);
		  maxBPLine = maxBPLine + 1;
		}
	}
}

function addVBPP() {
	var num = parseInt(document.all.vbpcnttmp.value);
	var table = document.all.vbptable;
	var type = document.all.vbptypetmp;
	var compid = document.all.complectvbp;
	var compname = document.all.complectvbpname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  add(table,type,maxVBPLine,'Ячейка питания',null,'vbip',
			  VBPResourcesList_arr,'delVBP',saveVBPIndex,'20','9',compid,compname);
		  maxVBPLine = maxVBPLine + 1;
		}
	}
}

function addBAA() {
	var num = parseInt(document.all.bacnttmp.value);
	var table = document.all.batable;
	var type = document.all.batypetmp;
	var compid = document.all.complectba;
	var compname = document.all.complectbaname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  var categ = document.all.bacategtmp;
			var cname = '';
			var cid='';
			for (var i3=0; i3 < categ.options.length; i3++) {
			  if (categ.options.item(i3).value == categ.value) {
				cname = categ.options.item(i3).text;
				cid =  categ.options.item(i3).value;
				break;
			  }
			}
		  add(table,type,maxBALine,cname,cid,'bia',BAResourcesList_arr,'delBA',saveBAIndex,'20','9',compid,compname);
		  maxBALine = maxBALine + 1;
		}
	}
}

function addSOO() {
	var num = parseInt(document.all.socnttmp.value);
	var table = document.all.sotable;
	var type = document.all.sotypetmp;
	var compid = document.all.complectso;
	var compname = document.all.complectsoname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  var categ = document.all.socategtmp;
			var cname = '';
			var cid='';
			for (var i3=0; i3 < categ.options.length; i3++) {
			  if (categ.options.item(i3).value == categ.value) {
				cname = categ.options.item(i3).text;
				cid =  categ.options.item(i3).value;
				break;
			  }
			}
		  add(table,type,maxSOLine,cname,cid,'sio',SOResourcesList_arr,'delSO',saveSOIndex,'20','8',compid,compname);
		  maxSOLine = maxSOLine + 1;
		}
	}
}

function addPOO() {
	var num = parseInt(document.all.pocnttmp.value);
	var table = document.all.potable;
	var type = document.all.potypetmp;
	var compid = document.all.complectpo;
	var compname = document.all.complectponame;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  var categ = document.all.pocategtmp;
			var cname = '';
			var cid='';
			for (var i3=0; i3 < categ.options.length; i3++) {
			  if (categ.options.item(i3).value == categ.value) {
				cname = categ.options.item(i3).text;
				cid =  categ.options.item(i3).value;
				break;
			  }
			}
		  add(table,type,maxPOLine,cname,cid,'pio',POResourcesList_arr,'delPO',savePOIndex,'20','8',compid,compname);
		  maxPOLine = maxPOLine + 1;
		}
	}
}

function addMUU() {
	var num = parseInt(document.all.mucnttmp.value);
	var table = document.all.mutable;
	var type = document.all.mutypetmp;
	var compid = document.all.complectmu;
	var compname = document.all.complectmuname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  var categ = document.all.mucategtmp;
			var cname = '';
			var cid='';
			for (var i3=0; i3 < categ.options.length; i3++) {
			  if (categ.options.item(i3).value == categ.value) {
				cname = categ.options.item(i3).text;
				cid =  categ.options.item(i3).value;
				break;
			  }
			}
		  add(table,type,maxMULine,cname,cid,'mio',MUResourcesList_arr,'delMU',saveMUIndex,'20','8',compid,compname);
		  maxMULine = maxMULine + 1;
		}
	}
}

function addCDD() {
	var num = parseInt(document.all.cdcnttmp.value);
	var table = document.all.cdtable;
	var type = document.all.cdtypetmp;
	var compid = document.all.complectcd;
	var compname = document.all.complectcdname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  var categ = document.all.cdcategtmp;
			var cname = '';
			var cid='';
			for (var i3=0; i3 < categ.options.length; i3++) {
			  if (categ.options.item(i3).value == categ.value) {
				cname = categ.options.item(i3).text;
				cid =  categ.options.item(i3).value;
				break;
			  }
			}
		  add(table,type,maxCDLine,cname,cid,'cio',CDResourcesList_arr,'delCD',saveCDIndex,'20','8',compid,compname);
		  maxCDLine = maxCDLine + 1;
		}
	}
}

function addCBS() {
	var num = parseInt(document.all.cbscnttmp.value);
	var table = document.all.cbstable;
	var type = document.all.cbstypetmp;
	var compid = document.all.complectcbs;
	var compname = document.all.complectcbsname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  var categ = document.all.cbscategtmp;
			var cname = '';
			var cid='';
			for (var i3=0; i3 < categ.options.length; i3++) {
			  if (categ.options.item(i3).value == categ.value) {
				cname = categ.options.item(i3).text;
				cid =  categ.options.item(i3).value;
				break;
			  }
			}
		  add(table,type,maxCBSLine,cname,cid,'cbis',CBSResourcesList_arr,'delCBS',saveCBSIndex,'20','8',compid,compname);
		  maxCBSLine = maxCBSLine + 1;
		}
	}
}

function addCBP() {
	var num = parseInt(document.all.cbpcnttmp.value);
	var table = document.all.cbptable;
	var type = document.all.cbptypetmp;
	var compid = document.all.complectcbp;
	var compname = document.all.complectcbpname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  addmsu(table,type,maxCBPLine,'Источник питания',null,'cbip',CBPResourcesList_arr,'delCBP',saveCBPIndex,'20','8',compid,compname);
		  maxCBPLine = maxCBPLine + 1;
		}
	}
}

function addRPP() {
	var num = parseInt(document.all.rpcnttmp.value);
	var table = document.all.rptable;
	var type = document.all.rptypetmp;
	var compid = document.all.complectrp;
	var compname = document.all.complectrpname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  addmsu(table,type,maxRPLine,'Репитер',null,'rip',RPResourcesList_arr,'delRP',saveRPIndex,'20','8',compid,compname);
		  maxRPLine = maxRPLine + 1;
		}
	}
}

function addANN() {
	var num = parseInt(document.all.ancnttmp.value);
	var table = document.all.antable;
	var type = document.all.antypetmp;
	var compid = document.all.complectan;
	var compname = document.all.complectanname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
			add(table,type,maxANLine,'Антенна',null,'ain',ANResourcesList_arr,'delAN',saveANIndex,'20','8',compid,compname);
		    maxANLine = maxANLine + 1;
		}
	}
}

function addAFT() {
	var num = parseInt(document.all.aftcnttmp.value);
	var table = document.all.afttable;
	var type = document.all.afttypetmp;
	var compid = document.all.complectaft;
	var compname = document.all.complectaftname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  var categ = document.all.aftcategtmp;
			var cname = '';
			var cid='';
			for (var i3=0; i3 < categ.options.length; i3++) {
			  if (categ.options.item(i3).value == categ.value) {
				cname = categ.options.item(i3).text;
				cid =  categ.options.item(i3).value;
				break;
			  }
			}
		  addaft(table,type,maxAFTLine,cname,cid,'aif',AFTResourcesList_arr,'delAFT',saveAFTIndex,'20','8',compid,compname);
		  maxAFTLine = maxAFTLine + 1;
		}
	}
}

function addPRO() {
	var num = parseInt(document.all.procnttmp.value);
	var table = document.all.protable;
	var type = document.all.protypetmp;
	var compid = document.all.complectpro;
	var compname = document.all.complectproname;
	if(!isNaN(num)) {
		for (var i=0; i < num; i++){
		  addpro(table,type,maxPROLine,'prio','delPRO',savePROIndex,'20','9',compid,compname);
		  maxPROLine = maxPROLine + 1;
		}
	}
}

function refreshBA() {
	refresh('batypetmp','bacategtmp',bajs);
}

function refreshSO() {
	refresh('sotypetmp','socategtmp',sojs);
}

function refreshPO() {
	refresh('potypetmp','pocategtmp',pojs);
}

function refreshMU() {
	refresh('mutypetmp','mucategtmp',mujs);
}

function refreshCD() {
	refresh('cdtypetmp','cdcategtmp',cdjs);
}

function refreshCBS() {
	refresh('cbstypetmp','cbscategtmp',cbsjs);
}

function addmsu(table,type,bline,name,categid,groupname,tarr,delname,saveindex,size1,size2,complectid,complectname) {

		var newRow = table.insertRow();
		newRow.className = "print";
		newRow.onmouseover = saveindex;
		for (var i=0; i < 10; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
		var bsmodval = '';
		for (var i1=0; i1 < type.options.length; i1++) {
		  if (type.options.item(i1).value == type.value) {
			bsmodval = type.options.item(i1).text;
			break;
		  }
		}
		
		newRow.cells(0).innerHTML = bline+1;
		newRow.cells(1).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].categ" VALUE="' + categid + '">' +name;
		newRow.cells(2).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].type" VALUE="' + type.value + '"><INPUT TYPE=TEXT VALUE="' + bsmodval + '" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: DCDCDC;" READONLY>';
				
		var t = document.all[groupname + "["+bline+"].type"];		
		
		if ( (tarr[t.value] == 'b') || (tarr[t.value] == 'B') ) {

			newRow.cells(4).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].count.string" size="9" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		} else if ( (tarr[t.value] == 'p') || (tarr[t.value] == 'P') ) {

			newRow.cells(4).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].sn" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"><input type="checkbox" NAME="' + groupname + '[' + bline + '].fictionSerial">';
			newRow.cells(3).innerHTML = '&nbsp;';

		} else if ( (tarr[t.value] == 's') || (tarr[t.value] == 'S') ) {

			newRow.cells(4).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].sn" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"><input type="checkbox" NAME="' + groupname + '[' + bline + '].fictionSerial">';
			newRow.cells(3).innerHTML = '&nbsp;';

		} else {
			newRow.cells(4).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '&nbsp;';
		}
		newRow.cells(5).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].comment" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';	

		newRow.cells(6).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].note" size="'+size1+'" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		newRow.cells(7).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].roomnumber" size="'+size2+'" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		newRow.cells(8).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].complect" VALUE="' + complectid.value + '"><INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].complectname" VALUE="' + complectname.value + '" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; WIDTH: 126pt; background-color: DCDCDC;" READONLY>';

		newRow.cells(9).innerHTML = '<input type="image" src="/images/del.gif" onclick="'+delname+'();return false;" name="'+delname+'"/>';

		newRow.onmouseover=saveindex;		
		

}

function add(table,type,bline,name,categid,groupname,tarr,delname,saveindex,size1,size2,complectid,complectname) {

		var newRow = table.insertRow();
		newRow.className = "print";
		newRow.onmouseover = saveindex;
		for (var i=0; i < 9; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
		var bsmodval = '';
		for (var i1=0; i1 < type.options.length; i1++) {
		  if (type.options.item(i1).value == type.value) {
			bsmodval = type.options.item(i1).text;
			break;
		  }
		}
		
		newRow.cells(0).innerHTML = bline+1;
		newRow.cells(1).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].categ" VALUE="' + categid + '">' +name;
		newRow.cells(2).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].type" VALUE="' + type.value + '"><INPUT TYPE=TEXT VALUE="' + bsmodval + '" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: DCDCDC;" READONLY>';
				
		var t = document.all[groupname + "["+bline+"].type"];		
		
		if ( (tarr[t.value] == 'b') || (tarr[t.value] == 'B') ) {

			newRow.cells(4).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].count.string" size="9" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		} else if ( (tarr[t.value] == 'p') || (tarr[t.value] == 'P') ) {

			newRow.cells(4).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].sn" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"><input type="checkbox" NAME="' + groupname + '[' + bline + '].fictionSerial">';
			newRow.cells(3).innerHTML = '&nbsp;';

		} else if ( (tarr[t.value] == 's') || (tarr[t.value] == 'S') ) {

			newRow.cells(4).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].sn" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"><input type="checkbox" NAME="' + groupname + '[' + bline + '].fictionSerial">';
			newRow.cells(3).innerHTML = '&nbsp;';

		} else {
			newRow.cells(4).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '&nbsp;';
		}
			
		newRow.cells(5).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].note" size="'+size1+'" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		newRow.cells(6).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].roomnumber" size="'+size2+'" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		newRow.cells(7).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].complect" VALUE="' + complectid.value + '"><INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].complectname" VALUE="' + complectname.value + '" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; WIDTH: 126pt; background-color: DCDCDC;" READONLY>';

		newRow.cells(8).innerHTML = '<input type="image" src="/images/del.gif" onclick="'+delname+'();return false;" name="'+delname+'"/>';

		newRow.onmouseover=saveindex;		
		

}

function addaft(table,type,bline,name,categid,groupname,tarr,delname,saveindex,size1,size2,complectid,complectname) {

		var newRow = table.insertRow();
		newRow.className = "print";
		newRow.onmouseover = saveindex;
		for (var i=0; i < 9; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
		var bsmodval = '';
		for (var i1=0; i1 < type.options.length; i1++) {
		  if (type.options.item(i1).value == type.value) {
			bsmodval = type.options.item(i1).text;
			break;
		  }
		}
		
		newRow.cells(0).innerHTML = bline+1;
		newRow.cells(1).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].categ" VALUE="' + categid + '">' +name;

		newRow.cells(2).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].sector" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		newRow.cells(3).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].count.string" size="9" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		newRow.cells(4).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].type" VALUE="' + type.value + '"><INPUT TYPE=TEXT VALUE="' + bsmodval + '" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: DCDCDC;" READONLY>';
						

		newRow.cells(5).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].ksb" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';
		
		newRow.cells(6).innerHTML = '<SELECT NAME="' + groupname + '[' + bline + '].gsm" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"><OPTION VALUE="900">900</OPTION><OPTION VALUE="1800">1800</OPTION></SELECT>';
		

		newRow.cells(7).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].complect" VALUE="' + complectid.value + '"><INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].complectname" VALUE="' + complectname.value + '" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; WIDTH: 126pt; background-color: DCDCDC;" READONLY>';

		newRow.cells(8).innerHTML = '<input type="image" src="/images/del.gif" onclick="'+delname+'();return false;" name="'+delname+'"/>';

		newRow.onmouseover=saveindex;		
		

}

function addpro(table,type,bline,groupname,delname,saveindex,size1,size2,complectid,complectname) {

		var newRow = table.insertRow();
		newRow.className = "print";
		newRow.onmouseover = saveindex;
		for (var i=0; i < 9; i++) {
			var newCell = newRow.insertCell();
			newCell.className = "print";
		}
		var promodval = type.value;

		var prop = document.getElementById('propolicytmp');
				
		newRow.cells(0).innerHTML = bline+1;
		newRow.cells(1).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].categname" size="12" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: DCDCDC;" READONLY>';
		newRow.cells(2).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].typename" VALUE="' + promodval + '" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';
			
		if ( prop.value == 'Количественный') {

			newRow.cells(4).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].count.string" size="9" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		} else if ( prop.value == 'Серийный' ) {

			newRow.cells(4).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].sn" size="20" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;"><input type="checkbox" NAME="' + groupname + '[' + bline + '].fictionSerial">';
			newRow.cells(3).innerHTML = '&nbsp;';

		} else {
			newRow.cells(4).innerHTML = '&nbsp;';
			newRow.cells(3).innerHTML = '&nbsp;';
		}	

		newRow.cells(5).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].note" size="'+size1+'" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		newRow.cells(6).innerHTML = '<INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].roomnumber" size="'+size2+'" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; background-color: D6EBFF;">';

		newRow.cells(7).innerHTML = '<INPUT TYPE=HIDDEN NAME="' + groupname + '[' + bline + '].complect" VALUE="' + complectid.value + '"><INPUT TYPE=TEXT NAME="' + groupname + '[' + bline + '].complectname" VALUE="' + complectname.value + '" style="font-size:8pt; FONT-FAMILY: Verdana,Arial; WIDTH: 126pt; background-color: DCDCDC;" READONLY>';

		newRow.cells(8).innerHTML = '<input type="image" src="/images/del.gif" onclick="'+delname+'();return false;" name="'+delname+'"/>';

		newRow.onmouseover=saveindex;		
		

}

function floatLink(iX,iY,id){
		var L=dD.getElementById?dD.getElementById(id):dD.all?dD.all[id]:dD.layers[id];		
		this[id+'O']=L;if(dD.layers)L.style=L;L.nX=L.iX=iX;L.nY=L.iY=iY;
		L.P=function(x,y){
			this.style.left=x+px;this.style.top=y+px;};L.Fm=function(){
				var pX, pY;	
		pX=(this.iX >=0)?0:nn?innerWidth:nn&&dH.clientWidth?dH.clientWidth:dB.clientWidth;	
		pY=nn?pageYOffset:nn&&dH.scrollTop?dH.scrollTop:dB.scrollTop;	
		if(this.iY<0)pY+=nn?innerHeight:nn&&dH.clientHeight?dH.clientHeight:dB.clientHeight;	
		this.nX+=.1*(pX+this.iX-this.nX);this.nY+=.1*(pY+this.iY-this.nY);this.P(this.nX,this.nY);
		setTimeout(this.id+'O.Fm()',33);};
		return L;
}

</script>




