<!-- MemoType:�������� �������� ���� (��� 9) -->
<P style='text-align:justify;text-indent:35.4pt'>����� ���
<logic:present name="MemoWordForm" property="arendaContractVO">
	�� �������� � <bean:write name="MemoWordForm" property="arendaContractVO.documentNumber" filter="true" scope="request"/>
	�� <july:datewrite name="MemoWordForm" property="arendaContractVO.documentDate" scope="request"/>
</logic:present>
���� �������� �������� �������� ���� ������������ ���������� �������, � ����������� ������ ������������ <bean:write name="MemoListForm" property="abonent.orgCustomer.name" filter="true" scope="session"/>
</P>