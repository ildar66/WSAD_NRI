package com.hps.july.siteinfo.actionbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;
import java.sql.*;
import javax.sql.*;
import javax.transaction.*;
import javax.naming.*;
import java.io.*;

/**
 * Обработчик загрузки word файла карты прохода
 * Creation date: (20.01.2004 19:14:24)
 * @author: Dmitry Dneprov
 */
public class CardPassWordUploadAction extends PassWordUploadAction {
/**
 * Returns type of document - named value constant.
 * Creation date: (05.02.2004 16:15:02)
 * @return java.lang.String
 */
public java.lang.String getDocType() {
	return "WayMapDocType";
}
}
