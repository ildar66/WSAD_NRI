<%@ page language = "java" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<% java.lang.String gColSpan = "6"; %>

<july:separator colspan="<%= gColSpan %>" />

<SCRIPT>
function checkAll(select , objname) {
    for (var i = 0; i < document.forms.length; i++) {
        for (var j = 0; j < document.forms[i].elements.length; j++) {
            if (document.forms[i].elements[j].name == objname) {
                document.forms[i].elements[j].checked = select;
            }
        }
    }
}

function selectcheckboxes(type){
    if(type.name == 'planreadall'){
        checkAll(type.checked , 'viewplan');
		if (!type.checked) {
			checkAll(false , 'editplan');
			document.all.item('planwriteall', 0).checked = false;
		}
    }
    if(type.name == 'planwriteall'){
        checkAll(type.checked , 'editplan');
		if (type.checked) {
			checkAll(true , 'viewplan');
			document.all.item('planreadall', 0).checked = true;
		}
    }
    if(type.name == 'factreadall'){
        checkAll(type.checked , 'viewfact');
		if (!type.checked) {
			checkAll(false , 'editfact');
			document.all.item('factwriteall', 0).checked = false;
		}
    }
    if(type.name == 'factwriteall'){
        checkAll(type.checked , 'editfact');
		if (type.checked) {
			checkAll(true , 'viewfact');
			document.all.item('factreadall', 0).checked = true;
		}
    }
}
</SCRIPT>


<!-- Table header  begin :-->
<tr class="title">
       <td  class="title" rowspan='2'><bean:message key="label.superregion.code"/></td>
       <td  class="title" rowspan='2'><bean:message key="label.superregion.name"/></td>
        <td  colspan='2' class="title">
                        <bean:message key="label.superregion.planData"/>
        </td>
        <td  colspan='2' class="title">
                        <bean:message key="label.superregion.factData"/>
        </td>

</tr>

<tr class="title">
       <td class="title">
           <bean:message key="label.superregion.read"/> <br>
           <input type="checkbox" name='planreadall' onclick="selectcheckboxes(this);">
           <bean:message key="label.superregion.all"/>
       </td>
       <td class="title">
           <bean:message key="label.superregion.write"/> <br>
           <input type="checkbox" name='planwriteall' onclick="selectcheckboxes(this);">
           <bean:message key="label.superregion.all"/>
       </td>
       <td class="title">
           <bean:message key="label.superregion.read"/> <br>
           <input type="checkbox" name='factreadall' onclick="selectcheckboxes(this);">
           <bean:message key="label.superregion.all"/>
       </td>
       <td class="title">
            <bean:message key="label.superregion.write" /> <br>
            <input type="checkbox" name='factwriteall' onclick="selectcheckboxes(this);">
            <bean:message key="label.superregion.all"/>
       </td>
</tr>


<july:separator colspan="<%= gColSpan %>" />
<!-- Table header  end :-->
