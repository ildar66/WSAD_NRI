/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.registerComponent("barchart");domapi.Barchart=function(i2T25){return domapi.comps.barchart.constructor(i2T25)};domapi.comps.barchart.constructor=function(i2T25){domapi.VQ7(i2T25,"w",200);domapi.VQ7(i2T25,"h",200);var x3A00=domapi.Component(i2T25,"barchart");try{x3A00.appendChild(document.createElement("DIV"));x3A00.appendChild(document.createElement("DIV"));x3A00.j1eW=false;x3A00.IG9=false;x3A00.m4A4=false;x3A00.U0O=false;x3A00.qrP=false;x3A00.S28=false;x3A00.Og7="arial";x3A00.T11=10;x3A00._67=1;x3A00.o84="arial";x3A00.$972=10;x3A00.v0B="";x3A00.F27R="";x3A00.$c5=0;x3A00.d5$5J=1;x3A00.$$_R=0;x3A00.A8469=0;x3A00.range=0;x3A00.data=[];x3A00.Y737=[];x3A00.k519=false;x3A00._340h=true;x3A00.l$700=false;x3A00.VlX0n=0;x3A00.B3u=0;x3A00.$l8Y=0;x3A00.k1_1=0;domapi.hl1(x3A00);return x3A00}finally{x3A00=null}};domapi.comps.barchart.Gk8HS=function(){this.T5$=null;this.J11=null;this.kD9R=null;this.yJ5=null;this.$6l3y=null};domapi.comps.barchart.$K8g4=function(a,b){return(a[0]>b[0])?-1:1};domapi.comps.barchart._v12=function(a,b){return(a[0]<b[0])?-1:1};domapi.comps.barchart.jp2=function(a,b){return(a[1]<b[1])?-1:1};domapi.comps.barchart.CP443=function(a,b){return(a[1]>b[1])?-1:1};domapi.comps.barchart.XOD5=function(a){return Math.round((((((this._340h)?(this.kD9R.getH()):(this.kD9R.getW()))-2)/(this.$c5))*(a+1)*(10/11)-1))};domapi.comps.barchart.qpW_=function(a){return Math.round((((this._340h)?(this.kD9R.getH()):(this.kD9R.getW()))-2)*(a/this.range))};domapi.comps.barchart.Pbg=function(){return this.kD9R.getY()+this.kD9R.getH()};domapi.comps.barchart.$9rc2=function(){return(((this._340h)?(this.kD9R.getW()):(this.kD9R.getH())-2)/(this.data.length))/2};domapi.comps.barchart.Y18$0=function(a,p){return Math.round(((a*2*this.$9rc2())+this.$9rc2())-(p/4))};domapi.comps.barchart.Gd2=function(a){return Math.round((this.data[i][0]*((((this._340h)?(this.kD9R.getH()):(this.kD9R.getW()))-2)/this.range))+2)};domapi.comps.barchart.g612b=function(t){return Math.round(this.kD9R.getY()+this.kD9R.getH()*0.5-t.length*0.5*(this.$972-1))};domapi.comps.barchart.L11=function(s,nF9vw){try{for(var a=0;a<s.length;a++){var b=document.createElement("SPAN");if(s.substr(a,1)==" ")b.innerHTML="&nbsp;";else b.innerHTML=s.substr(a,1);b.style.display='block';nF9vw.appendChild(b)}}finally{b=null}};domapi.comps.barchart.addChart=function(x,y,w,h,l,q){if(this.j1eW)return;q=domapi.rInt(q,this.d5$5J);this.d5$5J=q;l=domapi.rInt(l,this.$c5);if(q==1)this.$c5=l;else{this.$c5=0;this.$$_R=l}this.kD9R=domapi.Elm({parent:this,x:x,y:y,w:w,h:h});this.kD9R.appendChild(document.createElement("DIV"));this.j1eW=true;this.kD9R.setB(1);var w=this.kD9R.style;w.borderStyle=domapi.theme.border.solid;w.borderColor=domapi.theme.border.active;w.backgroundColor=domapi.theme.fonts.highlight.bgcolor;w=null};domapi.comps.barchart.addData=function(_2A49,name,del){if(!this.j1eW)return;del=del?del:",";var YD5w=_2A49.split(del);var names=name.split(del);try{for(i=0;i<YD5w.length;i++){if(parseInt(YD5w[i])*1.1>this.range){this.range=parseInt(YD5w[i])*1.1;this.$l8Y=1;if(this.d5$5J==2)this.$c5=Math.floor((this.range*0.99)/this.$$_R)}var t=this.data;t[t.length]=new Array();t[t.length-1][0]=parseInt(YD5w[i]);t[t.length-1][1]=names[i];var c2cu=domapi.Elm({parent:this.kD9R,x:0,y:0,w:0,h:0})}var q=((domapi.isIE&&domapi.major==5&&domapi.minor==0)?(100):(0));setTimeout('domapi.getElm("'+this.id+'").APd()',q)}finally{c2cu=null}};domapi.comps.barchart.addTitle=function(t,x,y){if(domapi.isNil(t)){this.BDie();return}if(!this.J11)this.J11=domapi.Elm({parent:this,x:x,y:y});this.IG9=true;this.J11.setText(t);this.J11.setP(5);var w=this.J11.style;try{w.textAlign='center';w.font=domapi.theme.fonts.window.asString();w.fontWeight='bold';w.color=domapi.theme.fonts.window.color;w.top='10px';w.visibility='visible'}finally{w=null}};domapi.comps.barchart.setGrid=function(l,q){if(!this.j1eW)return;q=domapi.rInt(q,this.d5$5J);this.d5$5J=q;l=domapi.rInt(l,this.$c5);if(q==1)this.$c5=l;else{this.$$_R=l;this.$c5=Math.floor((this.range*0.99)/this.$$_R)}this.k1_1=1;var t=this.kD9R.childNodes[0];try{var x=t.childNodes.length;if(x>0)for(var a=0;a<x;a++)t.removeChild(t.childNodes[0]);if(q==1){for(var a=0;a<l;a++){var SWMm3=document.createElement("DIV");var w=SWMm3.style;w.position="absolute";w.height=((this._340h)?1:this.kD9R.getH())+"px";w.width=((this._340h)?this.kD9R.getW():1)+"px";w.left=((this._340h)?0:this.XOD5(a))+"px";w.top=((this._340h)?(this.kD9R.getH()-this.XOD5(a)-4):0)+"px";w.backgroundColor=domapi.theme.fonts.buttonface.color;w.overflow="hidden";t.appendChild(SWMm3)}}else{var b=[this.$$_R];while(b[b.length-1]+this.$$_R<(this.range*0.99))b[b.length]=b[b.length-1]+this.$$_R;for(var a=0;a<b.length;a++){var SWMm3=document.createElement("DIV");var w=SWMm3.style;w.position="absolute";w.height=((this._340h)?1:this.kD9R.getH())+"px";w.width=((this._340h)?this.kD9R.getW():1)+"px";w.left=((this._340h)?0:this.qpW_(b[a])-1)+"px";w.top=((this._340h)?(this.kD9R.getH()-this.qpW_(b[a])-3):0)+"px";w.backgroundColor=domapi.theme.fonts.buttonface.color;w.overflow="hidden";t.appendChild(SWMm3)}}}finally{t=null;SWMm3=null;w=null}};domapi.comps.barchart.setLabels=function(l,p,r){if(!this.j1eW)return;l=domapi.rInt(l,this.$c5);p=domapi.rInt(p,this.T11);this.A8469=l;r=domapi.rInt(r,this._67);this._67=r;var t=this.childNodes[0];try{var _5P=t.childNodes.length;if(this.d5$5J==2){var b=[this.$$_R];while(b[b.length-1]+this.$$_R<(this.range*0.99))b[b.length]=b[b.length-1]+this.$$_R}if(_5P>0)for(var a=0;a<_5P;a++)t.removeChild(t.childNodes[0]);for(var a=0;a<l;a++){var SWMm3=document.createElement("DIV");var t6P5=document.createElement("DIV");var w=SWMm3.style;w.position="absolute";w.height=((this._340h)?1:2)+"px";w.width=((this._340h)?2:1)+"px";w.left=((this._340h)?(this.kD9R.getX()-2):(((this.d5$5J==1)?(this.XOD5(a)):(this.qpW_(b[a])-1))+this.kD9R.getX()+1))+"px";w.top=((this._340h)?(this.Pbg()-((this.d5$5J==1)?(this.XOD5(a)):(this.qpW_(b[a])-1))-3):(this.Pbg()))+"px";w.backgroundColor=domapi.theme.fonts.buttonface.color;w.overflow="hidden";var w=t6P5.style;w.position="absolute";w.height=((this._340h)?1:20)+"px";w.width=((this._340h)?this.kD9R.getX()-4:1)+"px";w.left=((this._340h)?(0):((((this.d5$5J==1)?(this.XOD5(a)):(this.qpW_(b[a])-1))+this.kD9R.getX()+1)-(p/8)))+"px";w.top=((this._340h)?(this.Pbg()-((this.d5$5J==1)?(this.XOD5(a)):(this.qpW_(b[a])-1))-5-(p/2)):(this.Pbg()+4))+"px";w.color=domapi.theme.fonts.buttonface.color;w.textAlign='right';w.fontFamily=this.Og7;w.fontSize=p+"px";if(!this._340h)w.lineHeight=(p-1)+'px';if(this.d5$5J==1){var u_g6=Math.round(((this.range*(10/11))/(l)*(a+1))*Math.pow(10,r));var WmM=u_g6.toString().substr(u_g6.toString().length-r,r);var k1_1=u_g6.toString().substr(0,u_g6.toString().length-r);if(parseInt(WmM)!=0&&r!=0)k1_1+='.'+WmM}else var k1_1=b[a];if(this._340h){t6P5.innerHTML="<span>"+k1_1+"</span>"}else if(this.l$700)t6P5.innerHTML=k1_1;else{this.L11(k1_1.toString(),t6P5);if(k1_1.toString().length*(p-1)>this.B3u){this.$l8Y=1;this.B3u=k1_1.toString().length*(p-1)}}t.appendChild(SWMm3);t.appendChild(t6P5);if(t6P5.childNodes[0].offsetWidth>this.VlX0n){this.$l8Y=1;this.VlX0n=t6P5.childNodes[0].offsetWidth}}if(this.$l8Y==1){this.$l8Y=0;this.setXAxis();this.setYAxis()}if(this.k1_1!=1)this.setGrid()}finally{t=null;SWMm3=null;t6P5=null;w=null}};domapi.comps.barchart.setNames=function(p){if(!this.j1eW||this.data.length==0)return;p=domapi.rInt(p,this.T11);var t=this.childNodes[1];try{var _5P=t.childNodes.length;this.h5w5();this.S28=true;for(var a=0;a<this.data.length;a++){SWMm3=document.createElement("DIV");var w=SWMm3.style;w.position="absolute";w.fontSize=p+"px";w.fontFamily=this.Og7;w.textAlign=(this._340h)?('center'):('right');w.lineHeight=(p-1)+'px';w.top=((this._340h)?(this.Pbg()):(this.kD9R.getY()+this.Y18$0(a,p)))+"px";w.left=((this._340h)?(this.kD9R.getX()+this.Y18$0(a,p)-2):(0))+"px";if(!this._340h)w.width=this.kD9R.getX()-4;if(!this._340h)SWMm3.innerHTML='<span>'+this.data[a][1]+'</span>';else if(this.l$700)SWMm3.innerHTML='<span>'+this.data[a][1]+'</span>';else{this.L11(this.data[a][1],SWMm3);if(this.data[a][1].length*(p-1)>this.B3u){this.$l8Y=1;this.B3u=this.data[a][1].length*(p-1)}}t.appendChild(SWMm3);if(!this._340h)if(SWMm3.childNodes[0].offsetWidth>this.VlX0n){this.$l8Y=1;this.VlX0n=SWMm3.childNodes[0].offsetWidth}}if(this.$l8Y==1){this.$l8Y=0;this.setXAxis();this.setYAxis()}}finally{t=null;w=null}};domapi.comps.barchart.q02=function(c,p8Td){if(!this.j1eW)return;if(c==null)this.k519=false;else{p8Td=p8Td?p8Td:",";this.Y737=c.split(p8Td);this.k519=true}this.APd()};domapi.comps.barchart.l79d=function(x){x=domapi.rInt(x,0);this._340h=((x==0)?true:false);this.draw()};domapi.comps.barchart.setXAxis=function(t,x,y){if(domapi.isNil(t))t=this.v0B;this.v0B=t;if(this.B3u==0)this.B3u=this.T11;if(this.VlX0n==0)this.VlX0n=this.T11;if(!this.yJ5)this.yJ5=domapi.Elm({parent:this,x:0,y:0});this.m4A4=true;this.yJ5.setText('');if(this._340h)this.yJ5.setText(t);else this.L11(t,this.yJ5);if(x)this.yJ5.setX(x);else if(this._340h)this.yJ5.setX(this.kD9R.getX());else this.yJ5.setX(this.kD9R.getX()-this.VlX0n-this.$972-4);if(y)this.yJ5.setY(y);else if(this._340h)this.yJ5.setY(this.Pbg()+this.B3u);else this.yJ5.setY(this.g612b(t));if(this._340h)this.yJ5.setW(this.kD9R.getW());else this.yJ5.setW(this.$972);var w=this.yJ5.style;try{w.textAlign='center';w.fontFamily=this.o84;w.fontWeight='bold';w.fontSize=this.$972+'px';w.color=domapi.theme.fonts.window.color;w.visibility='visible'}finally{w=null}};domapi.comps.barchart.setYAxis=function(t,x,y){if(domapi.isNil(t))t=this.F27R;this.F27R=t;if(this.B3u==0)this.B3u=this.T11;if(this.VlX0n==0)this.VlX0n=this.T11;if(!this.$6l3y)this.$6l3y=domapi.Elm({parent:this,x:0,y:0});this.U0O=true;this.$6l3y.setText('');if(this._340h)this.L11(t,this.$6l3y);else this.$6l3y.setText(t);if(x)this.$6l3y.setX(x);else if(this._340h)this.$6l3y.setX(this.kD9R.getX()-this.VlX0n-this.$972-4);else this.$6l3y.setX(this.kD9R.getX());if(y)this.$6l3y.setY(y);else if(this._340h)this.$6l3y.setY(this.g612b(t));else this.$6l3y.setY(this.Pbg()+this.B3u+4);if(!this._340h)this.$6l3y.setW(this.kD9R.getW());else this.$6l3y.setW(this.$972);var w=this.$6l3y.style;try{w.textAlign='center';w.fontFamily=this.o84;w.fontWeight='bold';w.fontSize=this.$972+'px';w.color=domapi.theme.fonts.window.color;w.visibility='visible';if(this._340h)w.lineHeight=(this.$972-1)+'px'}finally{w=null}};domapi.comps.barchart.h5w5=function(){var t=this.childNodes[1];try{var _5P=t.childNodes.length;this.S28=false;if(_5P>0)for(var a=0;a<_5P;a++)t.removeChild(t.childNodes[0])}finally{t=null}};domapi.comps.barchart.BDie=function(){if(!this.J11)return;this.J11.style.visibility='hidden';this.IG9=false};domapi.comps.barchart.U1w=function(){if(!this.yJ5)return;this.yJ5.style.visibility='hidden';this.yJ5=false};domapi.comps.barchart.l707=function(){if(!this.$6l3y)return;this.$6l3y.style.visibility='hidden';this.U0O=false};domapi.comps.barchart.APd=function(){var t=domapi.theme;var __4=t.fonts;if(!this.j1eW)return;try{var x3A00=this.data.length;for(i=0;i<x3A00;i++){if(this.k519)var a=this.Y737[i%this.Y737.length];else var a=__4.selection.bgcolor;if(a=='theme')a=__4.selection.bgcolor;var w=this.kD9R.childNodes[i+1];w.setB(1);w.setW((this._340h)?(this.$9rc2()):(this.Gd2(i)-1));w.setH((this._340h)?(this.Gd2(i)):(this.$9rc2()));w.setX((this._340h)?(Math.round(((i)*2*(this.$9rc2()))+(this.$9rc2()/2))):(-1));w.setY((this._340h)?((this.kD9R.getH()-2)-(this.Gd2(i))+1):(Math.round(((i)*2*(this.$9rc2()))+(this.$9rc2()/2))));w.setZ(1);w.setBgColor(a);w.style.borderStyle=t.border.solid;w.style.borderColor=t.border.active}var q=((domapi.isIE&&domapi.major==5&&domapi.minor==0)?(100):(0));if(this.A8469>0)this.setLabels();if(this.S28)setTimeout('domapi.getElm("'+this.id+'").setNames()',q)}finally{t=null;__4=null;w=null}};domapi.comps.barchart.bVe=function(){this.kD9R.setB(1);var w=this.kD9R.style;try{w.backgroundColor=this.theme.B$h6;w.borderColor=this.theme.h69R;for(var a=0;a<this.$c5;a++)this.kD9R.childNodes[0].childNodes[a].style.backgroundColor=this.theme.gIX9d;this.setGrid();this.APd();if(this.yJ5)this.setXAxis();if(this.$6l3y)this.setYAxis()}finally{w=null}};domapi.comps.barchart.draw=function(){var t=domapi.theme;var __4=t.fonts;var s=this.style;try{this.VlX0n=0;this.B3u=0;var b=this.doBorder?t.border.width:0;this.setB(b);this.setColor(__4.window.color);this.setBgColor(this.doBGFill?__4.window.bgcolor:"transparent");s.borderStyle=this.doBorder?t.border.solid:"none";s.borderColor=t.border.getInset();if(this.j1eW)this.bVe()}finally{t=null;__4=null;s=null}};domapi.comps.barchart.v5e6=function(t){this.data=this.data.sort(eval('this.sort'+t))};