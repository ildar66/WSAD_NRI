package com.hps.july.siteinfo.applets;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.ArrayList;

/**
 * Сохранение фотографий на сервере.
 * Creation date: (19.08.2003 16:41:15)
 * @author: Maxim Gerasimov
 */
class SaveImages {
/**
 * SaveImages constructor comment.
 */
public SaveImages() {
	super();
}
    public String[] save(String path, String servletPath,
                      String storageplace, URL codeBase)throws Exception{

        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            URL url = new URL(codeBase, servletPath);
            URLConnection con = url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setRequestProperty("Content-Length", String.valueOf(storageplace.length()));

            out = new ObjectOutputStream(con.getOutputStream());
            out.writeObject(storageplace);

            in = new ObjectInputStream(con.getInputStream());
            Object response = in.readObject();

            return saveFiles((Files)response, path);

        } catch (Exception e) {
            Log.log("Error in SaveImages.save", e);
            throw e;
        } finally {
            try{if(out != null) out.close();}catch(Exception e){e.printStackTrace();}
            try{if(in != null) in.close();}catch(Exception e){e.printStackTrace();}
        }
    }
    private String[] saveFiles(Files files, String path) throws Exception{

        BufferedOutputStream out = null;
        try {
            Hashtable hash = files.getFiles();
            Enumeration names = hash.keys();
            ArrayList ar = new ArrayList();
            while (names.hasMoreElements()) {
                String name = (String)names.nextElement();
                String imagePath = path+System.getProperty("file.separator")+name;
                byte[] ff = (byte[])hash.get(name);
                out = new BufferedOutputStream(
                    new FileOutputStream(imagePath));
                out.write(ff);
                out.flush();
                out.close();
                ar.add(imagePath);
            }
            Object[] obj = ar.toArray();
            String[] fileNames = new String[obj.length];
            for(int i = 0; i < fileNames.length; i++){
                fileNames[i] = (String)obj[i];
            }
            return fileNames;
        } catch (Exception e) {
            Log.log("Error in SaveImages.saveFiles", e);
            throw e;
        } finally {
            try{if(out != null) out.close();}catch(Exception e){e.printStackTrace();}
        }
    }
}
