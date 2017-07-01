package com.hps.july.siteinfo.applets;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/**
 * Аплет загрузки фотографий на сервер.
 * Creation date: (29.07.2003 16:24:09)
 * @author: Maxim Gerasimov
 */
public class UploadImg extends JApplet implements ActionListener {

    private java.lang.String servletPath = null;
    private java.awt.TextArea ta = null;
    private java.lang.String fnames[] = {};
    private javax.swing.JFileChooser ofd = null;
public void actionPerformed(java.awt.event.ActionEvent e) {

	ta.replaceRange("", 0, ta.getText().length());
    if (ofd == null) {
        ofd = new JFileChooser();
        ofd.setMultiSelectionEnabled(true);
        ofd.setCurrentDirectory(new File("C:\\"));
        ofd.setDialogType(0);
        ofd.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        ofd.addChoosableFileFilter(new FileFilter() {
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String extension = getExtension(f);
                if (extension != null) {
                    if (extension.equals("tiff")
                        || extension.equals("tif")
                        || extension.equals("gif")
                        || extension.equals("jpeg")
                        || extension.equals("jpg")) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }
            public String getDescription() {
                return "gif; jpg; jpeg; tiff; tif;";
            }
            private String getExtension(File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf('.');
                if (i > 0 && i < s.length() - 1) {
                    ext = s.substring(i + 1).toLowerCase();
                }
                return ext;
            }
        });
    }
    int dlgResult = ofd.showOpenDialog(UploadImg.this);
    if (dlgResult == 0) {
        File file[] = ofd.getSelectedFiles();
        fnames = new String[file.length];
        for (int i = 0; i < file.length; i++)
            fnames[i] = file[i].getPath();

        for (int i = 0; i < fnames.length; i++)
            ta.append(fnames[i] + "\n");

    } else {
        ta.append("Выберите фотографии");
    }
}
public void init() {
	
    try {
        servletPath = getParameter("servletPath");
    } catch (java.lang.Exception e) {
        System.out.println("Error in readProperties");
        e.printStackTrace(java.lang.System.out);
    }
    Container container = getContentPane();
    container.setBackground(Color.white);
    container.setForeground(Color.black);
    container.setLayout(new FlowLayout());
    JButton choose = new JButton("Выберите фотографии");
    choose.addActionListener(this);
    container.add(choose);
    ta = new TextArea("Выберите фотографии", 3, 70, TextArea.SCROLLBARS_VERTICAL_ONLY);
    ta.setEditable(false);
    container.add(ta);
}
private String parseFilename(java.lang.String path) {
	
    return path.substring(path.lastIndexOf('\\') + 1);
}
private Hashtable readFiles() throws Exception {
	
    BufferedInputStream bin = null;
    ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
    try {
        Hashtable files = new Hashtable();
        byte[] b = new byte[512];
        for (int i = 0; i < fnames.length; i++) {
            bin = new BufferedInputStream(new FileInputStream(fnames[i]));
            int count = 0;
            while ((count = bin.read(b)) != -1){
	            if(count == 512)
                	bout.write(b);
                else {
	                byte[] end = new byte[count];
	                System.arraycopy(b, 0, end, 0, count);
	                bout.write(end);
                }
            }
            files.put(parseFilename(fnames[i]), bout.toByteArray());
            bout.reset();
        }
        return files;
    } catch (Exception e) {
        System.out.println("Error in readFiles");
        e.printStackTrace(System.out);
        throw e;
    } finally {
        try {if (bin  != null) bin.close();} catch (Exception e) {e.printStackTrace();}
        try {if (bout != null)bout.close();} catch (Exception e) {e.printStackTrace();}
    }
}
public String upload(String storageplace, String photographer, String comments, String date) {
	
    try {
        if (comments == null || comments.trim().length() == 0)
            throw new Exception("Не задано описание фотографии");
        if (fnames.length == 0)
            throw new Exception("Не указаны фотографии для загрузки");

        int photograph = 0;
        try{
	        photograph = Integer.parseInt(photographer);
        }catch(Exception e){}
        
        Files files = new Files(
                comments,
                date,
                readFiles(),
                photograph,
                Integer.parseInt(storageplace));

        return uploadFiles(files);
    } catch (Exception e) {
	    e.printStackTrace(System.out);
        return e.getMessage();        
    }
}
private String uploadFiles(Files files) throws java.lang.Exception {
	
    ObjectOutputStream out = null;
    BufferedReader in = null;
    try {
        URL url = new URL(getCodeBase(), servletPath);
        URLConnection con = url.openConnection();
        con.setUseCaches(false);
        con.setDoOutput(true);
        con.setRequestProperty("Content-Length", String.valueOf(files.getSize()));
        con.connect();
        
        out = new ObjectOutputStream(con.getOutputStream());
        out.writeObject(files);
        
        in = new BufferedReader(new InputStreamReader(con.getInputStream()));        
        StringBuffer response = new StringBuffer();
        for (String line = "";(line = in.readLine()) != null;) {
            response.append(line);
        }

        String s = response.toString();
        return s;
    } catch (Exception e) {
        System.out.println("Error in uploadFiles");
        e.printStackTrace();
        throw e;
    } finally {
        try {if (out != null)out.close();} catch (Exception e) {e.printStackTrace();}
        try {if (in != null) in.close();}  catch (Exception e) {e.printStackTrace();}
    }
}
}
