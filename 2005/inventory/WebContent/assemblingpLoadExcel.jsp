<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.inventory.formbean.*"%>


<july:editform action="/ProcessAssemblingPLoadExcel.do" enctype="multipart/form-data">

<table class="main">   
    
    <july:separator/>
     <tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/loadexcel.gif" alt="Загрузить" onclick="document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; }">&nbsp;<july:backbutton/>
	</td>
    </tr>
   
    <july:separator/>
    <tr>
        <td class="title" colspan="2"><FONT class="attention">Будут созданы строки документа</FONT></td>
    </tr>

    <july:separator/>

    <tr>
        <td class="text">Файл для загрузки:</td>
        <td>		
		<html:file styleClass="editbig" name="AssemblingPLoadXlsForm" property="xslFile"></html:file>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr class="title">
	<td colspan="2">
		<input type="image" name="submit" src="/images/loadexcel.gif" alt="Загрузить" onclick="document.body.style.cursor='wait';if (document.forms(0).elements('wasposted').value == 1) { alert('Запрос уже отправлен на сервер пожалуйста подождите'); return false; } else { document.forms(0).elements('wasposted').value=1; }">&nbsp;<july:backbutton/>
	</td>
    </tr>
   
    <july:separator/>
    
</table>

</july:editform>