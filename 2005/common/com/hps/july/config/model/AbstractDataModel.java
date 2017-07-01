/*
 * Created on 16.08.2006
 *
 * Data model prototypes for data transfer
 */
package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author dima
 *
 */
public interface AbstractDataModel {
	
	public String getLoadURL();
	public String getSaveURL();
	public String getPostURL();
	public void writeData(ObjectOutputStream out) throws IOException;
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException;

}
