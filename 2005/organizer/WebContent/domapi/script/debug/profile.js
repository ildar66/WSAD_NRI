/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
var prof=new Object();prof.Fm8=new Object();prof.names=new Array();prof.start=function(x55D){if(prof.Fm8[x55D]==null||prof.Fm8[x55D].length==0){prof.Fm8[x55D]=new Array();prof.names[prof.names.length]=x55D}var O1H4=new Date();var $l28=prof.Fm8[x55D];$l28[$l28.length]=O1H4.getTime()};prof.end=function(x55D){PD2=new Date();var $l28=prof.Fm8[x55D];$l28[$l28.length-1]=PD2.getTime()-$l28[$l28.length-1]};prof.reset=function(x55D){if(prof.Fm8[x55D]!=null){prof.Fm8[x55D].length=0}};prof.c26=function(){for(var i=0;i<prof.names.length;i++){prof.reset(prof.names[i])}};prof.remove=function(x55D){if(prof.Fm8[x55D]!=null){prof.Fm8[x55D].length=0;for(var i=0;i<prof.names.length;i++){if(prof.names[i]==x55D)prof.names.splice(i,1)}}};prof.removeAll=function(){for(var i=prof.names.length-1;i>=0;i--)prof.remove(prof.names[i])};prof.pkJ=function(x55D){var t=0;var $l28=prof.Fm8[x55D];for(var i=0;i<$l28.length;i++)t+=$l28[i];if($l28.length>0){return x55D+' accessed: '+$l28.length+' avg time: '+(t/$l28.length)}else{return ""}};prof.$_2=function(x55D,Y87n){Y87n=(Y87n==null)?'<BR>':Y87n;var AoI="";for(var i=0;i<prof.names.length;i++)AoI+=prof.pkJ(prof.names[i])+Y87n;return AoI};prof.dump=function(x55D){return prof.Fm8[x55D].toString()};prof.dumpAll=function(x55D,Y87n){Y87n=(Y87n==null)?'<BR>':Y87n;var AoI="";for(var i=0;i<prof.names.length;i++)AoI+=prof.names[i]+','+prof.dump(prof.names[i])+Y87n;return AoI};