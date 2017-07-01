<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<SCRIPT language="javascript">
  window.location.href="/ShowTaskList.do";
</SCRIPT>

<FORM METHOD=POST ACTION="j_security_check">

<table class="main">
    <tr>
        <td class="text"><bean:message key="label.login.id"/>:</td>
        <td>
          <INPUT TYPE="TEXT" class="search" name="j_username" size="15">
        </td>
    </tr>
    <tr>
        <td class="probel" colspan="2"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
    </tr>
    <tr>
        <td class="text"><bean:message key="label.login.psw"/>:</td>
        <td>
          <INPUT TYPE="PASSWORD" Class="search" size="15" name="j_password">
        </td>
    </tr>
    <tr>
        <td class="probel" colspan="2"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td>
    </tr>
</table>

<CENTER>
  <INPUT TYPE="submit" NAME="login" VALUE='<bean:message key="button.login"/>'>
</CENTER>
</FORM>

