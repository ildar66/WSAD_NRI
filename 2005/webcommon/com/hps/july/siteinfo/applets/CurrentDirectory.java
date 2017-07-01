package com.hps.july.siteinfo.applets;

import java.io.*;
import java.util.*;

/**
 * Класс для выбора текущей директории.
 * Creation date: (14.08.2003 12:11:51)
 * @author: Maxim Gerasimov
 */
public class CurrentDirectory {
	private final String DIRECTORY = "directory";
	private final String EDITOR = "editor";
	private String oldPath = null;
	private String path = null;
	private String oldEditorPath = null;
	private String editorPath = null;
	private final String USERHOME = System.getProperty("user.home");
	private final String FILESEPARATOR = System.getProperty("file.separator");
	private final String PROPSFILENAME = "saveImagesProps.txt";
	private final String PROPSPATH = USERHOME + FILESEPARATOR + PROPSFILENAME;
	private boolean isChanged = false;

    public CurrentDirectory() {
        try {
            if (!checkPath(PROPSPATH)) {
                oldPath = getDriveLetter(USERHOME);
                path = oldPath;
                editorPath = oldPath;
                oldEditorPath = oldPath;
                isChanged = true;
            } else {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(PROPSPATH));
                Properties props = new Properties();
                props.load(in);

                oldPath = props.getProperty(DIRECTORY);
                path = oldPath;
                if (oldPath == null) {
                    oldPath = getDriveLetter(USERHOME);
                    path = oldPath;
                }

                oldEditorPath = props.getProperty(EDITOR);
                if(!checkPath(oldEditorPath))
                    oldEditorPath = getDriveLetter(USERHOME);
                editorPath = oldEditorPath;
            }
        } catch (Exception e) {
            Log.log("Error in CurrentDirectory constructor", e);
        }
    }
private boolean checkPath(String checkedPath){

	if(checkedPath != null){
	    File file = new File(checkedPath);
		return file.exists();
	} else
		return false;
}
private String getDriveLetter(String userHomePath){
	int x = userHomePath.indexOf("\\");
	return userHomePath.substring(0, x+1);
}
public java.lang.String getEditorPath() {
	return editorPath;
}
public java.lang.String getPath() {
	return path;
}
public void saveProperties(){
	
	BufferedOutputStream out = null;
	try {
		if(isChanged){
			Properties props = new Properties();
            if(path != null)
			    props.put(DIRECTORY, path);
            else
                props.put(DIRECTORY, oldPath);
			if(editorPath != null)
				props.put(EDITOR, editorPath);
            else
                props.put(EDITOR, oldEditorPath);
			out = new BufferedOutputStream(
				new FileOutputStream(PROPSPATH));
			props.store(out, null);
		}
	} catch (Exception e) {
        Log.log("Error in CurrentDirectory.saveProperties", e);
	} finally {
		try{if(out != null) out.close();}catch(Exception e){e.printStackTrace();}
	}
}
public void setEditorPath(java.lang.String newEditorPath) {
	if(oldEditorPath.compareTo(newEditorPath) != 0){
		isChanged = true;
        editorPath = newEditorPath;
    }
}
public void setPath(java.lang.String newPath) {
	if (oldPath.compareTo(newPath) != 0){
		isChanged = true;
        path = newPath;
    }
}
}
