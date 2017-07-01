<%@	page language =	"java" %>
<%@	page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@	page import="com.hps.july.web.util.*,com.hps.july.constants.*,com.hps.july.arenda.*" %>
<%@	taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@	taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"	%>
<%@	taglib uri="/WEB-INF/struts-html.tld" prefix="html"	%>
<%@	taglib uri="/WEB-INF/july.tld" prefix="july" %>

<HTML>
<HEAD>
	<TITLE>headers_right.jsp</TITLE>
</HEAD>
<BODY>
<TABLE border="1" style="border-collapse:collapse; border-color:  black; font-size:9pt;">
	<TBODY>
		<TR>
				<TH nowrap style="width: 60px;">Коммент.	</TH>
			<logic:equal name="LicenceListForm"	property="showColumn.isFas"	value="true" scope="session">
				<TH nowrap style="width: 60px;">ФАС				</TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isRutsr" value="true"	scope="session">
				<TH nowrap style="width: 60px;">РУЦР			</TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isAir_gr" value="true" scope="session">
				<TH nowrap style="width: 60px;">Аэро-граж</TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isAir_w" value="true"	scope="session">
				<TH nowrap style="width: 60px;">Аэро-воен</TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isGps"	value="true" scope="session">
				<TH nowrap style="width: 60px;">ГПС				 </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isGasn" value="true" scope="session">
				<TH nowrap style="width: 60px;">ГАСН		   </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isSes"	value="true" scope="session">
				<TH nowrap style="width: 60px;">СЭС			   </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isVch" value="true" scope="session">
				<TH nowrap style="width: 60px;">в\ч				   </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isTu" value="true" scope="session">
				<TH nowrap style="width: 60px;">ТУ				  </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isOtvod" value="true" scope="session">
				<TH nowrap style="width: 60px;">Акт	Земл. </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isKadastr"	value="true" scope="session">
				<TH nowrap style="width: 60px;">Кадастр	   </TH>
			</logic:equal>
			<logic:equal name="LicenceListForm"	property="showColumn.isProperty" value="true" scope="session">
				<TH nowrap style="width: 60px;">Дог	имущ. </TH>
			</logic:equal>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</HTML>
