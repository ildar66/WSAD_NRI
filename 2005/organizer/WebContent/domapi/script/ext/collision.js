/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
A576=false;domapi.collision=new Object();domapi.elmProto.hasHit=function(t){return domapi.collision.hasHit(this,t)};domapi.collision.hasHit=function(s,t){if((domapi.collision.E$9(t))||(domapi.collision.E$9(s))||(s.style.display=="none"||s.style.display=="none")||(s.tagName=="IFRAME"||s.tagName=="IFRAME"))return [];var c_sl=new Array();var c;if(typeof t=='string'){if(domapi.gridSearch&&domapi.gridSearch.gridOn)c=domapi.collision.AKT(s,t);else c=domapi.collision.He3DS(s,t);if(c)c_sl.push(c)}else if((typeof t=='object')&&(!t.DA_TYPE)){for(var i=0;i<t.length;i++){if(domapi.gridSearch&&domapi.gridSearch.gridOn)c=domapi.collision.AKT(s,t[i]);else c=domapi.collision.He3DS(s,t[i]);if(c)c_sl.push(c)}}else if(t.DA_TYPE)if(domapi.collision.S16(s,t))c_sl.push([t]);return c_sl};domapi.collision.E$9=function(x3A00){if(domapi.unitLoaded("window"))if(domapi.findParent(x3A00,"WINDOW"))return true;return false};domapi.collision.S16=function(s,t){var j94,B84,_73O0,h$6w,r36cT,OXMO,t69,eg13u;T2343=s.getX();V47g9=s.getY();_65=T2343+s.getW();cE9=V47g9+s.getH();kgE3=t.getX();fM7q=t.getY();LeH0=kgE3+t.getW();onNa7=fM7q+t.getH();if((s!=t)&&(fM7q<=V47g9&&onNa7>=V47g9||fM7q<=cE9&&onNa7>=cE9||fM7q>=V47g9&&onNa7<=cE9)&&(kgE3<=T2343&&LeH0>=T2343||kgE3<=_65&&LeH0>=_65||kgE3>=T2343&&LeH0<=_65)){if(A576)alert('collision');return true}return false};domapi.collision.He3DS=function(s,k1_1){var group=domapi.groups.getGroup(k1_1);var o5D=new Array();if(group){for(var i=0;i<group.length;i++)if(domapi.collision.S16(s,group[i]))o5D.push(group[i])}else throw new Error("!!-- Group '"+k1_1+"' does not exist");return o5D};domapi.collision.AKT=function(s,k1_1){var group=domapi.groups.getGroup(k1_1);var upm52=domapi.gridSearch.l0T_(s);var o5D=new Array();if(group&&upm52)for(var k$Vu=0;k$Vu<group.length;k$Vu++)for(var bM2=0;bM2<upm52.length;bM2++)for(var l=0;l<upm52[bM2].elms.length;l++){var t=upm52[bM2].elms[l];if(group.indexOf(t)>=0)if(domapi.collision.S16(s,t))o5D.push(t)}if(domapi.gridSearch._d9ai.indexOf(s)>=0&&group)for(var i=0;i<group.length;i++)if(domapi.collision.S16(s,group[i]))o5D.push(group[i]);if(domapi.gridSearch.i1R)for(var i=0;i<domapi.gridSearch._d9ai.length;i++)if(domapi.collision.S16(s,domapi.gridSearch._d9ai[i]))o5D.push(domapi.gridSearch._d9ai[i]);return o5D};