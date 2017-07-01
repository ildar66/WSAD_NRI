package org.apache.jsp;

import com.hps.july.web.util.*;
import com.hps.july.arenda.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _bottom extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _bottom( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/common/bottom.jsp";

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
      /* ------  july:statenavigator ------ */
      com.hps.july.taglib.StateNavigatorTag _jspx_th_july_statenavigator_0 = new com.hps.july.taglib.StateNavigatorTag();

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
        response.setContentType("TEXT/HTML; charset=windows-1251");
        pageContext = _jspxFactory.getPageContext(this, request, response,
        			"", true, 8192, true);

        application = pageContext.getServletContext();
        config = pageContext.getServletConfig();
        session = pageContext.getSession();
        out = pageContext.getOut();

        /* Service Method Phase */

        // HTML // begin [file="/common/bottom.jsp";from=(0,29);to=(1,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/common/bottom.jsp";from=(1,59);to=(2,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/common/bottom.jsp";from=(2,66);to=(3,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/common/bottom.jsp";from=(3,58);to=(4,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/common/bottom.jsp";from=(4,58);to=(5,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/common/bottom.jsp";from=(5,51);to=(10,72)]
          out.write("\r\n\r\n\r\n\t\t\t\t\t\t</TD>\r\n\t\t\t\t\t</TR>\r\n\t\t\t\t\t<tr class=\"title\" style=\"height:15\"><td class=\"title\" valign=\"top\">");

        // end
        // ##DEBUG## ##TAGLIB## "/common/bottom.jsp" 11,72-"/common/bottom.jsp" 11,94  LineMapIndex:1
          _jspx_th_july_statenavigator_0.setPageContext(pageContext);
          _jspx_th_july_statenavigator_0.setParent(null);
          _jspxTagObjects.push(_jspx_th_july_statenavigator_0);
            int _jspx_eval_july_statenavigator_0 = _jspx_th_july_statenavigator_0.doStartTag();
          // end
          // ##DEBUG## "/common/bottom.jsp" 11,72-"/common/bottom.jsp" 11,94  LineMapIndex:2
            if (_jspx_th_july_statenavigator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
        // end
        // HTML // begin [file="/common/bottom.jsp";from=(10,94);to=(22,9)]
          out.write("</td></tr>\r\n\t\t\t\t\t</table>\r\n\r\n\r\n\t\t</TD>\r\n\t</TR>\r\n\t<tr>\r\n\t\t<td class=\"probel\" colspan=\"3\" style=\"height:2px;background-image:/images/points.gif\" ><img src=\"/images/empty.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\"></td>\r\n\t</tr>\r\n  \t<tr>\r\n  \t\t<td colspan=\"3\" align=\"right\" class=\"copyright\">&copy; 2002 Copyright&nbsp;&nbsp;<a href=\"http://www.beeline.ru\" style=\"color:gray;\" style=\"text-decoration:none;\">BeeLine</a>&nbsp;&nbsp;</td>\r\n\t</tr>\r\n </TABLE>");

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
    "/common/bottom.jsp", 
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
    },
    {
    "1", 
    "11", 
    "11", 
    },
    };
  }
