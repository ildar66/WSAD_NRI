/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.registerComponent("viewbar");domapi.comps.viewbar.l64n="/";domapi.Viewbar=function(i2T25){return domapi.comps.viewbar.constructor(i2T25)};domapi.comps.viewbar.constructor=function(i2T25){var x3A00=domapi.Component(i2T25,"viewbar");try{x3A00.selected=null;x3A00.selectedGroup=null;x3A00.onchange=function(){};x3A00.onbeforechange=function(){return true};x3A00.setOverflow("auto");x3A00.groups=[];x3A00.groups.parentNode=x3A00;x3A00.groups.add=domapi.mJ00.viewbar.T7h;domapi.disallowSelect(x3A00);x3A00.ondrawitem=function(_8xC){};domapi.hl1(x3A00);x3A00.setValue("");return x3A00}finally{x3A00=null}};domapi.comps.viewbar.Gk8HS=function(){var i,k$Vu;for(i=0;i<this.groups.length;i++){for(k$Vu=0;k$Vu<this.groups[i].childNodes.length;k$Vu++)this.groups[i].childNodes[k$Vu].m2rC=null;this.groups[i].add=null;this.groups[i].collapse=null;this.groups[i].expand=null}this.selected=null;this.selectedGroup=null;this.onchange=null;this.onbeforechange=null;this.groups.parentNode=null;this.groups.add=null;this.groups=[];this.groups=null;this.ondrawitem=null};domapi.comps.viewbar.Q43hR=function(){this.Y750()};domapi.comps.viewbar.Y750=function(){var t=domapi.theme;var __4=t.fonts;var s=this.style;try{this.setB(t.border.width);s.borderStyle=this.doBorder?t.border.solid:"none";this.setBgColor(this.doBGFill?__4.window.bgcolor:"transparent");s.borderColor=t.border.getInset();s.font=__4.window.asString();for(var a=0;a<this.groups.length;a++)this.drawGroup(this.groups[a])}finally{t=null;__4=null;s=null}};domapi.comps.viewbar.drawGroup=function(k1_1){for(var a=0;a<k1_1.childNodes.length;a++)this.drawItem(k1_1.childNodes[a])};domapi.comps.viewbar.drawItem=function(_8xC){var t=domapi.theme;var __4=t.fonts;var s=_8xC.style;try{if(_8xC.isHeader)_8xC.className="DA_BUTTONFACE DA_VIEWBAR_HEADER";else if(_8xC.selected&&this.doShowSelection)_8xC.className="DA_VIEWBAR_ITEM DA_SELECTION";else _8xC.className="DA_VIEWBAR_ITEM";this.ondrawitem(_8xC)}finally{t=null;__4=null;s=null}};domapi.comps.viewbar.selectItem=function(_8xC){if(!this.onbeforechange(_8xC))return false;this.selected=_8xC;this.selectedGroup=_8xC.parentNode;var k1_1=this.groups;try{for(var b=0;b<k1_1.length;b++)for(var a=0;a<k1_1[b].childNodes.length;a++)if(k1_1[b].childNodes[a].selected){k1_1[b].childNodes[a].selected=false;this.drawItem(k1_1[b].childNodes[a])}_8xC.selected=true;if(_8xC.m2rC){if(typeof _8xC.m2rC=="function")_8xC.m2rC(_8xC);else eval(_8xC.m2rC)}this.drawItem(_8xC);this.setFormValue();this.onchange()}finally{k1_1=null}};domapi.comps.viewbar.deleteGroup=function(i){var _8xC=this.groups[i];try{if(!_8xC)return;_8xC.removeNode(true);this.groups.deleteItem(i)}finally{_8xC=null}};domapi.comps.viewbar.setExclusive=function(b){this.exclusive=b;if(b&&this.selectedGroup){for(var a=0;a<this.groups.length;a++)if(this.groups[a]!=this.selectedGroup)this.groups[a].collapse()}};domapi.comps.viewbar.onmouseover=function(x3A00){if(!this.doRollover||!this.enabled)return;var _8xC=domapi.findTarget(x3A00,"VIEWBARITEM");try{if(!_8xC||(_8xC.selected&&this.doShowSelection)||_8xC.isHeader)return;_8xC.className="DA_VIEWBAR_ITEM DA_HIGHLIGHT";this.ondrawitem(_8xC)}finally{_8xC=null}};domapi.comps.viewbar.onmouseout=function(x3A00){if(!this.doRollover||!this.enabled)return;var _8xC=domapi.findTarget(x3A00,"VIEWBARITEM");try{if(_8xC)this.drawItem(_8xC)}finally{_8xC=null}};domapi.comps.viewbar.onmousedown=function(x3A00){if(!this.enabled)return;var _8xC=domapi.findTarget(x3A00,"VIEWBARITEM");try{if(_8xC&&this.doDepress)_8xC.className="DA_VIEWBAR_ITEM DA_VIEWBAR_DEPRESS"+(_8xC.isHeader?"_H":"")}finally{_8xC=null}};domapi.comps.viewbar.onmouseup=function(x3A00){if(!this.enabled)return;var _8xC=domapi.findTarget(x3A00,"VIEWBARITEM");try{if(!_8xC)return;var k1_1=_8xC.parentNode;if(!_8xC.isHeader)this.selectItem(_8xC);else{if(k1_1.isCollapsed)k1_1.expand();else k1_1.collapse()}this.drawItem(_8xC)}finally{_8xC=null;k1_1=null}};domapi.comps.viewbar.setFormValue=function(){var t="";var s=this.selected;try{if(!s)return;var r=s.value;if(!r)r=s.innerHTML;r=domapi.findParent(s,"VIEWBARGROUP").value+domapi.comps.viewbar.l64n+r;domapi.RB78_(this.O$n,r)}finally{s=null}};domapi.mJ00.viewbar.T7h=function(i2T25){var k1_1=document.createElement("DIV");try{k1_1.id=this.parentNode.id+"_GROUP_"+this.parentNode.childNodes.length;k1_1.DA_TYPE="VIEWBARGROUP";k1_1.value=domapi.rVal(i2T25["value"],i2T25["text"]);var s=k1_1.style;s.margin="0px";s.listStyle="none";s.overflow="hidden";if(domapi.isGecko)s.paddingLeft="0px";this[this.length]=k1_1;this.parentNode.appendChild(k1_1);var t=domapi.mJ00.viewbar;k1_1.add=t.MA181;k1_1.collapse=t.FRWY;k1_1.expand=t.S75;k1_1.isCollapsed=true;k1_1.add({text:i2T25["text"],isHeader:true});this.parentNode.ondrawitem(this[this.length-1]);return this[this.length-1]}finally{s=null;k1_1=null;t=null}};domapi.mJ00.viewbar.MA181=function(i2T25){var x3A00=document.createElement("DIV");try{x3A00.id=this.id+"_"+this.childNodes.length;x3A00.DA_TYPE="VIEWBARITEM";x3A00.innerHTML=domapi.rVal(i2T25["value"],i2T25["text"]);x3A00.value=i2T25["value"];x3A00.m2rC=i2T25["onselect"];x3A00.isHeader=i2T25["isHeader"];x3A00.selected=false;var t=x3A00.style;t.position="relative";if(!x3A00.isHeader){t.display="none";t.cursor="default"}this.appendChild(x3A00);this.parentNode.drawItem(x3A00);return x3A00}finally{t=null;x3A00=null}};domapi.mJ00.viewbar.FRWY=function(){var p=this.parentNode;var c=this.childNodes;try{if(!c)return;this.isCollapsed=true;for(var a=1;a<c.length;a++)c[a].style.display="none";if(p.oncollapse)p.oncollapse(this);if(this.oncollapse)this.oncollapse()}finally{p=null;c=null}};domapi.mJ00.viewbar.S75=function(){var p=this.parentNode;var c=this.childNodes;try{if(p.exclusive)for(var a=0;a<p.groups.length;a++)p.groups[a].collapse();this.isCollapsed=false;for(a=1;a<c.length;a++)c[a].style.display="block";if(p.onexpand)p.onexpand(this);if(this.onexpand)this.onexpand()}finally{p=null;c=null}};