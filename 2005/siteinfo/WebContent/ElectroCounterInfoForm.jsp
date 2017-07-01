<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessElectroCounterInfo.do" styleId="pec">
<table class="main">
<july:separator/>

	<july:formbuttons/>

    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.code"/>:</july:reqmark></td>
        <td>
           <july:string property="id" size="5" insertable="false" updatable="false" />
        </td>
    </tr>

<july:separator/>
<tr>
  <td class="text"><july:reqmark><bean:message key="label.electroCounterInfo.table.code"/></july:reqmark></td>
  <td>
    <july:string property="code" size="50" insertable="true" updatable="true" />
        </td>
    </tr>
    <july:separator/>
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.electroCounterInfo.table.name"/>:</july:reqmark></td>
        <td>
          <july:string property="name" size="50" insertable="true" updatable="true" />
        </td>
    </tr>
    <july:separator/>
    <tr>
        <td class="text"><july:reqmark>Интервал поверки<%--<bean:message key="label.electroCounterInfo.table.ver_interval"/>--%>:</july:reqmark></td>
        <td>
          <july:string styleId="verification_interFrm" property="verification_interFrm" size="4" insertable="true" updatable="true" maxlength="2" />
        </td>
    </tr>

    <july:separator/>

    <july:formbuttons/>

    <july:separator/>

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
                obj.maxLength = maxLen;
                obj.onchange = function(e) {
                    if(!input_checkField(obj, maxLen, maxValue, minValue, type)) {
                        alert('Поле ' + name + ' имеет некорректное зачение');
                        obj.select();
                        obj.focus();
                        return false;
                    }
                };
            }
            return true ;
        }

        onload = function(e) {
            var DAYS_FROM_1900_TO_1970 = 25569;
            var MSEC_PER_DAY = 86400000;
            var obj = document.getElementById('verification_interFrm');
            if(obj) {
                input_setCheckField(obj, 2, 99, 1, 'int', '\'Интервал поверки\'');
            }
            document.body.style.cursor='auto';
        }

        var pec2 = document.getElementById('pec');
        if(pec2) {
            pec2.onsubmit = function(e) {
                var viFrm = document.getElementById('verification_interFrm');
                if(!input_checkField(viFrm, 2, 99, 1, 'int')) {
                    alert('Поле \'Интервал поверки\' имеет некорректное зачение');
                    viFrm.select();
                    viFrm.focus();
                    document.body.style.cursor='auto';
                    return false;
                }
            };
        }

    -->
</script>



