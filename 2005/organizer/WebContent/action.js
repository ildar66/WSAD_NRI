function checkPosted() {
	document.body.style.cursor='wait';
	if (document.forms(0).elements('wasposted').value == 1) {
		alert('������ ��� ��������� �� ������ ���������� ���������');
		return false;
	} else { 
		document.forms(0).elements('wasposted').value=1;
		return true;
	}
}