package com.hps.july.sitedoc.valueobject;

import javax.servlet.*;
import org.apache.struts.util.MessageResources;

/**
 * Служебный класс загружающий дополнительные строковые ресурсы
 * Используется в JSP и формах для отображения строковых констант
 */
public class TextResources {
public static MessageResources getBsResources(ServletContext app) {
	Object o = app.getAttribute("bsResources");
	System.out.println("TEXTR: bsResources: "+o);
	MessageResources mr = null;
	if(o != null && o instanceof MessageResources) {
		mr = (MessageResources)o;
	} else {
		System.out.println("TEXTR: bsResources: CREATE NEW");
		mr = MessageResources.getMessageResources("com.hps.july.sitedoc.BsResources");
		app.setAttribute("bsResources",mr);
	}
	return mr;
}
public static MessageResources getMenuResources(ServletContext app) {
	Object o = app.getAttribute("MenuResources");
	System.out.println("TEXTR: MenuResources: "+o);
	MessageResources mr = null;
	if(o != null && o instanceof MessageResources) {
		mr = (MessageResources)o;
	} else {
		System.out.println("TEXTR: MenuResources: CREATE NEW");
		mr = MessageResources.getMessageResources("com.hps.july.sitedoc.MenuResources");
		app.setAttribute("MenuResources",mr);
	}
	return mr;
}
public static MessageResources getSiteinfoResources(ServletContext app) {
	Object o = app.getAttribute("siteinfoResources");
	System.out.println("TEXTR: siteinfoResources: "+o);
	MessageResources mr = null;
	if(o != null && o instanceof MessageResources) {
		mr = (MessageResources)o;
	} else {
		System.out.println("TEXTR: siteinfoResources: CREATE NEW");
		mr = MessageResources.getMessageResources("com.hps.july.sitedoc.SiteinfoResources");
		app.setAttribute("siteinfoResources",mr);
	}
	return mr;
}
private static void initResources(javax.servlet.ServletContext app)
{
//	com.hps.july.sitedoc.formbean.SiteDocListForm dForm = (SiteDocListForm) form;
	MessageResources bsResources = MessageResources.getMessageResources("com.hps.july.sitedoc.BsResources");
	MessageResources siteinfoResources = MessageResources.getMessageResources("com.hps.july.sitedoc.SiteinfoResources");
	MessageResources menuResources = MessageResources.getMessageResources("com.hps.july.sitedoc.MenuResources");

	if(app.getAttribute("bsResources") == null) {
		app.setAttribute("bsResources", siteinfoResources);
	}
	if(app.getAttribute("siteinfoResources") == null) {
		app.setAttribute("siteinfoResources", siteinfoResources);
	}

	if(app.getAttribute("MenuResources") == null) {
		app.setAttribute("MenuResources", menuResources);
	}
}
}
