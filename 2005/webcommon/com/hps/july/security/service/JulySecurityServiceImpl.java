package com.hps.july.security.service;

//import javax.security.auth.login.LoginContext;
//import javax.security.auth.login.LoginException;
//import javax.servlet.http.HttpServletRequest;
//
//import com.ibm.websphere.security.auth.callback.WSCallbackHandlerImpl;

/**
 * @author dkrivenko
 */
public class JulySecurityServiceImpl implements JulySecurityService {

	/* (non-Javadoc)
	 * @see com.hps.july.security.service.SecurityService#switchOperator(java.lang.String)
	 */
	public void switchOperator(String operatorLogin) throws JulySecurityException {
//		LoginContext lc = null;
//            
//		 try {
//			String systemPassword = 
//				"kjdr85ngne774m,fpriogj3hhdyrug-d04k65mgkx8su4v -q-r8unwe87fj" +
//				"djwlk4jdm,spss498e812jm4-g8gkeped9trkgkld-f9snwlc.z/e]w=a0f9" + 
//				"d8r8340esldslkfk9e9pwoekfsigr958lss,mmcnyusoskdmgmnvreiz;;;se" +
//				"--rgf93ksksnac14w83f]-w4okgpw48yubc029y54tb-qeriegmna939r9flfk" +
//				"sjhhhrisdp[dlthlhlfp[rtohrjifigmrepotitjrpriotg04drorgogiew903" + 
//				"f85jgllyie82mfnqp0f-4orkgfjhdud9edl54-tlgldldkt94ug'''d0r90gkk";
//
//			   lc = new LoginContext("WSLogin",         
//						  new WSCallbackHandlerImpl(operatorLogin, "1Qazzaq1"));
//							
//		 } catch (LoginException le) {
//			   logError("Cannot create LoginContext. " + le.getMessage(), le);
//		 	   throw new JulySecurityException("Cannot create LoginContext. " + le.getMessage(), le); 
//		 } catch(SecurityException se) {
//			   logError("Cannot create LoginContext." + se.getMessage(), se);
//			   throw new JulySecurityException("Cannot create LoginContext." + se.getMessage(), se);
//		 }
//
//		  try { 
//		  	   	lc.login(); 
//				logInfo("Switch to operator " + operatorLogin + " successfully");
//		  } catch(LoginException le) {
//				logError("Fails to create Subject. " + le.getMessage(), le);
//				throw new JulySecurityException("Fails to create Subject. " + le.getMessage(), le);
//		  }
//		
//		  
	}

	/**
	 * @param string
	 * @param le
	 */
	private void logError(String message, Throwable e) {
		log("ERROR", message, e);		
	}

	/**
	 * @param string
	 * @param message
	 * @param e
	 */
	private void log(String logStatus, String message, Throwable e) {
		System.out.println(logStatus + " - " + this.getClass().getName() + ": " + message);
		if (e != null)
			e.printStackTrace();
	}

	/**
	 * @param string
	 * @param message
	 */
	private void log(String logStatus, String message) {
		log(logStatus, message, null);
	}

	/**
	 * @param string
	 */
	private void logInfo(String message) {
		log("INFO", message);
	}


}
