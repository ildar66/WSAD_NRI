package com.hps.july.siteinfo.applets;

import java.io.File;

/**
 * Фильтр исполняемых файлов (.EXE). Используется в аплете загрузки фотографий
 * Creation date: (18.08.2003 10:05:34)
 * @author: Maxim Gerasimov
 */
public class ExeFileFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = getExtension(f);
        if (extension != null) {
            if (extension.equals("exe"))
                return true;
            else
                return false;
        }
        return false;
    }
    public String getDescription() {
        return "exe";
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
}
