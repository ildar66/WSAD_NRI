<%@ page language = "java" %>
<%@ page contentType = "text/html; charset=windows-1251" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<html:form action="/NFS_Print.do">


<table class="main">
    <tr class="title">
        <td class="title">
          <july:closebutton page="/"/>
          <july:printerbutton/>
        </td>
    </tr>

	<july:separator/>

    <TR class="printable">
	    <TD class="printable">
		<logic:present name="NFS_PrintForm" property="sf">
	        <TABLE class="print" style="border-color: black; border-width: 2; border-collapse:collapse;" border="1">
		        <tr class="printable">
			        <td colspan="2" class="printable" style="font-weight: bold; font-size: 12pt">
					   ���������, ��������� (�� ��):
					</td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>���:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.vendor">
							<bean:write name="NFS_PrintForm" property="sf.vendor.inn"/>
						</logic:present>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>���:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.site">
							<bean:write name="NFS_PrintForm" property="sf.site.kpp"/>
						</logic:present>
				    </td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>��� ����������:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.vendor">
							<bean:write name="NFS_PrintForm" property="sf.vendor.vendorcode"/>
						</logic:present>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>������������ ����������:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.vendor">
							<bean:write name="NFS_PrintForm" property="sf.vendor.name"/>
						</logic:present>
				    </td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>������������ ���������:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.site">
							<bean:write name="NFS_PrintForm" property="sf.site.name"/>
						</logic:present>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>�������������� ���:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.site">
							<bean:write name="NFS_PrintForm" property="sf.site.code"/>
						</logic:present>
				    </td>
				</tr>
			</TABLE>
		</logic:present>
		<logic:notPresent name="NFS_PrintForm" property="sf">
	        <TABLE class="print" style="border-color: black; border-width: 2; border-collapse:collapse;" border="1">
		        <tr class="printable">
			        <td colspan="2" class="printable" style="font-weight: bold; font-size: 12pt">
					   ��������� (�� ��):
					</td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>���:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="zp.vendor">
							<bean:write name="NFS_PrintForm" property="zp.vendor.inn"/>
						</logic:present>
				    </td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>��� ����������:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="zp.vendor">
							<bean:write name="NFS_PrintForm" property="zp.vendor.vendorcode"/>
						</logic:present>
				    </td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>������������ ����������:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="zp.vendor">
							<bean:write name="NFS_PrintForm" property="zp.vendor.name"/>
						</logic:present>
				    </td>
				</tr>
			</TABLE>
		</logic:notPresent>
		</TD>
	</TR>

	<july:separator/>

    <TR class="printable">
	    <TD class="printable">
			<logic:present name="NFS_PrintForm" property="contract">
	        <TABLE class="print" style="border-color: black; border-width: 2; border-collapse:collapse;" border="1">
		        <tr class="printable">
			        <td colspan="3" class="printable" style="font-weight: bold; font-size: 12pt">
					   ������� :
					</td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>����� ��������:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="contract.numContract"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>���� ��������:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="contract.dateContract"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>����� ���������:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="contract.numContractNfs"/>
				    </td>
				</tr>
			</TABLE>
			</logic:present>
			<logic:notPresent name="NFS_PrintForm" property="contract">
				��� ������ �� ��������� !!!
			</logic:notPresent>
		</TD>
	</TR>

	<july:separator/>

    <TR class="printable">
	    <TD class="printable">
			<logic:present name="NFS_PrintForm" property="zp">
	        <TABLE class="print" style="border-color: black; border-width: 2; border-collapse:collapse;" border="1">
		        <tr class="printable">
			        <td colspan="3" class="printable" style="font-weight: bold; font-size: 12pt">
					   ����� �� ������������:
						<logic:equal name="NFS_PrintForm" property="zp.status" value="D">
						<B style="color: red">(������!)</B>
						</logic:equal>
					</td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>����� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="zp.numZp"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>��������� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="zp.stateZp"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						&nbsp;
				    </td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>����� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="zp.sumZp"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>� �.�. ��� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="zp.ndsZp"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>������ ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="zp.currZp"/>
				    </td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt" colspan="3">
						<I>������:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="zp.userCreate"/>
							(<july:datewrite name="NFS_PrintForm" property="zp.datecreate" showtime="true"/>)<br>
						<I>�������:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="zp.userModify"/>
							(<july:datewrite name="NFS_PrintForm" property="zp.datemodify" showtime="true"/>)
				    </td>
				</tr>				
			</TABLE>
			</logic:present>
			<logic:notPresent name="NFS_PrintForm" property="zp">
				��� ������ �� �� !!!
			</logic:notPresent>
		</TD>
	</TR>

	<july:separator/>

    <TR class="printable">
	    <TD class="printable">
			<logic:present name="NFS_PrintForm" property="sf">
	        <TABLE class="print" style="border-color: black; border-width: 2; border-collapse:collapse;" border="1">
		        <tr class="printable">
			        <td  colspan="4" class="printable" style="font-weight:bold; font-size:12pt">
					   ���� �� ����������:
						<logic:equal name="NFS_PrintForm" property="sf.status" value="D">
						<B style="color: red">(������!)</B>
						</logic:equal>
					</td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>����� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="sf.numSf"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>��������� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="sf.stateSf"/>
				    </td>
		            <td colspan="2" class="printable" style="font-size: 10pt">
						<I>���� ��������:</I>&nbsp;
							<july:datewrite name="NFS_PrintForm" property="sf.dateCreate" showtime="true"/>
				    </td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>����� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="sf.sumSf"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>� �.�.��� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="sf.nds"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>������ ���:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="sf.taxRate"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>������ ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="sf.currSf"/>
				    </td>
				</tr>
		        <tr class="printable">
		            <td colspan="2" class="printable" style="font-size: 10pt">
						<I>���������� �������:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.recipient">
							<bean:write name="NFS_PrintForm" property="sf.recipient.name"/>
						</logic:present>
				    </td>
		            <td colspan="2" class="printable" style="font-size: 10pt">
						<I>����:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.account">
							<bean:write name="NFS_PrintForm" property="sf.account.bank.name"/>
						</logic:present>
				    </td>
				</tr>
		        <tr class="printable">
		            <td colspan="2" class="printable" style="font-size: 10pt">
						<I>��������� ����:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.account">
							<bean:write name="NFS_PrintForm" property="sf.account.accountNum"/>
						</logic:present>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>���\����:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.account">
							<bean:write name="NFS_PrintForm" property="sf.account.bank.korschet"/>
						</logic:present>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>BIK:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="sf.account">
							<bean:write name="NFS_PrintForm" property="sf.account.bank.bik"/>
						</logic:present>
				    </td>
				</tr>
				<tr class="printable">
		            <td class="printable" style="font-size: 10pt" colspan="3">
						<I>������:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="sf.userCreate"/>
							(<july:datewrite name="NFS_PrintForm" property="sf.datecreate" showtime="true"/>)<br>
						<I>�������:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="sf.userModify"/>
							(<july:datewrite name="NFS_PrintForm" property="sf.datemodify" showtime="true"/>)
				    </td>
				</tr>
			</TABLE>
			</logic:present>
			<logic:notPresent name="NFS_PrintForm" property="sf">
				<B>����-������� �����������</B>
			</logic:notPresent>
		</TD>
	</TR>

	<july:separator/>

    <TR class="printable">
	    <TD class="printable">
			<logic:present name="NFS_PrintForm" property="pay">
	        <TABLE class="print" style="border-color: black; border-width: 2; border-collapse:collapse;" border="1">
		        <tr class="printable">
			        <td  colspan="4" class="printable" style="font-weight:bold; font-size:12pt">
					   ������:
						<logic:equal name="NFS_PrintForm" property="pay.status" value="D">
						<B style="color: red">(������!)</B>
						</logic:equal>
					</td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>����� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="pay.numPay"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>� ���� ��:</I>&nbsp;
							<july:datewrite name="NFS_PrintForm" property="pay.datePay"/>
				    </td>
		            <td colspan="2" class="printable" style="font-size: 10pt">
						<I>��������� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="pay.statePay"/>
				    </td>
				</tr>
		        <tr class="printable">
			        <td  colspan="4" class="printable" style="font-size: 10pt">
					   <I>���������� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="pay.purpose"/>
					</td>
				</tr>
		        <tr class="printable">
		            <td class="printable" style="font-size: 10pt">
						<I>����� ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="pay.sumPay"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>� ������ ��:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="pay.currPay"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>����� �� � ���.:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="pay.sumRubPay"/>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>� �.�. ��� � ���.:</I>&nbsp;
							<bean:write name="NFS_PrintForm" property="pay.sumNdsRub"/>
				    </td>
				</tr>
		        <tr class="printable">
		            <td colspan="2" class="printable" style="font-size: 10pt">
						<I>���������� �������:</I>&nbsp;
							<logic:present name="NFS_PrintForm" property="pay.recipient">
								<bean:write name="NFS_PrintForm" property="pay.recipient.name"/>
							</logic:present>
				    </td>
		            <td colspan="2" class="printable" style="font-size: 10pt">
						<I>����:</I>&nbsp;
							<logic:present name="NFS_PrintForm" property="pay.account">
								<bean:write name="NFS_PrintForm" property="pay.account.bank.name"/>
							</logic:present>
				    </td>
				</tr>
		        <tr class="printable">
		            <td colspan="2" class="printable" style="font-size: 10pt">
						<I>��������� ����:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="pay.account">
							<bean:write name="NFS_PrintForm" property="pay.account.accountNum"/>
						</logic:present>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>���\����:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="pay.account">
							<bean:write name="NFS_PrintForm" property="pay.account.bank.korschet"/>
						</logic:present>
				    </td>
		            <td class="printable" style="font-size: 10pt">
						<I>BIK:</I>&nbsp;
						<logic:present name="NFS_PrintForm" property="pay.account">
							<bean:write name="NFS_PrintForm" property="pay.account.bank.bik"/>
						</logic:present>
				    </td>
				</tr>
			</TABLE>
			</logic:present>
			<logic:notPresent name="NFS_PrintForm" property="pay">
				<B>������ �����������</B>
			</logic:notPresent>
		</TD>
	</TR>

	<july:separator/>

	<tr class="title">
    	<td class="title">
          <july:closebutton page="/"/>
          <july:printerbutton/> 
        </td>
    </tr>

</table>

</html:form>
