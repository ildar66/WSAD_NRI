/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.loadUnit("imagelistlite");domapi.registerComponent("speedbutton");var L8X=0;var m48=1;var YO81=2;var P9G75=3;domapi.Speedbutton=function(i2T25){return domapi.comps.speedbutton.constructor(i2T25)};domapi.comps.speedbutton.constructor=function(i2T25){var x3A00=domapi.Component(i2T25,"speedbutton");try{var p=domapi.mJ00.speedbutton;p.gD_KJ(x3A00,i2T25);domapi.addEvent(x3A00,"mouseout",p.C06);domapi.addEvent(x3A00,"mouseup",p.lh4);domapi.addEvent(x3A00,"mousedown",p.Sw_7);domapi.addEvent(x3A00,"mouseover",p.T3S);domapi.addEvent(x3A00,"mouseout",p.C06);if(!x3A00.enabled)x3A00.setEnabled(false);domapi.disallowSelect(x3A00);domapi.hl1(x3A00);domapi.mJ00.speedbutton._fI78(x3A00);return x3A00}finally{x3A00=null}};domapi.comps.speedbutton.Gk8HS=function(){this.gtMw=null;this.dropDown=null};domapi.comps.speedbutton.j0_Qg=function(b){domapi.css.addClass(this,"DA_SPEEDBUTTON_DISABLED",!b);if(this.gtMw)this.gtMw.setIndex(b?L8X:P9G75);this.disabled=!b};domapi.comps.speedbutton.setDown=function(b){if(b){if(this&&this.enabled&&this.doDepress){domapi.css.addClass(this,"DA_SPEEDBUTTON_DEPRESS");if(this.gtMw)this.gtMw.setIndex(YO81)}}else{domapi.mJ00.speedbutton._fI78(this);if(!this.down){if(this&&this.doDepress)domapi.css.removeClass(this,"DA_SPEEDBUTTON_DEPRESS");if(this.doRollover&&this.enabled&&this.gtMw)this.gtMw.setIndex(m48)}}};domapi.mJ00.speedbutton.gD_KJ=function(p,i2T25){try{if(!i2T25["src"])i2T25["imgW"]=0;if(i2T25["src"])p.gtMw=domapi.Imagelistlite({parent:p,src:i2T25["src"],w:domapi.rInt(i2T25["imgW"],16),h:domapi.rInt(i2T25["imgH"],16),orientation:i2T25["imgOrientation"]});if(domapi.isIE)if(p.gtMw)p.gtMw.align="middle";else p.style.lineHeight=domapi.rInt(i2T25["imgH"],16)+"px";p.title=i2T25["hint"];p.style.cursor="default";if(i2T25["text"]!=""){if(i2T25["orientation"]=="vertical")p.appendChild(document.createElement("BR"));var II9=document.createElement("SPAN");if(i2T25["orientation"]=="horizontal"&&!domapi.isNil(p.src))II9.style.paddingLeft="6px";II9.innerHTML=i2T25["text"];p.appendChild(II9)}if(i2T25["kind"]=="dropdown"){var _82W=document.createElement("SPAN");_82W.style.paddingLeft="3px";_82W.innerHTML=i2T25["dropdownArrow"];p.appendChild(_82W)}}finally{II9=null;_82W=null}};domapi.mJ00.speedbutton.uPJc=function(x3A00){var p=x3A00.parentNode;try{for(var a=0;a<p.childNodes.length;a++){var t=p.childNodes[a];if(t.DA_TYPE&&(t.DA_TYPE=="SPEEDBUTTON"))if(t.radioGroup==x3A00.radioGroup&&t.id!=x3A00.id){t.down=false;domapi.css.removeClass(t,"DA_SPEEDBUTTON_DEPRESS")}}}finally{p=null;t=null}};domapi.mJ00.speedbutton._fI78=function(x3A00){if(!x3A00.enabled)return;if(x3A00.radioGroup>0){domapi.mJ00.speedbutton.uPJc(x3A00);if(!x3A00.down)x3A00.down=true;else if(x3A00.doAllowAllUp)x3A00.down=false}};domapi.mJ00.speedbutton.T3S=function(E){var x3A00=domapi.findTarget(E,"SPEEDBUTTON");try{if(!x3A00||!x3A00.enabled||x3A00.f9f9)return;if(!x3A00.doRollover||x3A00.down)return;if(x3A00.gtMw)x3A00.gtMw.setIndex(m48);domapi.css.addClass(x3A00,"DA_HIGHLIGHT");x3A00.f9f9=true}finally{x3A00=null}};domapi.mJ00.speedbutton.C06=function(E){var x3A00=domapi.findTarget(E,"SPEEDBUTTON");try{if(!x3A00||!x3A00.enabled)return;if(x3A00.doDepress&&!x3A00.down)domapi.css.removeClass(x3A00,"DA_SPEEDBUTTON_DEPRESS");if(x3A00.gtMw)x3A00.gtMw.setIndex(L8X);if(x3A00.doRollover)domapi.css.removeClass(x3A00,"DA_HIGHLIGHT");x3A00.f9f9=false}finally{x3A00=null}};domapi.mJ00.speedbutton.Sw_7=function(E){var x3A00=domapi.findTarget(E,"SPEEDBUTTON");try{x3A00.setDown(true);if(x3A00.enabled&&x3A00.kind=="dropdown"&&x3A00.dropDown){var m=x3A00.dropDown;var p=domapi.mJ00.popupmenu;p.j44(m);p.w02=true;if(m.showing)m.hide();else{var a=domapi.getTrueOffset(x3A00);m.show(a[0],a[1]+x3A00.getH())}}}finally{x3A00=null;m=null;p=null}};domapi.mJ00.speedbutton.lh4=function(E){var x3A00=domapi.findTarget(E,"SPEEDBUTTON");if(x3A00&&x3A00.enabled)x3A00.setDown(false);x3A00=null};