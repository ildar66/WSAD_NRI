package com.hps.july.web.util;

/**
 * ¬спомогательный класс дл€ работы с ресурсами.
 * Creation date: (28.11.2002 15:53:27)
 * @author: Dmitry Dneprov
 */
public class MessageUtils extends org.apache.struts.util.PropertyMessageResources {
/**
 * MessageUtils constructor.
 * @param factory org.apache.struts.util.MessageResourcesFactory
 * @param config java.lang.String
 */
public MessageUtils(org.apache.struts.util.MessageResourcesFactory factory, String config) {
	super(factory, config);
}
/**
 * MessageUtils constructor.
 * @param factory org.apache.struts.util.MessageResourcesFactory
 * @param config java.lang.String
 * @param returnNull boolean
 */
public MessageUtils(org.apache.struts.util.MessageResourcesFactory factory, String config, boolean returnNull) {
	super(factory, config, returnNull);
}
    // --------------------------------------------------------- Public Methods

 
    /**
     * Returns a text message for the specified key, for the default Locale.
     * A null string result will be returned by this method if no relevant
     * message resource is found for this key or Locale, if the
     * <code>returnNull</code> property is set.  Otherwise, an appropriate
     * error message will be returned.
     * <p>
     * This method must be implemented by a concrete subclass.
     *
     * @param locale The requested message Locale, or <code>null</code>
     *  for the system default Locale
     * @param key The message key to look up
     */
    public String getMessage(String key) {

	    String message;
        synchronized (messages) {
            message = (String) messages.get(key);
        }
		return message;
    }
}
