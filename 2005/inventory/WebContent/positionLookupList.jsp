<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%@ page import="org.apache.struts.util.*"%>
<%@ page import="com.hps.july.siteinfo.valueobject.*"%>
<%@ page import="com.hps.july.siteinfo.formbean.*"%>

<july:lookupresult tableId="brtable" resultCols="6;17;2;18;19;20;21;22"/>

<july:browseform action="/ShowPositionLookupList.do" styleId="PosForm">

<table class="main"> 

<%@ include file="/positionLookupList/header.jsp"%>
<%@ include file="/positionLookupList/fields.jsp"%>
<%@ include file="/positionLookupList/formbuttonsTop.jsp"%>
<%@ include file="/positionLookupList/table.jsp"%>
<%@ include file="/positionLookupList/formbuttonsBottom.jsp"%>

</table>

</july:browseform>
