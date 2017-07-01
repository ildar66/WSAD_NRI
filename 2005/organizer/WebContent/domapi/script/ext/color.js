/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
if(!domapi.color)domapi.color={};domapi.color.lookupColors="F0F8FF,FAEBD7,00FFFF,7FFFD4,F0FFFF,"+"F5F5DC,FFE4C4,000000,FFEBCD,0000FF,"+"8A2BE2,A52A2A,DEB887,5F9EA0,7FFF00,"+"D2691E,FF7F50,6495ED,FFF8DC,DC143C,"+"00FFFF,00008B,008B8B,B8860B,A9A9A9,"+"006400,BDB76B,8B008B,556B2F,FF8C00,"+"9932CC,8B0000,E9967A,8FBC8B,1E90FF,"+"228B22,848484,008200,CD5C5C,E6E6FA,"+"FFFACD,D3D3D3,20B2AA,00FF00,FF00FF,"+"840000,7B68EE,000080,FFA500,FF0000,"+"FA8072,C6C6C6,6A5ACD,008284,FFFF00,"+"9ACD32,FFFFFF";domapi.color.lookupColorNames="aliceblue,antiquewhite,aqua,aquamarine,azure,"+"beige,bisque,black,blanchedalmond,blue,"+"blueviolet,brown,burlywood,cadetblue,chartreuse,"+"chocolate,coral,cornflowerblue,cornsilk,crimson,"+"cyan,darkblue,darkcyan,darkgoldenrod,darkgray,"+"darkgreen,darkkhaki,darkmagenta,darkolivegreen,darkorange,"+"darkorchid,darkred,darksalmon,darkseagreen,dodgerblue,"+"forestgreen,gray,green,indianred,lavender,"+"lemonchiffon,lightgrey,lightseagreen,lime,magenta,"+"maroon,mediumslateblue,navy,orange,red,"+"salmon,silver,slateblue,teal,yellow,"+"yellowgreen,white";domapi.color.lookupColors=domapi.color.lookupColors.split(",");domapi.color.lookupColorNames=domapi.color.lookupColorNames.split(",");domapi.color.debug=false;domapi.color.setColor=function(id,c,kind){kind=domapi.rVal(kind,"bg");c=domapi.rVal(c,"#FFFFFF");switch(kind){case "bg":domapi.getElm(id).style.backgroundColor=c;break;case "fg":domapi.getElm(id).style.color=c;break}};domapi.color.hexToRgb=function(_VE72){if(_VE72.charAt(0)!="#")_VE72="#"+_VE72;return new Array(parseInt(_VE72.substring(1,3),16),parseInt(_VE72.substring(3,5),16),parseInt(_VE72.substring(5,7),16))};domapi.color.rgbToHsl=function(_VE72){var R=[0,0,0];var LnX9=[0,0,0];var r=_VE72[0];var k1_1=_VE72[1];var b=_VE72[2];var vM$3,HRrCd,l1V98,Ry1r;vM$3=Math.min(r,Math.min(k1_1,b));HRrCd=Math.max(r,Math.max(k1_1,b));l1V98=HRrCd-vM$3;Ry1r=HRrCd+vM$3;R[0]=0;R[2]=Ry1r/510;R[1]=(R[2]<=0.5)?l1V98/Ry1r:l1V98/(510-l1V98);LnX9[0]=(HRrCd-r)/l1V98;LnX9[1]=(HRrCd-k1_1)/l1V98;LnX9[2]=(HRrCd-b)/l1V98;if(r==HRrCd&&LnX9[2]==1)R[0]=((k1_1==vM$3&&b>k1_1)?0.5+LnX9[2]:1-LnX9[1]);else if(k1_1==HRrCd)R[0]=((b==vM$3)?1+LnX9[0]:3-LnX9[2]);else if(b==HRrCd)R[0]=((r==vM$3)?3+LnX9[1]:5-LnX9[0]);else if(b>0)R[0]=5+LnX9[2];if(isNaN(R[0]))R[0]=0;if(isNaN(R[1]))R[1]=0;if(isNaN(R[2]))R[2]=0;R[0]=R[0]/6;R[0]=parseInt(R[0]*240);R[1]=parseInt(R[1]*240);R[2]=parseInt(R[2]*240);return R};domapi.color.hslToRgb=function(_VE72){var i,k$Vu,bM2,weight;var h=_VE72[0]/240;var s=_VE72[1]/240;var l=_VE72[2]/240;var R=[0,0,0];weight=(l<=0.5)?(l*(1+s)):(l+s-l*s);if(h==1)h=0;h=h*6;i=l*2-weight;k$Vu=i+(weight-i)*(h-parseInt(h));bM2=weight-(weight-i)*(h-parseInt(h));switch(parseInt(h)){case 0:R[0]=weight;R[1]=k$Vu;R[2]=i;break;case 1:R[0]=bM2;R[1]=weight;R[2]=i;break;case 2:R[0]=i;R[1]=weight;R[2]=k$Vu;break;case 3:R[0]=i;R[1]=bM2;R[2]=weight;break;case 4:R[0]=k$Vu;R[1]=i;R[2]=weight;break;case 5:R[0]=weight;R[1]=i;R[2]=bM2;break}R[0]=parseInt(R[0]*255+0.5);R[1]=parseInt(R[1]*255+0.5);R[2]=parseInt(R[2]*255+0.5);return R};domapi.color.alterColor=function(_VE72,B26){var p47$=domapi.color.hexToRgb(domapi.color.makeSureIsHexColor(_VE72));for(var i=0;i<p47$.length;i++){if(p47$[i]==0)p47$[i]=1;p47$[i]=Math.floor(p47$[i])+Math.floor((p47$[i]*B26)/100);if(p47$[i]>255)p47$[i]=255;if(p47$[i]<0)p47$[i]=0}return domapi.color.rgbToHex(p47$)};domapi.color.mergeColor=function(a0D73,NwI,fFJr){var a;var BP8=domapi.color.hexToRgb(domapi.color.makeSureIsHexColor(a0D73));var bd0=domapi.color.hexToRgb(domapi.color.makeSureIsHexColor(NwI));switch(fFJr){case "and":for(a=0;a<BP8.length;a++)BP8[a]=BP8[a]&bd0[a];break;case "or":for(a=0;a<BP8.length;a++)BP8[a]=BP8[a]|bd0[a];break;case "xor":for(a=0;a<BP8.length;a++)BP8[a]=BP8[a] ^ bd0[a];break;case "not":for(a=0;a<BP8.length;a++)BP8[a]=~ BP8[a];break;case "add":for(a=0;a<BP8.length;a++)BP8[a]=BP8[a]+bd0[a];break;case "subtract":for(a=0;a<BP8.length;a++)BP8[a]=BP8[a]-bd0[a];break;case "blend":for(a=0;a<BP8.length;a++)BP8[a]=Math.floor((BP8[a]+bd0[a])/2);break;case "floor":var K16=Math.floor((BP8[0]+BP8[1]+BP8[2])/3);if(K16>128)for(a=0;a<BP8.length;a++)BP8[a]=0;else for(a=0;a<BP8.length;a++)BP8[a]=255;break}for(a=0;a<BP8.length;a++){if(BP8[a]<0)BP8[a]=0;if(BP8[a]>255)BP8[a]=255}return domapi.color.rgbToHex(BP8)};domapi.elmProto.fadeToColor=function(kind,l04s,P9a,speed,m2rC){domapi.color.fadeToColor(this.id,kind,l04s,P9a,speed,m2rC)};domapi.color.fadeToColor=function(a32_t,kind,l04s,P9a,speed,m2rC){var a;if(domapi.color.debug)domapi.debug.dump_var("fadeToColor('"+a32_t+"','"+kind+"','"+l04s+"',"+P9a+","+speed+",'"+m2rC+"')");l04s=domapi.rVal(l04s,"#000000");kind=domapi.rVal(kind,"bg");P9a=domapi.rVal(P9a,10);speed=domapi.rVal(speed,10);var elm=domapi.getElm(a32_t);if(!elm)return;switch(kind){case "bg":elm.Kc242=domapi.color.hexToRgb(domapi.color.makeSureIsHexColor(elm.style.backgroundColor));elm.T1c7=domapi.color.hexToRgb(domapi.color.makeSureIsHexColor(l04s));if(isNaN(elm.Kc242[0]))for(a=0;a<elm.Kc242.length;a++)elm.Kc242[a]=255;if(isNaN(elm.T1c7[0]))for(a=0;a<elm.T1c7.length;a++)elm.T1c7[a]=255;break;case "fg":elm.o93=domapi.color.hexToRgb(domapi.color.makeSureIsHexColor(elm.style.color));elm.w85=domapi.color.hexToRgb(domapi.color.makeSureIsHexColor(l04s));if(isNaN(elm.o93[0]))for(a=0;a<elm.o93.length;a++)elm.o93[a]=0;if(isNaN(elm.w85[0]))for(a=0;a<elm.w85.length;a++)elm.w85[a]=0;break;default:return}domapi.color.rXk2(a32_t,kind,P9a,speed,m2rC)};domapi.color.rXk2=function(a32_t,kind,P9a,speed,m2rC){var elm=domapi.getElm(a32_t);var K7l5=0;var l1V98,C_02,Gt18,SWMm3;switch(kind){case "bg":var v55_=elm.Kc242;var $I3ga=elm.T1c7;break;case "fg":var v55_=elm.o93;var $I3ga=elm.w85;break}if(domapi.color.debug)var $fgM=" current="+v55_+" target="+$I3ga;for(var a=0;a<v55_.length;a++){C_02=v55_[a];Gt18=$I3ga[a];l1V98=0;if(C_02!=Gt18){SWMm3=Gt18-C_02;if(!isNaN(SWMm3)){l1V98=Math.floor((SWMm3)*P9a/100);C_02=parseInt(C_02)+l1V98}else l1V98=100};if(Math.abs(l1V98)<1){K7l5++;C_02=Gt18}v55_[a]=C_02}if(domapi.color.debug)domapi.debug.dump_var($fgM+" done="+K7l5);switch(kind){case "bg":elm.style.backgroundColor=domapi.color.rgbToHex(v55_);break;case "fg":elm.style.color=domapi.color.rgbToHex(v55_);break}if(K7l5!=3)setTimeout("domapi.color.rXk2(\""+a32_t+"\",\""+kind+"\","+P9a+","+speed+",\""+m2rC+"\")",speed);else if(typeof m2rC!="undefined"&&m2rC!="undefined")eval(m2rC)};domapi.elmProto.alphaTo=function(Q_2,L529,steps,speed,m2rC){if(this.isAlpha)return;domapi.rInt(Q_2,this.getAlpha());Q_2=Math.round(Q_2);domapi.rInt(steps,50);domapi.rInt(speed,20);domapi.rInt(L529,3);this.v5327=this.getAlpha();var q0x=Q_2-this.v5327;var q7U8D=q0x/((Math.pow(steps,2)+2*steps+1)/(4*steps));this.isAlpha=true;this.tBA=domapi.bags.elms.indexOf(this);domapi.color.Y5m6e(this.tBA,L529,q0x,q7U8D,Q_2,steps,1,speed,m2rC)};domapi.color.Y5m6e=function(elmIndex,type,q0x,q7U8D,Q_2,steps,A47e,speed,m2rC){var elm=domapi.bags.elms[elmIndex];if(A47e<=steps){switch(parseInt(type)){case 1:elm.v5327+=q7U8D*Math.pow(A47e/steps,3);break;case 2:elm.v5327+=q7U8D*Math.pow(((steps-A47e)+1)/steps,3);if(Math.round(elm.v5327)==Q_2)A47e=steps;break;case 3:elm.v5327+=q0x/steps;break}elm.setAlpha(Math.round(elm.v5327));A47e++;setTimeout("domapi.color.Y5m6e(\""+elmIndex+"\","+type+","+q0x+","+q7U8D+","+Q_2+","+steps+","+A47e+","+speed+",\""+m2rC+"\")",speed)}else{elm.isAlpha=false;elm.setAlpha(Q_2);if(typeof m2rC!="undefined"&&m2rC!="undefined")eval(m2rC)}};