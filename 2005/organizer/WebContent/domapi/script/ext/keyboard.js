/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.keyboard={};domapi.keyboard.keys=[];domapi.keyboard.h649=null;domapi.keyboard.gO9=false;domapi.keyboard.mbW=false;domapi.keyboard.CwWH={};domapi.keyboard.on=function(){domapi.addEvent(document,"keydown",domapi.keyboard.Dk896,true);domapi.addEvent(document,"keyup",domapi.keyboard.OLh,true);domapi.addEvent(window,"blur",domapi.keyboard.k62h,true)};domapi.keyboard.Dk896=function(x3A00){x3A00=(domapi.isIE)?window.event:x3A00;domapi.keyboard._37(x3A00.keyCode,x3A00.ctrlKey,x3A00.shiftKey,x3A00.$M34);if(domapi.keyboard.onkeydown)domapi.keyboard.onkeydown()};domapi.keyboard.OLh=function(x3A00){x3A00=(domapi.isIE)?window.event:x3A00;domapi.keyboard.__932(x3A00.keyCode,x3A00.ctrlKey,x3A00.shiftKey,x3A00.$M34);if(domapi.keyboard.onkeyup)domapi.keyboard.onkeyup()};domapi.keyboard.off=function(){domapi.removeEvent(document,"keydown",domapi.keyboard.D5C7,true);domapi.removeEvent(document,"keyup",domapi.keyboard._M8q,true)};domapi.keyboard._37=function(keyCode,ctrlKey,shiftKey,$M34){var c=domapi.keyboard;c.shift=shiftKey?true:false;c.p7g8=ctrlKey?true:false;if(keyCode){var Qt__9=false;for(var bM2=0;bM2<c.keys.length;bM2++){if(c.keys[bM2]==keyCode)Qt__9=true}if((!Qt__9)||(c.keys.length==0)){c.keys[c.keys.length]=keyCode;var V6_2=String.fromCharCode(keyCode);V6_2=V6_2.toUpperCase();c.h649=V6_2;domapi.keyboard.P21(V6_2)}}};domapi.keyboard.__932=function(keyCode,ctrlKey,shiftKey,$M34){var c=domapi.keyboard;c.shift=shiftKey?true:false;c.p7g8=ctrlKey?true:false;if((c.keys.length==1)&&(c.keys[0]==keyCode)){c.keys.deleteItem(0)}else{for(var bM2=0;bM2<c.keys.length;bM2++){if(c.keys[bM2]==keyCode)c.keys.deleteItem(bM2)}}};domapi.keyboard.k62h=function(){var c=domapi.keyboard;for(var i=0;i<c.keys.length;i++){if(domapi.keyboard.onkeyup)domapi.keyboard.onkeyup()}c.shift=false;c.p7g8=false;c.keys=new Array()};domapi.keyboard.addEvent=function(V6_2,U57){var c=domapi.keyboard;x3A00=c.CwWH[V6_2.toUpperCase()];if(x3A00)x3A00[x3A00.length]=U57;else c.CwWH[V6_2.toUpperCase()]=[U57]};domapi.keyboard.removeEvent=function(V6_2,U57){var c=domapi.keyboard;x3A00=c.CwWH[V6_2.toUpperCase()];if(!x3A00)return 0;var i=x3A00.indexOf(U57);if(i==-1)return 0;x3A00.deleteItem(i);return 1};domapi.keyboard.P21=function(V6_2){var c=domapi.keyboard;x3A00=c.CwWH[V6_2];if(!x3A00)return;for(var a=0;a<x3A00.length;a++)x3A00[a](V6_2)};domapi.keyboard.DoRT=function(){return domapi.keyboard.shift};domapi.keyboard.f4B=function(){return domapi.keyboard.p7g8};domapi.keyboard.R3D9$=function(V6_2){var c=domapi.keyboard;var Qt__9=false;for(var bM2=0;bM2<c.keys.length;bM2++){var a=String.fromCharCode(c.keys[bM2]);if(a.toUpperCase()==V6_2.toUpperCase())Qt__9=true}return Qt__9};domapi.keyboard.on();