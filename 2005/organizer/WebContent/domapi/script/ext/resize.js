/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.loadUnit("selection");domapi.loadUnit("drag");domapi.loadUnit("groups");domapi.resize=new Object();domapi.resize.on=function(group){if(group){domapi.groups.callFunction(group,"resizeOn()")}else{this.resizeStatus=true}var r=domapi.resize.H7W43;domapi.regHook('setX',r);domapi.regHook('setX',r);domapi.regHook('setY',r);domapi.regHook('setY',r);domapi.regHook('setW',r);domapi.regHook('setH',r);domapi.regHook('moveTo',r);domapi.regHook('dragEnd',r)};domapi.resize.off=function(group){if(group){domapi.groups.callFunction(group,"resizeOff()")}else{domapi.resize.f92(this);this.resizeStatus=false}domapi.elmProto.unRegHook('setX',domapi.resize.H7W43);domapi.elmProto.unRegHook('setX',domapi.resize.H7W43);domapi.elmProto.unRegHook('setY',domapi.resize.H7W43);domapi.elmProto.unRegHook('setY',domapi.resize.H7W43);domapi.elmProto.unRegHook('setW',domapi.resize.H7W43);domapi.elmProto.unRegHook('setH',domapi.resize.H7W43);domapi.elmProto.unRegHook('moveTo',domapi.resize.H7W43);domapi.elmProto.unRegHook('dragEnd',domapi.resize.H7W43)};domapi.resize._1o=function(x3A00){x3A00.resize=new Object();var pnLiO=x3A00.resize;var w$3=domapi.selection.controls;pnLiO.tV8=x3A00.getX();pnLiO.pk6=x3A00.getY();pnLiO.d63L=x3A00.getW();pnLiO.wlNE6=x3A00.getH();pnLiO.minX=0;pnLiO.minY=0;pnLiO.minH=(w$3.bv8<w$3.size)?(w$3.size*2)-(w$3.bv8*2):1;pnLiO.minW=(w$3.bv8<w$3.size)?(w$3.size*2)-(w$3.bv8*2):1;pnLiO.maxX=(x3A00.parentNode==document.body)?domapi.bodyWidth():x3A00.parentNode.getW();pnLiO.maxY=(x3A00.parentNode==document.body)?domapi.bodyHeight():x3A00.parentNode.getH();var c=x3A00.selection.controls;l=domapi.selection.Gj3P1;for(var i=0;i<8;i++){if(c[i])c[i].turnOnDrag(null,domapi.drag.dtCustom,0,null,domapi.resize["_moveControl"+l[i].charAt(0).toUpperCase()+l[i].substr(1)],domapi.resize.H7W43)}x3A00.resizeStatus="go"};domapi.resize.f92=function(x3A00){if(!x3A00.resizeStatus)return;var c=x3A00.selection.controls;l=domapi.selection.Gj3P1;for(var i=0;i<8;i++){if(c[i])c[i].turnOffDrag()}x3A00.resizeStatus=true;x3A00.resize=null};domapi.resize.H7W43=function(x3A00){var parent=(!x3A00)?this.elm.parent:x3A00;if((!parent.resizeStatus)||(!parent.resize)||(parent.resizeStatus=='go'))return;var pX5d=parent.resize;pX5d.tV8=parent.getX();pX5d.pk6=parent.getY();pX5d.d63L=parent.getW();pX5d.wlNE6=parent.getH();if(parent.reflowStatus)domapi.reflow._ko(parent);parent.resizeStatus=true};domapi.resize.$_3j=function(x,y,dX,dY){var parent=this.elm.parent;var pX5d=parent.resize;parent.resizeStatus="go";if(pX5d.tV8+dX<=pX5d.minX){dX=pX5d.minX-pX5d.tV8}else if(pX5d.tV8+dX>=pX5d.tV8+pX5d.d63L-pX5d.minW){dX=pX5d.d63L-pX5d.minW}if(pX5d.pk6+dY<=pX5d.minY){dY=pX5d.minY-pX5d.pk6}else if(pX5d.pk6+dY>=pX5d.pk6+pX5d.wlNE6-pX5d.minH){dY=pX5d.wlNE6-pX5d.minH}var x=pX5d.tV8+dX;var w=pX5d.d63L-dX;var y=pX5d.pk6+dY;var h=pX5d.wlNE6-dY;parent.setX(x);parent.setW(w);parent.setY(y);parent.setH(h);parent.resizeStatus=true};domapi.resize.pq5=function(x,y,dX,dY){var parent=this.elm.parent;var pX5d=parent.resize;parent.resizeStatus="go";if(pX5d.tV8+dX<=pX5d.minX){dX=pX5d.minX-pX5d.tV8}else if(pX5d.tV8+dX>=pX5d.tV8+pX5d.d63L-pX5d.minW){dX=pX5d.d63L-pX5d.minW}var x=pX5d.tV8+dX;var w=pX5d.d63L-dX;parent.setX(x);parent.setW(w);parent.resizeStatus=true};domapi.resize.f88N=function(x,y,dX,dY){var parent=this.elm.parent;var pX5d=parent.resize;parent.resizeStatus="go";if(pX5d.tV8+dX<=pX5d.minX){dX=pX5d.minX-pX5d.tV8}else if(pX5d.tV8+dX>=pX5d.tV8+pX5d.d63L-pX5d.minW){dX=pX5d.d63L-pX5d.minW}if(pX5d.wlNE6+dY<=pX5d.minH){dY=0-pX5d.wlNE6+pX5d.minH}else if(pX5d.pk6+dY+pX5d.wlNE6>=pX5d.maxY){dY=pX5d.maxY-(pX5d.pk6+pX5d.wlNE6)}var h=pX5d.wlNE6+dY;var x=pX5d.tV8+dX;var w=pX5d.d63L-dX;parent.setX(x);parent.setW(w);parent.setH(h);parent.resizeStatus=true};domapi.resize.G95=function(x,y,dX,dY){var parent=this.elm.parent;var pX5d=parent.resize;parent.resizeStatus="go";if(pX5d.pk6+dY<=pX5d.minY){dY=pX5d.minY-pX5d.pk6}else if(pX5d.pk6+dY>=pX5d.pk6+pX5d.wlNE6-pX5d.minH){dY=pX5d.wlNE6-pX5d.minH}var y=pX5d.pk6+dY;var h=pX5d.wlNE6-dY;parent.setY(y);parent.setH(h);parent.resizeStatus=true};domapi.resize._k5_=function(x,y,dX,dY){var parent=this.elm.parent;var pX5d=parent.resize;parent.resizeStatus="go";if(pX5d.wlNE6+dY<=pX5d.minH){dY=0-pX5d.wlNE6+pX5d.minH}else if(pX5d.pk6+dY+pX5d.wlNE6>=pX5d.maxY){dY=pX5d.maxY-(pX5d.pk6+pX5d.wlNE6)}var h=pX5d.wlNE6+dY;parent.setH(h);parent.resizeStatus=true};domapi.resize.w31=function(x,y,dX,dY){var parent=this.elm.parent;var pX5d=parent.resize;parent.resizeStatus="go";if(pX5d.tV8+pX5d.d63L+dX>=pX5d.maxX){dX=pX5d.maxX-pX5d.tV8-pX5d.d63L}else if(dX<(0-pX5d.d63L+pX5d.minW)){dX=0-pX5d.d63L+pX5d.minH}if(pX5d.pk6+dY<=pX5d.minY){dY=pX5d.minY-pX5d.pk6}else if(pX5d.pk6+dY>=pX5d.pk6+pX5d.wlNE6-pX5d.minH){dY=pX5d.wlNE6-pX5d.minH}var y=pX5d.pk6+dY;var w=pX5d.d63L+dX;var h=pX5d.wlNE6-dY;parent.setW(w);parent.setY(y);parent.setH(h);parent.resizeStatus=true};domapi.resize.Ts97M=function(x,y,dX,dY){var parent=this.elm.parent;var pX5d=parent.resize;parent.resizeStatus="go";if(pX5d.tV8+pX5d.d63L+dX>=pX5d.maxX){dX=pX5d.maxX-pX5d.tV8-pX5d.d63L}else if(dX<(0-pX5d.d63L+pX5d.minW)){dX=0-pX5d.d63L+pX5d.minW}var w=pX5d.d63L+dX;parent.setW(w);parent.resizeStatus=true};domapi.resize.GH_R4=function(x,y,dX,dY){var parent=this.elm.parent;var pX5d=parent.resize;parent.resizeStatus="go";if(pX5d.tV8+pX5d.d63L+dX>=pX5d.maxX){dX=pX5d.maxX-pX5d.tV8-pX5d.d63L}else if(dX<(0-pX5d.d63L+pX5d.minW)){dX=0-pX5d.d63L+pX5d.minW}if(pX5d.wlNE6+dY<=pX5d.minH){dY=0-pX5d.wlNE6+pX5d.minH}else if(pX5d.pk6+dY+pX5d.wlNE6>=pX5d.maxY){dY=pX5d.maxY-(pX5d.pk6+pX5d.wlNE6)}var h=pX5d.wlNE6+dY;var w=pX5d.d63L+dX;parent.setW(w);parent.setH(h);parent.resizeStatus=true};domapi.elmProto.resizeOn=domapi.resize.on;domapi.elmProto.resizeOff=domapi.resize.off;domapi.elmProto.resizeStatus=false;