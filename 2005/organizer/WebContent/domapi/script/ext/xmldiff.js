/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
domapi.g4KG=function(sbqvp,U7BN6,q49bs,V4Q7){this.ewX3L=sbqvp.documentElement;this.BPP=U7BN6.documentElement;this.q49bs=domapi.rBool(q49bs,false);if(this.q49bs){this.XO4Y8=domapi.xml.getDomDocument("http://www.xmldb.org/xupdate","modifications","xupdate");this.XO4Y8.documentElement.setAttribute("version","1.0")}else this.XO4Y8=domapi.xml.getDomDocument(null,"xmldiff");this._2Qqm=this.XO4Y8.documentElement;this.$2pW9=true;this.D$8r=true;this.V_2(this.ewX3L,this.BPP)};domapi.g4KG.prototype.V_2=function(ewX3L,BPP){var ARX28=ewX3L.childNodes;var cG2F=BPP.childNodes;var K1k42=[];var Cx$V=[];for(i=0;i<ARX28.length;i++){if(ARX28.item(i).nodeType==1)K1k42[K1k42.length]=new domapi.CmG_7(ARX28.item(i).nodeName,ARX28.item(i));else{if(ARX28.item(i).nodeType==3)if(ARX28.item(i).nodeValue.trim()!="")K1k42[K1k42.length]=new domapi.CmG_7("text"+i,ARX28.item(i))}}for(i=0;i<cG2F.length;i++){if(cG2F.item(i).nodeType==1)Cx$V[Cx$V.length]=new domapi.CmG_7(cG2F.item(i).nodeName,cG2F.item(i));else{if(cG2F.item(i).nodeType==3)if(cG2F.item(i).nodeValue.trim()!="")Cx$V[Cx$V.length]=new domapi.CmG_7("text"+i,cG2F.item(i))}}domapi.CmG_7.p0O43(K1k42);domapi.CmG_7.p0O43(Cx$V);var OL168=0;var Kv1=0;while(OL168<K1k42.length&&Kv1<Cx$V.length){while(Kv1<Cx$V.length&&K1k42[OL168].name>Cx$V[Kv1].name){n2t=Cx$V[Kv1].Ea79.previousSibling;this.addSubTree(K1k42[OL168].Ea79.parentNode,Cx$V[Kv1].Ea79,n2t,domapi.xml.ac8O(cG2F,Cx$V[Kv1].Ea79));Kv1++}if(Kv1>=Cx$V.length){break}while(OL168<K1k42.length&&K1k42[OL168].name<Cx$V[Kv1].name){this.H05(K1k42[OL168].Ea79);OL168++;if(OL168>=K1k42.length)break}if(OL168>=K1k42.length){break}if(K1k42[OL168].name==Cx$V[Kv1].name&&K1k42[OL168].name){if(K1k42[OL168].Ea79.nodeType==3){if(!(K1k42[OL168].Ea79.nodeValue==Cx$V[Kv1].Ea79.nodeValue)&&this.$2pW9){this.I9n(K1k42[OL168].Ea79.parentNode,K1k42[OL168].Ea79.nodeValue,Cx$V[Kv1].Ea79.nodeValue)}}else{if(this.D$8r)this.x93(K1k42[OL168].Ea79,Cx$V[Kv1].Ea79);this.V_2(K1k42[OL168].Ea79,Cx$V[Kv1].Ea79)}OL168++;Kv1++}}if(OL168<K1k42.length){while(OL168<K1k42.length){this.H05(K1k42[OL168].Ea79);OL168++}}else{if(Kv1<Cx$V.length){n2t=Cx$V[Kv1].Ea79.previousSibling;this.addSubTree(Cx$V[Kv1].Ea79.parentNode,Cx$V[Kv1].Ea79,n2t,-1);Kv1++}}};domapi.g4KG.prototype.addSubTree=function(parent,n539,XI5a,wc$17){var i;if(this.q49bs){if(wc$17==-1||wc$17==parent.childNodes.length){k2k57=this.XO4Y8.createElement("xupdate:append");k2k57.setAttribute("select",domapi.xml.generateXPath(parent));k2k57.setAttribute("child","last()")}else{k2k57=this.XO4Y8.createElement("xupdate:insert-after");k2k57.setAttribute("select",domapi.xml.generateXPath(parent.childNodes.item(wc$17-1)))}add=this.XO4Y8.createElement("xupdate:element");add.setAttribute("name",n539.nodeName);k2k57.appendChild(add);this._2Qqm.appendChild(k2k57);xP9=n539.attributes;if(xP9){for(i=0;i<xP9.length;i++){K5g19=this.XO4Y8.createElement("xupdate:attribute");K5g19.setAttribute("name",xP9.item(i).nodeName);K5g19.text=xP9.item(i).nodeValue;add.appendChild(K5g19)}}_1TK=n539.cloneNode(true);for(i=0;i<_1TK.childNodes.length;i++)_8xC=_1TK.childNodes.item(i);if(_8xC.nodeType==3){B8tV=this.XO4Y8.createElement("xupdate:text");B8tV.appendChild(_8xC);add.appendChild(B8tV)}else add.appendChild(_8xC)}else{add=this.XO4Y8.createElement("addsubtree");add.setAttribute("xpathparent",domapi.xml.generateXPath(parent));if(XI5a==null){}else{add.setAttribute("insertOrder",wc$17);this._2Qqm.appendChild(add);_1TK=n539.cloneNode(true);add.appendChild(_1TK)}}};domapi.g4KG.prototype.H05=function(jG4u){if(this.q49bs)del=this.XO4Y8.createElement("xupdate:remove");else del=this.XO4Y8.createElement("delsubtree");del.setAttribute((this._N0?"select":"xpath"),domapi.xml.generateXPath(jG4u));this._2Qqm.appendChild(del)};domapi.g4KG.prototype.I9n=function(parent,j3Dg5,U52nJ){if(this.q49bs){$l8Y=this.XO4Y8.createElement("xupdate:update");$l8Y.text=U52nJ}else{$l8Y=this.XO4Y8.createElement("changedata");$l8Y.setAttribute("newvalue",U52nJ);$l8Y.setAttribute("oldvalue",j3Dg5)}$l8Y.setAttribute((this._N0?"select":"xpath"),domapi.xml.generateXPath(parent));this._2Qqm.appendChild($l8Y)};domapi.g4KG.prototype.x93=function(w425,vh70){eI0_3=w425.attributes;_T9=vh70.attributes;if(eI0_3.length==0||_T9.length==0)return;var hvbM;if(this.q49bs)hvbM=this.XO4Y8.createElement("xupdate:update");else hvbM=this.XO4Y8.createElement("changeattr");var Wl2=false;var i;for(i=0;i<eI0_3.length;i++){Gh7=eI0_3.item(i);FopJf=_T9.getNamedItem(Gh7.nodeName);if(FopJf){if(Gh7.nodeValue!=FopJf.nodeValue){Wl2=true;if(this.q49bs){hvbM.text=FopJf.nodeValue;hvbM.setAttribute("select",domapi.xml.generateXPath(w425)+"/@"+FopJf.nodeName)}else{$Ot22=this.XO4Y8.createElement("attribute");$Ot22.setAttribute("newvalue",FopJf.nodeValue);$Ot22.setAttribute("oldvalue",Gh7.nodeValue);$Ot22.setAttribute("name",Gh7.nodeName);hvbM.setAttribute("xpath",domapi.xml.generateXPath(w425));hvbM.appendChild($Ot22)}}if(Wl2){this._2Qqm.appendChild(hvbM)}}else{JQNL=this.XO4Y8.createElement("xupdate:remove");JQNL.setAttribute("select",domapi.xml.generateXPath(w425)+"/@"+Gh7.nodeName);this._2Qqm.appendChild(JQNL)}}if(_T9.length>eI0_3.length){i2Y5=this.XO4Y8.createElement("xupdate:append");i2Y5.setAttribute("select",domapi.xml.generateXPath(w425));for(i=0;i<_T9.length;i++){FopJf=_T9.item(i);Gh7=eI0_3.getNamedItem(FopJf.nodeName);if(!Gh7){V84=this.XO4Y8.createElement("xupdate:attribute");V84.setAttribute("name",FopJf.nodeName);V84.text=FopJf.nodeValue;i2Y5.appendChild(V84)}}this._2Qqm.appendChild(i2Y5)}};domapi.CmG_7=function(name,Ea79){this.name=name;this.Ea79=Ea79};domapi.CmG_7.prototype.toString=function(){return this.name};domapi.CmG_7.p0O43=function(McMEA){skA0l=-1;Y80=McMEA.length;while(skA0l<Y80){_c8=false;skA0l++;for(i=skA0l;i<Y80-2;i++){if(McMEA[i].name>McMEA[i+1].name){l=McMEA[i];McMEA[i]=McMEA[i+1];McMEA[i+1]=i;_c8=true}}if(!_c8)break;for(i=Y80-2;i>skA0l;i--){if(McMEA[i].name>McMEA[i+1].name){l=McMEA[i];McMEA[i]=McMEA[i+1];McMEA[i+1]=i;_c8=true}}if(!_c8)break}};