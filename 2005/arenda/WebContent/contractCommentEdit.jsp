<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<jsp:useBean id="DogHistoryListForm" scope="session" type="com.hps.july.arenda.formbean.DogHistoryListForm"/>
<%
	String contrnum = DogHistoryListForm.getContrnum();
	String comment = (DogHistoryListForm.getComment()!=null)?DogHistoryListForm.getComment():"";
	String fieldnames = request.getParameter("fieldnames"); //"name1|name2|name3|..."
	String formname = request.getParameter("formname");
	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
    String dataStr = format.format(new java.util.Date(System.currentTimeMillis()));
%>
<HTML>
<HEAD>
	<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
	<TITLE>Редактирование коментария к договору № <%=contrnum%>.</TITLE>
	<LINK rel="stylesheet" type="text/css" href="/main.css">
	<script language="javascript" type="text/javascript">
	function Go(strval) {
		var thisform = document.refform;
		var outform = window.opener.document.forms[thisform.formname.value];
	
		if(outform != null)
		{
			var names = thisform.fieldnames.value.split('|'), values = strval.split('|');
			for(var i in names)
				if(names[i].length > 0)
					outform[names[i]].value = unescape(values[i]);
			outform.submit();
			window.opener.document.body.style.cursor='wait'
		}
		Close();
	}

	function Close()
	{
		if(window.opener) {
			window.opener.focus();
		}
		window.close();
	}
	</script>
</HEAD>
<BODY>
	<FORM name=refform>
	<!--hidden field-->
	<INPUT type="hidden" name="fieldnames" value="<%=fieldnames%>"> 
	<INPUT type="hidden" name="formname" value="<%=formname%>">
	<table class="main">
	<tr><td class="probel"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td></tr>
	<tr class="title">
		<td>
			<IMG SRC="/images/save.gif" onclick="Go(document.forms(0).comment.value+'|true');" ALT="Сохранить" border=0/>
			<IMG SRC="/images/restore.gif" onclick="document.forms(0).reset()" ALT="Отменить правку" border=0/>
			<IMG SRC="/images/cancel.gif" onclick="Close();" ALT="Отказ и возврат" border=0/>
			<FONT class="attention"><B> Комментарий к договору № <%=contrnum%>: </B></FONT>
		</td>
	</tr>
	<%--tr><td class="probel"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td></tr> 
	<tr>
		<td class="title"><FONT class="attention"><B>Комментарий к договору № <%=contrnum%>:</B></FONT></td>
	</tr--%>
	<tr><td class="probel"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td></tr> 
	<tr>
		<td>
			<TEXTAREA onkeypress="if(this.value.length>=800) event.returnValue=false;" onchange="this.value=this.value.substr(0,800);"  onpaste="this.value=(this.value+window.clipboardData.getData('Text')).substr(0,800);event.returnValue=false;" title="Комментарий к договору" name=comment rows=8 cols=70><%= comment.trim()%>&#10;<%=dataStr%>:</TEXTAREA>
		</td>
	</tr>
	<tr><td class="probel"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td></tr>
	<tr class="title">
		<td>
			<IMG SRC="/images/save.gif" onclick="Go(document.forms(0).comment.value+'|true');" ALT="Сохранить" border=0/>
			<IMG SRC="/images/restore.gif" onclick="document.forms(0).reset()" ALT="Отменить правку" border=0/>
			<IMG SRC="/images/cancel.gif" onclick="Close();" ALT="Отказ и возврат" border=0/>
		</td>
	</tr>
	<tr><td class="probel"><img src="/images/empty.gif" width="1" height="1" border="0" alt=""></td></tr> 
	</table>
	</FORM>
</BODY>
<script language="javascript" type="text/javascript">
	document.refform.comment.focus();
</script>
</HTML>
