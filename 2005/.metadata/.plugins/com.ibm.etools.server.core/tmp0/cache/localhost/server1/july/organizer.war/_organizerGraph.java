package org.apache.jsp;

import com.hps.july.web.util.*;
import com.hps.july.organizer.*;
import com.hps.july.organizer.valueobject.*;
import com.hps.july.constants.Applications;
import com.hps.july.valueobject.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _organizerGraph extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _organizerGraph( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/organizerGraph.jsp";

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

        // HTML // begin [file="/organizerGraph.jsp";from=(0,29);to=(1,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(1,59);to=(2,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(2,106);to=(3,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(3,82);to=(4,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(4,58);to=(5,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(5,51);to=(8,1)]
          out.write("\r\n<SCRIPT language=javascript src=\"/common/exitFromNRI.js\" type=\"text/javascript\"></SCRIPT>  \r\n\r\n\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 9,3-"/organizerGraph.jsp" 11,4  LineMapIndex:1
          
          	    int appState = ParamsParser.getState( pageContext );
              
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(10,6);to=(13,2)]
          out.write("\r\n\t<script>\r\n\t<!--\r\n\t\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 14,4-"/organizerGraph.jsp" 25,4  LineMapIndex:4
          	Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
          			String lastUrl = null;
          			String classButton = "ButtonEnabledArmed";
          			String menuStatus = "0";
          			if(profile != null) {
          				lastUrl = profile.getSystemLastURL();
          				menuStatus = profile.getSystemMenuStatus();
          				if(menuStatus == null) menuStatus = "0"; 
          				else if(menuStatus.equals("1")) classButton = "ButtonEnabledArmedPressed";
          			}
          			if(lastUrl != null && appState != APPStates.LOGOUT) { 
          				
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(24,6);to=(24,33)]
          out.write(" document.location.href = '");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 25,36-"/organizerGraph.jsp" 25,43  LineMapIndex:16
          out.print(lastUrl);
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(24,45);to=(24,48)]
          out.write("'; ");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 25,50-"/organizerGraph.jsp" 27,2  LineMapIndex:17
          
          			}
          		
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(26,4);to=(27,13)]
          out.write("\r\n\t\tvar stat = ");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 28,16-"/organizerGraph.jsp" 28,26  LineMapIndex:20
          out.print(menuStatus);
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(27,28);to=(31,0)]
          out.write(";\r\n\t-->\r\n\t</script>\r\n\r\n");

        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(31,38);to=(38,32)]
          out.write("\r\n<TABLE class=includer border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <TR>\r\n    <TD colspan=\"3\" width=\"100%\" bgcolor=\"D6EBFF\" height=\"43\">\r\n\t<table height=\"100%\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<div id=\"ctnrButton\" class=\"");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 39,35-"/organizerGraph.jsp" 39,46  LineMapIndex:21
          out.print(classButton);
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(38,48);to=(47,0)]
          out.write("\">\r\n\t\t\t\t\t<iframe id=\"updateMenu1\" name=\"updateMenu1\" src=\"\" width=\"100%\" height=\"100%\" frameborder=\"0\" style=\"display:none\"></iframe>\r\n\t\t\t\t</div>\r\n\t\t\t\t<img src=\"/images/logo_beeline.gif\" border=\"0\" alt=\"\">\r\n\t\t\t</td>\r\n\t\t\t<td width=\"10%\" align=\"right\">\r\n\t\t\t\t<a href=\"#\" title=\"Помощь\" onclick=\"window.open('/organizer.doc', '_blank', 'top=40, left=100, width=830, height=630, scrollbars=yes, resizable=yes'); return false;\"><img src=\"/images/helph.gif\" border=\"0\" hspace=\"12\"></a>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n");

        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(56,4);to=(68,3)]
          out.write("\r\n\t</table>\r\n\t</td>\r\n  </TR>\r\n  <tr>\r\n\t<td colspan=\"7\" background=\"/images/points3.gif\" height=\"1\"><img src=\"/images/empty.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\"></td>\r\n  </tr>\r\n  <TR>\r\n    <TD vAlign=top width=\"240\" >\r\n<table width=\"240\" height=\"100%\" id=\"menuCntr\">\r\n\t<tr class=\"select\">\r\n\t\t<td class=\"menu\" vAlign=top>\r\n\t\t\t");

        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(70,7);to=(71,3)]
          out.write("\r\n\t\t\t");

        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(71,45);to=(72,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 73,3-"/organizerGraph.jsp" 73,63  LineMapIndex:22
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "menuTree.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(72,63);to=(125,1)]
          out.write("\r\n\t\t</td>\r\n    </tr>\r\n</TABLE>\r\n</TD>\r\n\t<script>\r\n\t<!--\r\n\t\tvar button2 = document.getElementById('ctnrButton');\r\n\t\tif(button2) {\r\n\t\t\tbutton2.onclick = function() {\r\n\t\t\t\tvar button1 = document.getElementById('ctnrButton');\r\n\t\t\t\tvar menuCntr = document.getElementById('menuCntr');\r\n\t\t\t\tvar menuUpdate2 = document.getElementById('updateMenu1');\r\n\t\t\t\t//var graphMenu = document.getElementById('graphMenu');\r\n\t\t\t\tif(button1 && menuCntr && menuUpdate2) {\r\n\t\t\t\t\tif(stat == 0) { \r\n\t\t\t\t\t\tbutton1.className = 'ButtonEnabledArmedPressed'; \r\n\t\t\t\t\t\tstat = 1; menuCntr.style.display = 'none'; //graphMenu.style.display = 'block';\r\n\t\t\t\t\t}\r\n\t\t\t\t\telse { \r\n\t\t\t\t\t\tbutton1.className = 'ButtonEnabledArmed'; \r\n\t\t\t\t\t\tstat = 0; menuCntr.style.display = 'block'; //graphMenu.style.display = 'none';\r\n\t\t\t\t\t}\r\n\t\t\t\t\tvar url = '/organizer/updateMenu?menu_status=' + stat;\r\n\t\t\t\t\tif(menuUpdate2)\t{\r\n\t\t\t\t\t\tmenuUpdate2.src = url;\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t\tvar button1 = document.getElementById('ctnrButton');\r\n\t\t\tvar menuCntr = document.getElementById('menuCntr');\r\n\t\t\t//var graphMenu = document.getElementById('graphMenu');\r\n\t\t\tif(button1 && menuCntr) {\r\n\t\t\t\tif(stat == 0) { \r\n\t\t\t\t\tbutton1.className = 'ButtonEnabledArmed'; \r\n\t\t\t\t\tmenuCntr.style.display = 'block';\r\n\t\t\t\t\t//graphMenu.style.display = 'none';\r\n\t\t\t\t}\r\n\t\t\t\telse { \r\n\t\t\t\t\tbutton1.className = 'ButtonEnabledArmedPressed'; \r\n\t\t\t\t\tmenuCntr.style.display = 'none';\r\n\t\t\t\t\t//graphMenu.style.display = 'block';\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t\t\r\n\t\t}\r\n\t-->\r\n\t</script>\r\n\r\n<td style=\"background-image: url(/images/points_vert.gif); background-repeat: repeat-y;\"><img src=\"/images/empty.gif\" width=\"1\" height=\"1\" border=\"0\" alt=\"\"></td>\r\n\r\n<TD vAlign=top width=\"100%\">\r\n\r\n\t");

        // end
        // ##DEBUG## ##TAGLIB## "/organizerGraph.jsp" 126,1-"/organizerGraph.jsp" 126,15  LineMapIndex:23
          _jspx_th_july_errors_0.setPageContext(pageContext);
          _jspx_th_july_errors_0.setParent(null);
          _jspxTagObjects.push(_jspx_th_july_errors_0);
            int _jspx_eval_july_errors_0 = _jspx_th_july_errors_0.doStartTag();
          // end
          // ##DEBUG## "/organizerGraph.jsp" 126,1-"/organizerGraph.jsp" 126,15  LineMapIndex:24
            if (_jspx_th_july_errors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(125,15);to=(126,1)]
          out.write("\r\n\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 127,3-"/organizerGraph.jsp" 131,3  LineMapIndex:25
          
          	switch( appState )
          		{
          		case APPStates.MAIN:
          			
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(130,5);to=(131,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 132,3-"/organizerGraph.jsp" 132,63  LineMapIndex:30
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/orgMain.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(131,63);to=(132,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 133,5-"/organizerGraph.jsp" 136,3  LineMapIndex:31
          
          			break;
          		case APPStates.LOGIN:
          			
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(135,5);to=(136,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 137,3-"/organizerGraph.jsp" 137,65  LineMapIndex:35
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/loginForm.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(136,65);to=(137,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 138,5-"/organizerGraph.jsp" 141,3  LineMapIndex:36
          
          			break;
          		case APPStates.LOGOUT:
          			
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(140,5);to=(141,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 142,3-"/organizerGraph.jsp" 142,66  LineMapIndex:40
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/logoutForm.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(141,66);to=(142,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 143,5-"/organizerGraph.jsp" 146,3  LineMapIndex:41
          
          			break;
          		case APPStates.REREGISTER:
          			
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(145,5);to=(146,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 147,3-"/organizerGraph.jsp" 147,70  LineMapIndex:45
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/reregisterForm.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(146,70);to=(147,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 148,5-"/organizerGraph.jsp" 151,3  LineMapIndex:46
          
          			break;
          		case APPStates.TASKLIST:
          			
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(150,5);to=(151,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 152,3-"/organizerGraph.jsp" 152,64  LineMapIndex:50
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/taskList.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(151,64);to=(152,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 153,5-"/organizerGraph.jsp" 156,3  LineMapIndex:51
          
          			break;
          		case APPStates.ERROR:
          			
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(155,5);to=(156,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 157,3-"/organizerGraph.jsp" 157,61  LineMapIndex:55
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/error.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(156,61);to=(157,3)]
          out.write("\r\n\t\t\t");

        // end
        // ##DEBUG## ##SCRIPTLET## "/organizerGraph.jsp" 158,5-"/organizerGraph.jsp" 161,3  LineMapIndex:56
          
          			break;
          		default:
          			
        // end
        // HTML // begin [file="/organizerGraph.jsp";from=(160,5);to=(161,12)]
          out.write("\r\n            ");

        // end
        // ##DEBUG## "/organizerGraph.jsp" 162,12-"/organizerGraph.jsp" 162,70  LineMapIndex:60
          {
            String _jspx_qStr = "";
            JspRuntimeLibrary.include(request, response, "/error.jsp" + _jspx_qStr, out, true);
            if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
              return;
          }
        // end
   