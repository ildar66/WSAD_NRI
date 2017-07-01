        function SelectableTable() {
            this._item = null;
            this._selectedId = null;
            this._itype = null;
            this._normalClass = 'normal';
            this._selectedClass = 'color3';
            this._row = null;
            this._previousRow = null;
            this._retparams = null;
            this._paramName = null;
            this._anchorName = 'p';

            return this;
        }
////////////////////////
        SelectableTable.prototype.getAnchorName = function() {
            return this._anchorName;
        }
        SelectableTable.prototype.setAnchorName = function(anchorName) {
            this._anchorName = anchorName;
        }
        SelectableTable.prototype.getParamName = function() {
            return this._paramName;
        }
        SelectableTable.prototype.setParamName = function(paramName) {
            this._paramName = paramName;
        }
        SelectableTable.prototype.getRetparams = function() {
            if(this._selectedId) {
                this._retparams = 'retparams=(' + this._paramName + '=' + this._selectedId + '%23p' + this._selectedId + ')';
            }
            return this._retparams;
        }
        SelectableTable.prototype.getSelectedClass = function() {
            return this._selectedClass;
        }
        SelectableTable.prototype.setSelectedClass = function(className) {
            this._selectedClass = className;
        }
        SelectableTable.prototype.getNormalClass = function() {
            return this._normalClass;
        }
        SelectableTable.prototype.setSelectedId = function(id) {
            this._selectedId = id;
        }
        SelectableTable.prototype.getSelectedId = function() {
            return this._selectedId;
        }
        SelectableTable.prototype.setRowSelected = function(row) {
            //alert('setRowSelectedById');
            var c = 1;
            var parentElement = row.parentNode;
            while((parentElement && parentElement.nodeName != 'TABLE') || c > 3) {
                parentElement = parentElement.parentNode;
                c++;
            }
            //alert(parentElement.getAttribute('id')+' '+this._item.getAttribute('id'));
            document.getElementById(this._item.getAttribute('id'));

            if(parentElement && parentElement == this._item) {
                if(this._row) {
                    var trClassName = this._row.getAttribute('classReal');
                    if(trClassName) {
                        this._row.className = trClassName;
                    } else {
                        this._row.className = this._normalClass;
                    }
                }
                this._row = row;
                this._row.className = this._selectedClass;
                id = row.getAttribute('selectableID');
                if(id) {
                    this.setSelectedId(id);
                }
                   var listTR = parentElement.getElementsByTagName('TR');
                   var pRow = null;
                   var nRow = null;

                    for(var i = 0; i < listTR.length; i++) {
                        if(this._row) {
                            if(listTR[i].getAttribute('selectableID')) {
                                if(listTR[i] == this._row) {
                                    if(((i + 1) < listTR.length)) {
                                        var y = i;
                                        while(y++ < listTR.length) {
                                            if(listTR[y] && listTR[y].getAttribute('selectableID')) {
                                                nRow = listTR[y];
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                } else { pRow = listTR[i]; }
                            }
                        }
                    }
                    if(nRow != null) this._previousRow = nRow;
                    else if(pRow != null) this._previousRow = pRow;
                    else this._previousRow = this._row;
                    var spn = document.getElementById('selectable_' + this._paramName);
                    if(spn) {
                        var spn_value = spn.getAttributeNode('value');
                        if(this._row) spn_value.value = this._row.getAttribute('selectableID');
                    }
                    var spnn = document.getElementById('selectable_' + this._paramName + '_next');
                    if(spnn) {
                        var spnn_value = spnn.getAttributeNode('value');
                        if(this._previousRow) spnn_value.value = this._previousRow.getAttribute('selectableID');
                    }
            }
            //alert(this.getURL('delete', 'dd.txt'));
        }
        SelectableTable.prototype.setRowSelectedById = function(byId) {
            //alert('setRowSelectedById');
            var c = 1;
            var row = document.getElementById(byId);
            if(row) {
                var parentElement = row.parentNode;
                while((parentElement && parentElement.nodeName != 'TABLE') || c > 3) {
                    parentElement = parentElement.parentNode;
                    c++;
                }
                //alert(parentElement.getAttribute('id')+' '+this._item.getAttribute('id'));
                document.getElementById(this._item.getAttribute('id'));

                if(parentElement && parentElement == this._item) {
                    if(this._row) {
                        var trClassName = this._row.getAttribute('classReal');
                        if(trClassName) {
                            this._row.className = trClassName;
                        } else {
                            this._row.className = this._normalClass;
                        }
                    }
                    this._row = row;
                    this._row.className = this._selectedClass;
                    id = row.getAttribute('selectableID');
                    if(id) {
                        this.setSelectedId(id);
                    }
                       var listTR = parentElement.getElementsByTagName('TR');
                       var pRow = null;
                       var nRow = null;

                        for(var i = 0; i < listTR.length; i++) {
                            if(this._row) {
                                if(listTR[i].getAttribute('selectableID')) {
                                    if(listTR[i] == this._row) {
                                        if(((i + 1) < listTR.length)) {
                                            var y = i;
                                            while(y++ < listTR.length) {
                                                if(listTR[y] && listTR[y].getAttribute('selectableID')) {
                                                    nRow = listTR[y];
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    } else { pRow = listTR[i]; }
                                }
                            }
                        }
                        if(nRow != null) this._previousRow = nRow;
                        else if(pRow != null) this._previousRow = pRow;
                        else this._previousRow = this._row;
                        var spn = document.getElementById('selectable_' + this._paramName);
                        if(spn) {
                            var spn_value = spn.getAttributeNode('value');
                            if(this._row) spn_value.value = this._row.getAttribute('selectableID');
                        }
                        var spnn = document.getElementById('selectable_' + this._paramName + '_next');
                        if(spnn) {
                            var spnn_value = spnn.getAttributeNode('value');
                            if(this._previousRow) spnn_value.value = this._previousRow.getAttribute('selectableID');
                        }
                }
            }
            //alert(this.getURL('delete', 'dd.txt'));
        }
        SelectableTable.prototype.setSelectedRow = function() {
            if(this._item && this._selectedId) {
                var list2 = this._item.getElementsByTagName('TR'); //'rows' can be
                for (var i = 0; i < list2.length; i++) {
                    if(list2[i].nodeName == 'TR') {
                        var selectableID = list2[i].getAttribute('selectableID');
                        if(selectableID && this._selectedId == selectableID) {
                            this.setRowSelected(list2[i]);
                        }
                    }
                }
            }
        }
        SelectableTable.prototype.setItem = function(table) {
            this._item = table;
            if(this._item) {
                if(this._item.getAttribute('itype') && this._item.getAttribute('itype') == 'selectableTable') {
                    this._itype = this._item.getAttribute('itype');
                    var listTR = this._item.getElementsByTagName('TR'); //'rows' can be
                    for (var i = 0; i < listTR.length; i++) {
                        if(listTR[i].nodeName == 'TR' && listTR[i].getAttribute('selectableID')) {
                            listTR[i].onmouseout = function() {
                                var c = 1;
                                var parentElement = this.parentNode;
                                while((parentElement && parentElement.nodeName != 'TABLE') || c > 3) {
                                    parentElement = parentElement.parentNode;
                                    c++;
                                }
                                if(parentElement && parentElement.getAttribute('itype') == 'selectableTable' && parentElement.getAttribute('modelName')) {
                                    id = this.getAttribute('selectableID');
                                    var trClassName = this.getAttribute('classReal');
                                    //alert(trClassName);
                                    if(id && eval(parentElement.getAttribute('modelName') +'.getSelectedId()') && eval(parentElement.getAttribute('modelName') +'.getSelectedId()') == id) {
                                        this.className = eval(parentElement.getAttribute('modelName') +'.getSelectedClass()');
                                    } else {
                                        if(trClassName) {
                                            this.className = trClassName;
                                        } else {
                                            this.className = eval(parentElement.getAttribute('modelName') +'.getNormalClass()');
                                        }

                                    }
                                }
                            }
                            listTR[i].onclick = function() {
                                var c = 1;
                                var parentElement = this.parentNode;
                                while((parentElement && parentElement.nodeName != 'TABLE') || c > 3) {
                                    parentElement = parentElement.parentNode;
                                    c++;
                                }
                                if(parentElement && parentElement.getAttribute('itype') == 'selectableTable' && parentElement.getAttribute('modelName')) {
                                    var id = this.getAttribute('selectableID');
                                    if(id) {
                                        eval(parentElement.getAttribute('modelName') +'.setSelectedId('+id+')');
                                        var byId = this.getAttribute('id');
                                        if(byId) eval(parentElement.getAttribute('modelName') +'.setRowSelectedById(\''+byId+'\')');
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        SelectableTable.prototype.getItem = function() {
            return this._item;
        }
        SelectableTable.prototype.getProfileString = function(prevUrl, s) {
            var params = '';
            var inputs = document.getElementsByTagName('INPUT');
            for (var i = 0; i < inputs.length; i++) {
                if(inputs[i] && inputs[i].getAttribute('id') && inputs[i].getAttribute('name')) {
                    var name = inputs[i].getAttribute('name');
                    if(name.indexOf('selectable_') != -1) {
                        value = inputs[i].getAttribute('value');
                        //alert(document.getElementById(name).getAttribute('name') + ' ' + document.getElementById(name).getAttribute('value'));
                        if(value && value.length > 0) {
                            if(params && params.length > 0) params += '|';
                            params += (name + '=' + value);
                        }
                    }
                }
            }
            if(s && s.length > 0) {
                if(params && params.length > 0) params += '|';//'%26';
                params += ('action_=' + s);
            }
            if(params && params.length > 0) params += '|';//'%26';
            params += ('anchor_name=' + this._paramName);
            if(params && params.length > 0) params += '|';//'%26';
            params += ('param_name=' + this._paramName);
            params = ('profile_param=(' + params + ')');
            var main = ''
            if(prevUrl) {
                var i1 = prevUrl.indexOf('?');
                var i = prevUrl.indexOf('#');
                var anchor1 = '';
                if(i != -1) anchor1 = prevUrl.substring(i + 1);
                if(i1 != -1) {
                    main = prevUrl.substring(0, i1);
                } else {
                    if(i != -1) main = prevUrl.substring(0, i + 1);
                    else main = prevUrl;
                }
                var params2 = '';
                if(i1 != -1) {
                    if(i != -1) params2 = prevUrl.substring(i1 + 1, i);
                    else params2 = prevUrl.substring(i1 + 1);
                }
                if(params2.length > 0) {
                    main = main + '?' + params2;
                    main = main + '&' + params;
                } else main = main + '?' + params;
                if(anchor1.length > 0) main = main + '#' + anchor1;
            }
            //alert(params);
            return main;
        }
///////////////////////
