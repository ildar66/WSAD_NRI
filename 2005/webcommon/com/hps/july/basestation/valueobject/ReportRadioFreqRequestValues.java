package com.hps.july.basestation.valueobject;

import java.util.*;
import java.math.BigDecimal;
/**
 * Служебный класс-контейнер для хранения классов ReportRadioFreqRequestValue
 * и получения наборов строк для полей таблицы документа -
 * для документа "Заявка на назначение радиочастот для радиорелейных линий связи"
 */
public class ReportRadioFreqRequestValues {
	private Collection values = new ArrayList(); // Коллекция экземпляров ReportRadioFreqRequestValues
	private java.util.Set amplifkoeffs = new TreeSet(); // записи о коэффициентах усиления (п.20)
	private java.util.Set antdiams = new TreeSet(); // записи о диаметрах антенн (п.19)
	private java.util.Set dnangles = new TreeSet(); // записи о ширине ДН (п.21)
	private java.util.Set freqdevs = new TreeSet(); // записи об относит. нестабильности частоты (п.17)
	private java.util.Set freqranges = new TreeSet(); // записи о диапазонах частот (п.13)
	private java.util.Set gkrchs = new TreeSet(); // записи о номере и дате решения ГКРЧ (п.6)
	private java.util.Set manufacturers = new TreeSet(); // записи о наименованиях производителя (п.12)
	private java.util.Set mkkrrecomms = new TreeSet(); // записи о рекомендациях МККР (п.15)
	private java.util.Set models = new TreeSet(); // названия оборудования (п.11)
	private java.util.Set powers = new TreeSet(); // мощности несущей передатчика (п.16)
	private java.util.Set radiationclasses = new TreeSet(); // классы излучения (р.14)
	private java.util.Set recvsensitivities = new TreeSet(); // записи о чувствительности приемника (п.18)
	private java.util.Set rrls = new TreeSet(); // номеры и даты сертификатов соответствия (п.24)
	private java.util.Set streamspeeds = new TreeSet(); // скорости передачи (п.23)
	private int quantity = 0; // Общее количество пролетов в заявке (п.9)
/**
 * 
 */
public ReportRadioFreqRequestValues() {}
/**
 * ReportRadioFreqRequestValues constructor comment.
 */
public ReportRadioFreqRequestValues(Collection values) {
	super();
	ArrayList list = (ArrayList)values;
	Iterator it = list.iterator();
	while(it.hasNext()) {
		ReportRadioFreqRequestValue value = (ReportRadioFreqRequestValue)it.next();
		this.addAmplifkoeff(value);
		this.addAntdiam(value);
		this.addDnangle(value);
		this.addFreqdev(value);
		this.addFreqrange(value);
		this.addGKRCH(value);
		this.addManufacturer(value);
		this.addMkkrrecomm(value);
		this.addModel(value);
		this.addPower(value);
		this.addRadiationclass(value);
		this.addRecvsensitivity(value);
		this.addRRL(value);
		this.addStreamspeed(value);
		this.addQuantity(value);
		
		this.values.add(value);
	}
}
/**
 * 
 * @return java.util.Set
 */
public void addAmplifkoeff(ReportRadioFreqRequestValue value) {
	String model = value.getModel().trim();
	if(value.getAmplifkoeff1() != null) {
		ReportStringPair pair = new ReportStringPair(value.getModel().trim(), value.getAmplifkoeff1().toString());
		this.amplifkoeffs.add(pair);
	}
	if(value.getAmplifkoeff2() != null) {
		ReportStringPair pair = new ReportStringPair(value.getModel().trim(), value.getAmplifkoeff2().toString());
		this.amplifkoeffs.add(pair);
	}
}
/**
 * 
 * @return java.util.Set
 */
public void addAntdiam(ReportRadioFreqRequestValue value) {
System.out.println("ANTDIAM:"+value.getAntdiam1());
	if(value.getAntdiam1() != null)
		this.antdiams.add(", " + value.getAntdiam1().toString() + " м");
System.out.println("ANTDIAM:"+value.getAntdiam2());
	if(value.getAntdiam2() != null)
		this.antdiams.add(", " + value.getAntdiam2().toString() + " м");
}
/**
 * 
 */
public void addDnangle(ReportRadioFreqRequestValue value) {
	if((value.getDnangleh1() == null) && (value.getDnanglew1() == null) &&
		(value.getDnangleh2() == null) && (value.getDnanglew2() == null)) {
		return;
	}
	String model = value.getModel().trim();
	ReportStringPair pair = null;
	boolean slashAppended = false;
	boolean linePrepared = false;
	StringBuffer line = new StringBuffer();
	if(value.getDnangleh1() != null){
		line.append(value.getDnangleh1());
		line.append("/");
		slashAppended = true;
		linePrepared = true;
	}
	if(value.getDnanglew1() != null) {
		if(!slashAppended)
			line.append("/");
		line.append(value.getDnanglew1());
		linePrepared = true;
	}
	if(linePrepared) {
		pair = new ReportStringPair(model, line.toString());
		dnangles.add(pair);
	}
	slashAppended = linePrepared = false;
	line = new StringBuffer();
	if(value.getDnangleh2() != null){
		line.append(value.getDnangleh2());
		line.append("/");
		slashAppended = true;
		linePrepared = true;
	}
	if(value.getDnanglew2() != null) {
		if(!slashAppended)
			line.append("/");
		line.append(value.getDnanglew2());
		linePrepared = true;
	}
	if(linePrepared) {
		pair = new ReportStringPair(model, line.toString());
		dnangles.add(pair);
	}
}
/**
 * 
 */
public void addFreqdev(ReportRadioFreqRequestValue value) {
	if(value.getFreqdevlowk() == null)
		return;
	String line = value.getFreqdevlowk() + "*10<sup>-" + value.getFreqdevlowlog10() + "</sup>";
	ReportStringPair pair = new ReportStringPair(value.getModel().trim(), line);
	freqdevs.add(pair);
}
/**
 * 
 * @return java.util.Set
 */
public void addFreqrange(ReportRadioFreqRequestValue value) {
	if(value.getFreqrange() != null) {
		ReportStringPair pair = new ReportStringPair(value.getModel().trim(), value.getFreqrange());
		freqranges.add(pair);
	}
}
/**
 * 
 */
public void addGKRCH(ReportRadioFreqRequestValue value) {
	if(value.getGkrchblanknumber() == null)
		return;
	StringBuffer line = new StringBuffer(value.getGkrchblanknumber().trim());
	if(value.getGkrchblankdate() != null) {
		line.append(" от ");
		line.append(value.getGkrchblankdate());
	}
	ReportStringPair pair = new ReportStringPair(value.getModel().trim(), line.toString());
	this.gkrchs.add(pair);
}
/**
 * 
 * @return java.util.Set
 */
public void addManufacturer(ReportRadioFreqRequestValue value) {
	String shortname = value.getOrgshortname();
	String name = value.getOrgname();
	if(shortname != null) 
		this.manufacturers.add(shortname);
	else if(name != null)
		this.manufacturers.add(name);
}
/**
 * 
 */
public void addMkkrrecomm(ReportRadioFreqRequestValue value) {
	if(value.getMkkrrecomm() == null)
		return;
	ReportStringPair pair = new ReportStringPair(value.getModel().trim(), value.getMkkrrecomm());
	mkkrrecomms.add(pair);
}
/**
 * 
 * @return java.util.Set
 */
public void addModel(ReportRadioFreqRequestValue value) {
	this.models.add(value.getModel());
}
/**
 * 
 */
public void addPower(ReportRadioFreqRequestValue value) {
	if(value.getPower() != null) {
		ReportStringPair pair = new ReportStringPair(value.getModel().trim(), value.getPower().toString());
		powers.add(pair);
	}
}
/**
 * 
 * @param value com.hps.july.basestation.valueobject.ReportRadioFreqRequestValue
 */
public void addQuantity(ReportRadioFreqRequestValue value) {
	this.quantity++;
}
/**
 * 
 */
public void addRadiationclass(ReportRadioFreqRequestValue value) {
	if(value.getRadiationclass() == null)
		return;
	ReportStringPair pair = new ReportStringPair(value.getModel().trim(), value.getRadiationclass());
	radiationclasses.add(pair);
}
/**
 * 
 */
public void addRecvsensitivity(ReportRadioFreqRequestValue value) {
	if(value.getRecvsensitivity() == null)
		return;
	recvsensitivities.add(new ReportStringPair(value.getModel().trim(), value.getRecvsensitivity().toString()));
}
/**
 * 
 */
public void addRRL(ReportRadioFreqRequestValue value) {
	if(value.getRrlblanknumber() == null)
		return;
	StringBuffer line = new StringBuffer(value.getRrlblanknumber());
	if(value.getRrlblankdate() != null) {
		line.append(" от ");
		line.append(value.getRrlblankdate());
	}
	ReportStringPair pair = new ReportStringPair(value.getModel().trim(), line.toString());
	rrls.add(pair);
}
/**
 * 
 */
public void addStreamspeed(ReportRadioFreqRequestValue value) {
	if(value.getStreamspeed() == null)
		return;
	ReportStringPair pair = new ReportStringPair(value.getModel().trim(), value.getStreamspeed());
	streamspeeds.add(pair);
}
/**
 * 
 * @param value com.hps.july.basestation.valueobject.ReportRadioFreqRequestValue
 */
public void addValue(ReportRadioFreqRequestValue value) {
	if(value.getModel() == null)
		return;
	this.addAmplifkoeff(value);
	this.addAntdiam(value);
	this.addDnangle(value);
	this.addFreqdev(value);
	this.addFreqrange(value);
	this.addGKRCH(value);
	this.addManufacturer(value);
	this.addMkkrrecomm(value);
	this.addModel(value);
	this.addPower(value);
	this.addRadiationclass(value);
	this.addRecvsensitivity(value);
	this.addRRL(value);
	this.addStreamspeed(value);
	this.addQuantity(value);
	
	this.values.add(value);
}
/**
 * 
 * @return java.util.Set
 */
public Set getAmplifkoeffs() {
	return amplifkoeffs;
}
/**
 * 
 * @return java.util.Set
 */
public Set getAntdiams() {
	return antdiams;
}
/**
 * 
 * @return java.util.Set
 */
public Set getDnangles() {
	return dnangles;
}
/**
 * 
 * @return java.util.Set
 */
public Set getFreqdevs() {
	return freqdevs;
}
/**
 * 
 * @return java.util.Set
 */
public Set getFreqranges() {
	return freqranges;
}
/**
 * 
 */
public Set getGKRCHs() {
	return gkrchs;
}
/**
 * 
 * @return java.util.Set
 */
public Set getManufacturers() {
	return manufacturers;
}
/**
 * 
 * @return java.util.Set
 */
public Set getMkkrrecomms() {
	return mkkrrecomms;
}
/**
 * 
 * @return java.util.Set
 */
public Set getModels() {
	return models;
}
/**
 * 
 * @return java.util.Set
 */
public Set getPowers() {
	return powers;
}
/**
 * 
 * @return int
 */
public int getQuantity() {
	return quantity;
}
/**
 * 
 * @return java.util.Set
 */
public Set getRadiationclasses() {
	return radiationclasses;
}
/**
 * 
 * @return java.util.Set
 */
public Set getRecvsensitivities() {
	return recvsensitivities;
}
/**
 * 
 * @return java.util.Set
 */
public Set getRRLs() {
	return rrls;
}
/**
 * 
 * @return java.util.Set
 */
public Set getStreamspeeds() {
	return streamspeeds;
}
public void setAntdiams(Set set) {
}
/**
 * 
 * @param newQuantity int
 */
public void setQuantity(int newQuantity) {
	quantity = newQuantity;
}
}
