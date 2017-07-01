<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 //EN">
<HTML>
<HEAD>
<TITLE>T</TITLE>
<script language="javascript">
	if(opener){
		opener.getEquipment('<%=request.getParameter("equip_id")%>' , '<%=request.getParameter("equip_name")%>');
		window.opener.focus();
	}
	window.close();
</script>
</HEAD>

<BODY BGCOLOR="#FFFFFF">EquipmentListTrailcomConnect</BODY>
</HTML>
