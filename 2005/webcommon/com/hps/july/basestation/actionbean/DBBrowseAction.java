package com.hps.july.basestation.actionbean;

import com.hps.july.siteinfo.valueobject.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.basestation.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.cdbc.lib.*;

/**
 * Обработчик списка элементов оборудования
 */
public class DBBrowseAction
	extends com.hps.july.web.util.BrowseAction
{
protected CDBCResultSet invokeDBProc(String procname,Object[] filterParams) {
	CDBCResultSet rs = new CDBCResultSet();
	return rs;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	String s = request.getParameter(Constants.PROCESS_PROPERTY);
	if ("1".equals(s)) {
		return mapping.findForward("process");
	}
/*
    // Call browse initialization
	ActionForward result = ((BrowseForm)form).initBrowse(mapping, request, response);
	if (result != null) return result;
    
	// Call navigated perform
	super.perform(mapping, form, request, response);

    //get form
    DBBrowseForm browseForm = (DBBrowseForm) form;
    ActionErrors errors = new ActionErrors();

    try {
        browseForm.validateValues(errors); 

        // Determine browse bean name
        String procname = browseForm.getBrowseProcedureName();
		Object[] filterParams = browseForm.getFilterParams();
		// @TODO: Invoke browse procedure
		CDBCResultSet rs = invokeDBProc(procname,filterParams);

		int rowsOnPage = getRowsOnPage();
		int stdRowsOnPage = 30;
		int overlapRows = getOverlapRows();
        //calculate new page
        int pages = 0;

        if (rowsOnPage == -1) {
			rowsOnPage = rs.getRowsCount();
			if (rowsOnPage < stdRowsOnPage) {
				rowsOnPage = stdRowsOnPage;
			}
		}
		pages = rs.getRowsCount() / (rowsOnPage - overlapRows) + 1;
		request.setAttribute("numberOfLines", new Integer(((CDBCResultSet)collection).getRowsCount()).toString());
		
        String action = browseForm.getBrowseAction();
        int page = browseForm.getCurrentPage();
        
		if (Constants.BROWSE_ACTION_BOTTOM.equals(action)) {
			page = Integer.MAX_VALUE;
			browseForm.setBrowseAction("");
		} else if (Constants.BROWSE_ACTION_NEXT.equals(action)) {
			page++;
			browseForm.setBrowseAction("");
		} else if (Constants.BROWSE_ACTION_PREV.equals(action)) {
			page--;
			browseForm.setBrowseAction("");
		} else if (Constants.BROWSE_ACTION_TOP.equals(action)) {
			page = 1;
			browseForm.setBrowseAction("");
		}
        page = (page >= 1) ? page : 1;

        //building display list
        ArrayList displayList = new ArrayList(rowsOnPage);
        int nRecords = 1;
		int startRecord = (page-1) * (rowsOnPage - overlapRows);
		if (startRecord < 0)
			startRecord = 0;
		int endRecord = startRecord + rowsOnPage - 1;
		int curRecord = -1;
		int i = -1;
		int goodRecords = 0;

		if (collection != null) {
			ListIterator cdbcit = null;
			Iterator colIter = null;
			Enumeration colEnum = null;
			if (isCDBC)
				cdbcit = ((CDBCResultSet)collection).listIterator();
			else if (isCollection)
				colIter = ((Collection)collection).iterator();
			else
				colEnum = ((AccessBeanTable)collection).rows();

//			tc.finish(">>>>	BROWSE: #2.2");
			
			//System.out.println(">>>> BROWSE: StartRecord=" + startRecord + ", EndRecord=" + endRecord);	
        	while (true) {
	        	if (isCDBC) {
	        		if (!cdbcit.hasNext())
	        			break;
	        	} else if (isCollection) {
	        		if (!colIter.hasNext())
	        			break;
	        	} else {
	        		if (!colEnum.hasMoreElements())
	        			break;
	        	}
	        	curRecord++;
	        	int curPage = curRecord / (rowsOnPage - overlapRows) + 1;
				if (page == (curPage-1))
					curPage = page;

	        	// Calculate display index
	        	i = rowsOnPage - curPage * (rowsOnPage-overlapRows) + curRecord - overlapRows;

	        	//System.out.println(">>>> BROWSE: CurRecord=" + curRecord + ", curPage=" + curPage + ", i=" + i);
	        		
	        	Object arec = null;
	        	if (isCDBC)
	        		arec = cdbcit.next();
	        	else if (isCollection)
	        		arec = colIter.next();
	        	else
	        		arec = colEnum.nextElement();
	        		
	        	if ((curRecord >= startRecord) && (curRecord <= endRecord)) {
		        	Object brec = ((BrowseForm)form).constructRowModelBean(arec);
		        	if (brec == null)
		        		brec = constructRowModelBean(arec);
		        	try {
	        			displayList.set(i, brec);
		        	} catch (java.lang.IndexOutOfBoundsException ee) {
		        		displayList.add(i, brec); // Store current element
		        	}
	        		goodRecords++;
	        	} else {
		        	try {
		        		displayList.set(i, arec); // Store current element
		        	} catch (java.lang.IndexOutOfBoundsException ee) {
		        		displayList.add(i, arec); // Store current element
		        	}
	        	}
	        	// Check end of page
	        	if (curRecord == endRecord)
	        		break;

        	}

//			tc.finish(">>>>	BROWSE: #2.3");
        	//System.out.println(">>>> BROWSE: GoodRecords=" + goodRecords);
        	boolean needConstruct = false;
        	
			// Check if we are after end page
			if ((goodRecords == 0) && (curRecord < startRecord)) {
				goodRecords = i+1;
				//page = (curRecord + overlapRows) / rowsOnPage + 1;
		        page = curRecord / (rowsOnPage - overlapRows) + 1;
		        needConstruct = true;
			}
			// Check end page
			for (int j = (rowsOnPage-1); j >= goodRecords; j--) {
				try {
					displayList.remove(j);
			    } catch (java.lang.IndexOutOfBoundsException ee) {
				    // Nothing to remove
			    }
			}

			// Construct unconstructed objects
			if (needConstruct) {
        		//System.out.println(">>>> BROWSE: Constructing last page objects");
				for (int k = 0; k < displayList.size(); k++) {
					Object arec = displayList.get(k);
		        	Object brec = ((BrowseForm)form).constructRowModelBean(arec);
		        	if (brec == null)
		        		brec = constructRowModelBean(arec);
	        		displayList.set(k, brec);
				}
			}

			//pages = page;
			
		} else {
			collection = new Vector().elements();
		}
		
//		tc.finish(">>>>	BROWSE: #3");
    	
        browseForm.setCurrentPage(page);
        if (displayList.size() == 0)
        	displayList.add(null);
        request.setAttribute("browseList", displayList);
        request.setAttribute("numberOfPages", new Integer(pages));
        if (!errors.empty()) 
        	saveErrors(request, errors);
    } catch (Exception e) {
        browseForm.setCurrentPage(0);
        Vector displayList = new Vector();
        displayList.add(null);
        request.setAttribute("browseList", displayList);
        request.setAttribute("numberOfPages", new Integer(0));
        if (!errors.empty()) {
            System.out.println("Error while check form:");
        } else {
            System.out.println("Error while constructing list:");
            e.printStackTrace(System.out);
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
        }
        saveErrors(request, errors);
        //throw new ServletException( "While constructing list: ", e );
    }
    // Memory collection Debug
    //System.gc();
*/
    return mapping.findForward( "main" );
}
}
