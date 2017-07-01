package com.hps.july.arenda.valueobject;

/**
 * Комментарии юристов VO.
 * Creation date: (22.07.2005 15:22:17)
 * @author: Shafigullin Ildar
 */
public class LawyearNoteOnPosition_VO {
    /**
    begin work;
    
    -- ============================================================
    --   Table: lawyearNoteOnPosition                              
    -- ============================================================
    create table lawyearNoteOnPosition
    (
    id          integer                not null,
    number      integer                not null,
    idPosition  integer                not null,
    idContract  integer                        ,
    note        char(1000)                     ,
    created     datetime year to second          ,
    createdBy   integer                        ,
    modified    datetime year to second          ,
    modifiedBy  integer                        ,
    primary key (id) constraint PK_LAWYEARNOTEONPO
    );
    
    alter table lawyearNoteOnPosition
    add constraint (foreign key  (idPosition)
       references positions (storageplace) constraint FK_REF_45970_459706);
    
    alter table lawyearNoteOnPosition
    add constraint (foreign key  (idContract)
       references leasecontracts (leasedocument) constraint FK_REF_45970_459709);
    
    alter table lawyearNoteOnPosition
    add constraint (foreign key  (createdBy)
       references people (man) constraint FK_REF_46442_464421);
    
    alter table lawyearNoteOnPosition
    add constraint (foreign key  (modifiedBy)
       references people (man) constraint FK_REF_46442_464424);
    
    commit work;
    */
    private java.lang.Integer id; //primary key
    private java.lang.Integer number; //номер
    private java.lang.Integer idPosition; //ссылка на positions (storageplace)
    private java.lang.Integer idContract; //ссылка на leasecontracts (leasedocument) 
    private java.lang.String note; //комментарий
    private java.sql.Timestamp created; //дата создания
    private java.lang.Integer createdBy; //кем (references people (man))
    private java.sql.Timestamp modified; //дата модификации
    private java.lang.Integer modifiedBy; //кем модифицирована(references people (man))
	private java.lang.String createdName;
	private java.lang.String modifiedName;
/**
 * Insert the method's description here.
 * Creation date: (23.07.2005 14:05:00)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LawyearNoteOnPosition_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
    id = (Integer) ro.getColumn("id").asObject();
    setNumber((Integer) ro.getColumn("number").asObject());
    setIdPosition((Integer) ro.getColumn("idposition").asObject());
    setIdContract((Integer) ro.getColumn("idcontract").asObject());
    setNote(ro.getColumn("note").asString());
    setCreated((java.sql.Timestamp) ro.getColumn("created").asObject());
    setCreatedBy((Integer) ro.getColumn("createdby").asObject());
    setModified((java.sql.Timestamp) ro.getColumn("modified").asObject());
    setModifiedBy((Integer) ro.getColumn("modifiedby").asObject());
}
/**
 * LawyearNoteOnPosition_VO constructor comment.
 */
public LawyearNoteOnPosition_VO(Integer aID) {
	super();
	id = aID;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:26:49)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getCreated() {
	return created;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:27:35)
 * @return java.lang.Integer
 */
public java.lang.Integer getCreatedBy() {
	return createdBy;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2005 11:51:18)
 * @return java.lang.String
 */
public java.lang.String getCreatedName() {
	return createdName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:22:39)
 * @return java.lang.Integer
 */
public java.lang.Integer getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:24:45)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdContract() {
	return idContract;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:23:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdPosition() {
	return idPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:28:23)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getModified() {
	return modified;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:28:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getModifiedBy() {
	return modifiedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2005 11:51:57)
 * @return java.lang.String
 */
public java.lang.String getModifiedName() {
	return modifiedName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:25:26)
 * @return java.lang.String
 */
public java.lang.String getNote() {
	return note;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:23:21)
 * @return java.lang.Integer
 */
public java.lang.Integer getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:26:49)
 * @param newCreated java.sql.Timestamp
 */
public void setCreated(java.sql.Timestamp newCreated) {
	created = newCreated;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:27:35)
 * @param newCreatedBy java.lang.Integer
 */
public void setCreatedBy(java.lang.Integer newCreatedBy) {
	createdBy = newCreatedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2005 11:51:18)
 * @param newCreatedName java.lang.String
 */
public void setCreatedName(java.lang.String newCreatedName) {
	createdName = newCreatedName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:22:39)
 * @param newId java.lang.Integer
 */
public void setId(java.lang.Integer newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:24:45)
 * @param newIdContract java.lang.Integer
 */
public void setIdContract(java.lang.Integer newIdContract) {
	idContract = newIdContract;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:23:56)
 * @param newIdPosition java.lang.Integer
 */
public void setIdPosition(java.lang.Integer newIdPosition) {
	idPosition = newIdPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:28:23)
 * @param newModified java.sql.Timestamp
 */
public void setModified(java.sql.Timestamp newModified) {
	modified = newModified;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:28:55)
 * @param newModifiedBy java.lang.Integer
 */
public void setModifiedBy(java.lang.Integer newModifiedBy) {
	modifiedBy = newModifiedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2005 11:51:57)
 * @param newModifiedName java.lang.String
 */
public void setModifiedName(java.lang.String newModifiedName) {
	modifiedName = newModifiedName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:25:26)
 * @param newNote java.lang.String
 */
public void setNote(java.lang.String newNote) {
	note = newNote;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:23:21)
 * @param newNumber java.lang.Integer
 */
public void setNumber(java.lang.Integer newNumber) {
	number = newNumber;
}
}
