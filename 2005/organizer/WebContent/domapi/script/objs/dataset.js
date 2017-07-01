/*
Copyright (c) Nebiru Software 2001, 2005
  Compressed and obfuscated by JSCruncher Pro.
  http://domapi.com/jscruncherpro
*/
ftUnknown=0;ftString=1;ftInteger=2;ftBoolean=3;ftFloat=4;ftDate=5;ctUnknown=0;ctCustom=1;ctText=2;ctCheckbox=3;ctSelect=4;ctCombobox=5;ctDatepicker=6;ctBrowseButton=7;domapi.loadUnit("csv");domapi.loadUnit("json");domapi.loadUnit("xmlcore");domapi.loadUnit("sysutils");domapi.mJ00.Dataset={};domapi.Dataset=function(i2T25){this.cols=[];this.rows=[];for(var i in i2T25)this[i]=i2T25[i]};domapi.Dataset.prototype.defaultColWidth=120;domapi.Dataset.prototype.defaultRowHeight=domapi.theme.skin.metrics.dropdown.h;domapi.Dataset.prototype.defaultMinColWidth=20;domapi.Dataset.prototype.clear=function(){this.rows=[];this.dataChanged()};domapi.Dataset.prototype.toString=function(){return "[object Dataset]"};domapi.Dataset.prototype.assert=function(){if(this.inUpdate)return;var i,k$Vu,c,r;for(i=0;i<this.cols.length;i++){c=this.cols[i];c.w=c.w||this.defaultColWidth;c.Ml1I=c.Ml1I||this.defaultMinColWidth;c.textAlign=c.textAlign||"left";c.headerAlign=c.headerAlign||c.textAlign;c.sortable=domapi.rBool(c.sortable,true);c.fieldName=domapi.rVal(c.fieldName,'Column '+i);c.text=domapi.rVal(c.text,c.fieldName);c.fieldType=domapi.rInt(c.fieldType,ftUnknown);c.controlType=domapi.rInt(c.controlType,ctUnknown);if(c.sorted)this.$FF7=i}for(k$Vu=0;k$Vu<this.rows.length;k$Vu++){r=this.rows[k$Vu];if(r){r.h=domapi.rInt(r.h,this.defaultRowHeight);this.assertRow(r)}}};domapi.Dataset.prototype.assertRow=function(r){var c=r.cells;var C=this.cols;while(c.length<C.length)c.push(new domapi.DatasetCell({}));if(c.length>C.length)c.length=C.length};domapi.Dataset.prototype.beginUpdate=function(){this.inUpdate=true};domapi.Dataset.prototype.endUpdate=function(){this.inUpdate=false;this.dataChanged()};domapi.Dataset.prototype.dataChanged=function(){if(!this.inUpdate){this.assert();if(this.G437n&&this.G437n.s3kp)this.G437n.s3kp();if(this.ondatachanged)this.ondatachanged()}};domapi.Dataset.prototype.reset=function(f3msv){this.rows=[];this.cols=[];if(!f3msv)this.dataChanged()};domapi.Dataset.prototype.cellByIndex=function(r,c){return this.rows[r].cells[c]};domapi.Dataset.prototype.visibleCol=function(G7h5_){var r=-1;var c=this.cols;for(var i=0;i<c.length;i++){if(!c[i].hidden)r++;if(r==G7h5_)return i}return-1};domapi.Dataset.prototype.visibleCols=function(){var R=[];var c=this.cols;for(var i=0;i<c.length;i++)if(!c[i].hidden)R.push(i);return R};domapi.Dataset.prototype.visibleRows=function(){var R=[];var r=this.rows;for(var i=0;i<r.length;i++)if(!r[i].hidden)R.push(i);return R};domapi.Dataset.prototype.visibleRowcount=function(){return this.visibleRows().length};domapi.Dataset.prototype.getVisibleRowsIndex=function(index,itk){if(arguments.length==1)itk=0;var R=this.rows;var q$2=R.length;var r=itk-1;for(var i=itk;i<q$2;i++){if(!R[i].hidden)r++;if(r==index)return i}return r};domapi.Dataset.prototype.visibleColsWidth=function(){var r=0;var a=this.visibleCols();for(var i=0;i<a.length;i++)r+=parseInt(this.cols[a[i]].w);return r};domapi.Dataset.prototype.visibleRowTop=function(index){var r=0;var a=this.visibleRows();for(var i=0;i<index;i++)r+=this.rows[a[i]].h;return r};domapi.Dataset.prototype.visibleRowsHeight=function(){var r=0;var a=this.visibleRows();for(var i=0;i<a.length;i++)r+=this.rows[a[i]].h;return r};domapi.Dataset.prototype.sort=function(w3$,dir){var a=this.rows;for(var i=0;i<this.cols.length;i++)if(this.cols[i].fieldName==w3$){var p=domapi.mJ00.Dataset;p.$FF7=i;p.sortDir=dir;p.obj=this;p.fieldType=this.cols[i].fieldType;p.eb946=new Date(1,1,1901);for(i=0;i<a.length;i++){a[i].jN88j=a[i].cells[p.$FF7].value;switch(p.fieldType){case ftUnknown:a[i].jN88j=a[i].jN88j.toLowerCase();break;case ftString:a[i].jN88j=a[i].jN88j.toLowerCase();break;case ftBoolean:a[i].jN88j=String(a[i].jN88j).toLowerCase().trim();if(a[i].jN88j=="")a[i].jN88j="false";a[i].jN88j=(a[i].jN88j=="true"||a[i].jN88j=="yes"||a[i].jN88j==true)?true:false;break;case ftFloat:a[i].jN88j=parseFloat(sysutils.filterChars(a[i].jN88j,","));break;case ftInteger:a[i].jN88j=parseInt(sysutils.filterChars(a[i].jN88j,","));break;case ftDate:a[i].jN88j=sysutils.isDate(a[i].jN88j);break}}a.sort(this.j2u);this.$FF7=i;this.sortDir=dir;if(this.onsort)this.onsort(w3$,dir);return i}return-1};domapi.Dataset.prototype.j2u=function(Fyr,B){var p=domapi.mJ00.Dataset;var a=Fyr.jN88j;var b=B.jN88j;if(p.sortDir)return(a==b)?0:(a<b)?1:-1;else return(a==b)?0:(a>b)?1:-1};domapi.Dataset.prototype.displayText=function(r,c){try{var Nu5=this.cellByIndex(r,c);if(Nu5){if(typeof Nu5.text!="undefined")return Nu5.text;else if(typeof Nu5.value!="undefined")return Nu5.value;else return 'nothing to display'}else{return 'displayText error: r='+r+', c='+c}}catch(E){var s='Error in domapi.Dataset.prototype.displayText(r='+r+', c='+c+');\n'+E.message;if(domapi.debug)dump(s);else throw new Error(s)}};domapi.Dataset.prototype.getValue=function(r,c){try{var Nu5=this.cellByIndex(r,c);if(Nu5){if(typeof Nu5.value!="undefined")return Nu5.value;else if(typeof Nu5.text!="undefined")return Nu5.text;else return 'no_value'}else{return 'getValue error'}}catch(E){var s='Error in domapi.Dataset.prototype.getValue(r='+r+', c='+c+');\n'+E.message;if(domapi.debug)dump(s);else throw new Error(s)}};domapi.Dataset.prototype.setValue=function(r,c,value){try{var Nu5=this.cellByIndex(r,c);if(Nu5){Nu5.value=value;this.dataChanged()}else{return 'setValue error'}}catch(E){var s='Error in domapi.Dataset.prototype.setValue(r='+r+', c='+c+');\n'+E.message;if(domapi.debug)dump(s);else throw new Error(s)}};domapi.Dataset.prototype.setText=function(r,c,value){try{var Nu5=this.cellByIndex(r,c);if(Nu5){Nu5.text=value;this.dataChanged()}else{return 'setValue error'}}catch(E){var s='Error in domapi.Dataset.prototype.setValue(r='+r+', c='+c+');\n'+E.message;if(domapi.debug)dump(s);else throw new Error(s)}};domapi.Dataset.prototype.getColcount=function(){return this.cols.length};domapi.Dataset.prototype.setColcount=function(i){while(this.cols.length<i)this.addCol()};domapi.Dataset.prototype.addCol=function(i2T25){var C=new domapi.DatasetCol(i2T25);try{this.cols.push(C);this.dataChanged();if(this.onaddcol)this.onaddcol(C);return C}finally{C=null}};domapi.Dataset.prototype.insertCol=function(i,i2T25){var C=new domapi.DatasetCol(i2T25);try{this.cols.insert(C);this.dataChanged();if(this.oninsertcol)this.oninsertcol(C);return C}finally{C=null}};domapi.Dataset.prototype.deleteCol=function(i){this.cols.deleteItem(i);this.dataChanged();if(this.ondeletecol)this.ondeletecol(i)};domapi.Dataset.prototype.swapCols=function(i,k$Vu){var r=this.rows;this.cols.y471(i,k$Vu);for(var bM2=0;bM2<r.length;bM2++)r[bM2].cells.y471(i,k$Vu);this.dataChanged();if(this.onswapcols)this.onswapcols(i,k$Vu)};domapi.Dataset.prototype.getRowcount=function(){return this.rows.length};domapi.Dataset.prototype.setRowcount=function(i){while(this.rows.length<i)this.addRow()};domapi.Dataset.prototype.addRow=function(i2T25){var R=new domapi.DatasetRow(i2T25);try{this.rows.push(R);this.assert();this.dataChanged();if(this.onaddrow)this.onaddrow(R);return R}finally{R=null}};domapi.Dataset.prototype.insertRow=function(i,i2T25){var R=new domapi.DatasetRow(i2T25);try{this.rows.insert(i,R);this.dataChanged();if(this.oninsertrow)this.oninsertrow(R);return R}finally{R=null}};domapi.Dataset.prototype.deleteRow=function(i){this.rows.deleteItem(i);this.dataChanged();if(this.ondeleterow)this.ondeleterow(i)};domapi.Dataset.prototype.swapRows=function(i,k$Vu){this.rows.y471(i,k$Vu);this.dataChanged();if(this.onswaprows)this.onswaprows(i,k$Vu)};domapi.Dataset.prototype.findSelected=function(k$Vu){for(var i=k$Vu;i<this.rows.length;i++)if(this.rows[i].selected){this.Us741=i+1;return i}return-1};domapi.Dataset.prototype.firstSelected=function(){return this.findSelected(0)};domapi.Dataset.prototype.nextSelected=function(){this.Us741=domapi.rInt(this.Us741,0);return this.findSelected(this.Us741)};domapi.DatasetCol=function(i2T25){i2T25["text" ]=domapi.rVal(i2T25["text" ],"col");i2T25["fieldName" ]=domapi.rVal(i2T25["fieldName" ],null);i2T25["fieldType" ]=domapi.rVal(i2T25["fieldType" ],ftUnknown);i2T25["controlType" ]=domapi.rVal(i2T25["controlType"],ctUnknown);i2T25["w" ]=domapi.rInt(i2T25["w" ],domapi.Dataset.prototype.defaultColWidth);i2T25["minWidth" ]=domapi.rInt(i2T25["minWidth" ],domapi.Dataset.prototype.defaultMinColWidth);i2T25["maxWidth" ]=domapi.rInt(i2T25["maxWidth" ],null);i2T25["hidden" ]=domapi.rBool(i2T25["hidden" ],false);i2T25["sortable" ]=domapi.rBool(i2T25["sortable" ],true);i2T25["editable" ]=domapi.rBool(i2T25["editable" ],false);i2T25["sorted" ]=domapi.rBool(i2T25["sorted" ],false);i2T25["textAlign" ]=domapi.rVal(i2T25["textAlign" ],"left");i2T25["headerAlign" ]=domapi.rVal(i2T25["headerAlign"],i2T25["textAlign" ]);for(var i in i2T25)this[i]=i2T25[i]};domapi.DatasetRow=function(i2T25){if(!i2T25.cells)i2T25.cells=[];i2T25["h" ]=domapi.rInt(i2T25["h" ],domapi.Dataset.prototype.defaultRowHeight);for(var i in i2T25)this[i]=i2T25[i]};domapi.DatasetCell=function(i2T25){i2T25["text" ]=domapi.rVal(i2T25["text" ],null);i2T25["value" ]=domapi.rVal(i2T25["value" ],null);for(var i in i2T25)this[i]=i2T25[i]};domapi.Dataset.prototype.loadFromJson=function(R4C0,f3msv){this.reset(f3msv);for(var i in R4C0)this[i]=R4C0[i];this.dataChanged();if(this.onloadfromjson)this.onloadfromjson()};domapi.Dataset.prototype.loadFromJsonUrl=function(url,f3msv){var k$Vu=domapi.urlToJson(url);this.loadFromJson(k$Vu,f3msv)};domapi.Dataset.prototype.saveToJson=function(){return{cols:this.cols,rows:this.rows}};domapi.Dataset.prototype.loadFromCsv=function(e95,f3msv,y91){this.reset(f3msv);var Fyr=domapi.csvToArray(e95);if(Fyr.length){var i,k$Vu,top,R;if(y91){for(i=0;i<Fyr[0].length;i++)this.cols.push({text:'Col'+i,fieldName:'Col'+i})}else{for(i=0;i<Fyr[0].length;i++)this.cols.push({text:Fyr[0][i],fieldName:Fyr[0][i]})}top=y91?0:1;for(i=top;i<Fyr.length;i++){R={cells:[]};for(k$Vu=0;k$Vu<Fyr[i].length;k$Vu++)R.cells.push({text:Fyr[i][k$Vu],value:Fyr[i][k$Vu]});this.rows.push(R)}}this.dataChanged();if(this.onloadfromcsv)this.onloadfromcsv()};domapi.Dataset.prototype.loadFromCsvUrl=function(url,f3msv,y91){var s=domapi.getContent(url);this.loadFromCsv(s,f3msv,y91)};domapi.Dataset.prototype.saveToCsv=function(y91){var r="";var i,k$Vu,Fyr,top;if(!y91){Fyr=[];for(i=0;i<this.cols.length;i++)Fyr.push(this.cols[i].fieldName);r+=domapi.arrayToCsvLine(Fyr)}for(i=0;i<this.rows.length;i++){if(i||!y91)r+="\n";Fyr=[];for(k$Vu=0;k$Vu<this.cols.length;k$Vu++)Fyr.push(this.getValue(i,k$Vu));r+=domapi.arrayToCsvLine(Fyr)}return r};domapi.Dataset.prototype.loadFromXml=function(yF034,mvq4,f3msv){this.reset(f3msv);var C=yF034.documentElement.selectNodes("//"+mvq4);if(C.length!=1){throw new Error(domapi.formatGetString('ERR_MISSING_XML_ROOT',[mvq4]));return false}if(this.onloadfromxml)this.onloadfromxml();return this.loadFromXmlNode(C[0])};domapi.Dataset.prototype.loadFromXmlUrl=function(url,mvq4,f3msv){var yF034=domapi.xml.getDomDocument();yF034.async=false;yF034.load(url);if(this.onloadfromxml)this.onloadfromxml();return this.loadFromXml(yF034,mvq4,f3msv)};domapi.Dataset.prototype.loadFromXmlNode=function(i64R){var k$Vu=domapi.xmlNodeToJson(i64R);this.loadFromJson(k$Vu,true);var C=this.cols};domapi.Dataset.prototype.saveToXml=function(X0P3,Pv9uJ){X0P3=domapi.rVal(X0P3,"dataset");return domapi.jsonToXml(this,X0P3,Pv9uJ)};