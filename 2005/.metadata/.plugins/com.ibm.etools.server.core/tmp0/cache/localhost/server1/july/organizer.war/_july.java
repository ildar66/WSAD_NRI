package org.apache.jsp;

import com.hps.july.web.util.*;
import com.hps.july.constants.*;
import com.hps.july.organizer.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _july extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _july( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/july.jsp";

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
      /* ------  july:licence ------ */
      com.hps.july.taglib.LicenceTag _jspx_th_july_licence_0 = new com.hps.july.taglib.LicenceTag();

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

        // HTML // begin [file="/july.jsp";from=(0,29);to=(1,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/july.jsp";from=(1,59);to=(2,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/july.jsp";from=(2,94);to=(3,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/july.jsp";from=(3,51);to=(5,0)]
          out.write("\r\n\r\n");

        // end
        // HTML // begin [file="/initProfile.jspf";from=(0,0);to=(1,0)]
          out.write("\r\n");

        // end
        // ##DEBUG## ##SCRIPTLET## "/initProfile.jspf" 2,2-"/initProfile.jspf" 12,0  LineMapIndex:1
          
              Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
              String userName = request.getRemoteUser();
              if (profile == null && userName != null) {
                  profile = new Profile(userName);
                  request.getSession().setAttribute(Profile.PROFILE, profile);
                  //update profile
          		ProcessProfile pp = new ProcessProfile();
                  pp.loadProfile(profile);
              }
        // end
        // HTML // begin [file="/initProfile.jspf";from=(11,2);to=(12,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/july.jsp";from=(5,36);to=(15,0)]
          out.write("\r\n\r\n<html>\r\n<head>\r\n <META HTTP-EQUIV = \"Pragma\" CONTENT=\"no-cache\">\r\n <title>Вход в систему</title>\r\n <link rel=\"stylesheet\" type=\"text/css\" href=\"/main.css\">\r\n</head>\r\n\r\n<body>\r\n");

        // end
        // ##DEBUG## ##TAGLIB## "/july.jsp" 16,0-"/july.jsp" 16,39  LineMapIndex:12
          _jspx_th_july_licence_0.setPageContext(pageContext);
          _jspx_th_july_licence_0.setParent(null);
          _jspx_th_july_licence_0.setLicence("/comctl2.lpk");
          _jspxTagObjects.push(_jspx_th_july_licence_0);
            int _jspx_eval_july_licence_0 = _jspx_th_july_licence_0.doStartTag();
          // end
          // ##DEBUG## "/july.jsp" 16,0-"/july.jsp" 16,39  LineMapIndex:13
            if (_jspx_th_july_licence_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
        // end
        // HTML // begin [file="/july.jsp";from=(15,39);to=(16,1)]
          out.write("\r\n\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/july.jsp" 17,3-"/july.jsp" 25,14  LineMapIndex:14
          
          	int app = ParamsParser.getApplication( pageContext );
          	int state = ParamsParser.getState( pageContext );
          	switch( app ) {
          	  case Applications.ORGANIZER:
                    switch( state )
                      {
                      case APPStates.LOGIN  :
                        
        // end
        // HTML // begin [file="/july.jsp";from=(24,16);to=(25,14)]
          out.write("\r\n              ");

        // end
        // ##DEBUG## "/july.jsp" 26,14-"/july.jsp" 26,76  LineMapIndex:23
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/loginForm.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/july.jsp";from=(25,76);to=(26,14)]
          out.write("\r\n              ");

        // end
        // ##DEBUG## ##SCRIPTLET## "/july.jsp" 27,16-"/july.jsp" 30,7  LineMapIndex:24
          
                        break;
              		case APPStates.REREGISTER:
              			
        // end
        // HTML // begin [file="/july.jsp";from=(29,9);to=(30,7)]
          out.write("\r\n    \t\t\t");

        // end
        // ##DEBUG## "/july.jsp" 31,7-"/july.jsp" 31,74  LineMapIndex:28
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/reregisterForm.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/july.jsp";from=(30,74);to=(31,7)]
          out.write("\r\n    \t\t\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/july.jsp" 32,9-"/july.jsp" 35,14  LineMapIndex:29
          
              			break;
                      default:
                        
        // end
        // HTML // begin [file="/july.jsp";from=(34,16);to=(35,14)]
          out.write("\r\n              ");

        // end
        // ##DEBUG## "/july.jsp" 36,14-"/july.jsp" 36,81  LineMapIndex:33
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/organizerGraph.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/july.jsp";from=(35,81);to=(36,14)]
          out.write("\r\n              ");

        // end
        // ##DEBUG## ##SCRIPTLET## "/july.jsp" 37,16-"/july.jsp" 42,3  LineMapIndex:34
          
                        break;
                      }
          		  break;
          		default:
          			
        // end
        // HTML // begin [file="/july.jsp";from=(41,5);to=(42,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## "/july.jsp" 43,3-"/july.jsp" 43,61  LineMapIndex:40
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/error.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/july.jsp";from=(42,61);to=(43,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/july.jsp" 44,5-"/july.jsp" 47,1  LineMapIndex:41
          
          			break;
          		}
          	
        // end
        // HTML // begin [file="/july.jsp";from=(46,3);to=(49,0)]
          out.write("\r\n</body>\r\n</html>\r\n");

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
    "/july.jsp", 
    "/initProfile.jspf", 
    },
    {
    "0", 
    "1", 
    },
    };
    public static String[][] _jspx_debug_LineMapping = {
    {
    "0", 
    "1", 
    "1", 
    "1", 
    "1", 
    "1", 
    "1", 
    "1", 
    "1", 
    "1", 
    "1", 
    "1", 
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
    "2", 
    "3", 
    "4", 
    "5", 
    "6", 
    "7", 
    "8", 
    "9", 
    "10", 
    "11", 
    "12", 
    "16", 
    "16", 
    "17", 
    "18", 
    "19", 
    "20", 
    "21", 
    "22", 
    "23", 
    "24", 
    "25", 
    "26", 
    "27", 
    "28", 
    "29", 
    "30", 
    "31", 
    "32", 
    "33", 
    "34", 
    "35", 
    "36", 
    "37", 
    "38", 
    "39", 
    "40", 
    "41", 
    "42", 
    "43", 
    "44", 
    "45", 
    "46", 
    "47", 
    },
    };
  }
