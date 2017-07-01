package com.hps.july.basestation.valueobject;

import java.util.*;
import java.math.BigDecimal;
import com.hps.july.web.util.*;

/**
 * Служебный класс-контейнер для хранения классов ReportRadioFreqRequestValue
 * и получения наборов строк для полей таблицы документа -
 * для документа "Заявка на назначение радиочастот для радиорелейных линий связи"
 */
public class ReportRadioFreqRequestVOs
{
	private StringAndBigDecimalProperty s_bd = new StringAndBigDecimalProperty();
	private StringAndSqlDateProperty s_date = new StringAndSqlDateProperty();
	private StringAndIntegerProperty s_i = new StringAndIntegerProperty();
	
	private int hopscount;
	
	private Collection gkrchs = new ArrayList(); // Массив пар документов ГКРЧ (ReportPairString)
	private Collection models = new ArrayList(); // массив названий оборудования пролётов (String)
	private Collection vendors = new ArrayList(); // Массив названий производителей (ReportPairString)
	private Collection freqrange = new ArrayList(); // Массив полос частот по решениям ГКРЧ (ReportPairString)
	private Collection radioclass = new ArrayList(); // Массив пар класса излучения (ReportPairString)
	private Collection mkkrplan = new ArrayList(); // Массив Частотных планов (ReportPairString)
	private Collection powers = new ArrayList(); //
	private Collection freqdevs = new ArrayList(); //
	private Collection rsens = new ArrayList(); //
	private Collection anttypes = new ArrayList(); // String[]
	private Collection coeff = new ArrayList(); // (ReportPairString[])
	private Collection widths = new ArrayList(); //
	private Collection speeds = new ArrayList();
	private Collection rrls = new ArrayList();
	
	
/*	
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
*/

	public ReportRadioFreqRequestVOs()
	{
	}

	public void addAnttype(BigDecimal diam)
	{
		if(diam != null) {
			s_bd.setBigDecimal(diam);
			anttypes.add("" + s_bd.getString() + " м");
		}
	}
	
	public void addCoeff(String model, BigDecimal newCoeff) {
		if(newCoeff != null) {
			s_bd.setBigDecimal(newCoeff);
			coeff.add(new ReportStringPair(model,s_bd.getString()));
		}
	}

	public void addFreqdevs(String model, BigDecimal freqdev) {
		if(freqdev != null) {
			s_bd.setBigDecimal(freqdev);
			freqdevs.add(new ReportStringPair(model,s_bd.getString()));
		}
	}

	public void addFreqrange(String model, String ffreqrange) {
		freqrange.add(new ReportStringPair(model,ffreqrange));
	}
	
	public void addGkrchs(String model, String number, java.sql.Date date) {
		if(number != null && date != null) {
			s_date.setSqlDate(date);
			String result = number + " от " + s_date.getString();
			gkrchs.add(new ReportStringPair(model,result));
		} else {
			gkrchs.add(new ReportStringPair(model,""));
		}
	}

	public void addMkkrplan(String model, String mkkr) {
		mkkrplan.add(new ReportStringPair(model,mkkr));
	}

	public void addModels(String model) {
		models.add(model);
	}
	
	public void addPowers(String model, BigDecimal power) {
		if(power != null) {
			s_bd.setBigDecimal(power);
			powers.add(new ReportStringPair(model,s_bd.getString()));
		}
	}
	
	public void addRadioclass(String model, String rclass) {
		radioclass.add(new ReportStringPair(model,rclass));
	}
	
	public void addRrls(String model, String number, java.sql.Date date) {
		if(number != null && date != null) {
			s_date.setSqlDate(date);
			String result = number + " от " + s_date.getString();
			rrls.add(new ReportStringPair(model,result));
		} else {
			rrls.add(new ReportStringPair(model,""));
		}
	}

	public void addRsens(String model, BigDecimal dbm) {
		if(dbm != null) {
			s_bd.setBigDecimal(dbm);
			rsens.add(new ReportStringPair(model,s_bd.getString()));
		}
	}

	public void addSpeeds(String model, String speed) {
		speeds.add(new ReportStringPair(model,speed));
	}

	public void addVendors(String vendor) {
		vendors.add(vendor);
	}

public Iterator getAnttypes() {
	return anttypes.iterator();
}
public Iterator getCoeff() {
	return coeff.iterator();
}
public Iterator getFreqdevs() {
	return freqdevs.iterator();
}
public Iterator getFreqrange() {
	return freqrange.iterator();
}
public Iterator getGkrchs() {
	return gkrchs.iterator();
}
public int getHopscount() {
	return hopscount;
}
public Iterator getMkkrplan() {
	return mkkrplan.iterator();
}
public Iterator getModels() {
	return models.iterator();
}
public Iterator getPowers() {
	return powers.iterator();
}
public Iterator getRadioclass() {
	return radioclass.iterator();
}
public Iterator getRrls() {
	return rrls.iterator();
}
public Iterator getRsens() {
	return rsens.iterator();
}
public Iterator getSpeeds() {
	return speeds.iterator();
}
public Iterator getVendors() {
	return vendors.iterator();
}
public Iterator getWidths() {
	return widths.iterator();
}
/**
 * 
 * @param newHopscount int
 */
public void setHopscount(int newHopscount) {
	hopscount = newHopscount;
}

	public void addWidths(String model, Object hwidth, Object vwidth) {
		String r = "";
		if(hwidth != null) {
			s_bd.setBigDecimal((BigDecimal)hwidth);
			r += s_bd.getString();
			if(vwidth != null) {
				r += "/";
			}
		}
		if(vwidth != null) {
			s_bd.setBigDecimal((BigDecimal)vwidth);
			r += s_bd.getString();
		}
		widths.add(new ReportStringPair(model,r));
	}
}
