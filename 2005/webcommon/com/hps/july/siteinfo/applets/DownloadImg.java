package com.hps.july.siteinfo.applets;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * Аплет загрузки фотографий на компьютер пользователя.
 * Creation date: (31.07.2003 17:31:20)
 * @author: Maxim Gerasimov
 */
public class DownloadImg extends javax.swing.JApplet implements Captions{

	private JFileChooser ofd = null;
    private JFileChooser ed = null;
	private String path = null;
    private String editorPath = null;

    private String servletPath = null;
	private String storageplace = null;

	private CurrentDirectory currentDirectory = null;
    private ExeFileFilter exeFileFilter = null;
    private TextArea ta = null;

    private JButton saveButton = null;
    private JButton cancelButton = null;
    private JButton editorButton = null;
private void addListeners(){
//////////////////////
    saveButton.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            disableButtons(true);
            try {
                if(path == null)
                    throw new Exception();
                File file = ofd.getSelectedFile();
                if(file != null){
                    path = file.getCanonicalPath();
                    ofd.setCurrentDirectory(file);
                    ofd.setSelectedFile(file);
                    currentDirectory.setPath(path);
                }

                SaveImages saveImages = new SaveImages();
                String[] fileNames = saveImages.save(path, servletPath,
                        storageplace, getCodeBase());

                if(editorPath.endsWith(".exe"))
                    Runtime.getRuntime().exec(editorPath + " "+fileNames[0]);

            } catch (IOException e1) {
                Log.log("Error in DownloadImg.actionPerformed for saveButton", e1);
                JOptionPane.showMessageDialog(null, error_save_txt, "",
                    JOptionPane.ERROR_MESSAGE);
            }  catch (Exception e1) {
                disableButtons(false);
                JOptionPane.showMessageDialog(null, chooseDir_txt, "",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            disableButtons(false);
            ofd.approveSelection();
        }
    });
//////////////////////
    editorButton.addActionListener(new ActionListener(){
		public void actionPerformed(java.awt.event.ActionEvent e) {
            try {
                int result = ed.showDialog(DownloadImg.this, choose_txt);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = ed.getSelectedFile();
                    editorPath = file.getCanonicalPath();
                    ed.setCurrentDirectory(file);
                    ed.setSelectedFile(file);
                    ta.replaceRange(editorPath, 0, ta.getText().length());
                    currentDirectory.setEditorPath(editorPath);
                }
            } catch (IOException e1) {
                Log.log("Error in DownloadImg.actionPerformed for editButton", e1);
                JOptionPane.showMessageDialog(null, error_edit_txt, "",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
	});
//////////////////////
    cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent ee) {
            ofd.approveSelection();
        }
    });
}
private void createJFileChoosers(){

    ofd = new JFileChooser();
    ofd.setDialogType(JFileChooser.CUSTOM_DIALOG);
    ofd.setMultiSelectionEnabled(false);
    ofd.setCurrentDirectory(new File(path));
    ofd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    ofd.setDialogTitle(chooseDirLabel_txt);
    ofd.setControlButtonsAreShown(false);

    Box box = Box.createVerticalBox();
    editorButton = new JButton(chooseEditor_txt);
    editorButton.setPreferredSize(new Dimension(140, 50));
    box.add(editorButton);
    box.add(Box.createVerticalStrut(5));
    String text = editorPath == null ? "" : editorPath;
    ta = new TextArea(text, 1, 2);
    ta.setSize(100, 20);
    ta.setEditable(false);
    box.add(ta);
    box.add(Box.createVerticalGlue());

    cancelButton = new JButton(cancel_txt);
    cancelButton.setPreferredSize(new Dimension(140, 20));
    box.add(cancelButton);
    box.add(Box.createVerticalStrut(5));
    saveButton = new JButton(save_txt);
    saveButton.setPreferredSize(new Dimension(140, 20));
    box.add(saveButton);
    //ofd.setAccessory(box);

    ed  = new JFileChooser();
    ed.setCurrentDirectory(new File(editorPath));
    ed.setDialogType(JFileChooser.CUSTOM_DIALOG);
    ed.setMultiSelectionEnabled(false);
    ed.setFileSelectionMode(JFileChooser.FILES_ONLY);
    ed.setDialogTitle(chooseDirEditor_txt);
    ed.setApproveButtonText(choose_txt);
    ed.setFileFilter(exeFileFilter);
}
private void disableButtons(boolean isDisable){
    cancelButton.setEnabled(!isDisable);
    editorButton.setEnabled(!isDisable);
    saveButton.setEnabled(!isDisable);
}
//    private CustomDialog customDialog = null;

public void init() {
	super.init();

	servletPath = getParameter("servletPath");
	storageplace = getParameter("storageplace");

	currentDirectory = new CurrentDirectory();
    path = currentDirectory.getPath();
    editorPath = currentDirectory.getEditorPath();

    exeFileFilter = new ExeFileFilter();

    createJFileChoosers();
    addListeners();
//    customDialog = new CustomDialog(null, false);

//    JButton go = new JButton("Go");
//    go.addActionListener(new ActionListener(){
//        public void actionPerformed(java.awt.event.ActionEvent e) {
//            ofd.showSaveDialog(DownloadImg.this);
//        }
//    });
//    getContentPane().add(go);
}
public void save(){
    ofd.showSaveDialog(DownloadImg.this);
}
public void stop() {
	super.stop();
	currentDirectory.saveProperties();
}
}
