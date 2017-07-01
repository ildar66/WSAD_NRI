<!-- MemoType:Возврат оборудование  (тип А)-->
<P style='text-align:justify;text-indent:35.4pt'>Прошу Вас дать указание оформить возврат оборудования, выданного по счету
	<logic:present name="MemoWordForm" property="leasebillVO">
		№ <bean:write name="MemoWordForm" property="leasebillVO.billnumber" filter="true" scope="request"/>
		от <july:datewrite name="MemoWordForm" property="leasebillVO.billdate"/>
	</logic:present>
	<logic:notPresent name="MemoWordForm" property="leasebillVO">
		№_________от_________
	</logic:notPresent>
	арендодателю <bean:write name="MemoListForm" property="abonent.orgCustomer.name" filter="true" scope="session"/>, в связи с отказом клиента 
</P>
