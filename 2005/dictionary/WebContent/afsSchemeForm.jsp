<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessAfsScheme.do">

<table class="main">

    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>
    
    <html:hidden property="schemeid"/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.numscheme"/>:</td>
        <td>
           <july:string property="numscheme" size="5" insertable="true" updatable="true" />
        </td>
    </tr>

    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.sectcount900"/>:</td>
        <td>
           <july:string property="sectcount900Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.sectcount1800"/>:</td>
        <td>
           <july:string property="sectcount1800Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
   
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.afsscheme.antX2"/>:</td>
        <td>
           <july:string property="antX2Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.antX4"/>:</td>
        <td>
           <july:string property="antX4Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.antV1"/>:</td>
        <td>
           <july:string property="antV1Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.antV2"/>:</td>
        <td>
           <july:string property="antV2Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.dbc1"/>:</td>
        <td>
           <july:string property="dbc1Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.dbc2"/>:</td>
        <td>
           <july:string property="dbc2Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.df1"/>:</td>
        <td>
           <july:string property="df1Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.df2"/>:</td>
        <td>
           <july:string property="df2Frm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.tma"/>:</td>
        <td>
           <july:string property="tmaFrm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.jo"/>:</td>
        <td>
           <july:string property="joFrm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.ji"/>:</td>
        <td>
           <july:string property="jiFrm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.con"/>:</td>
        <td>
           <july:string property="connFrm" size="5" insertable="true" updatable="true" />
        </td>
    </tr>
    
    <july:separator/>
    
    <tr>
        <td class="text"><bean:message key="label.afsscheme.notes"/>:</td>
        <td>
           <july:textarea property="notes" cols="40" rows="7" insertable="true" updatable="true"/>
        </td>
    </tr>
    
    <july:separator/>
    
    <july:formbuttons/>
    
    <july:separator/>
    
</table>


</july:editform>

