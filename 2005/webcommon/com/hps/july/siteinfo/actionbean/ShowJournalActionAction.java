package com.hps.july.siteinfo.actionbean;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;

/**
 * ���������� ����� ���������� �������� ������ � �������
 */
public class ShowJournalActionAction
	extends AbstractEditAction
{
public boolean isAddtoHistory() {
	return false;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
	HttpServletResponse response) throws IOException, ServletException
{
	return super.perform(mapping, form, request, response);
}
}
