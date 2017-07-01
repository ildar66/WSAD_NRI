<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<july:editform action="/ProcessEquipmanuf.do">

<table class="main">

    <july:separator/>
    
	<july:formbuttons/>
    
    <july:separator/>

    <tr>
        <td class="title" colspan="2"><july:actionalert/></td>
    </tr>
    
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.equipmanuf.manufid"/>:</td>
        <td>
           <july:string property="manufid" size="5" insertable="false" updatable="false" />
        </td>
    </tr>
    
  
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.equipmanuf.name"/></july:reqmark>:</td>
        <td>
           <july:string property="name" size="40" insertable="true" updatable="true" />
        </td>
    </tr>
   
    <july:separator/>

    <tr>
        <td class="text"><july:reqmark><bean:message key="label.equipmanuf.shortname"/></july:reqmark>:</td>
        <td>
           <july:string property="shortname" size="40" insertable="true" updatable="true" />
        </td>
    </tr>
   
    <july:separator/>

    <tr>
        <td class="text"><bean:message key="label.equipmanuf.equipcatalog"/>:</td>
        <td>
           <july:string property="equipcatalog" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
   
    <july:separator/>    

    <tr>
        <td class="text"><bean:message key="label.equipmanuf.officialsite"/>:</td>
        <td>
           <july:string property="officialsite" size="30" insertable="true" updatable="true" />
        </td>
    </tr>
   
    <july:separator/>

	<tr>
        <td class="text"><bean:message key="label.equipmanuf.comment"/>:</td>
        <td><july:textarea property="comment" cols="40" rows="7" insertable="true" updatable="true"/></td>
    </tr>
   
    <july:separator/>

    <july:formbuttons/>
    
    <july:separator/>
    
</table>

</july:editform>