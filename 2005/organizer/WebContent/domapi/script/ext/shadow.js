/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.shadow={};domapi.useElmHooks=true;domapi.shadow.dropShadow=function(x3A00,_8xC){var i,r;_8xC=domapi.rInt(_8xC,3);if(typeof x3A00.getZ!="function"){x3A00.getZ=domapi.elmProto.getZ;x3A00.getW=domapi.elmProto.getW;x3A00.getH=domapi.elmProto.getH;x3A00.getX=domapi.elmProto.getX;x3A00.getY=domapi.elmProto.getY;x3A00._WqR=domapi.elmProto._WqR;x3A00.setZ=function(_5P){this.TGY.setZ(_5P-1)}}x3A00.doShadow=true;if(!x3A00.TGY){x3A00.TGY=domapi.Elm({type:(domapi.isIE?"DIV":"IMG"),parent:x3A00.parentNode,x:0,y:0,w:10,h:10,doIframeShield:true});if(domapi.isIE)x3A00.TGY.runtimeStyle.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+domapi.theme.skin.shadow.src+"',sizingMethod='scale')";else x3A00.TGY.src=domapi.theme.skin.shadow.src}x3A00.TGY.size=_8xC;x3A00.regHook("setX",domapi.shadow.U9x9r);x3A00.regHook("setY",domapi.shadow.U9x9r);x3A00.regHook("setW",domapi.shadow.U9x9r);x3A00.regHook("setH",domapi.shadow.U9x9r);x3A00.regHook("hide",domapi.shadow.n$12);x3A00.regHook("show",domapi.shadow.EcSG);x3A00.regHook("setZ",domapi.shadow.FB2);domapi.shadow.U9x9r(x3A00)};domapi.shadow.freeShadow=function(x3A00){if(typeof x3A00.getB!="function"){x3A00.getZ=null;x3A00.getW=null;x3A00.getH=null;x3A00.getX=null;x3A00.getY=null;x3A00._WqR=null;x3A00.setZ=null}x3A00.unRegHook("setX",domapi.shadow.U9x9r);x3A00.unRegHook("setY",domapi.shadow.U9x9r);x3A00.unRegHook("setW",domapi.shadow.U9x9r);x3A00.unRegHook("setH",domapi.shadow.U9x9r);x3A00.unRegHook("hide",domapi.shadow.n$12);x3A00.unRegHook("show",domapi.shadow.EcSG);x3A00.unRegHook("setZ",domapi.shadow.FB2);x3A00.TGY=null};domapi.shadow.U9x9r=function(x3A00){if(!domapi.rBool(x3A00.doShadow,true)||!x3A00.TGY)return;var _5P=x3A00.getZ()-1;if(_5P<0)_5P=0;x3A00.TGY.setZ(_5P);x3A00.TGY.sizeToElm(x3A00);x3A00.TGY.moveTo(x3A00.getX()+x3A00.TGY.size,x3A00.getY()+x3A00.TGY.size)};domapi.shadow.n$12=function(x3A00){x3A00.TGY.style.display="none"};domapi.shadow.EcSG=function(x3A00){x3A00.TGY.style.display="inline"};domapi.shadow.FB2=function(x3A00,i2T25){x3A00.TGY.setZ(i2T25[0]-1)};