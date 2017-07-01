package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _loginForm extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _loginForm( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/loginForm.jsp";

  public final void _jspx_init() throws org.apache.jasper.runtime.JspException {
    /* Init Method Phase */
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse  response)
      throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    String  _value = null;
    java.util.Stack _jspxTagObjects = new java.util.Stack();
    /* Service Declaration Phase */
      /* ------  july:errors ------ */
      com.hps.july.taglib.ErrorsTag _jspx_th_july_errors_0 = new com.hps.july.taglib.ErrorsTag();

                        try {

                          if (_jspx_inited == false) {
                            synchronized (this) {
                              if (_jspx_inited == false) {
                                _jspx_init();
                                _jspx_inited = true;
                              }
                            }
                          }

                          _jspxFactory = JspFactory.getDefaultFactory();
                          response.setContentType("text/html; charset=windows-1251");
                          pageContext = _jspxFactory.getPageContext(this, request, response,
                          			"", true, 8192, true);

                          application = pageContext.getServletContext();
                          config = pageContext.getServletConfig();
                          session = pageContext.getSession();
                          out = pageContext.getOut();

                          /* Service Method Phase */

                          // HTML // begin [file="/loginForm.jsp";from=(0,29);to=(1,0)]
                            out.write("\r\n");

                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(1,59);to=(2,0)]
                            out.write("\r\n");

                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(2,60);to=(3,0)]
                            out.write("\r\n");

                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(3,58);to=(4,0)]
                            out.write("\r\n");

                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(4,58);to=(5,0)]
                            out.write("\r\n");

                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(5,51);to=(8,1)]
                            out.write("\r\n\r\n  <TABLE class=\"main\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" vAlign=top>\r\n\t");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 9,1-"/loginForm.jsp" 9,15  LineMapIndex:1
                            _jspx_th_july_errors_0.setPageContext(pageContext);
                            _jspx_th_july_errors_0.setParent(null);
                            _jspxTagObjects.push(_jspx_th_july_errors_0);
                              int _jspx_eval_july_errors_0 = _jspx_th_july_errors_0.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 9,1-"/loginForm.jsp" 9,15  LineMapIndex:2
                              if (_jspx_th_july_errors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(8,15);to=(11,101)]
                            out.write("\r\n  </TABLE>\r\n\r\n<FORM METHOD=POST ACTION=\"j_security_check\" onsubmit='if (document.all.wasposted.value==\"1\") {alert(\"");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 12,101-"/loginForm.jsp" 12,138  LineMapIndex:3
                            /* ------  bean:message ------ */
                            org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_0 = new org.apache.struts.taglib.bean.MessageTag();
                            _jspx_th_bean_message_0.setPageContext(pageContext);
                            _jspx_th_bean_message_0.setParent(null);
                            _jspx_th_bean_message_0.setKey("label.wasposted");
                            _jspxTagObjects.push(_jspx_th_bean_message_0);
                              int _jspx_eval_bean_message_0 = _jspx_th_bean_message_0.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 12,101-"/loginForm.jsp" 12,138  LineMapIndex:4
                              if (_jspx_th_bean_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(11,138);to=(18,11)]
                            out.write("\"); return false;} else {document.all.wasposted.value=\"1\";}'>\r\n\r\n<INPUT TYPE=\"HIDDEN\" NAME=\"wasposted\" VALUE=\"0\">\r\n\r\n<table class=\"main\">\r\n    <tr class=\"title\">\r\n    \t<td class=\"title\" colspan=\"2\">\r\n           ");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 19,11-"/loginForm.jsp" 19,51  LineMapIndex:5
                            /* ------  bean:message ------ */
                            org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_1 = new org.apache.struts.taglib.bean.MessageTag();
                            _jspx_th_bean_message_1.setPageContext(pageContext);
                            _jspx_th_bean_message_1.setParent(null);
                            _jspx_th_bean_message_1.setKey("label.registration");
                            _jspxTagObjects.push(_jspx_th_bean_message_1);
                              int _jspx_eval_bean_message_1 = _jspx_th_bean_message_1.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 19,11-"/loginForm.jsp" 19,51  LineMapIndex:6
                              if (_jspx_th_bean_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(18,51);to=(22,4)]
                            out.write("\r\n        </td>\r\n    </tr>\r\n    \r\n    ");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 23,4-"/loginForm.jsp" 23,21  LineMapIndex:7
                            /* ------  july:separator ------ */
                            com.hps.july.taglib.SeparatorTag _jspx_th_july_separator_0 = new com.hps.july.taglib.SeparatorTag();
                            _jspx_th_july_separator_0.setPageContext(pageContext);
                            _jspx_th_july_separator_0.setParent(null);
                            _jspxTagObjects.push(_jspx_th_july_separator_0);
                              int _jspx_eval_july_separator_0 = _jspx_th_july_separator_0.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 23,4-"/loginForm.jsp" 23,21  LineMapIndex:8
                              if (_jspx_th_july_separator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(22,21);to=(25,25)]
                            out.write("\r\n    \r\n    <tr>\r\n        <td class=\"text\">");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 26,25-"/loginForm.jsp" 26,61  LineMapIndex:9
                            /* ------  bean:message ------ */
                            org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_2 = new org.apache.struts.taglib.bean.MessageTag();
                            _jspx_th_bean_message_2.setPageContext(pageContext);
                            _jspx_th_bean_message_2.setParent(null);
                            _jspx_th_bean_message_2.setKey("label.login.id");
                            _jspxTagObjects.push(_jspx_th_bean_message_2);
                              int _jspx_eval_bean_message_2 = _jspx_th_bean_message_2.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 26,25-"/loginForm.jsp" 26,61  LineMapIndex:10
                              if (_jspx_th_bean_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(25,61);to=(31,4)]
                            out.write(":</td>\r\n        <td>\r\n          <INPUT TYPE=\"TEXT\" class=\"search\" name=\"j_username\" size=\"15\">\r\n        </td>\r\n    </tr>\r\n    \r\n    ");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 32,4-"/loginForm.jsp" 32,21  LineMapIndex:11
                            /* ------  july:separator ------ */
                            com.hps.july.taglib.SeparatorTag _jspx_th_july_separator_1 = new com.hps.july.taglib.SeparatorTag();
                            _jspx_th_july_separator_1.setPageContext(pageContext);
                            _jspx_th_july_separator_1.setParent(null);
                            _jspxTagObjects.push(_jspx_th_july_separator_1);
                              int _jspx_eval_july_separator_1 = _jspx_th_july_separator_1.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 32,4-"/loginForm.jsp" 32,21  LineMapIndex:12
                              if (_jspx_th_july_separator_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(31,21);to=(34,25)]
                            out.write("\r\n    \r\n    <tr>\r\n        <td class=\"text\">");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 35,25-"/loginForm.jsp" 35,62  LineMapIndex:13
                            /* ------  bean:message ------ */
                            org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_3 = new org.apache.struts.taglib.bean.MessageTag();
                            _jspx_th_bean_message_3.setPageContext(pageContext);
                            _jspx_th_bean_message_3.setParent(null);
                            _jspx_th_bean_message_3.setKey("label.login.psw");
                            _jspxTagObjects.push(_jspx_th_bean_message_3);
                              int _jspx_eval_bean_message_3 = _jspx_th_bean_message_3.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 35,25-"/loginForm.jsp" 35,62  LineMapIndex:14
                              if (_jspx_th_bean_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(34,62);to=(40,4)]
                            out.write(":</td>\r\n        <td>\r\n          <INPUT TYPE=\"PASSWORD\" Class=\"search\" size=\"15\" name=\"j_password\">\r\n        </td>\r\n    </tr>\r\n    \r\n    ");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 41,4-"/loginForm.jsp" 41,21  LineMapIndex:15
                            /* ------  july:separator ------ */
                            com.hps.july.taglib.SeparatorTag _jspx_th_july_separator_2 = new com.hps.july.taglib.SeparatorTag();
                            _jspx_th_july_separator_2.setPageContext(pageContext);
                            _jspx_th_july_separator_2.setParent(null);
                            _jspxTagObjects.push(_jspx_th_july_separator_2);
                              int _jspx_eval_july_separator_2 = _jspx_th_july_separator_2.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 41,4-"/loginForm.jsp" 41,21  LineMapIndex:16
                              if (_jspx_th_july_separator_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(40,21);to=(45,43)]
                            out.write("\r\n    \r\n</table>\r\n\r\n<CENTER>\r\n  <INPUT TYPE=\"submit\" NAME=\"login\" VALUE='");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 46,43-"/loginForm.jsp" 46,77  LineMapIndex:17
                            /* ------  bean:message ------ */
                            org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_4 = new org.apache.struts.taglib.bean.MessageTag();
                            _jspx_th_bean_message_4.setPageContext(pageContext);
                            _jspx_th_bean_message_4.setParent(null);
                            _jspx_th_bean_message_4.setKey("button.login");
                            _jspxTagObjects.push(_jspx_th_bean_message_4);
                              int _jspx_eval_bean_message_4 = _jspx_th_bean_message_4.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 46,43-"/loginForm.jsp" 46,77  LineMapIndex:18
                              if (_jspx_th_bean_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(45,77);to=(46,35)]
                            out.write("'>&nbsp;\r\n  <BUTTON onclick=\"window.close()\">");

                          // end
                          // ##DEBUG## ##TAGLIB## "/loginForm.jsp" 47,35-"/loginForm.jsp" 47,68  LineMapIndex:19
                            /* ------  bean:message ------ */
                            org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_5 = new org.apache.struts.taglib.bean.MessageTag();
                            _jspx_th_bean_message_5.setPageContext(pageContext);
                            _jspx_th_bean_message_5.setParent(null);
                            _jspx_th_bean_message_5.setKey("button.exit");
                            _jspxTagObjects.push(_jspx_th_bean_message_5);
                              int _jspx_eval_bean_message_5 = _jspx_th_bean_message_5.doStartTag();
                            // end
                            // ##DEBUG## "/loginForm.jsp" 47,35-"/loginForm.jsp" 47,68  LineMapIndex:20
                              if (_jspx_th_bean_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/loginForm.jsp";from=(46,68);to=(58,0)]
                            out.write("</BUTTON>&nbsp;\r\n  <BUTTON onclick=\"window.open('/info/information.html', '_blank', 'top=20, left=20, width=1000, height=720, scrollbars=yes, resizable=yes'); return false;\">Информация</BUTTON>\r\n  <BR>\r\n  <IMG SRC=\"/images/main3.gif\" border=0 alt=\"\">\r\n  <BR>\r\n  <IFRAME src=\"/infoNRI.html\" align=\"middle\" height=\"300\" width=\"800\"></IFRAME>  \r\n</CENTER>\r\n</FORM>\r\n\r\n<SCRIPT language=\"JavaScript\">\r\n   document.all.j_username.focus();\r\n</SCRIPT>\r\n");

                          // end

                        } catch (Throwable t) {
                          if (out != null && out.getBufferSize() != 0)
                            out.clearBuffer();
                          if (pageContext != null) pageContext.handlePageException(t);
                        } finally {
                          while (_jspxTagObjects.empty() == false){
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          }
                          if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);

                          /* Service Finally Phase */
                        }
                      }
                      public static String[][] _jspx_debug_FileMapping = {
                      {
                      "/loginForm.jsp", 
                      },
                      {
                      "0", 
                      },
                      };
                      public static String[][] _jspx_debug_LineMapping = {
                      {
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      "0", 
                      },
                      {
                      "1", 
                      "9", 
                      "9", 
                      "12", 
                      "12", 
                      "19", 
                      "19", 
                      "23", 
                      "23", 
                      "26", 
                      "26", 
                      "32", 
                      "32", 
                      "35", 
                      "35", 
                      "41", 
                      "41", 
                      "46", 
                      "46", 
                      "47", 
                      "47", 
                      },
                      };
                    }
