package com.hps.july.siteinfo.applets;

/**
 * Список файлов для аплета загрузки фотографий.
 * Creation date: (29.07.2003 16:29:25)
 * @author: Maxim Gerasimov
 */
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Enumeration;

public class Files implements Serializable{

    private int storageplace;
    private int photographer;
    private String comments = null;
    private Hashtable files = null;
	private String date = null;
	private java.lang.String externalPhotograher = null;

	private java.lang.String groupName = null;
	private java.lang.String userName = null;
/**
 * Files constructor comment.
 */
public Files() {
	super();
}
    public Files(String comments, String date, Hashtable files, int photographer, int storageplace) {
        this.comments = comments;
        this.files = files;
        this.photographer = photographer;
        this.storageplace = storageplace;
        this.date = date;
    }
    public Files(String comments, String date, Hashtable files, int photographer, int storageplace,
                 String externalPhotograher) {
        this.comments = comments;
        this.files = files;
        this.photographer = photographer;
        this.storageplace = storageplace;
        this.date = date;
        this.externalPhotograher = externalPhotograher;

    }
    public String getComments() {
        return comments;
    }
/**
 * Insert the method's description here.
 * Creation date: (29.07.2003 16:34:54)
 * @return java.lang.String
 */
public java.lang.String getDate() {
	return date;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 18:45:53)
 * @return java.lang.String
 */
public java.lang.String getExternalPhotograher() {
	return externalPhotograher;
}
    public Hashtable getFiles() {
        return files;
    }
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 11:40:39)
 * @return java.lang.String
 */
public java.lang.String getGroupName() {
	return groupName;
}
    public int getPhotographer() {
        return photographer;
    }
    public String getSize(){
        if(files != null && files.size() > 0){
            int length = 0;
            Enumeration keys = files.keys();
            while(keys.hasMoreElements()){
                length += ((byte[])files.get(keys.nextElement())).length;
            }
            return String.valueOf(length + 8 + comments.getBytes().length);
        }else{
            return String.valueOf(0);
        }
    }
    public int getStorageplace() {
        return storageplace;
    }
/**
 * Insert the method's description here.
 * Creation date: (30.03.2005 14:03:49)
 * @return java.lang.String
 */
public java.lang.String getUserName() {
	return userName;
}
    public void setComments(String comments) {
        this.comments = comments;
    }
/**
 * Insert the method's description here.
 * Creation date: (29.07.2003 16:34:54)
 * @param newDate java.lang.String
 */
public void setDate(java.lang.String newDate) {
	date = newDate;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 18:45:53)
 * @param newExternalPhotograher java.lang.String
 */
public void setExternalPhotograher(java.lang.String newExternalPhotograher) {
	externalPhotograher = newExternalPhotograher;
}
    public void setFiles(Hashtable files) {
        this.files = files;
    }
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 11:40:39)
 * @param newGroupName java.lang.String
 */
public void setGroupName(java.lang.String newGroupName) {
	groupName = newGroupName;
}
    public void setPhotographer(int photographer) {
        this.photographer = photographer;
    }
    public void setStorageplace(int storageplace) {
        this.storageplace = storageplace;
    }
/**
 * Insert the method's description here.
 * Creation date: (30.03.2005 14:03:49)
 * @param newUserName java.lang.String
 */
public void setUserName(java.lang.String newUserName) {
	userName = newUserName;
}
    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append("storageplace="+storageplace+"\n");
        buf.append("photographer="+photographer+"\n");
        buf.append("comments="+comments+"\n");
        buf.append("size="+getSize()+"\n");

        buf.append("File names:\n");
        Enumeration enum = files.keys();
        while(enum.hasMoreElements())
            buf.append("\t\t"+(String)enum.nextElement()+"\n");
        return buf.toString();
    }
}
