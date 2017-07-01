<%@ page language = "java" %>
<%@ page import="com.hps.july.sitedoc.valueobject.SiteDocObject,

                 org.apache.struts.util.RequestUtils,
                 com.hps.july.sitedoc.valueobject.EquipmentObject"%>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<SCRIPT>
<%--
function checkAll(select , objId) {
    for (var i = 0; i < document.forms.length; i++) {
        for (var j = 0; j < document.forms[i].elements.length; j++) {
            if (document.forms[i].elements[j].id == objId) {
                document.forms[i].elements[j].checked = select;
            }
        }
    }
}
function checkAll_Search(select , objId) {
    for (var i = 0; i < document.forms.length; i++) {
        for (var j = 0; j < document.forms[i].elements.length; j++) {
            if (document.forms[i].elements[j].id == objId) {
                document.forms[i].elements[j].checked = select;
                document.forms[i].elements[j].disabled= select
            }
        }
    }
}
--%>
function checkAll(select, groupId){

   for(var i=0; i< document.all.item(groupId).length; i++){
              document.all.item(groupId)[i].checked=select;
   }
}

</SCRIPT>

<% //String gColSpan = "6";

String gColSpan = request.getAttribute("colspan")+"";
%>
       <!-- Table header -->
        <tr class="title">
            <july:headercolumn  key="SiteDocEquipmentList.table.type" colType="string"/>

            <july:sortcolumn key="SiteDocEquipmentList.table.number" colType="string"
                   ascFinder="1" descFinder="2" />
            <july:sortcolumn key="SiteDocEquipmentList.table.name" colType="string"
                   ascFinder="3" descFinder="4" />
            <july:headercolumn key="SiteDocEquipmentList.table.position"  colType="string"/>
            <july:headercolumn key="SiteDocEquipmentList.table.address"  colType="string"/>
			<TD class="title">
<INPUT type=checkbox class=editcheckbox value='true' name='isAllEquipment' id='isAllEquipmentId'
 onclick='checkAll(this.checked ,"isEquipmentId" )' />
            </TD>
        </tr>


<july:separator colspan="<%= gColSpan %>" />


        <!-- Table body -->

        <logic:iterate id="obj" name="browseList">
	      <logic:present name="obj">
<%
	EquipmentObject ob=(EquipmentObject)pageContext.getAttribute("obj");
%>
            <tr class="normal" onMouseOver="className='select'" onMouseOut="className='normal'">
                <td class="text">
                    	<bean:write name="obj" property="typeName" filter="true"/>
				</td>
                <td class="text">
                        <bean:write name="obj" property="number" filter="true"/>
				</td>
                <td class="text">
                        <bean:write name="obj" property="name" filter="true"/>
				</td>
                <td class="text">
                        <bean:write name="obj" property="posName" filter="true"/>
				</td>
                <td class="text">
                        <bean:write name="obj" property="address" filter="true"/>
				</td>

<td class="link">
 <INPUT  type=checkbox class=editcheckbox value='<%=ob.getId()%>' name='check_add' id='isEquipmentId'/>
</td>

</tr>

<july:separator colspan="<%= gColSpan %>" />

	      </logic:present>
        </logic:iterate>

