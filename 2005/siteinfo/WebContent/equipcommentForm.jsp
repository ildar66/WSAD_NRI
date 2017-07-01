<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

 
<july:editform action="/ProcessEquipComment.do">


<table class="main">

  <july:errors/>
  
  <html:hidden property="storagecard"/>
  
	<july:separator/>
    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text" colspan="2"><bean:message key="label.equipdet.comment"/>:</td>
    </tr>
    <tr>
        <td colspan="2">
          <july:textarea property="comment" cols="50" rows="3" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>

    <tr class="title">
        <td colspan="2"><INPUT TYPE="IMAGE" NAME="submit" SRC="/images/save.gif"
          ALT="Сохранить">&nbsp;<A HREF="equipcommentSuccess.jsp"
            TITLE="Отказ и возврат"><IMG SRC="/images/cancel.gif" ALT="Отказ и возврат"
            BORDER="0"></td>
    </tr>

    <july:separator/>
</table>

</july:editform>

