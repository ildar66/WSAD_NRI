/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.loadUnit("list");mtGet=0;mtPost=1;domapi.RPCPacket=function(i2T25){this.guid=domapi.guid();this.url=domapi.rVal(i2T25["url"]);this.data=new domapi.List();this.statusText=domapi.rVal(i2T25["statusText"],domapi.getString("RPC_DEF_STATUS"));this.method=domapi.rInt(i2T25["method"],mtGet)};domapi.RPCPacket.prototype.loadFromForm=function(__4){this.data.loadFromForm(__4,true)};