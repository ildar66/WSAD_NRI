function CallRef(theForm, referenceid, fieldnames)
{
	var url = 'refselect.asp?formname=' + theForm.name + '&referenceid=' + referenceid;
	var names = fieldnames.split(','), values = new Array();
	for(var i = 0; i < names.length; i++)
	{
		var n = names[i], v = '';
		if(n.charAt(0) == '-')
		{
			n = n.substr(1);
		}
		else if(n.charAt(0) == '*')
		{
			v = escape(theForm[n.substr(1)].value);
			n = '';
		}
		else if(n.length > 0)
		{
			v = escape(theForm[n].value);
		}
		names[i] = n;
		values[i] = v;
	}
	fieldnames = names.join('|');
	fieldvalues = values.join('|');
	url += '&fieldnames=' + fieldnames + '&fieldvalues=' + fieldvalues;
	var wnd = window.open(url, 'ref', 'width=630,height=318,resizable=yes,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes');
	wnd.focus();
}

//+ field_alert:
function field_alert(field, message)
{
	var msg = 'Неверное значение в поле \'%title%\'.'
	if(message != null)
		msg = msg + '\n' + message;
	alert(msg.replace(/%title%/, field.title));
	field_select(field);
	return false;
}

function field_warn(field, message)
{
	var msg = 'Неверное значение в поле \'%title%\'.'
	if(message != null)
		msg = msg + '\n' + message;
	if(!confirm(msg.replace(/%title%/, field.title) + '\nИгнорировать предупреждение ?'))
	{
		field_select(field);
		return false;
	}
	return true;
}

function alert_field(field, message)
{
	alert(message.replace(/%title%/, field.title));
	field_select(field);
	return false;
}

//+ внимание:
function warn_field(field, message)
{
	if(!confirm(message.replace(/%title%/, field.title) + '\nИгнорировать предупреждение ?'))
	{
		field_select(field);
		return false;
	}
	return true;
}

//+ money_format:
function money_format(n, dd)
{
	var a = n.toString().split('.');
	if(a[1] == null) a[1] = '00'; else a[1] = (a[1] + '00').substr(0, 2);
	return (a[0] + dd + a[1]);
}

function valacc_check(e)
{
	var r = e.value.match(/^(\/\/\w{2}|\/)(.*)$/);
	var b = r == null?true:clearing_check(r[1],r[2]);
	if(!b)
		alert_field(e, 'Неверное значение в поле \'%title%\'.')
	return b;
}

function clearing_check(code, acc)
{
	var codes = new Array('/',       '//AT',    '//AU',    '//BL',    '//CH',    '//CP',    '//SC',    '//FW',    '//CC',    '//SW',    '//ES',    '//IT'),
		exps  = new Array(/^.*$/, /^\d{5}$/, /^\d{6}$/, /^\d{8}$/, /^\d{6}$/, /^\d{4}$/, /^\d{6}$/, /^\d{9}$/, /^\d{9}$/, /^\d{6}$/, /^\d{9}$/, /^\w{23}$/);
	
	for(var i = 0; i < codes.length; i++)
		if(codes[i] == code)
			return exps[i].test(acc);
	return true;
}

//проверка даты документа:
function docdate_check(e)
{
	var DyMilli = 1000 * 60 * 60 * 24;
	var d = e.value.split('/');
	var d1 = new Date(d[2], d[1] - 1, d[0]), d2 = new Date();
	d2.setHours(0, 0, 0, 0);
	if((d1.getTime() + DyMilli * 10) < d2.getTime())
		return alert_field(e, 'Дата не должна быть меньше текущей более чем на 10 дней.');
//	if(d1.getTime() < d2.getTime())
//		return alert_field(e, 'Дата должна быть не меньше текущей.');
	else
		return true;
}

function document_save(e)
{
	var theForm = document.docform;
	if(docform_onsubmit())
	{
		theForm.btnsubmit.value = e.value;
		theForm.submit();
	}
}

function pattern_save(e)
{
	var theForm = document.docform;
	if(theForm.patterntitle.value.length == 0)
	{
		alert('Введите \'Наименование шаблона\'.');
		theForm.patterntitle.select();
	}
	else
	{
		theForm.btnsubmit.value = e.value;
		theForm.submit();
	}
}

function coma_replace(n, dd){
	var a = n.toString().split(',');
	if(a[1] == null)
		return a[0]; 
	else 
		return (a[0] + dd + a[1]);
}
