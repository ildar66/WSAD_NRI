<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>


<table class="main">

	<july:separator/>

    <tr class="title">
        <td class="title">&nbsp;</td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text">
        
        
      <H2>Данные от оборудования на позиции</H2>
      <H3>GSM ID: <%= request.getParameter("gsmid") %> <%= request.getParameter("posname") %><BR>

      <BR>
      <BR> Нет данных из системы OSS
        </td>
    </tr>
    
    <july:separator/>
    
    <tr class="title">
        <td class="title">&nbsp;</td>
    </tr>

    <july:separator/>
    
</table>


