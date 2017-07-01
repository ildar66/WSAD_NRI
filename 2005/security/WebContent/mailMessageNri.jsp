<%@ page language = "java"%>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<SCRIPT language=javascript src="/common/validate.js" type="text/javascript"></SCRIPT>

<july:editform action="/MailMessageNriProcess.do">
<script language='javascript'>
function Check(){
	var theForm = document.forms[0];
	with(theForm){
		if(!field_check(theForm['hour'], 'Кол-во часов', 3, true)) return false;
		if(!field_check(theForm['vo.topic'], 'Тема', 0, true)) return false;
		if(!field_check(theForm['vo.text'], 'Текст', 0, true)) return false;
	}						
	return true;
}
</script>

<table class="main" style="font-size: 9pt">
	<tr class="title">
		<td class="title" colspan="2">
	       <july:currmark>Оповещение пользователей</july:currmark></td>
	</tr>
	
    <july:separator/>
    <tr>
        <td class="title" colspan="2">
        	<july:reqmark>Фильтр: Кол-во часов, в течении который пользователи были активны</july:reqmark>
        	<july:string property="hour" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    <tr>
        <td class="title"><july:reqmark>Шаблон:</july:reqmark></td>
        <td>
           <july:string property="vo.templateName" size="50" insertable="false" updatable="false" />
        </td>
    </tr>
    
    <july:separator/>
    <tr>
        <td class="title"><july:reqmark>Тема:</july:reqmark></td>
        <td>
          <july:string property="vo.topic" size="50" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    <tr>
        <td class="title"><july:reqmark>Текст:</july:reqmark></td>
        <td>
          <july:textarea property="vo.text" rows="10" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    <tr class="title">
    	<td colspan="2">
    		<july:backbutton page="/main.do"/>&nbsp;
    		<INPUT TYPE="IMAGE" NAME="submit" SRC="/images/save.gif" ALT="Оповестить" onclick="return Check();">
    	</td>
    </tr>
    
    <july:separator/>
    
</table>


</july:editform>

