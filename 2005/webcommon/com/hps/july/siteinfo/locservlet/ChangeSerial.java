package com.hps.july.siteinfo.locservlet;

import javax.servlet.http.*;
import javax.servlet.*;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.objects.*;

/**
 * ������� ��� ��������� ����������� ��� ���������� ������������
 */
public class ChangeSerial
	extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws javax.servlet.ServletException, java.io.IOException
{
	performTask(request, response);
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws javax.servlet.ServletException, java.io.IOException
{
	performTask(request, response);
}
public void outResult(ServletOutputStream out, String code, String msg)
	throws java.io.IOException
{
	out.println(code);
	if(msg != null) {
		out.write(msg.getBytes("Cp1251"));
//		out.println(msg.getBytes("Cp1251"));
	}
}
/**
 * ���� ������
 * 200 : �� ����, ������ �������� �����
 * 500 : ����������� ������.
 * 501 : ���������� ������ ��� �����.
 * 502 : ����� �� �������.
 * 503 : �������� ����� ��� ����������.
 * 504 : � ����� ��� ���������� ��������� ���.
 * 505 : ������ ������������� ����� �������� �����
 * 506 : �������� ����� ������.
 * 507 : ���������� ��������� ����� �������� �����.
 * 508 : ��� ���������� ������������ � �������� �������
 */
public void performTask(HttpServletRequest request, HttpServletResponse response)
{
	try {
		response.setContentType("text/plain;charset=windows-1251");
		
		int storagecard = 0;
		String newsn = null;
		ServletOutputStream out = response.getOutputStream();
//		java.io.PrintWriter pw = response.getWriter();

		try {
			storagecard = Integer.parseInt(request.getParameter("storagecard"));
			newsn = request.getParameter("newsn");
			if(newsn == null || newsn.trim().length() < 1 || "�/� ����������".equals(newsn)) {
				throw new ChangeSerialException(506, "������ ������������� ������ �������� �����!");
			}

			if(CDBCStoragecardsObject.hasRealSerial(newsn)) {
				throw new ChangeSerialException(503, "�������� ����� ��� ����������!");
			}

			StorageCardAccessBean bean;
			try {
				bean = new StorageCardAccessBean();
				bean.setInitKey_storagecard(storagecard);
				bean.refreshCopyHelper();
			} catch(Exception e) {
				throw new ChangeSerialException(502, "����� �� �������!");
			}

			int r = CDBCStoragecardsObject.changeSerial(storagecard,newsn,true);

			switch(r) {
			case 0:
				outResult(out, "200", CDBCStoragecardsObject.findSerialBySC(storagecard)); // OK: �������� ����� ���������
				break;
			case 13:
				throw new ChangeSerialException(508, "������������ ������������ ��������� ������!");
			default:
				throw new ChangeSerialException(507, "���������� ��������� ����� �������� �����!");
			}
		} catch(NumberFormatException nfe) {
			outResult(out, "501", "������ ��� �������� ��������!"); // Error: ���������� ��������� ��� �����
		} catch(ChangeSerialException cse) {
			outResult(out, cse.getCode(), cse.getArg());
		} catch(Exception e) {
			e.printStackTrace(System.out);
			outResult(out, "500", "����������� ������. ���������� ��� ���.");
		}
		out.flush();
	} catch(java.io.IOException ioe) {
		ioe.printStackTrace(System.out);
	}
/*
	if (storagecard != 0) {

		try {
			ServletOutputStream out=response.getOutputStream();

			// Get AccessBean
			StorageCardAccessBean bean=new StorageCardAccessBean();
			bean.setInitKey_storagecard(storagecard);
			bean.refreshCopyHelper();

			response.setContentType("text/plain");
			String comment = bean.getComment();
			if (comment != null)
				out.write(comment.getBytes("Cp1251"));
			else
				out.print("");

			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
*/
}
}
