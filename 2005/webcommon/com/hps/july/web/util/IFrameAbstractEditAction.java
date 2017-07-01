/*
 * Created on 10.07.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.web.util;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class IFrameAbstractEditAction extends AbstractEditAction {
	
	public IFrameAbstractEditAction() {
		super();
		// setLastVisited(false);
	}
	
	public boolean isAddtoHistory() {
		return false;
	}
	
	public boolean isReturnable() {
		return false;
	}

	public static boolean isNavigateModule(int app) {
		return false;
	}

}
