<!-- MemoType:Изменить тарифный план (тип 9) -->
<P style='text-align:justify;text-indent:35.4pt'>Прошу Вас
<logic:present name="MemoWordForm" property="arendaContractVO">
	по договору № <bean:write name="MemoWordForm" property="arendaContractVO.documentNumber" filter="true" scope="request"/>
	от <july:datewrite name="MemoWordForm" property="arendaContractVO.documentDate" scope="request"/>
</logic:present>
дать указание изменить тарифный план обслуживания телефонных номеров, с сохранением номера арендодателю <bean:write name="MemoListForm" property="abonent.orgCustomer.name" filter="true" scope="session"/>
</P>