package com.hps.july.siteinfo.valueobject;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Enumeration;

/**
 * Контейнер для группы фотографий
 * @author: Maxim Gerasimov
 */
public class Files implements Serializable{
    private int storageplace;
    private int photographer;
    private String comments;
    private Hashtable files;
    public Files(String comments, Hashtable files, int photographer, int storageplace) {
        this.comments = comments;
        this.files = files;
        this.photographer = photographer;
        this.storageplace = storageplace;
    }
    public String getComments() {
        return comments;
    }
    public Hashtable getFiles() {
        return files;
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
    public void setComments(String comments) {
        this.comments = comments;
    }
    public void setFiles(Hashtable files) {
        this.files = files;
    }
    public void setPhotographer(int photographer) {
        this.photographer = photographer;
    }
    public void setStorageplace(int storageplace) {
        this.storageplace = storageplace;
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
