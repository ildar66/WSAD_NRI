<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

  <TABLE class="main" border="0" cellpadding="0" cellspacing="0" vAlign=top>
	<july:errors/>
  </TABLE>

<FORM METHOD=POST ACTION="j_security_check" onsubmit='if (document.all.wasposted.value=="1") {alert("<bean:message key="label.wasposted"/>"); return false;} else {document.all.wasposted.value="1";}'>

<INPUT TYPE="HIDDEN" NAME="wasposted" VALUE="0">

<table class="main">
    <tr class="title">
    	<td class="title" colspan="2">
           <bean:message key="label.registration"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.login.id"/>:</td>
        <td>
          <INPUT TYPE="TEXT" class="search" name="j_username" size="15">
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.login.psw"/>:</td>
        <td>
          <INPUT TYPE="PASSWORD" Class="search" size="15" name="j_password">
        </td>
    </tr>
    
    <july:separator/>
    
</table>

<CENTER>
  <INPUT TYPE="submit" NAME="login" VALUE='<bean:message key="button.login"/>'>&nbsp;
  <BUTTON onclick="window.close()"><bean:message key="button.exit"/></BUTTON>&nbsp;
  <BUTTON onclick="window.open('/info/information.html', '_blank', 'top=20, left=20, width=1000, height=720, scrollbars=yes, resizable=yes'); return false;">Информация</BUTTON>
  <BR>
  <IMG SRC="/images/main3.gif" border=0 alt="">
  <BR>
  <IFRAME src="/infoNRI.html" align="middle" height="300" width="800"></IFRAME>  
</CENTER>
</FORM>

<SCRIPT language="JavaScript">
   document.all.j_username.focus();
</SCRIPT>
