package org.apache.jsp;

import com.hps.july.web.util.*;
import com.hps.july.arenda.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _top extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _top( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/common/top.jsp";

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
          response.setContentType("text/html; charset=windows-1251");
          pageContext = _jspxFactory.getPageContext(this, request, response,
          			"", true, 8192, true);

          application = pageContext.getServletContext();
          config = pageContext.getServletConfig();
          session = pageContext.getSession();
          out = pageContext.getOut();

          /* Service Method Phase */

          // HTML // begin [file="/common/top.jsp";from=(0,29);to=(1,0)]
            out.write("\r\n");

          // end
          // HTML // begin [file="/common/top.jsp";from=(1,59);to=(2,0)]
            out.write("\r\n");

          // end
          // HTML // begin [file="/common/top.jsp";from=(2,66);to=(3,0)]
            out.write("\r\n");

          // end
          // HTML // begin [file="/common/top.jsp";from=(3,58);to=(4,0)]
            out.write("\r\n");

          // end
          // HTML // begin [file="/common/top.jsp";from=(4,58);to=(5,0)]
            out.write("\r\n");

          // end
          // HTML // begin [file="/common/top.jsp";from=(5,51);to=(6,0)]
            out.write("\r\n");

          // end
          // ##DEBUG## ##SCRIPTLET## "/common/top.jsp" 7,2-"/common/top.jsp" 13,0  LineMapIndex:1
            
            	int app = ParamsParser.getApplication(pageContext);
            	int state = ParamsParser.getState(pageContext);
            	String helpFile = "window.open('" + com.hps.july.util.AppUtils.getHelpFileName(app, state) + "', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;";
            	Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
            	com.hps.july.valueobject.RegionsAccess_TO curReg = profile.getProfileAccess().getCurrRegion();		
          // end
          // HTML // begin [file="/common/top.jsp";from=(12,2);to=(20,45)]
            out.write("\r\n<TABLE class=includer border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n\t<TR>\r\n\t\t<TD colspan=\"3\" width=\"100%\" bgcolor=\"D6EBFF\" height=\"43\">\r\n\t\t\t<table height=\"100%\" width=\"100%\">\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t<img src=\"/images/logo_beeline_dogovor.gif\" border=\"0\" alt=\"\">\r\n\t\t\t\t\t\t<B style=\"color: blue; font-size: 80%\">");

          // end
          // ##DEBUG## "/common/top.jsp" 21,48-"/common/top.jsp" 21,70  LineMapIndex:8
            out.print(curReg.getRegionName());
          // end
          // HTML // begin [file="/common/top.jsp";from=(20,72);to=(22,86)]
            out.write("</B>\r\n\t\t\t\t\t</td>\r\n                    <td width=\"10%\" align=\"right\"><a href=\"#\" title=\"Помощь\" onclick=\"");

          // end
          // ##DEBUG## "/common/top.jsp" 23,89-"/common/top.jsp" 23,99  LineMapIndex:9
            out.print( helpFile );
          // end
          // HTML // begin [file="/common/top.jsp";from=(22,101);to=(35,57)]
            out.write("\"><img src=\"/images/helph.gif\" border=\"0\" hspace=\"12\"></a></td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t</td>\r\n\t</TR>\r\n\t<tr>\r\n\t\t<td colspan=\"3\" background=\"/images/points3.gif\" height=\"1\"><img src=\"/images/empty.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\"></td>\r\n\t</tr>\r\n\r\n\t<TR>\r\n\t\t<TD COLSPAN=\"3\" vAlign=top width=\"100%\">\r\n\r\n\t\t  <TABLE class=\"main\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" vAlign=top height=\"100%\">\r\n\t\t\t<TR class=\"title\" style=\"height:15\"><TD class=\"title\">");

          // end
          // ##DEBUG## ##TAGLIB## "/common/top.jsp" 36,57-"/common/top.jsp" 36,79  LineMapIndex:10
            _jspx_th_july_statenavigator_0.setPageContext(pageContext);
            _jspx_th_july_statenavigator_0.setParent(null);
            _jspxTagObjects.push(_jspx_th_july_statenavigator_0);
              int _jspx_eval_july_statenavigator_0 = _jspx_th_july_statenavigator_0.doStartTag();
            // end
            // ##DEBUG## "/common/top.jsp" 36,57-"/common/top.jsp" 36,79  LineMapIndex:11
              if (_jspx_th_july_statenavigator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
          // end
          // HTML // begin [file="/common/top.jsp";from=(35,79);to=(36,3)]
            out.write("</TD></TR>\r\n\t\t\t");

          // end
          // ##DEBUG## ##TAGLIB## "/common/top.jsp" 37,3-"/common/top.jsp" 37,17  LineMapIndex:12
            /* ------  july:errors ------ */
            com.hps.july.taglib.ErrorsTag _jspx_th_july_errors_0 = new com.hps.july.taglib.ErrorsTag();
            _jspx_th_july_errors_0.setPageContext(pageContext);
            _jspx_th_july_errors_0.setParent(null);
            _jspxTagObjects.push(_jspx_th_july_errors_0);
              int _jspx_eval_july_errors_0 = _jspx_th_july_errors_0.doStartTag();
            // end
            // ##DEBUG## "/common/top.jsp" 37,3-"/common/top.jsp" 37,17  LineMapIndex:13
              if (_jspx_th_july_errors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
          // end
          // HTML // begin [file="/common/top.jsp";from=(36,17);to=(39,0)]
            out.write("\r\n\t\t\t<TR><TD vAlign=top width=\"100%\">\r\n\r\n");

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
      "/common/top.jsp", 
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
      },
      {
      "1", 
      "7", 
      "8", 
      "9", 
      "10", 
      "11", 
      "12", 
      "13", 
      "21", 
      "23", 
      "36", 
      "36", 
      "37", 
      "37", 
      },
      };
    }
