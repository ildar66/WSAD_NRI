<!-- MemoType:������� ������������  (��� �)-->
<P style='text-align:justify;text-indent:35.4pt'>����� ��� ���� �������� �������� ������� ������������, ��������� �� �����
	<logic:present name="MemoWordForm" property="leasebillVO">
		� <bean:write name="MemoWordForm" property="leasebillVO.billnumber" filter="true" scope="request"/>
		�� <july:datewrite name="MemoWordForm" property="leasebillVO.billdate"/>
	</logic:present>
	<logic:notPresent name="MemoWordForm" property="leasebillVO">
		�_________��_________
	</logic:notPresent>
	������������ <bean:write name="MemoListForm" property="abonent.orgCustomer.name" filter="true" scope="session"/>, � ����� � ������� ������� 
</P>
