/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.loadUnit("rollover");domapi.registerComponent("sidebar");domapi.Sidebar=function(i2T25){return domapi.comps.sidebar.constructor(i2T25)};domapi.comps.sidebar.constructor=function(i2T25){var x3A00=domapi.Component(i2T25,"sidebar");try{x3A00.panels=x3A00.childNodes;var p=domapi.mJ00.sidebar;domapi.addEvent(x3A00,"click",p.O7356);domapi.addEvent(x3A00,"dblclick",p.j0XkM);domapi.disallowSelect(x3A00);domapi.hl1(x3A00);if(!x3A00.enabled)x3A00.setEnabled(false);return x3A00}finally{x3A00=null}};domapi.comps.sidebar.Gk8HS=function(){for(var i=0;i<this.panels.length;i++){this.panels[i].rollover=null;this.panels[i].hMD=null;this.panels[i].body=null;this.panels[i].caption=null}this.panels=null};domapi.comps.sidebar.Q43hR=function(){this.b2$6()};domapi.comps.sidebar.b2$6=function(){var t=domapi.theme;var __4=t.fonts;var s=this.style;var b=this.doBorder?t.border.width:0;try{this.setB(b);s.borderStyle=this.doBorder?"groove":"none";s.overflow="auto"}finally{s=null;t=null;__4=null}};domapi.comps.sidebar.MR9=function(w,h){};domapi.comps.sidebar.addPanel=function(i2T25){var skin=domapi.theme.skin;try{domapi.VQ7(i2T25,"caption","Panel "+(this.panels.length+1));domapi.VQ7(i2T25,"enabled",true);domapi.VQ7(i2T25,"opened",true);domapi.VQ7(i2T25,"doAllowClosing",true);var panel=document.createElement("DIV");var quOm1=document.createElement("DIV");var p9Bu=document.createElement("DIV");panel .DA_TYPE="SIDEBAR_PANEL";p9Bu .DA_TYPE="SIDEBAR_PANEL_BODY";panel .className="DA_SIDEBAR_PANEL";quOm1.className="DA_SIDEBAR_PANELHEADER";p9Bu .className="DA_SIDEBAR_PANELBODY";panel .enabled=i2T25["enabled"];panel .opened=i2T25["opened"];quOm1.innerHTML='<div><table border="0" cellpadding="0" cellspacing="0"><tr><td width="100%">'+i2T25["caption"]+'</td><td align="right"></td></tr></table></div>';panel.rollover=domapi.Rollover({parent:quOm1.getElementsByTagName("TD")[1],w:skin.metrics.sidebar.Vg04Y,h:skin.metrics.sidebar.kE8,src:skin.sidebarClose.src,A47e:4});panel.rollover.style.padding="0px";panel.rollover.onclick=domapi.mJ00.sidebar._3co;if(!this.doAllowClosing||!i2T25["doAllowClosing"])panel.rollover.style.display="none";if(i2T25["element"])domapi.transferElm(i2T25["element"],p9Bu);panel.appendChild(quOm1);panel.appendChild(p9Bu);this.appendChild(panel);panel.hMD=panel.childNodes[0];panel.body=panel.childNodes[1];panel.caption=quOm1.getElementsByTagName("TD")[0];if((!this.doAllowAllOpen&&this.panels.length>1)||!panel.opened)this.closePanel(this.panels.length-1);if(!panel.enabled||!this.enabled)this.setEnabled(false,this.panels.length-1);return panel}finally{skin=null;panel=null;quOm1=null;p9Bu=null}};domapi.comps.sidebar.openPanel=function(i){var panel=this.panels[i];try{if(!panel)return;panel.opened=true;panel.rollover.setSrc(domapi.theme.skin.sidebarClose.src);panel.body.style.display="";if(!this.doAllowAllOpen)for(var k$Vu=0;k$Vu<this.panels.length;k$Vu++)if(i!=k$Vu)this.closePanel(k$Vu);if(!this.enabled||!panel.enabled){panel.rollover.setEnabled(true);panel.rollover.setEnabled(false)}}finally{panel=null}};domapi.comps.sidebar.closePanel=function(i){var panel=this.panels[i];try{if(!panel)return;panel.opened=false;panel.rollover.setSrc(domapi.theme.skin.sidebarOpen.src);panel.body.style.display="none";if(!this.enabled||!panel.enabled){panel.rollover.setEnabled(true);panel.rollover.setEnabled(false)}}finally{panel=null}};domapi.comps.sidebar.setEnabled=function(b,i){var k$Vu;var p=this.panels;try{if(arguments.length==1)i=-1;for(k$Vu=0;k$Vu<p.length;k$Vu++){if(i==k$Vu||i==-1){p[k$Vu].enabled=b;p[k$Vu].caption.disabled=!b;p[k$Vu].rollover.setEnabled(b);domapi.css.addClass(p[k$Vu],"DA_SIDEBAR_DISABLED",!b)}}if(i==-1)this.enabled=b}finally{p=null}};domapi.mJ00.sidebar._3co=function(E){var r=domapi.findTarget(E,"SIDEBAR");var x3A00=domapi.findTarget(E,"SIDEBAR_PANEL");var i=domapi.getNodeIndex(x3A00);try{if(!x3A00||!r||!x3A00.enabled||!r.enabled)return;if(x3A00.opened)r.closePanel(i);else r.openPanel(i)}finally{r=null;x3A00=null}};domapi.mJ00.sidebar.O7356=function(E){var r=domapi.findTarget(E,"SIDEBAR");var R=domapi.findTarget(E,"ROLLOVER");var b=domapi.findTarget(E,"SIDEBAR_PANEL_BODY");var x3A00=domapi.findTarget(E,"SIDEBAR_PANEL");try{var i=domapi.getNodeIndex(x3A00);if(!x3A00||!r||!x3A00.enabled||!r.enabled||b||R||!r.doAllowHeaderClick)return;if(x3A00.opened)r.closePanel(i);else r.openPanel(i)}finally{r=null;R=null;b=null;x3A00=null}};domapi.mJ00.sidebar.j0XkM=function(E){var r=domapi.findTarget(E,"SIDEBAR");var R=domapi.findTarget(E,"ROLLOVER");var b=domapi.findTarget(E,"SIDEBAR_PANEL_BODY");var x3A00=domapi.findTarget(E,"SIDEBAR_PANEL");try{var i=domapi.getNodeIndex(x3A00);if(!x3A00||!r||!x3A00.enabled||!r.enabled||b||R||!r.doAllowHeaderDoubleClick)return;if(x3A00.opened)r.closePanel(i);else r.openPanel(i)}finally{r=null;R=null;b=null;x3A00=null}};