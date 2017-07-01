<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessBar.do">

<script language="JavaScript">
<!--
function recalcend() {
	var st = new Number(document.all.serstart.value);
	var ed = new Number(document.all.sercount.value);
	document.all.serend.value = st + ed;
}
//-->
</script>


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
           <july:string property="serid" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.bar.fser"/>:</july:reqmark></td>
        <td>
          <july:string property="serprefix" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.bar.fstart"/>:</july:reqmark></td>
        <td>
          <july:string property="serstart" size="15" insertable="true" updatable="true"  onchange="recalcend();"/>
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.bar.fcount"/>:</july:reqmark></td>
        <td>
          <july:string property="sercount" size="5" insertable="true" updatable="true" onchange="recalcend();" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><july:reqmark><bean:message key="label.bar.fend"/>:</july:reqmark></td>
        <td>
          <july:string property="serend" size="15" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.bar.fdate"/>:</td>
        <td>
          <july:date  property="serdateFrm" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.bar.fworker"/>:</td>
        <td>
          <july:string property="wrkcode" size="5" insertable="false" updatable="false" />
          <july:string property="wrkname" size="35" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

