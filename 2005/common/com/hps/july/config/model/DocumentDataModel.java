package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * List of documents
 * Model - provides data to the visual form
 * + applet data transfer logic
 * @author dima
 *
 */
public class DocumentDataModel implements Serializable, AbstractDataModel
{
	private ArrayList documents;
	private int basestation;
	
	public DocumentDataModel() {
		documents = new ArrayList();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(DocumentDataModel dm) {
		this.documents = dm.documents;
	}
	
	/**
	 * Документы
	 * @return
	 */
	public ArrayList getDocuments() {
		return documents;
	}
	public void setDocuments(ArrayList adocuments) {
		documents = adocuments;
	}
	
	
	
	public String getLoadURL() {
		return "/inventory/LoadDocuments?basestation=" + getBasestation();
	}
	
	public String getSaveURL() {
		return null;
	}
	
	public String getPostURL() {
		return null;
	}

	public void writeData(ObjectOutputStream out) throws IOException {
		out.writeObject(this);
	}
	
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
		DocumentDataModel dm = (DocumentDataModel)in.readObject();
		assignObject(dm);
	}
	
	/**
	 * @return
	 */
	public int getBasestation() {
		return basestation;
	}

	/**
	 * @param i
	 */
	public void setBasestation(int i) {
		basestation = i;
	}

}
