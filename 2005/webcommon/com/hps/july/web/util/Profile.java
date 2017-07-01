package com.hps.july.web.util;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

/**
 * Класс описывает профайл текущего пользователя.
 * Creation date: (13.09.2004 11:49:58)
 * @author: Vadim Glushkov
 */
public class Profile {

    public static final String PROFILE = "USER_PROFILE";

    //-------------
    public static final String SYSTEM = "SYSTEM"; //основные параметры	профиля Пользователя
    public static final String MENU_STATUS = "menu_status"; // 0/1; close/open; default open
    public static final String LAST_VISITED_URL = "last_visited_url"; // последний посещенный урл
    public static final String MENU_ITEM = "itemMenu"; // текущее состояние меню (выбранный элемент)
	public static final String TERRABYTE_SERVER = "TERRABYTE_SERVER"; // текущий файловый сервер  
	public static final String TERRABYTE_HOST = "TERRABYTE_HOST"; // текущий файловый сервер  
	public static final String TERRABYTE_PORT = "TERRABYTE_PORT"; // текущий файловый сервер  

    //-------------
    public static final String FORM = "FORM"; //все параметры формы - на будущее

    //-------------
    public static final String SELECTABLE = "SELECTABLE"; //все выьираемые параметры
    public static final String SELECTED = "SELECTED"; //move to this name, in query #p...
    public static final String SELECTABLE_PREFIX = "selectable_"; // префикс выьираемых параметров
    public static final String SELECTABLE_POSTFIX = "_next"; // постфикс выьираемых параметров
    public static final String PROFILE_PARAM = "profile_param"; // постфикс выьираемых параметров
    public static final String ACTION = "action_"; //для определения нажатого линка !
    public static final String ANCHOR_NAME = "anchor_name";
    public static final String PARAM_NAME = "param_name";

    private HashMap params = new HashMap();
    private HashMap systemParams = new HashMap();

    private java.lang.String currentURL;
    private java.lang.String previousURL;
    private String login = null;
    private Integer operatorId = null;
    private ProfileAccess profileAccess = null;//для модуля Аренды(разделение по регионам и др.)
	/**
	 * Profile constructor comment.
	 */
	public Profile() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.12.2005 17:26:31)
	 * @param userName java.lang.String
	 */
	public Profile(String userName) {
		this.login = userName;
	}
	public void add(ActionMapping mapping, HttpServletRequest request) {
		
		setLogin(request);
		String url = calculateKey(mapping, request);
		this.previousURL = this.currentURL;
		this.currentURL = url;
		
		HashMap selectable = null;
		
		selectable = getSelectableParams(this.currentURL, true);

		//определение всех выбираемых параметров
		addSelectableParams(selectable, request);
		return;
	}
	private void addSelectableParams(HashMap params, javax.servlet.http.HttpServletRequest request) {
		if(params != null) {
			Enumeration names = request.getParameterNames();
			while(names.hasMoreElements()) {
				String name = (String)names.nextElement();
				if(name != null && (name.indexOf(Profile.SELECTABLE_PREFIX, 0) > 0)
					&& (name.indexOf(Profile.SELECTABLE_POSTFIX, 0) == -1)) {
						String value = request.getParameter(name);
						params.put(name, value);
						value = request.getParameter(name + Profile.SELECTABLE_POSTFIX);
						if(value != null) {
							params.put(name + Profile.SELECTABLE_POSTFIX, value);
						}
				}
				if(name != null && Profile.ANCHOR_NAME.equals(name)) {
					String value = request.getParameter(name);
					params.put(name, value);
				}
			}
			String profileParam = request.getParameter(Profile.PROFILE_PARAM);
			if(profileParam != null) {
				profileParam = profileParam.substring(1);
				profileParam = profileParam.substring(0, profileParam.length()-1);
				HashMap previousSelectable = getSelectableParams(this.previousURL, true);
				if(previousSelectable != null) {
					parseParameters(previousSelectable, profileParam.getBytes());
				}
			}
			//this.info();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.12.2004 17:57:03)
	 * @param mapping org.apache.struts.action.ActionMapping
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public void addSystemLastURL(String url) {
		//setLogin(request);  //----есть в ProcessAction !
		//String url = computeURL(mapping, request); //перенесли на определение ProfileProcess
		//System.out.println("LAST VISITED URL [" + url + "]");
        setSystemParameter(LAST_VISITED_URL, url);
		return;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2005 12:05:40)
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public void addSystemMenuItem(String menuItem) {
			//setLogin(request);
			//String menuItem = request.getParameter(MENU_ITEM);
			setSystemParameter(MENU_ITEM, menuItem);
	}
	public void addSystemTerrabyteServer(Integer terrabyteServerId) {
			setSystemParameter(TERRABYTE_SERVER, terrabyteServerId);
	}
	protected void addSystemTerrabyteHost(String terrabyteServerHost) {
			setSystemParameter(TERRABYTE_HOST, terrabyteServerHost);
	}
	protected void addSystemTerrabytePort(Integer terrabyteServerPort) {
			setSystemParameter(TERRABYTE_PORT, terrabyteServerPort);
	}
	public void addSystemMenuStatus(HttpServletRequest request) {
		setLogin(request);
		String status = request.getParameter(MENU_STATUS);
        setSystemParameter(MENU_STATUS, status);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.12.2004 17:53:45)
	 * @param mapping org.apache.struts.action.ActionMapping
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public String calculateKey(ActionMapping mapping, HttpServletRequest request) {
		String path = mapping.getPath();
		String contextPath = request.getContextPath();
		String url = contextPath + path;
		return url;
	}
    private byte convertHexDigit( byte b ) {
        if ((b >= '0') && (b <= '9')) return (byte)(b - '0');
        if ((b >= 'a') && (b <= 'f')) return (byte)(b - 'a' + 10);
        if ((b >= 'A') && (b <= 'F')) return (byte)(b - 'A' + 10);
        return 0;
    }
	public java.lang.String getCurrentURL() {
		return currentURL;
	}
    public String getLogin() {
	    return this.login;
    }
    public Integer getOperatorId() {
	    return this.operatorId;
    }
	public java.lang.String getPreviousURL() {
		return previousURL;
	}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 13:43:43)
 * @return com.hps.july.web.util.ProfileAccess
 */
public ProfileAccess getProfileAccess() {
    if (profileAccess == null)
        initProfileAccess();
    return profileAccess;
}
	public String getSelectableAction(String key) {
		return getSelectableParameter(key, Profile.ACTION);
	}
	public String getSelectableAnchor(String key) {
		return getSelectableParameter(key, Profile.ANCHOR_NAME);
	}
	public String getSelectableCurrentParameter(String key, String name) {
		return getSelectableParameter(key, Profile.SELECTABLE_PREFIX + name);
	}
	public String getSelectableNextParameter(String key, String name) {
		return getSelectableParameter(key, Profile.SELECTABLE_PREFIX + name + Profile.SELECTABLE_POSTFIX);
	}
	protected String getSelectableParameter(String key, String name) {
		HashMap selectable = getSelectableParams(key, false);
		String value = (selectable != null)?((String)selectable.get(name)):null;
		return value;
	}
	public String getSelectableParamName(String key) {
		return getSelectableParameter(key, Profile.PARAM_NAME);
	}
	private HashMap getSelectableParams(String key, boolean create) {
		HashMap contextParam = null;
		HashMap selectable = null;
		if(key != null) {
			contextParam = (HashMap)this.params.get(key);
			if(contextParam == null) {
				if(create) {
					contextParam = new HashMap(1);
					selectable = new HashMap(6);
					this.params.put(key, contextParam);
					contextParam.put(SELECTABLE, selectable);
				}
			} else {
				selectable = (HashMap)contextParam.get(SELECTABLE);
				if(selectable == null) {
					selectable = new HashMap(6);
					contextParam.put(SELECTABLE, selectable);
				}
			}
		}
		return selectable;
	}
	public String getSystemLastURL() {
		String url = (String)this.systemParams.get(LAST_VISITED_URL);
		return url;
	}
	/**
	 * Метод для получения состояния меню (выделенного элемента)
	 * Creation date: (28.11.2005 12:31:55)
	 * @return java.lang.String
	 */
	public String getSystemMenuItem() {
			String status = (String)this.systemParams.get(MENU_ITEM);
			return status;
	}
	public String getSystemMenuStatus() {
		String status = (String)this.systemParams.get(MENU_STATUS);
		return status;
	}
	public Integer getSystemTerrabyteServer() {
		return (Integer)this.systemParams.get(TERRABYTE_SERVER);
	}
	public String getSystemTerrabyteHost() {
		return (String)this.systemParams.get(TERRABYTE_HOST);
	}
	public Integer getSystemTerrabytePort() {
		return (Integer)this.systemParams.get(TERRABYTE_PORT);
	}
    public Object getSystemParam(String key) {
        return this.systemParams.get(key);
    }
    public Collection getSystemParamsNames() {
        return this.systemParams.keySet();
    }
	public void info() {
		System.out.println("------------------");
		java.util.Set s = this.params.keySet();
		java.util.Iterator iter = s.iterator();
		int mapCount = 0;
		int objectCount = 0;
		int keyCount = 0;
		while(iter.hasNext()) {
			String s1 = (String)iter.next();
			if(s1 != null) {
				keyCount++;
				System.out.println("["+s1+"]");
				HashMap m = (HashMap)this.params.get(s1);
				if(m != null) {
					mapCount++;
					java.util.Set s2 =  m.keySet();
					java.util.Iterator iter2 = s2.iterator();
					while(iter2.hasNext()) {
						String s3 = (String)iter2.next();
						keyCount++;
						System.out.println("\t ["+s3+"]");
						HashMap m4 = (HashMap)m.get(s3);
						mapCount++;
						java.util.Set s4 =  m4.keySet();
						java.util.Iterator iter4 = s4.iterator();
						while(iter4.hasNext()) {
							String s10= (String)iter4.next();
							objectCount++;
							System.out.println("\t\t ["+s10+"]-["+m4.get(s10)+"]");
						}
					}
				}
			}
		}
		System.out.println("ProfileInfo \tkeyCount["+keyCount+"]");
		System.out.println("ProfileInfo \tmapCount["+mapCount+"]");
		System.out.println("ProfileInfo \tobjectCount["+objectCount+"]");
		System.out.println("------------------");
	}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 13:41:44)
 */
private void initProfileAccess() {
    setProfileAccess(new ProfileAccess(getOperatorId()));
}
    private void parseParameters(HashMap map, byte[] data) {

        if (data != null && data.length > 0) {
            int    pos = 0;
            int    ix = 0;
            int    ox = 0;
            String key = null;
            String value = null;
            while (ix < data.length) {
                byte c = data[ix++];
                switch ((char) c) {
                case '|':
                    value = new String(data, 0, ox);
                    if (key != null) {
                        map.put(key, value);
                        key = null;
                    }
                    ox = 0;
                    break;
                case '=':
                    if (key == null) {
                        key = new String(data, 0, ox);
                        ox = 0;
                    } else {
                        data[ox++] = c;
                    }
                    break;
                case '+':
                    data[ox++] = (byte)' ';
                    break;
                case '%':
                    data[ox++] = (byte)((convertHexDigit(data[ix++]) << 4)
                                    + convertHexDigit(data[ix++]));
                    break;
                default:
                    data[ox++] = c;
                }
            }
            if (key != null) {
                value = new String(data, 0, ox);
            	map.put(key, value);
            }
        }
    }
	public void setCurrentURL(java.lang.String newCurrentURL) {
		currentURL = newCurrentURL;
	}
    public void setLogin(String login) {
        if(login != null) {
            if(this.login != null && !login.equals(this.login)) {
                this.operatorId = null;
            }
            this.login = login;
        }
    }
    public void setLogin(javax.servlet.http.HttpServletRequest request) {
	    //System.out.println("request.getUserPrincipal() ["+request.getUserPrincipal()+"]");
	    //System.out.println("request.getRemoteUser() ["+request.getRemoteUser()+"]");
	    String login = null;
	    if(request.getUserPrincipal() != null) login = request.getUserPrincipal().getName();
        setLogin(login);
    }
    public void setOperatorId(Integer oper) {
	    this.operatorId = oper;
    }
	public void setPreviousURL(java.lang.String newPreviousURL) {
		previousURL = newPreviousURL;
	}
/**
 * Insert the method's description here.
 * Creation date: (21.11.2005 13:43:43)
 * @param newProfileAccess com.hps.july.web.util.ProfileAccess
 */
private void setProfileAccess(ProfileAccess newProfileAccess) {
	profileAccess = newProfileAccess;
}
	public void setSelectableAction(String key, String value) {
		setSelectableParameter(key, Profile.ACTION, value);
	}
	public void setSelectableAnchor(String key, String value) {
		setSelectableParameter(key, Profile.ANCHOR_NAME, value);
	}
	public void setSelectableCurrentParameter(String key, String name, String value) {
		setSelectableParameter(key, Profile.SELECTABLE_PREFIX + name, value);
	}
	public void setSelectableNextParameter(String key, String name, String value) {
		setSelectableParameter(key, Profile.SELECTABLE_PREFIX + name + Profile.SELECTABLE_POSTFIX, value);
	}
	public void setSelectableParameter(String key, String name, String value) {
		HashMap selectable = getSelectableParams(key, false);
		if(selectable != null) selectable.put(name, value);
	}
	public void setSelectableParamName(String key, String value) {
		setSelectableParameter(key, Profile.PARAM_NAME, value);
	}
	public void setSystemParameter(String key, Object value) {
        setSystemParameter(key, value, false);
	}
	public void setSystemParameter(String key, Object value, boolean load) {
		Object currentValue = (Object)this.systemParams.get(key);
		String chKey = "ch__" + key;
		//параметр загружен !
        if(load) this.systemParams.put(chKey, new Character('0'));
        else {
        	//TODO: переделать !
	        Character changed = (Character)this.systemParams.get(chKey);
	        if(changed != null && changed.charValue() != '2') {
	            if(currentValue == null) {
	                this.systemParams.put(chKey, new Character('2'));
	            } else {
	                if(value != null && !currentValue.equals(value)) {
	                    this.systemParams.put(chKey, new Character('1'));
	                } else {
	                	//всегда update
						this.systemParams.put(chKey, new Character('1')); 
	                    //this.systemParams.put(chKey, new Character('0'));
	                }
	            }
	        } else {
		        //флаг указывающий на новый параметр
		        this.systemParams.put(chKey, new Character('2'));
	        }
        }
		//System.out.println("load ["+load+"] curValue ["+currentValue+"]  new ["+value+"]"  );
		//System.out.println("IN  ---- ["+key+"] ["+value+"]  CH["+((Character)this.systemParams.get(chKey)).charValue()+"]");
		this.systemParams.put(key, value);
		return;
	}
}
