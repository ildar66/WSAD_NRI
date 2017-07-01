package com.hps.july.dictionary.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.dictionary.formbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * Обработчик формы выбора класса добавляемого оборудования
 * Модифицирует базовый обработчик с целью исключения возврата на форму выбора и 
 * исключения ссылки из навигатора
 */
public class ChooseRtypeAction
	extends AbstractEditAction
{
public boolean isAddtoHistory() {
	return true;
}
public boolean isReturnable() {
	return false;
}
}
