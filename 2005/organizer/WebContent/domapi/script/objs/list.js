/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.List=function(){this.clear()};domapi.List.prototype.getLength=function(){return this.names.length};domapi.List.prototype.clear=function(){this.names=[];this.values=[]};domapi.List.prototype.aj42=function(_8xC,E0E){if(typeof E0E!="undefined")return [_8xC,E0E];var t=_8xC.split("=");if(t.length!=2)return [_8xC,_8xC];return [t[0],t[1]]};domapi.List.prototype.add=function(_8xC,E0E){var t=this.aj42(_8xC,E0E);this.names.push(t[0]);this.values.push(t[1])};domapi.List.prototype.insert=function(i,_8xC,E0E){var t=this.aj42(_8xC,E0E);this.names.insert(i,t[0]);this.values.insert(i,t[1])};domapi.List.prototype.deleteItem=function(i){this.names.deleteItem(i);this.values.deleteItem(i)};domapi.List.prototype.reverse=function(){this.names.reverse();this.values.reverse()};domapi.List.prototype.swapItems=function(i,k$Vu){var t;t=this.names[i];this.names[i]=this.names[k$Vu];this.names[k$Vu]=t;t=this.values[i];this.values[i]=this.values[k$Vu];this.values[k$Vu]=t};domapi.List.prototype.sortByName=function(){this.F_RW(0)};domapi.List.prototype.sortByValue=function(){this.F_RW(1)};domapi.List.prototype.F_RW=function(bM2){var b,j103J,qx876;for(var a=0;a<this.names.length-1;a++)for(b=a+1;b<this.names.length;b++){j103J=bM2?this.values[a]:this.names[a];qx876=bM2?this.values[b]:this.names[b];if(j103J>qx876)this.swapItems(a,b)}};domapi.List.prototype.findNameByValue=function(s){var i=this.values.indexOf(s);return i==-1?null:this.names[i]};domapi.List.prototype.findValueByName=function(s){var i=this.names.indexOf(s);return i==-1?null:this.values[i]};domapi.List.prototype.loadFromString=function(s,DJ0P2,B9mg,append){DJ0P2=domapi.rVal(DJ0P2,"\n");B9mg=domapi.rVal(B9mg,"=");var t;var $c5=s.split(DJ0P2);if(!append)this.clear();for(var a=0;a<$c5.length;a++){t=$c5[a].split(B9mg);this.add(t[0],t[1])}};domapi.List.prototype.saveToString=function(DJ0P2,B9mg,doEscape){DJ0P2=domapi.rVal(DJ0P2,"\n");B9mg=domapi.rVal(B9mg,"=");var r="";for(var a=0;a<this.names.length;a++){if(r!="")r+=DJ0P2;r+=(doEscape?escape(this.names[a]):this.names[a])+B9mg+(doEscape?escape(this.values[a]):this.values[a])}return r};domapi.List.prototype.saveToURL=function(DJ0P2,B9mg,doEscape){DJ0P2=domapi.rVal(DJ0P2,"\n");B9mg=domapi.rVal(B9mg,"=");var r="";for(var a=0;a<this.names.length;a++){if(r!="")r+=DJ0P2;r+=(doEscape?encodeURI(this.names[a]):this.names[a])+B9mg+(doEscape?encodeURI(this.values[a]):this.values[a])}return r};domapi.List.prototype.toString=function(DJ0P2,B9mg,doEscape){return this.saveToString(DJ0P2,B9mg,doEscape)};domapi.List.prototype.saveToSelect=function(s,append){var nF9vw=s.options;if(!append)nF9vw.length=0;var i=nF9vw.length;for(var a=0;a<this.names.length;a++){nF9vw[a+i]=new Option(this.names[a],this.values[a])}};domapi.List.prototype.loadFromSelect=function(s,append){if(!append)this.clear();var nF9vw=s.options;for(var a=0;a<s.length;a++)this.add(s[a].text,s[a].value)};domapi.List.prototype.loadFromURLParams=function(append){if(!append)this.clear();var s=location.search.split("?");if(s.length<2)return;var p=s[1].split("&");for(var a=0;a<p.length;a++)this.add(p[a])};domapi.List.prototype.loadFromForm=function(__4,append){if(!append)this.clear();var x3A00=__4.elements;var b,nF9vw;for(var a=0;a<x3A00.length;a++)if(x3A00[a].name!=null&&x3A00[a].name!=""){if(x3A00[a].type.toUpperCase()=="SELECT"){nF9vw=x3A00[a].options;for(var b=0;b<nF9vw.length;b++)if(nF9vw[b].selected)this.add(x3A00[a].name,nF9vw[b].value)}else this.add(x3A00[a].name,x3A00[a].value)}};domapi.List.prototype.saveToXML=function(i64R,Pv9uJ){i64R=domapi.rVal(i64R,"List");Pv9uJ=Pv9uJ?"\n":"";var r='<'+i64R+' length="'+this.names.length+'">'+Pv9uJ;for(var a=0;a<this.names.length;a++){r+='<item>'+Pv9uJ+'<name>'+this.names[a]+'</name>'+Pv9uJ+'<value>'+this.values[a]+'</value>'+Pv9uJ+'</item>'+Pv9uJ}return r+'</'+i64R+'>'};