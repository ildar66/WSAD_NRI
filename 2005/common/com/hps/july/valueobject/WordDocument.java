package com.hps.july.valueobject;

/**
 * Информация для загрузки/сохранения документов Word.
 * Creation date: (17.11.2005 10:28:14)
 * @author: Shafigullin Ildar
 */
public class WordDocument {
	private Integer id = null;
	private byte[] text = null;
	private String filename = null;
	private Integer documentType = null; //тип документа NRI
	private String objectType = null; //группа документов NRI
	/**
	 * WordDocument constructor comment.
	 */
	public WordDocument(Integer id, byte[] text, String filename) {
		super();
		this.id = id;
		this.text = text;
		this.filename = filename;
	}
	/**
	 * WordDocument constructor comment.
	 */
	public WordDocument(Integer id, String aObjectType, byte[] text, String filename) {
		super();
		this.id = id;
		this.text = text;
		this.filename = filename;
		this.objectType = aObjectType;
	}
	/**
	 * WordDocument constructor comment.
	 */
	public WordDocument(Integer id, Integer aDocType, String aObjectType, byte[] text, String filename) {
		super();
		this.id = id;
		this.text = text;
		this.filename = filename;
		this.documentType = aDocType;
		this.objectType = aObjectType;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (17.11.2005 10:29:49)
	 * @return java.lang.String
	 */
	public java.lang.String getFilename() {
		return filename;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.11.2005 10:29:49)
	 * @return int
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.11.2005 10:29:49)
	 * @return byte[]
	 */
	public byte[] getText() {
		return text;
	}
	/**
	 * @return
	 */
	public Integer getDocumentType() {
		return documentType;
	}

	/**
	 * @return
	 */
	public String getObjectType() {
		return objectType;
	}

}
