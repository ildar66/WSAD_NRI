<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="com.hps.july.web.util.*,com.hps.july.arenda.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<frameset rows="75,*" FRAMEBORDER="1" BORDER="1"
	resize="yes">

	<frame name="header" title='header.frame'
		scrolling="NO" noresize
		src="<%=request.getContextPath() %>/banner.jsp"
		marginwidth="0" marginheight="0">

	<frameset cols="23%,*" resize="yes" FRAMESPACING="3">
		<FRAME title='task.nav.frame'
			src="<%=request.getContextPath() %>/navigator.jsp"
			name="navigation_tree" resize="yes" marginwidth="10" marginheight="0"
			onload="this.focus()">
		<frameset rows="*,100" resize="yes" FRAMESPACING="2" BORDER="1">
			<FRAME title='work.area.frame'
				SRC="<%=request.getContextPath()  %>/content.jsp"
				name="detail" marginwidth="15" marginheight="10" resize="yes"
				onload="isloaded=0;this.focus()">
			<FRAME title='status.area.frame'
				src="<%=request.getContextPath()  %>/status.jsp"
				resize="yes" name="console_messages" marginwidth="10"
				marginheight="10">
		</frameset>
	</frameset>

	<frame name="futer" title='futer.frame'
		scrolling="NO" noresize
		src="<%=request.getContextPath() %>/futer.jsp"
		marginwidth="0" marginheight="0">

</frameset>
<noframes>You must use a browser that supports frames.
</noframes>


