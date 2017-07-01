<%@ page language = "java" %>

<%@ page import="com.hps.july.web.util.*,
		 com.hps.july.siteinfo.APPStates,
                 com.hps.july.constants.Applications,
                 com.hps.july.siteinfo.formbean.ElectroCounterForm,
                 java.util.Iterator,
                 java.util.ArrayList,
                 com.hps.july.cdbc.lib.CDBCRowObject,
                 com.hps.july.cdbc.lib.CDBCColumnObject"%>

<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<script>
    <!--
        <%
            ElectroCounterForm ecf = (ElectroCounterForm)request.getAttribute("electroCounterForm");
            Iterator iterator = ecf.getCounterModels();
        %>
            var intervals = new Array(
        <%
            while(iterator.hasNext()) {
                CDBCRowObject ro = (CDBCRowObject)iterator.next();
                if(ro != null) {
                    CDBCColumnObject co = ro.getColumn("id");
                    String id = co.asString();
                    co = ro.getColumn("verification_inter");
                    String inter = co.asString();
                    out.print(id);
                    out.print(",");
                    out.print(inter);
                    if(iterator.hasNext()) out.print(",");
                }
            }
         %>
            ); //closing array !!!

    -->
</script>
<july:editform action="/ProcessElectroCounter.do" styleId="pec" >
<html:hidden property="ignoreWarning"/>

    <table class="main">
        <july:separator colspan="1" />
		<tr>
            <td align="left" valign="middle">
                <table class="main" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tr class="title">
                        <td align="left" valign="middle">
            			    <july:formbuttons/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
		<july:separator colspan="1" />
        <tr>
            <td>
                <table style="width : 100%;">
<%--
                    <tr>
                        <td align="left" valign="middle">
                            <table style="width : 100%;">
                                <tr>
                                    <td align="left" valign="middle" style="width : 30%">Идентификатор</td>
                                    <td align="left" valign="middle" style="width : 70%">
                                        <july:string property="counterid" size="5" insertable="false" updatable="false" />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
--%>
                    <tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%"><july:reqmark>Позиция:</july:reqmark></td>
                                    <td align="left" valign="middle" style="width : 70%">
                                        <input type="hidden" name="pp"/>
                                        <html:hidden property="positionid"/>
                                        <july:string size="20" property="position" insertable="false" updatable="false"/>
                                        <july:lookupbutton action="/../basestation/ShowPositionLookupList.do?planstate=2" styleId="posl" fieldNames="positionid;position;pp;pp;zoneName;pp;pp;pp;pp;pp;pp;pp" insertable="true" updatable="true"/>
                                        <july:string size="20" property="zoneName" insertable="false" updatable="false"/>
                                        <july:string property="counterid" size="0" insertable="false" updatable="false" style="visibility : hidden; width : 0px" />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <july:separator />
                    <tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%"><july:reqmark>Номер счётчика:</july:reqmark></td>
                                    <td align="left" valign="middle" style="width : 20%">
                                        <july:string property="vendor_number" size="10" insertable="true" updatable="false" maxlength="10"/>
                                    </td>
                                    <td class="text" align="right" valign="middle" style="width : 25%"><july:reqmark>Модель счётчика:</july:reqmark></td>
                                    <td align="left" valign="middle">
                                        <july:select collection="counterModels" property="counterinfo_id" insertable="true" updatable="false" onchange="changeInterval();" style="width : 130pt">
                                            <html:option value="0">_______________</html:option>
                                            <july:options collection="counterModels" property="id" labelProperty="code" />
                                        </july:select>
                                    </td>                                    
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <july:separator />
                    <tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%"><july:reqmark>Год выпуска:</july:reqmark></td>
                                    <td align="left" valign="middle" style="width : 20%">
                                        <script>
                                            <!--
                                                function setInstallationDate() {
                                                    var DAYS_FROM_1900_TO_1970 = 25569;
                                                    var MSEC_PER_DAY = 86400000;
                                                    var inst = document.getElementById('installation_dateFrm_dt');
                                                    var prod = document.getElementById('production_year');
                                                    if(inst && prod) {
                                                        var d1 = new Date();
                                                        var f1 = d1.getFullYear();
                                                        var value = prod.value;
                                                        d1.setFullYear(parseIntFunction(value));
                                                        d1.setMonth(0);
                                                        d1.setDate(1);
                                                        setDate_installation_dateFrm(((d1.getTime() / MSEC_PER_DAY) + DAYS_FROM_1900_TO_1970));
                                                    }
                                                }
                                            -->
                                        </script>
                                        <july:string styleId="production_year" property="production_year" size="4" insertable="true" updatable="true" maxlength="4"/>
                                    </td>
                                    <td class="text" align="right" valign="middle"  style="width : 25%">Дата установки:</td>
                                    <td align="left" valign="middle">
                                        <july:date property="installation_dateFrm" styleId="installation_dateFrm" insertable="true" updatable="true"/>
                                    </td>                                    
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <july:separator />
                    <%--tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle"  style="width : 30%">Дата установки</td>
                                    <td align="left" valign="middle"  style="width : 70%">
                                        <july:date property="installation_dateFrm" styleId="installation_dateFrm" insertable="true" updatable="true"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <july:separator /--%>
                    <tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%"><july:reqmark>Начальные показания:</july:reqmark></td>
                                    <td align="left" valign="middle" style="width : 20%">
                                        <july:string styleId="initial_settingsFrm" property="initial_settingsFrm" size="10" insertable="true" updatable="true" maxlength="10"/>
                                    </td>
                                    <td align="left" valign="middle" style="width : 50%">кВт</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <july:separator />
                    <%--tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%"><july:reqmark>Модель счётчика</july:reqmark></td>
                                    <td align="left" valign="middle" style="width : 70%">
                                        <july:select collection="counterModels" property="counterinfo_id" insertable="true" updatable="true" onchange="changeInterval();" >
                                            <html:option value="0">_______________</html:option>
                                            <july:options collection="counterModels" property="id" labelProperty="code" />
                                        </july:select>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <july:separator /--%>
                    <tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%">Информация об установке:</td>
                                    <td align="left" valign="middle" style="width : 70%">
                                        <july:string styleId="place_info" property="place_info" size="40" insertable="true" updatable="true"  style="width : 380pt"/>
<%--
                                        <html:textarea property="place_info" value="place_info" rows="3" cols="50"></html:textarea>
--%>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <script>
                        <!--
                                function onChangeCState() {
                                    for(i = 0; i < document.forms[0].cstate.length; i++) {
                                        if(document.forms[0].cstate[i].checked) {
                                            var value = document.forms[0].cstate[i].value;
                                            var ra = document.getElementById('replace_all');
                                            var rc = document.getElementById('replace_counter');
                                            var rr = document.getElementById('replace_reason');
                                            var rd = document.getElementById('replace_date');
                                            var da = document.getElementById('delete_all');
                                            var dr = document.getElementById('delete_reason');
                                            var dd = document.getElementById('delete_date');
                                            if(value == 1) {
                                                if(ra) {
                                                    ra.style.visibility = 'hidden';
                                                    ra.style.display = 'none';
                                                }
                                                if(rc) {
                                                    rc.style.visibility = 'hidden';
                                                    rc.style.display = 'none';
                                                }
                                                if(rr) {
                                                    rr.style.visibility = 'hidden';
                                                    rr.style.display = 'none';
                                                }
                                                if(rd) {
                                                    rd.style.visibility = 'hidden';
                                                    rd.style.display = 'none';
                                                }
                                                if(da) {
                                                    da.style.visibility = 'hidden';
                                                    da.style.display = 'none';
                                                }
                                                if(dr) {
                                                    dr.style.visibility = 'hidden';
                                                    dr.style.display = 'none';
                                                }
                                                if(dd) {
                                                    dd.style.visibility = 'hidden';
                                                    dd.style.display = 'none';
                                                }
                                            } else if(value == 2) {
                                                if(ra) {
                                                    ra.style.visibility = 'visible';
                                                    ra.style.display = 'block';
                                                }
                                                if(rc) {
                                                    rc.style.visibility = 'visible';
                                                    rc.style.display = 'block';
                                                }
                                                if(rr) {
                                                    rr.style.visibility = 'visible';
                                                    rr.style.display = 'block';
                                                }
                                                if(rd) {
                                                    rd.style.visibility = 'visible';
                                                    rd.style.display = 'block';
                                                }
                                                if(da) {
                                                    da.style.visibility = 'hidden';
                                                    da.style.display = 'none';
                                                }
                                                if(dr) {
                                                    dr.style.visibility = 'hidden';
                                                    dr.style.display = 'none';
                                                }
                                                if(dd) {
                                                    dd.style.visibility = 'hidden';
                                                    dd.style.display = 'none';
                                                }

                                            } else if(value == 3) {
                                                if(ra) {
                                                    ra.style.visibility = 'hidden';
                                                    ra.style.display = 'none';
                                                }
                                                if(rc) {
                                                    rc.style.visibility = 'hidden';
                                                    rc.style.display = 'none';
                                                }
                                                if(rr) {
                                                    rr.style.visibility = 'hidden';
                                                    rr.style.display = 'none';
                                                }
                                                if(rd) {
                                                    rd.style.visibility = 'hidden';
                                                    rd.style.display = 'none';
                                                }
                                                if(da) {
                                                    da.style.visibility = 'visible';
                                                    da.style.display = 'block';
                                                }
                                                if(dr) {
                                                    dr.style.visibility = 'visible';
                                                    dr.style.display = 'block';
                                                }
                                                if(dd) {
                                                    dd.style.visibility = 'visible';
                                                    dd.style.display = 'block';
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                        -->
                    </script>
                    <july:separator />
                    <tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%">Состояние:</td>
                                    <td align="left" valign="middle" style="width : 20%">
                                      <july:radio property="cstate" value="1" insertable="true" updatable="true" onclick="onChangeCState();" >
                                        Активный
                                      </july:radio>
                                    </td>
                                    <td align="left" valign="middle" style="width : 20%">
                                      <july:radio property="cstate" value="2" insertable="false" updatable="true" onclick="onChangeCState();">
                                        Замененный
                                      </july:radio>
                                    </td>
                                    <td align="left" valign="middle" style="width : 30%">
                                      <july:radio property="cstate" value="3" insertable="false" updatable="true" onclick="onChangeCState();" >
                                        Демонтированный
                                      </july:radio>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <july:separator />
                    <tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%">Дата последней поверки:</td>
                                    <td align="left" valign="middle" style="width : 70%">
                                        <script>
                                            <!--
                                                function checkNextDate() {
                                                    var DAYS_FROM_1900_TO_1970 = 25569;
                                                    var MSEC_PER_DAY = 86400000;
                                                    var last = document.getElementById('last_verificationFrm_dt');
                                                    var next = document.getElementById('next_verificationFrm_dt');
                                                    var interval = document.getElementById('verification_interFrm');
                                                    if(last && next && interval) {
                                                        var d1 = new Date((last.gDate - DAYS_FROM_1900_TO_1970) * MSEC_PER_DAY);
                                                        var f1 = d1.getFullYear();
                                                        var value = interval.value;
                                                        d1.setFullYear(f1 + parseIntFunction(value));
                                                        setDate_next_verificationFrm(((d1.getTime() / MSEC_PER_DAY) + DAYS_FROM_1900_TO_1970));
                                                    }
                                                }
                                            -->
                                        </script>
                                        <july:date styleId="last_verificationFrm" property="last_verificationFrm" insertable="true" updatable="true" onchange=" checkNextDate(); " />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <july:separator />
                    <tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%">Межповерочный интервал:</td>
                                    <td align="left" valign="middle" style="width : 15%">
                                        <input type="text" name="verification_interFrm" maxlength="2" value='<bean:write name="electroCounterForm" property="verification_interFrm"/>' readonly="true" style="background-color: DCDCDC" size="4" />
                                    </td>
                                    <td class="text" align="right" valign="middle" style="width : 35%">Дата следующей поверки:</td>
                                    <td align="left" valign="middle" style="width : 20%">
                                        <july:date styleId="next_verificationFrm" property="next_verificationFrm" insertable="true" updatable="true"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <july:separator />                                        
                    <tr>
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle"  style="width : 30%">Электроснабжение:</td>
                                    <td align="left" valign="middle"  style="width : 20%">
										<july:checkbox name="electroCounterForm" property="isVendorPowerSupply" insertable="true" updatable="true"/>
                                    </td>
                                    <td class="text" align="left" valign="middle"  style="width : 50%">
                                        <logic:present name="electroCounterForm" property="modifiedByName">
                                    	  Изменил: <bean:write name="electroCounterForm" property="modifiedByName"/> <july:datewrite name="electroCounterForm" property="modifiedDate" showtime="true"/>
                                    	</logic:present>                                    
                                    </td>
	                               </tr>
                            </table>
                        </td>
                    </tr>

                    <%
                        String actionStr = request.getParameter("action");
                        if(actionStr != null && !actionStr.equalsIgnoreCase("Add")) {
                    %>
                    <tr id="replace_all" style="visibility : hidden; display : none;">
                        <td align="left" valign="middle">
                            <table class="find" style="width : 100%;">
                                <tr class="title">
                                    <td class="text" align="left" valign="middle" style="width : 100%">Замена счётчика:</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr id="replace_counter" style="visibility : hidden; display : none;">
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%">Новый счётчик:</td>
                                    <td align="left" valign="middle" style="width : 70%">
                                        <july:select collection="positionCounters" property="nextid" insertable="true" updatable="true">
                                            <html:option value="0">_______________</html:option>
                                            <july:options collection="positionCounters" property="counterid" labelProperty="vendor_number"/>
                                        </july:select>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr id="replace_reason" style="visibility : hidden; display : none;">
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%">Причина замены:</td>
                                    <td align="left" valign="middle" style="width : 70%">
                                        <july:string styleId="replace_reason" property="replace_reason" size="40" insertable="true" updatable="true" />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr id="replace_date" style="visibility : hidden; display : none;">
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%">Дата замены:</td>
                                    <td align="left" valign="middle" style="width : 20%">
                                        <july:date property="replace_dateFrm" insertable="true" updatable="true"/>
                                    </td>
                                    <td class="text" align="left" valign="middle" style="width : 35%">Конечные показания замененного:</td>
                                    <td align="left" valign="middle" style="width : 10%">
                                        <july:string property="replace_settingsFrm" size="5" insertable="true" updatable="true" maxlength="10" />
                                    </td>
                                    <td class="text" align="left" valign="middle" style="width : 5%">кВт</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr id="delete_all" style="visibility : hidden; display : none;">
                        <td align="left" valign="middle">
                            <table class="find" style="width : 100%;">
                                <tr class="title">
                                    <td class="text" align="left" valign="middle" style="width : 100%">Демонтаж счётчика:</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr id="delete_reason" style="visibility : hidden; display : none;">
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%">Причина демонтажа:</td>
                                    <td align="left" valign="middle" style="width : 70%">
                                        <july:string styleId="dismantling_reason" property="dismantling_reason" size="40" insertable="true" updatable="true" />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr id="delete_date" style="visibility : hidden; display : none;">
                        <td align="left" valign="middle">
                            <table class="main" style="width : 100%;">
                                <tr>
                                    <td class="text" align="left" valign="middle" style="width : 30%">Дата демонтажа:</td>
                                    <td align="left" valign="middle" style="width : 20%">
                                        <july:date property="dismantling_dateFrm" insertable="true" updatable="true"/>
                                    </td>
                                    <td class="text" align="left" valign="middle" style="width : 35%">Конечные показания демонтированного:</td>
                                    <td align="left" valign="middle" style="width : 10%">
                                        <july:string property="dismantling_setFrm" size="3" insertable="true" updatable="true" maxlength="10" />
                                    </td>
                                    <td class="text" align="left" valign="middle" style="width : 5%">кВт</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </td>
        </tr>
        <july:separator />
        <tr>
            <td align="left" valign="middle">
                <table class="main" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tr class="title">
                        <td align="left" valign="middle">
            			    <july:formbuttons/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <july:separator />
    </table>
</july:editform>
<script>
    <!--
        function input_checkField(obj, maxLen, maxValue, minValue, type) {
            input_checkFieldLength(obj);
            return checkType(obj, maxLen, maxValue, minValue, type);
        }
        function checkType(obj, maxLen, maxValue, minValue, type) {
            if(type == 'int') {
                var value = obj.value ;
                if (!/^[-+]?[0-9]+$/.test(value)) return false ;
                var intValue = parseIntFunction(value);
                var result = true ;
                if((minValue < 0) && intValue < minValue) result = false ;
                if((maxValue < 0) && intValue > maxValue) result = false ;
            }
            return result ;
        }
        function parseIntFunction(value) {
            var v = new String(value);
            while (v.length > 1 && v.indexOf("0") == 0) v = v.substring(1);
            return parseInt(v);
        }
        function input_checkFieldLength(obj) {
            if (obj.value.length > obj.maxLength)
                obj.value = obj.value.substring(0, obj.maxLength);
        }

        function input_setCheckField(obj, maxLen, maxValue, minValue, type, name) {
            var attrs = obj.attributes;
            var checkReadOnly = false;
            for (var i = 0; i < attrs.length; i++) {
              if (attrs[i].nodeValue && attrs[i].nodeName == 'readOnly') {
                    checkReadOnly = true;
              }
            }

            if (obj != null && obj.value != null && obj.value.length != null && obj.name != null && !checkReadOnly) {
                //alert('input name [' + obj.name + '] value [' + maxLen + ']');
                obj.maxLength = maxLen;
                obj.onblur = function(e) {
                    if(!input_checkField(obj, maxLen, maxValue, minValue, type)) {
                        alert('Поле ' + name + ' имеет некорректное зачение');
                        obj.select();
                        obj.focus();
                        return false;
                    }
                    if(obj.id == 'production_year') {
                        var value = obj.value;
                        if(parseIntFunction(value) < 1) {
                            var d1 = new Date();
                            var f1 = d1.getFullYear();
                            obj.value = f1;
                        } else if(parseIntFunction(value) < 1970) {
                            var temp = parseIntFunction(value) + 2000;
                            obj.value = temp;
                        }
                        setInstallationDate();
                    }
                };
            }
            return true;
        }



        onload = function(e) {
            changeInterval(); //Set Interval at first time;
            onChangeCState(); //set visibility of replace or delete counter at first time
            var pec1 = document.getElementById('pec');
            pec1.onsubmit = function(e) {
                var positionid = document.getElementById('positionid');
                var position = document.getElementById('position');
                var attrs = position.attributes;
                var checkReadOnly = false;
                for (var i = 0; i < attrs.length; i++) {
                  if (attrs[i].nodeValue && attrs[i].nodeName == 'readOnly') {
                        checkReadOnly = true;
                  }
                }
                if(!positionid || (positionid && positionid.value == '' && !checkReadOnly)) {
                    alert('Укажите позицию !');
                    document.forms(0).elements('wasposted').value = 0;
                    document.body.style.cursor='auto';
                    return false;
                }
                var vendor_number = document.forms[0].vendor_number.value;
                if(vendor_number == '') {
                    alert('Укажите номер счётчика!');
                    document.forms[0].vendor_number.select();
                    document.forms[0].vendor_number.focus();
                    document.forms(0).elements('wasposted').value = 0;
                    document.body.style.cursor='auto';
                    return false;
                }
                var obj1 = document.getElementById('counterinfo_id');
                if(obj1) {
                    var obj1Name = obj1.nodeName;
                    var modelCounter = 0;
                    if(obj1Name != 'INPUT') {
                        modelCounter = document.forms[0].counterinfo_id.options[document.forms[0].counterinfo_id.selectedIndex].value;
                    } else {
                        modelCounter = document.forms[0].counterinfo_id.value;
                    }
                    if(modelCounter && (modelCounter == 0 || modelCounter == '')) {
                        alert('Укажите модель счётчика!');
                        document.forms[0].counterinfo_id.focus();
                        document.forms(0).elements('wasposted').value = 0;
                        document.body.style.cursor='auto';
                        return false;
                    }
                }

                if(!checkType(document.forms[0].initial_settingsFrm, 10, 9999999999, 1, 'int')) {
                    alert('Укажите начальное значение счётчика !');
                    document.forms[0].initial_settingsFrm.value = 0;
                    document.forms[0].initial_settingsFrm.select();
                    document.forms[0].initial_settingsFrm.focus();
                    document.forms(0).elements('wasposted').value = 0;
                    document.body.style.cursor='auto';
                    return false;
                }

                for(i = 0; i < document.forms[0].cstate.length; i++) {
                    if(document.forms[0].cstate[i].checked) {
                        var value = document.forms[0].cstate[i].value;
                        if(value == '2') {
                            var nextid = document.forms[0].nextid[document.forms[0].nextid.selectedIndex].value;
                            if(nextid == 0) {
                                alert('Укажите счётчик на который происходит замена !');
                                document.forms(0).elements('wasposted').value = 0;
                                document.body.style.cursor='auto';
                                return false;
                            }
                            if(document.forms[0].replace_reason.value == '') {
                                alert('Укажите причину замены !');
                                document.forms[0].replace_reason.focus();
                                document.forms(0).elements('wasposted').value = 0;
                                document.body.style.cursor='auto';
                                return false;
                            }
                            if(!checkType(document.forms[0].replace_settingsFrm, 10, 9999999999, 1, 'int')) {
                                alert('Укажите конечное значение заменённого счётчика !');
                                document.forms[0].replace_settingsFrm.value = 0;
                                document.forms[0].replace_settingsFrm.select();
                                document.forms[0].replace_settingsFrm.focus();
                                document.forms(0).elements('wasposted').value = 0;
                                document.body.style.cursor='auto';
                                return false;
                            }
                        } else {
                            if(value == '3') {
                                if(document.forms[0].dismantling_reason.value == '') {
                                    alert('Укажите причину демонтажа счётчика !');
                                    document.forms[0].dismantling_reason.select();
                                    document.forms[0].dismantling_reason.focus();
                                    document.forms(0).elements('wasposted').value = 0;
                                    document.body.style.cursor='auto';
                                    return false;
                                } else {
                                    if(!checkType(document.forms[0].dismantling_setFrm, 10, 9999999999, 1, 'int')) {
                                        alert('Укажите конечное значение демонтированного счётчика !');
                                        document.forms[0].dismantling_setFrm.value = 0;
                                        document.forms[0].dismantling_setFrm.select();
                                        document.forms[0].dismantling_setFrm.focus();
                                        document.forms(0).elements('wasposted').value = 0;
                                        document.body.style.cursor='auto';
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }


            var DAYS_FROM_1900_TO_1970 = 25569;
            var MSEC_PER_DAY = 86400000;
            var obj = document.getElementById('verification_interFrm');
            if(obj) {
                input_setCheckField(obj, 2, 99, 1, 'int', '\'Межповерочный интервал\'');
                var last = document.getElementById('last_verificationFrm_dt');
                var next = document.getElementById('next_verificationFrm_dt');
                if(last && next) {
                    var d1 = new Date((last.gDate - DAYS_FROM_1900_TO_1970) * MSEC_PER_DAY);
                    var f1 = d1.getFullYear();
                    var value = obj.value;
                    d1.setFullYear(f1 + parseIntFunction(value));
                    setDate_next_verificationFrm(((d1.getTime() / MSEC_PER_DAY) + DAYS_FROM_1900_TO_1970));
                }
                obj.onchange = function(e) {
                    var last = document.getElementById('last_verificationFrm_dt');
                    var next = document.getElementById('next_verificationFrm_dt');
                    if(last && next) {
                        var d1 = new Date((last.gDate - DAYS_FROM_1900_TO_1970) * MSEC_PER_DAY);
                        var f1 = d1.getFullYear();
                        var value = this.value;
                        d1.setFullYear(f1 + parseIntFunction(value));
                        setDate_next_verificationFrm(((d1.getTime() / MSEC_PER_DAY) + DAYS_FROM_1900_TO_1970));
                    }
                }
            }

            var next1 = document.getElementById('next_verificationFrm_dt');
            if(next1) {
                next1.onfocus = function(e) {
                    alert('Дата следующей поверки изменяется автоматически !');
                    document.forms[0].verification_interFrm.focus();
                    return false;
                }
            }

            obj = document.getElementById('production_year');
            if(obj) {
                input_setCheckField(obj, 4, 9999, 1, 'int', '\'Год выпуска\'');
            }
            obj = document.getElementById('initial_settingsFrm');
            if(obj) input_setCheckField(obj, 10, 9999999999, 1, 'int', '\'Начальные установки\'');
            obj = document.getElementById('replace_settingsFrm');
            if(obj) input_setCheckField(obj, 10, 9999999999, 1, 'int', '\'Конечные установки заменённого счётчика\'');
            obj = document.getElementById('dismantling_setFrm');
            if(obj) input_setCheckField(obj, 10, 9999999999, 1, 'int', '\'Конечные установки демонтированного счётчика\'');
            document.body.style.cursor='auto';
        }

        function changeInterval() {
            var DAYS_FROM_1900_TO_1970 = 25569;
            var MSEC_PER_DAY = 86400000;
            var obj = document.getElementById('verification_interFrm');
            if(obj) {
                var obj1 = document.getElementById('counterinfo_id');
                if(obj1) {
                    var obj1Name = obj1.nodeName;
                    var v1 = 0;
                    if(obj1Name != 'INPUT') {
                        v1 = document.forms[0].counterinfo_id.options[document.forms[0].counterinfo_id.selectedIndex].value;
                    } else {
                        v1 = document.forms[0].counterinfo_id.value;
                    }
                    for (var i1 = 0; i1 < intervals.length; i1+=2) {
                        if(intervals[i1] == v1) {
                            if(intervals[i1 + 1]) {
                                var newInterval = intervals[i1 + 1];
                                obj.value = newInterval;
                                var last = document.getElementById('last_verificationFrm_dt');
                                var next = document.getElementById('next_verificationFrm_dt');
                                if(last && next) {
                                    var d1 = new Date((last.gDate - DAYS_FROM_1900_TO_1970) * MSEC_PER_DAY);
                                    var f1 = d1.getFullYear();
                                    var value = newInterval;
                                    d1.setFullYear(f1 + parseIntFunction(value));
                                    setDate_next_verificationFrm(((d1.getTime() / MSEC_PER_DAY) + DAYS_FROM_1900_TO_1970));
                                }
                            }
                        }
                    }
                }
            }
        }

    -->
</script>