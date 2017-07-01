<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessTyperesponsibility.do">

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
           <july:string property="responsibilityType" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    <july:separator/>
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.name"/>:</july:reqmark></td>
        <td>
          <july:string property="name" size="50" insertable="true" updatable="true" />
        </td>
    </tr>
    <july:separator/>
    <tr>
        <td class="text"><bean:message key="label.typeresponsibility.isprint"/>:</td>
        <td>
          <july:checkbox property="isPrint" insertable="true" updatable="true" />
        </td>
    </tr>
    <july:separator/>
    <july:formbuttons/>
    <july:separator/>
</table>
</july:editform>



