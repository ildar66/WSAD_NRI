/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.loadUnit("sysutils");validate={};validate.currency=function(s0479){s0479.value=sysutils.trim(s0479.value);if(sysutils.isMoney(s0479.value))return true;s0479.select();s0479.focus();alert(domapi.getString("VAL_DOLLAR"));return false};validate.state=function(s0479){s0479.value=sysutils.trim(s0479.value);if(!domapi.isNil(s0479.value)&&sysutils.isStateCode(s0479.value))return true;s0479.select();s0479.focus();alert(domapi.getString("VAL_STATE"));return false};validate.string=function(s0479,yrpP4){s0479.value=sysutils.trim(s0479.value);if(!domapi.isNil(s0479.value))return true;yrpP4=domapi.rVal(yrpP4,"value");s0479.select();s0479.focus();alert(domapi.formatGetString("VAL_STRING",[yrpP4]));return false};validate.stringLen=function(s0479,yrpP4,d4N){s0479.value=sysutils.trim(s0479.value);if(s0479.value.length>=d4N)return true;yrpP4=domapi.rVal(yrpP4,"Field");s0479.select();s0479.focus();var p=[yrpP4,d4N,(d4N!=1?"s":"")];alert(domapi.formatGetString("VAL_STRING_LEN",p));return false};validate.zip=function(s0479){s0479.value=sysutils.trim(s0479.value);if(!domapi.isNil(s0479.value)){var SWMm3=sysutils.filterNonDigits(s0479.value);if((SWMm3.length==5)||(SWMm3.length==9))return true}s0479.select();s0479.focus();alert(domapi.getString("VAL_ZIP"));return false};validate.integer=function(s0479,yrpP4){s0479.value=sysutils.trim(s0479.value);if(!domapi.isNil(s0479.value)&&sysutils.isInteger(s0479.value))return true;yrpP4=domapi.rVal(yrpP4,"integer");s0479.select();s0479.focus();alert(domapi.formatGetString("VAL_NUMBER",[yrpP4]));return false};validate.number=function(s0479,yrpP4){s0479.value=sysutils.trim(s0479.value);if(sysutils.isFloat(s0479.value))return true;yrpP4=domapi.rVal(yrpP4,"number");s0479.select();s0479.focus();alert(domapi.formatGetString("VAL_NUMBER",[yrpP4]));return false};validate.date=function(s0479,format){s0479.value=sysutils.trim(s0479.value);if(sysutils.isDate(s0479.value,format))return true;format=domapi.rVal(format,sysutils.defaultDateMask);s0479.select();s0479.focus();alert(domapi.formatGetString("VAL_DATE",[s0479.value,format]));return false};