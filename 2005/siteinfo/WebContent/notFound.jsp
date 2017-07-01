<html><meta></meta><body>
<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld" prefix="alex" %>
<p style="font-size: medium; text-align: center; color: Red;"><br><br><br>
<logic:equal parameter="namedValue" value="WayMapDocType" scope="request">
<bean:message key="word.label.nocardpass"/>
</logic:equal>
<logic:equal parameter="namedValue" value="PassListDocType" scope="request">
<bean:message key="word.labal.nolispass"/>
</logic:equal>

</body></html>