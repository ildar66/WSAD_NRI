<%@ page language = "java" %>

<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>



<FORM METHOD=POST ACTION="ibm_security_logout">

<INPUT TYPE="HIDDEN" name="logoutExitPage" VALUE="/main.do">



<table class="main">

    <tr>

        <td class="text"><bean:message key="label.logout.id"/>:</td>

    </tr>

    <tr>

        <td class="probel" colspan="2"><img src="images/empty.gif" width="1" height="1" border="0" alt=""></td>

    </tr>

</table>



<CENTER>

  <INPUT TYPE="submit" NAME="logout" VALUE='<bean:message key="button.logout"/>'>

</CENTER>

</FORM>



