package com.hps.july.siteinfo.applets;

/**
 * ����� ����������� ������ Java-������ �� ���������� ������������.
 * Creation date: (30.07.2003 10:22:13)
 * @author: Maxim Gerasimov
 */
public class JavaVersion extends java.applet.Applet {
public String getVersion() {
    return System.getProperty("java.version");
}
}
