<script language="javascript">
function switchRanges() {
	var cc = document.forms[0]['isRange[0]'][0].checked;
	var sty;
	if(cc) { sty = '#DCDCDC'; } else { sty = '#D6EBFF'; }
	for(i = 1; i < 5; i++) {
		document.forms[0]['isRange['+i+']'][0].disabled = cc;
		document.forms[0]['isRange['+i+']'][0].style.backgroundColor = sty;
	}
}
</script>
