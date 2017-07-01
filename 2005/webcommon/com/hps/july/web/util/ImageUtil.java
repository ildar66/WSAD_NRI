package com.hps.july.web.util;

import com.sun.jimi.core.filters.*;
import com.sun.jimi.core.encoder.jpg.*;
import com.sun.jimi.core.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
/**
 * Insert the type's description here.
 * Creation date: (15.03.2005 15:09:21)
 * @author: Vadim Glushkov
 */
public class ImageUtil {
	
	/**
	 * ImageUtil constructor comment.
	 */
	public ImageUtil() {
		super();
	}
    public static byte [] shrinkImage(byte[] abyte) {

        int border = 10000;
        ByteArrayInputStream iSource = new ByteArrayInputStream(abyte);
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        ByteArrayInputStream fais = null;
        try {
            Image image = Jimi.getImage(iSource);
            int y100 = abyte.length;
            abyte = null;
            ImageProducer source = null;
            if(y100 <= border) {
                JPGEncoderFactory factory = new JPGEncoderFactory();
                //Полный идиотизм !!!!!!!!! невозможность подключить библиотеку !
                //w encoder1 = factory.createEncoder();
                //encoder1.encodeImages(new y(image.getSource()), fos);
                //JimiEncoder encoder = factory.createEncoder();
                //encoder.encodeImages(new JimiImageEnumeration(image.getSource()), fos);
            } else {
                while(y100 > border) {
                    Shrink shrink = new Shrink(image.getSource(), 2);
                    source = new FilteredImageSource(image.getSource(), shrink);
                    
                    //JPGEncoderFactory factory = new JPGEncoderFactory();
	                //Полный идиотизм номер 2 !!!!!!!!! невозможность подключить библиотеку !
	                //w encoder1 = factory.createEncoder();
	                //encoder1.encodeImages(new y(image.getSource()), fos);
	                //JimiEncoder encoder = factory.createEncoder();
	                //encoder.encodeImages(new JimiImageEnumeration(image.getSource()), fos);
                    y100 = fos.size();
                    if(y100 <= border) {
                        fos.flush();
                        break;
                    }
                    fais = new ByteArrayInputStream(fos.toByteArray());
                    image = Jimi.getImage(fais);
                    fais.close();
                    fos.reset();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            try { if(iSource != null) iSource.close(); } catch(Exception e) {}
            try { if(fais != null) fais.close(); } catch(Exception e) {}
            try { if(fos != null) fos.close(); } catch(Exception e) {}
        }
        return fos.toByteArray();
    }
    public static byte [] shrinkImage(byte[] abyte, String name) {

        int border = 10000;
        ByteArrayInputStream iSource = new ByteArrayInputStream(abyte);
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        ByteArrayInputStream fais = null;
        try {
	        String ident = DataType.getID(name);
            Image image = Jimi.getImage(iSource);
            int y100 = abyte.length;
            abyte = null;
            ImageProducer source = null;
            if(y100 <= border) {
                JPGEncoderFactory factory = new JPGEncoderFactory();
                JimiWriter writer = Jimi.createJimiWriter(ident, fos);
                writer.setSource(image.getSource());
                writer.putImage(fos);
                //Полный идиотизм !!!!!!!!! невозможность подключить библиотеку !
                //w encoder1 = factory.createEncoder();
                //encoder1.encodeImages(new y(image.getSource()), fos);
                //JimiEncoder encoder = factory.createEncoder();
                //encoder.encodeImages(new JimiImageEnumeration(image.getSource()), fos);
            } else {
                while(y100 > border) {
                    Shrink shrink = new Shrink(image.getSource(), 2);
                    source = new FilteredImageSource(image.getSource(), shrink);
                    
                    JimiWriter writer = Jimi.createJimiWriter(ident, fos);
                    writer.setSource(source);
                    writer.putImage(fos);
                   //JPGEncoderFactory factory = new JPGEncoderFactory();
	                //Полный идиотизм номер 2 !!!!!!!!! невозможность подключить библиотеку !
	                //w encoder1 = factory.createEncoder();
	                //encoder1.encodeImages(new y(image.getSource()), fos);
	                //JimiEncoder encoder = factory.createEncoder();
	                //encoder.encodeImages(new JimiImageEnumeration(image.getSource()), fos);
                    y100 = fos.size();
                    if(y100 <= border) {
                        fos.flush();
                        break;
                    }
                    fais = new ByteArrayInputStream(fos.toByteArray());
                    image = Jimi.getImage(fais);
                    fais.close();
                    fos.reset();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            try { if(iSource != null) iSource.close(); } catch(Exception e) {}
            try { if(fais != null) fais.close(); } catch(Exception e) {}
            try { if(fos != null) fos.close(); } catch(Exception e) {}
        }
        return fos.toByteArray();
    }
}
