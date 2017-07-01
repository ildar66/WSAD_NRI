package com.hps.july.taglib;

/**
 * Insert the type's description here.
 * Creation date: (24.09.2004 16:39:43)
 * @author: Vadim Glushkov
 */
public abstract class BaseSelectableTag extends org.apache.struts.taglib.html.BaseTag {

//  Navigation Management

    /** Access key character. */
    protected String accesskey= null;

    /** Tab index value. */
    protected String tabindex = null;

//  Mouse Events

    /** Mouse click event. */
    private String onclick = null;

    /** Mouse double click event. */
    private String ondblclick = null;

    /** Mouse over component event. */
    private String onmouseover = null;

    /** Mouse exit component event. */
    private String onmouseout = null;

    /** Mouse moved over component event. */
    private String onmousemove = null;

    /** Mouse pressed on component event. */
    private String onmousedown = null;

    /** Mouse released on component event. */
    private String onmouseup = null;

//  Keyboard Events

    /** Key down in component event. */
    private String onkeydown = null;

    /** Key released in component event. */
    private String onkeyup = null;

    /** Key down and up together in component event. */
    private String onkeypress = null;

// Text Events

    /** Text selected in component event. */
    private String onselect = null;

    /** Content changed after component lost focus event. */
    private String onchange = null;

// Focus Events and States

    /** Component lost focus event. */
    private String onblur = null;

    /** Component has received focus event. */
    private String onfocus = null;

    /** Component is disabled. */
    private boolean disabled = false;

    /** Component is readonly. */
    private boolean readonly = false;

// CSS Style Support

    /** Style attribute associated with component. */
    private String style = null;

    /** Named Style class associated with component. */
    private String styleClass = null;

    /** Identifier associated with component.  */
    private String styleId = null;

// Other Common Attributes

    /** The advisory title of this element. */
    private String title = null;


    /** Returns the accessKey character. */
    public String getAccesskey() {
	return (this.accesskey);
    }
    /** Returns the disabled event handler. */
    public boolean getDisabled() {
        return disabled;
    }
    /** Returns the onBlur event handler. */
    public String getOnblur() {
        return onblur;
    }
    /** Returns the onChange event handler. */
    public String getOnchange() {
        return onchange;
    }
    /** Returns the onClick event handler. */
    public String getOnclick() {
        return onclick;
    }
    /** Returns the onDblClick event handler. */
    public String getOndblclick() {
        return ondblclick;
    }
    /** Returns the onFocus event handler. */
    public String getOnfocus() {
        return onfocus;
    }
    /** Returns the onKeyDown event handler. */
    public String getOnkeydown() {
        return onkeydown;
    }
    /** Returns the onKeyPress event handler. */
    public String getOnkeypress() {
        return onkeypress;
    }
    /** Returns the onKeyUp event handler. */
    public String getOnkeyup() {
        return onkeyup;
    }
    /** Returns the onMouseDown event handler. */
    public String getOnmousedown() {
        return onmousedown;
    }
    /** Returns the onMouseMove event handler. */
    public String getOnmousemove() {
        return onmousemove;
    }
    /** Returns the onMouseOut event handler. */
    public String getOnmouseout() {
        return onmouseout;
    }
    /** Returns the onMouseOver event handler. */
    public String getOnmouseover() {
        return onmouseover;
    }
    /** Returns the onMouseUp event handler. */
    public String getOnmouseup() {
        return onmouseup;
    }
    /** Returns the onSelect event handler. */
    public String getOnselect() {
        return onselect;
    }
    /** Returns the readonly event handler. */
    public boolean getReadonly() {
        return readonly;
    }
    /** Returns the style attribute. */
    public String getStyle() {
        return style;
    }
    /** Returns the style class attribute. */
    public String getStyleClass() {
        return styleClass;
    }
    /** Returns the style id attribute.  */
    public String getStyleId() {
        return styleId;
    }
    /** Returns the tabIndex value. */
    public String getTabindex() {
	return (this.tabindex);
    }
// Other Common Elements

    /** Returns the advisory title attribute. */
    public String getTitle() {
        return title;
    }
    /**
     * Prepares the event handlers for inclusion in the component's HTML tag.
     * @return The prepared String for inclusion in the HTML tag.
     */
    protected String prepareEventHandlers() {
        StringBuffer handlers = new StringBuffer();
        prepareMouseEvents(handlers);
        prepareKeyEvents(handlers);
        prepareTextEvents(handlers);
        prepareFocusEvents(handlers);
        return handlers.toString();
    }
    /**
     * Prepares the focus event handlers, appending them to the the given
     * StringBuffer.
     * @param handlers The StringBuffer that output will be appended to.
     */
    private void prepareFocusEvents(StringBuffer handlers) {

        if (onblur != null) {
            handlers.append(" onblur=\"");
            handlers.append(onblur);
            handlers.append("\"");
        }

        if (onfocus != null) {
            handlers.append(" onfocus=\"");
            handlers.append(onfocus);
            handlers.append("\"");
        }

        if (disabled) {
            handlers.append(" disabled=\"disabled\"");
        }

        if (readonly) {
            handlers.append(" readonly=\"readonly\"");
        }

    }
    /**
     * Prepares the keyboard event handlers, appending them to the the given
     * StringBuffer.
     * @param handlers The StringBuffer that output will be appended to.
     */
    private void prepareKeyEvents(StringBuffer handlers) {

        if (onkeydown != null) {
            handlers.append(" onkeydown=\"");
            handlers.append(onkeydown);
            handlers.append("\"");
        }

        if (onkeyup != null) {
            handlers.append(" onkeyup=\"");
            handlers.append(onkeyup);
            handlers.append("\"");
        }

        if (onkeypress != null) {
            handlers.append(" onkeypress=\"");
            handlers.append(onkeypress);
            handlers.append("\"");
        }
    }
    // -------------------------------------------------------- Private Methods


    /**
     * Prepares the mouse event handlers, appending them to the the given
     * StringBuffer.
     * @param handlers The StringBuffer that output will be appended to.
     */
    private void prepareMouseEvents(StringBuffer handlers) {
        if (onclick != null) {
            handlers.append(" onclick=\"");
            handlers.append(onclick);
            handlers.append("\"");
        }

        if (ondblclick != null) {
            handlers.append(" ondblclick=\"");
            handlers.append(ondblclick);
            handlers.append("\"");
        }

        if (onmouseover != null) {
            handlers.append(" onmouseover=\"");
            handlers.append(onmouseover);
            handlers.append("\"");
        }

        if (onmouseout != null) {
            handlers.append(" onmouseout=\"");
            handlers.append(onmouseout);
            handlers.append("\"");
        }

        if (onmousemove != null) {
            handlers.append(" onmousemove=\"");
            handlers.append(onmousemove);
            handlers.append("\"");
        }

        if (onmousedown != null) {
            handlers.append(" onmousedown=\"");
            handlers.append(onmousedown);
            handlers.append("\"");
        }

        if (onmouseup != null) {
            handlers.append(" onmouseup=\"");
            handlers.append(onmouseup);
            handlers.append("\"");
        }
    }
    // ------------------------------------------------------ Protected Methods


    /**
     * Prepares the style attributes for inclusion in the component's HTML tag.
     * @return The prepared String for inclusion in the HTML tag.
     */
    protected String prepareStyles() {
        StringBuffer styles = new StringBuffer();
        if (style != null) {
            styles.append(" style=\"");
            styles.append(style);
            styles.append("\"");
        }
        if (styleClass != null) {
            styles.append(" class=\"");
            styles.append(styleClass);
            styles.append("\"");
        }
        if (styleId != null) {
            styles.append(" id=\"");
            styles.append(styleId);
            styles.append("\"");
        }
        if (title != null) {
            styles.append(" title=\"");
            styles.append(title);
            styles.append("\"");
        }
        return styles.toString();
    }
    /**
     * Prepares the text event handlers, appending them to the the given
     * StringBuffer.
     * @param handlers The StringBuffer that output will be appended to.
     */
    private void prepareTextEvents(StringBuffer handlers) {

        if (onselect != null) {
            handlers.append(" onselect=\"");
            handlers.append(onselect);
            handlers.append("\"");
        }

        if (onchange != null) {
            handlers.append(" onchange=\"");
            handlers.append(onchange);
            handlers.append("\"");
        }
    }
    // --------------------------------------------------------- Public Methods


    /**
     * Release any acquired resources.
     */
    public void release() {

	super.release();
	accesskey = null;
	tabindex = null;
	onclick = null;
	ondblclick = null;
	onmouseover = null;
	onmouseout = null;
	onmousemove = null;
	onmousedown = null;
	onmouseup = null;
	onkeydown = null;
	onkeyup = null;
	onkeypress = null;
	onselect = null;
	onchange = null;
	onblur = null;
	onfocus = null;
        disabled = false;
        readonly = false;
	style = null;
	styleClass = null;
        styleId = null;
        title = null;

    }
    // ------------------------------------------------------------- Properties

//  Navigation Management

    /** Sets the accessKey character. */
    public void setAccesskey(String accessKey) {
	this.accesskey = accessKey;
    }
    /** Sets the disabled event handler. */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
// Focus Events and States

    /** Sets the onBlur event handler. */
    public void setOnblur(String onBlur) {
        this.onblur = onBlur;
    }
// Text Events

    /** Sets the onChange event handler. */
    public void setOnchange(String onChange) {
        this.onchange = onChange;
    }
// Mouse Events

    /** Sets the onClick event handler. */
    public void setOnclick(String onClick) {
        this.onclick = onClick;
    }
    /** Sets the onDblClick event handler. */
    public void setOndblclick(String onDblClick) {
        this.ondblclick = onDblClick;
    }
    /** Sets the onFocus event handler. */
    public void setOnfocus(String onFocus) {
        this.onfocus = onFocus;
    }
// Keyboard Events

    /** Sets the onKeyDown event handler. */
    public void setOnkeydown(String onKeyDown) {
        this.onkeydown = onKeyDown;
    }
    /** Sets the onKeyPress event handler. */
    public void setOnkeypress(String onKeyPress) {
        this.onkeypress = onKeyPress;
    }
    /** Sets the onKeyUp event handler. */
    public void setOnkeyup(String onKeyUp) {
        this.onkeyup = onKeyUp;
    }
    /** Sets the onMouseDown event handler. */
    public void setOnmousedown(String onMouseDown) {
        this.onmousedown = onMouseDown;
    }
    /** Sets the onMouseMove event handler. */
    public void setOnmousemove(String onMouseMove) {
        this.onmousemove = onMouseMove;
    }
    /** Sets the onMouseOut event handler. */
    public void setOnmouseout(String onMouseOut) {
        this.onmouseout = onMouseOut;
    }
    /** Sets the onMouseOver event handler. */
    public void setOnmouseover(String onMouseOver) {
        this.onmouseover = onMouseOver;
    }
    /** Sets the onMouseUp event handler. */
    public void setOnmouseup(String onMouseUp) {
        this.onmouseup = onMouseUp;
    }
    /** Sets the onSelect event handler. */
    public void setOnselect(String onSelect) {
        this.onselect = onSelect;
    }
    /** Sets the readonly event handler. */
    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }
// CSS Style Support

    /** Sets the style attribute. */
    public void setStyle(String style) {
        this.style = style;
    }
    /** Sets the style class attribute. */
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }
    /** Sets the style id attribute.  */
    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }
    /** Sets the tabIndex value. */
    public void setTabindex(String tabIndex) {
	this.tabindex = tabIndex;
    }
    /** Sets the advisory title attribute. */
    public void setTitle(String title) {
        this.title = title;
    }
}
