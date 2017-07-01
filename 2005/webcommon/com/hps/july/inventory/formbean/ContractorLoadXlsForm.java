package com.hps.july.inventory.formbean;

import java.util.HashMap;
import com.hps.july.persistence.EquipmentSetAccessBean;
import java.util.Iterator;
import java.util.LinkedList;
import com.hps.july.cdbc.objects.CDBCEquipmentObject;
import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import com.hps.july.web.util.ValidationException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;
import jxl.Cell;
import jxl.CellType;
import jxl.format.CellFormat;
import jxl.Sheet;
import jxl.Workbook;

/**
 * Форма загрузки данных
 */
public class ContractorLoadXlsForm extends ContractorInventoryForm{
	private org.apache.struts.upload.FormFile xslFile;	
public ContractorLoadXlsForm(){
	setLastVisited(true);
}
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception{
	return null;
}
public int getApplication(){
	return com.hps.july.constants.Applications.INVENTORY;
}
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request){
	return null;
}
public int getState(){
	return com.hps.july.inventory.APPStates.CONTRLOADXLS;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2005 15:59:21)
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getXslFile() {
	return xslFile;
}
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	final String IBPBS = "Источник питания Базовой Станции";
	final String VIBPBS = "Выпрямители Источников питания БС";
	final String ACIBP = "Аккумуляторы Источников питания БС и BSC\\";
	final String BPA = "Блок преобразования аварий";	
	final String SO = "Силовое оборудование";
	final String PO = "Прочее оборудование";
	final String MSHU = "Малошумящий усилитель";
	final String CD = "Комбайнеры. Делители.";
	final String CONTR = "Контроллер";
	final String BSCIBP = "Источник питания Контроллера Базовых Станций";
	final String REP = "1.5 Репитер";
	final String ANT = "2.2 Антенны";
	final String AFT = "2.1 Антенно-фидерный тракт";
	final String PRO1 = "ПРОЧЕЕ";
	final String PRO2 = "ОБОРУДОВАНИЕ";
	final String CABLERCH = "Кабель р/ч";
	
	ArrayList bis = new ArrayList();
	ArrayList bip = new ArrayList();
	ArrayList vbip = new ArrayList();
	ArrayList acc = new ArrayList();
	ArrayList bia = new ArrayList();
	ArrayList sio = new ArrayList();
	ArrayList pio = new ArrayList();
	ArrayList mio = new ArrayList();
	ArrayList cio = new ArrayList();
	ArrayList cbis = new ArrayList();
	ArrayList cbip = new ArrayList();
	ArrayList rip = new ArrayList();
	ArrayList ain = new ArrayList();
	ArrayList aif = new ArrayList();
	ArrayList prio = new ArrayList();
	
	Connection conn = null;
	PreparedStatement ps = null;
	PreparedStatement bsSearcgPs = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	PreparedStatement ps7 = null;
	PreparedStatement ps8 = null;	
		
	Workbook workbook = null;

	try{
	
		FormFile formFile = getXslFile();
		String str = formFile.getFileName();

		byte[] data = formFile.getFileData();
		java.io.ByteArrayInputStream file = new ByteArrayInputStream(data);
        
    	workbook = Workbook.getWorkbook(file);
    	Sheet sheet = workbook.getSheet(0);

		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		int id = keyGen.getNextKey("tables.invcontracts");

		conn = new JdbcConnection().getConnection();
		
		ps = conn.prepareStatement("insert into invcontracts values(?,?,?,?,?,?,?,?,?,?,?)");
		// BEE00001443
		String bsSearchSQL = " select " + 
			" basestations.equipment as eq, equipment.position as posid " +
			" from basestations, equipment " + 
			" where number = ? " +
			"  and type in ('S', 'C', 'G') " +
			"  and (state900 in ('W', 'M', 'P') or state1800 in ('W', 'M', 'P')) " +
			"  and equipment.equipment = basestations.equipment ";
		bsSearcgPs = conn.prepareStatement(bsSearchSQL);	
		
		ps3 = conn.prepareStatement("select countpolicy,resource from resources where model=?");
		ps5 = conn.prepareStatement("select count(*) from categresources where categid = ? and resource =?");
		ps7 = conn.prepareStatement("select count(*) from categresources where (categid = ? or categid=?) and resource =?");
		ps6 = conn.prepareStatement("insert into categresources values(?,?)");
		ps8 = conn.prepareStatement("select resource from resources where model = ? and resourcesubtype = 20");
		
		//-------------данные----------
		java.sql.Date invDate = null;
		Integer gsmid = new Integer(0);
		String sgsmid = sheet.getCell(2,2).getContents();
		if(sgsmid!=null) gsmid = new Integer(sgsmid);

		//------------позиция----------
		//-----------комплект----------
		// BEE00001443
		int positioncode = 0;
		int complectid = 0;	
		
		bsSearcgPs.setInt(1,gsmid.intValue());
		ResultSet bsSearcgRs = bsSearcgPs.executeQuery();			
		if(bsSearcgRs.next()){
			complectid = bsSearcgRs.getInt(1);	
			positioncode = bsSearcgRs.getInt(2);
		}else{
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notfind.position",String.valueOf(gsmid)));	
			throw new ValidationException();
		}
		//-----------------------------
		
		String curGroup = "";
		String insMan= "";
		String sinvDate="";
		String gsm = "";
		for(int i = 0;i<rows;i++){
			String row = sheet.getCell(1,i).getContents().trim();
			String count3 = sheet.getCell(3,i).getContents().trim();
				
			//System.out.println("row " + i + ":" + row.trim());
			//System.out.println("curGroup " + i + ":" + curGroup);
			
			if(row.equals("Инвентаризацию провели:")){
				insMan = sheet.getCell(3,i).getContents();
				sinvDate = sheet.getCell(6,i).getContents();
				SimpleDateFormat sdf = new SimpleDateFormat();
				if(sinvDate.indexOf("/")!=-1) sdf.applyPattern("dd/MM/yyyy");
				else if(sinvDate.indexOf(".")!=-1) sdf.applyPattern("dd.MM.yyyy");
				else continue;
				invDate = new java.sql.Date((sdf.parse(sinvDate)).getTime());
			}
			else if(row.equals(IBPBS) || row.equals(VIBPBS) || row.equals(ACIBP) || row.equals(BPA)
				|| row.equals(SO) || row.equals(PO) || row.equals(MSHU) || row.equals(CD)
				|| row.equals(CONTR) || row.equals(BSCIBP) || row.equals(REP) || row.equals(ANT)
				|| row.equals(AFT) || (row.toUpperCase().indexOf(PRO1)!=-1 && row.toUpperCase().indexOf(PRO2)!=-1)){
				curGroup = row;
			}			
			else if((row.equals(C_BS) || (row.equals(C_IBP) && curGroup.equals(IBPBS))
				|| (row.equals(C_YPIT) && curGroup.equals(VIBPBS))) && !"".equals(count3)){
				String model = sheet.getCell(8,i).getContents();
				if(!model.equals("") && !model.equals("0")){
					PosVO bsvo = new PosVO();
					
					int categid = 0;
					if(row.equals(C_IBP) && curGroup.equals(IBPBS)){
						model = model.replace('-',' ');
						model = model.replace('М','M');
						categid = BS_BP;						
					}else if(row.equals(C_YPIT) && curGroup.equals(VIBPBS)){
						categid = BS_BP_VIPR;
					}

					//System.out.println("------------------");
					bsvo.setResourcecateg(categid);
					//------type
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();
					
					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							bsvo.setUnknownTypeError(model);	
						}else if(!row.equals(C_BS)){
							ps5.setInt(1,categid);
							ps5.setInt(2,type);
							ResultSet rs4 = ps5.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,categid);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
						
					}else{
						type = 0;
						bsvo.setUnknownTypeError(model);						
					}
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();
					String note = sheet.getCell(5,i).getContents();
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
					String room = sheet.getCell(6,i).getContents();					
					
					bsvo.setType(new Integer(type));
					if(vcnt>1){	 
						bsvo.setCount("1");
					}
					else if(vcnt==1){
						bsvo.setCount(count);
					}
					bsvo.setSn(sn);
					bsvo.setNote(note);
					bsvo.setRoomnumber(room);
					bsvo.setComplect(new Integer(complectid));

					if(row.equals(C_IBP) && curGroup.equals(IBPBS)){
						for(int j=0;j<vcnt;j++){
							bip.add(bsvo);
						}
					}else if(row.equals(C_BS)){
						for(int j=0;j<vcnt;j++){
							bis.add(bsvo);
						}
					}else if(row.equals(C_YPIT) && curGroup.equals(VIBPBS)){
						for(int j=0;j<vcnt;j++){							
							vbip.add(bsvo);
							/*System.out.println("++++ "+ j);
							System.out.println("++++size: "+ vbip.size());
							System.out.println("++++valueb: "+ ((PosVO)vbip.get(j)).getSn());
							if(j>0){
								System.out.println("++++set "+ j);
								((PosVO)vbip.get(j)).setSn("");
							}
							System.out.println("++++valuea: "+ ((PosVO)vbip.get(j)).getSn());
							System.out.println("-------------------");*/
						}
					}
					
					
				}else continue;
			}else if(row.equals("Аккумулятор") && curGroup.equals(ACIBP) && !"".equals(count3)){
				String model = sheet.getCell(8,i).getContents();
				if(!model.equals("") && !model.equals("0")){
					PosVO accvo = new PosVO();

					accvo.setResourcecateg(ACC_BS);
					//------type
					if(model.endsWith("A")){
						model = model.substring(0,model.length()-1);
						model = model + "А";
					}
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();	
						
					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							accvo.setUnknownTypeError(model);	
						}else{						
							ps7.setInt(1,ACC_BS);
							ps7.setInt(2,ACC_BSC);
							ps7.setInt(3,type);
							ResultSet rs4 = ps7.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,ACC_BS);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
					}else{
						type = 0;
						accvo.setUnknownTypeError(model);
					}
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();
					String note = "";
					
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
							
					//Double begvolt = null;
					//Double afterhour = null;
					String sbegvolt = sheet.getCell(5,i).getContents();
					sbegvolt = sbegvolt.replace(',','.');
					//begvolt = new Double(sbegvolt);
					String safterhour = sheet.getCell(6,i).getContents();
					safterhour = safterhour.replace(',','.');
					//afterhour = new Double(safterhour);
					
					accvo.setType(new Integer(type));
					if(vcnt>1){	 
						accvo.setCount("1");
					}
					else if(vcnt==1){
						accvo.setCount(count);
					}
					
					accvo.setSn(sn);
					accvo.setNote(sbegvolt);
					accvo.setComment(note);
					accvo.setRoomnumber(safterhour);
					accvo.setComplect(new Integer(complectid));

					for(int j=0;j<vcnt;j++){
						acc.add(accvo);
					}
					
				}else continue;
			}else if((row.equals("Блок внешних аварий") || row.equals("Инвертер аварий")) 
					&& curGroup.equals(BPA) && !"".equals(count3)){
				String model = sheet.getCell(2,i).getContents();
				if(!model.equals("") && !model.equals("0")){
					PosVO bpavo = new PosVO();

					bpavo.setResourcecateg(BS_INV_AV);
					//------type
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();		
						
					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							bpavo.setUnknownTypeError(model);	
						}else{
							ps5.setInt(1,BS_INV_AV);
							ps5.setInt(2,type);
							ResultSet rs4 = ps5.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,BS_INV_AV);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
						
					}else{						
						type = 0;
						bpavo.setUnknownTypeError(model);
					}

					int categ = 0;
					if(row.equals("Блок внешних аварий")){
						categ = 2;
					}else if(row.equals("Инвертер аварий")){
						categ = 1;
					} 
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();
					String note = sheet.getCell(5,i).getContents();
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
							
					String room = sheet.getCell(6,i).getContents();					

					bpavo.setCateg(new Integer(categ));
					bpavo.setType(new Integer(type));
					if(vcnt>1){	 
						bpavo.setCount("1");
					}
					else if(vcnt==1){
						bpavo.setCount(count);
					}
					bpavo.setSn(sn);
					bpavo.setNote(note);
					bpavo.setRoomnumber(room);
					bpavo.setComplect(new Integer(complectid));
					
					for(int j=0;j<vcnt;j++){
						bia.add(bpavo);
					}
					
				}else continue;
			}else if((row.equals("Щит питания") || row.equals("АВР") || row.equals("Панель коммутационная")) 
					&& curGroup.equals(SO) && !"".equals(count3)){
						
				String model = "";
				int categ = 0;
				int categid = 0;
				if(row.equals("Щит питания")){
					categ = 1;
					categid = BS_SH;
					model = sheet.getCell(8,i).getContents();
				}else if(row.equals("АВР")){
					categ = 2;
					categid = BS_AVR;
					model = sheet.getCell(8,i).getContents();
				}else if(row.equals("Панель коммутационная")){
					categ = 3;
					categid = BSC_P_COM;
					model = sheet.getCell(2,i).getContents();
				} 
				
				
				if(!model.equals("") && !model.equals("0")){
					PosVO bpavo = new PosVO();
					bpavo.setResourcecateg(categid);
					//------type
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();		
						
					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							bpavo.setUnknownTypeError(model);	
						}else{
							ps5.setInt(1,categid);
							ps5.setInt(2,type);
							ResultSet rs4 = ps5.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,categid);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
						
					}else{
						type = 0;
						bpavo.setUnknownTypeError(model);
					}
					
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();
					String note = sheet.getCell(5,i).getContents();
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
					String room = sheet.getCell(6,i).getContents();					

					bpavo.setCateg(new Integer(categ));
					bpavo.setType(new Integer(type));
					if(vcnt>1){	 
						bpavo.setCount("1");
					}
					else if(vcnt==1){
						bpavo.setCount(count);
					}
					bpavo.setSn(sn);
					bpavo.setNote(note);
					bpavo.setRoomnumber(room);
					bpavo.setComplect(new Integer(complectid));
					
					for(int j=0;j<vcnt;j++){
						sio.add(bpavo);
					}
					
				}else continue;
			}else if((row.equals("Кондиционер") || row.equals("Панель сигнализации") 
				|| row.equals("Источник питания УЗО") || row.equals("Преобразователь УЗО")) 
					&& curGroup.equals(PO) && !"".equals(count3)){
						
				String model = "";
				int categ = 0;
				int categid = 0;
				if(row.equals("Кондиционер")){
					categ = 1;
					categid = BS_COND;
					model = sheet.getCell(8,i).getContents();					
				}else if(row.equals("Панель сигнализации")){
					categ = 2;
					categid = BS_PAN_SIG;
					model = sheet.getCell(8,i).getContents();
				}else if(row.equals("Источник питания УЗО")){
					categ = 3;
					categid = BS_IST_PIT_UZO;
					model = sheet.getCell(8,i).getContents();
				}else if(row.equals("Преобразователь УЗО")){
					categ = 4;
					categid = BS_PR_UZO;
					model = sheet.getCell(2,i).getContents();
				} 

				if(!model.equals("") && !model.equals("0")){
					PosVO bpavo = new PosVO();
					//------type
					bpavo.setResourcecateg(categid);
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();	
						
					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							bpavo.setUnknownTypeError(model);	
						}else{
							ps5.setInt(1,categid);
							ps5.setInt(2,type);
							ResultSet rs4 = ps5.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,categid);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
						
					}else{
						type = 0;
						bpavo.setUnknownTypeError(model);
					}
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();
					String note = sheet.getCell(5,i).getContents();
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
					String room = sheet.getCell(6,i).getContents();					

					bpavo.setCateg(new Integer(categ));
					bpavo.setType(new Integer(type));
					if(vcnt>1){	 
						bpavo.setCount("1");
					}
					else if(vcnt==1){
						bpavo.setCount(count);
					}
					bpavo.setSn(sn);
					bpavo.setNote(note);
					bpavo.setRoomnumber(room);
					bpavo.setComplect(new Integer(complectid));
					
					for(int j=0;j<vcnt;j++){
						pio.add(bpavo);
					}
					
				}else continue;
			}else if((row.equals("МШУ. Источник питания") || row.equals("МШУ.Усилитель") 
				|| row.equals("МШУ.Инжектор")) 
					&& curGroup.equals(MSHU) && !"".equals(count3)){
						
				String model = sheet.getCell(8,i).getContents();
				int categ = 0;
				int categid = 0;
				if(row.equals("МШУ. Источник питания")){
					categ = 1;
					categid = MSU_IBP;
				}else if(row.equals("МШУ.Усилитель")){
					categ = 2;
					categid = MSU_USIL;
				}else if(row.equals("МШУ.Инжектор")){
					categ = 3;
					categid = MSU_INJ;
				}
				
				if(!model.equals("") && !model.equals("0")){
					PosVO bpavo = new PosVO();
					bpavo.setResourcecateg(categid);
					//------type
					
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();

					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							bpavo.setUnknownTypeError(model);	
						}else{
							ps5.setInt(1,categid);
							ps5.setInt(2,type);
							ResultSet rs4 = ps5.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,categid);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
					}else{
						type = 0;
						bpavo.setUnknownTypeError(model);
					}
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();				
					String room = sheet.getCell(6,i).getContents();
					String note = "";		

					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
					
					bpavo.setCateg(new Integer(categ));
					bpavo.setType(new Integer(type));
					if(vcnt>1){	 
						bpavo.setCount("1");
					}
					else if(vcnt==1){
						bpavo.setCount(count);
					}
					bpavo.setSn(sn);
					bpavo.setNote(note);
					bpavo.setRoomnumber(room);
					bpavo.setComplect(new Integer(complectid));
					
					for(int j=0;j<vcnt;j++){
						mio.add(bpavo);
					}
					
				}else continue;
			}else if((row.equals("Делитель") || row.equals("Диплексер") 
				|| row.equals("Комбайнер 900/1800")) 
					&& curGroup.equals(CD) && !"".equals(count3)){
						
				String model = sheet.getCell(8,i).getContents();
				int categ = 0;
				int categid = 0;
				if(row.equals("Делитель")){
					categ = 1;
					categid = AFS_IN_DEL;
				}else if(row.equals("Диплексер")){
					categ = 2;
					categid = AFS_IN_DIP;
				}else if(row.equals("Комбайнер 900/1800")){
					categ = 3;
					categid = AFS_IN_COMB;
				}
				
				
				if(!model.equals("") && !model.equals("0")){
					PosVO bpavo = new PosVO();
					bpavo.setResourcecateg(categid);
					//------type
					
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();

					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							bpavo.setUnknownTypeError(model);	
						}else{
							ps5.setInt(1,categid);
							ps5.setInt(2,type);
							ResultSet rs4 = ps5.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,categid);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
					}else{
						type = 0;
						bpavo.setUnknownTypeError(model);
					}
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();	
					String note = sheet.getCell(5,i).getContents();
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
					String room = sheet.getCell(6,i).getContents();					

					bpavo.setCateg(new Integer(categ));
					bpavo.setType(new Integer(type));
					if(vcnt>1){	 
						bpavo.setCount("1");
					}
					else if(vcnt==1){
						bpavo.setCount(count);
					}
					bpavo.setSn(sn);
					bpavo.setNote(note);
					bpavo.setRoomnumber(room);
					bpavo.setComplect(new Integer(complectid));
					
					for(int j=0;j<vcnt;j++){
						cio.add(bpavo);
					}
					
				}else continue;
			}else if((row.equals("Основная стойка.") || row.equals("Стойка расширения.")) 
					&& curGroup.equals(CONTR) && !"".equals(count3)){
						
				String model = sheet.getCell(8,i).getContents();
				int categ = 0;
				int categid = 0;
				if(row.equals("Основная стойка.")){
					categ = 1;
					categid = BSC_OSN_ST;
				}else if(row.equals("Стойка расширения.")){
					categ = 2;
					categid = BSC_ST_RASH;
				}				
				
				if(!model.equals("") && !model.equals("0")){
					PosVO bpavo = new PosVO();
					bpavo.setResourcecateg(categid);
					//------type
					
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();

					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							bpavo.setUnknownTypeError(model);	
						}else{
							ps5.setInt(1,categid);
							ps5.setInt(2,type);
							ResultSet rs4 = ps5.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,categid);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
					}else{						
						type = 0;
						bpavo.setUnknownTypeError(model);
					}
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();	
					String note = sheet.getCell(5,i).getContents();
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
					String room = sheet.getCell(6,i).getContents();					

					bpavo.setCateg(new Integer(categ));
					bpavo.setType(new Integer(type));
					if(vcnt>1){	 
						bpavo.setCount("1");
					}
					else if(vcnt==1){
						bpavo.setCount(count);
					}
					bpavo.setSn(sn);
					bpavo.setNote(note);
					bpavo.setRoomnumber(room);
					bpavo.setComplect(new Integer(complectid));
					
					for(int j=0;j<vcnt;j++){
						cbis.add(bpavo);
					}
					
				}else continue;
			}else if((row.equals(C_IBP) || row.equals("Репитер")) 
						&& (curGroup.equals(BSCIBP) || curGroup.equals(REP)) && !"".equals(count3)){
							
				String model = "";
				int categid = 0;
				if(row.equals(C_IBP)){
					categid = BSC_BP;
					model = sheet.getCell(8,i-1).getContents();					
				}else if(row.equals("Репитер")){
					categid = 39;
					model = sheet.getCell(8,i).getContents();
				}
				
				if(!model.equals("") && !model.equals("0")){
					PosVO bsvo = new PosVO();
					bsvo.setResourcecateg(categid);
					//------type
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();		
						
					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							bsvo.setUnknownTypeError(model);	
						}else{
							ps5.setInt(1,categid);
							ps5.setInt(2,type);
							ResultSet rs4 = ps5.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,categid);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
						
					}else{
						type = 0;
						bsvo.setUnknownTypeError(model);
					}
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();	
					String note = sheet.getCell(5,i).getContents();
					String comment = "";
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						comment = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
					String room = sheet.getCell(6,i).getContents();
					
					bsvo.setType(new Integer(type));
					if(vcnt>1){	 
						bsvo.setCount("1");
					}
					else if(vcnt==1){
						bsvo.setCount(count);
					}
					bsvo.setSn(sn);
					bsvo.setNote(note);
					bsvo.setComment(comment);
					bsvo.setRoomnumber(room);
					bsvo.setComplect(new Integer(complectid));

					
					if(row.equals(C_IBP)){
						for(int j=0;j<vcnt;j++){
							cbip.add(bsvo);
						}
					}else if(row.equals("Репитер")){
						for(int j=0;j<vcnt;j++){
							rip.add(bsvo);
						}						
					}
					
				}else continue;
			}else if(row.equals("Антенна") && curGroup.equals(ANT) && !"".equals(count3)){
							
				String model =  sheet.getCell(2,i).getContents();
				
				if(!model.equals("") && !model.equals("0")){
					PosVO bsvo = new PosVO();
					bsvo.setResourcecateg(AFS_ANT);
					//------type
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();		
						
					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");

						if(rs2.next()){
							type = 0;
							bsvo.setUnknownTypeError(model);	
						}else{
							ps5.setInt(1,AFS_ANT);
							ps5.setInt(2,type);
							ResultSet rs4 = ps5.executeQuery();
							int count = -1;
							rs4.next();
							count = rs4.getInt(1);

							if(count==0){
								ps6.setInt(1,AFS_ANT);
								ps6.setInt(2,type);
								ps6.execute();
							}
						}
					}else{
						type = 0;
						bsvo.setUnknownTypeError(model);
					}
					
					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();	
					String note = sheet.getCell(6,i).getContents();
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
					
					bsvo.setType(new Integer(type));
					if(vcnt>1){	 
						bsvo.setCount("1");
					}
					else if(vcnt==1){
						bsvo.setCount(count);
					}
					bsvo.setSn(sn);
					bsvo.setNote(note);
					bsvo.setComplect(new Integer(complectid));
					
					
					for(int j=0;j<vcnt;j++){
						ain.add(bsvo);
					}
					
				}else continue;
			}else if(row.indexOf(CABLERCH)!=-1 && curGroup.equals(AFT) && !"".equals(count3)){
							
				String model =  sheet.getCell(8,i).getContents();
				String count2 =  sheet.getCell(3,i).getContents();
				int categ = 0;
				String cabletype = "";
				
				String gsmC = sheet.getCell(6,i).getContents();
				if(!gsmC.equals("")) gsm = gsmC;
				
				if(row.equals(C_CABLE_0)){
					categ = 1;
					model = "0";
				}else if(row.equals(C_CABLE_14)){
					categ = 2;
					cabletype = "CF 1/4-50";
				}else if(row.equals(C_CABLE_12)){
					categ = 3;					
					cabletype = "LCF 1/2-50";
				}else if(row.equals(C_CABLE_114)){
					categ = 4;					
					cabletype = "LCF 1 1/4-50";
				}else if(row.equals(C_CABLE_158)){
					categ = 5;
					cabletype = "LCF 1 5/8-50";
				}else if(row.equals(C_CABLE_78)){
					categ = 6;
					cabletype = "LCF 7/8-50";
				}else{
					if(model.equals("1/4")){
						categ = 2;
						cabletype = "CF 1/4-50";
					}
					else if(model.equals("1/2")){
						categ = 3;
						cabletype = "LCF 1/2-50";
					}
					else if(model.equals("1 1/4")){
						categ = 4;
						cabletype = "LCF 1 1/4-50";
					}
					else if(model.equals("1 5/8")){
						categ = 5;
						cabletype = "LCF 1 5/8-50";
					}
					else if(model.equals("7/8")){
						categ = 6;
						cabletype = "LCF 7/8-50";
					}
					else if(model.equals("РК-50-1751С")){
						categ = 7;
						cabletype = "РК-50-17-51С";
					}
					
				}
				
				if(!model.equals("") && !model.equals("0")){
					PosVO afvo = new PosVO();
					afvo.setResourcecateg(AFS_AFT);
					
					ps8.setString(1,cabletype); 
					ResultSet rs2 = ps8.executeQuery();		
						
					int type = 0;
					if(rs2.next()){
						type = rs2.getInt(1);

						ps5.setInt(1,AFS_AFT);
						ps5.setInt(2,type);
						ResultSet rs4 = ps5.executeQuery();
						int count = -1;
						rs4.next();
						count = rs4.getInt(1);

						if(count==0){
							ps6.setInt(1,AFS_AFT);
							ps6.setInt(2,type);
							ps6.execute();
						}
					}else{
						type = 0;
						afvo.setUnknownTypeError(cabletype);
					}

					String sector = sheet.getCell(2,i).getContents();
					String count = sheet.getCell(3,i).getContents();
					
					Double ksv = null;
					String sksv = sheet.getCell(5,i).getContents();
					sksv = sksv.replace(',','.');
					if(isValidDec(sksv)) ksv = new Double(sksv);
	
					String note = sheet.getCell(6,i).getContents();

					afvo.setCateg(new Integer(categ));
					afvo.setType(new Integer(type));
					afvo.setCount(count);
					afvo.setSector(sector);
					afvo.setKsb(ksv!=null?ksv.toString():"");
					afvo.setGsm(gsm);
					
					afvo.setComplect(new Integer(complectid));
					
					aif.add(afvo);
					
				}else continue;
			}else if(curGroup.toUpperCase().indexOf(PRO1)!=-1 && curGroup.toUpperCase().indexOf(PRO2)!=-1){
				
				String nextrow = sheet.getCell(1,i+1).getContents().trim();	
				if(nextrow.equals("Инвентаризацию провели:")){
					curGroup = "";
					continue;
				}
					
				String model = sheet.getCell(2,i).getContents();
				if(!model.equals("") && !model.equals("0")){
					PosVO bpavo = new PosVO();
					
					//------type
					ps3.setString(1,model); 
					ResultSet rs2 = ps3.executeQuery();		
						
					int type = 0;
					String countpolicy = "";
					if(rs2.next()){
						type = rs2.getInt("resource");
						countpolicy = rs2.getString("countpolicy");
						if(rs2.next()){
							type = 0;
							bpavo.setUnknownTypeError(model);
						}
					}else{						
						type = 0;
						bpavo.setUnknownTypeError(model);
					}

					String count = sheet.getCell(3,i).getContents();
					String sn = sheet.getCell(4,i).getContents();
					String note = sheet.getCell(5,i).getContents();
					if(countpolicy.equals("B") && sn!=null && !sn.equals("")){
						note = sn;
						sn = "";
					}
					int vcnt = 1;
					if((countpolicy.equals("S") || countpolicy.equals("P")) && isValidInt(count) 
							&& new Integer(count).intValue()>1){
						vcnt = new Integer(count).intValue();
					}
					String room = sheet.getCell(6,i).getContents();					

					bpavo.setCateg(null);
					bpavo.setType(new Integer(type));
					bpavo.setTypename(model);
					if(vcnt>1){	 
						bpavo.setCount("1");
					}
					else if(vcnt==1){
						bpavo.setCount(count);
					}
					bpavo.setSn(sn);
					bpavo.setNote(note);
					bpavo.setRoomnumber(room);
					bpavo.setComplect(new Integer(complectid));

					for(int j=0;j<vcnt;j++){
						prio.add(bpavo);
					}					
					
				}else continue;
			}
			
						
		}
		
		//----------------------		

	
		getHeadercalcerrors().clear();
        getCalcerrors().clear();
				

        ps.setInt(1,id);
        ps.setInt(2,1);
        ps.setInt(3,positioncode);
        ps.setDate(4,invDate);
        ps.setNull(5,java.sql.Types.INTEGER);
        ps.setNull(6,java.sql.Types.CHAR);
        ps.setNull(7,java.sql.Types.INTEGER);
        ps.setString(8,insMan);
        ps.setString(9,"1");
        ps.setString(10,"");
        ps.setNull(11,java.sql.Types.INTEGER);
        ps.execute();

        request.getSession().setAttribute("idact",new Integer(id));

        //String prefix = "Оборудование ";
        String postfix = " не найдено!";
        HashMap xlserrors = new HashMap();
        int position = 1;
        //Создание бс
		for(int i = 0; i < bis.size(); i++) {
			if(bis.get(i)!=null && ((PosVO)bis.get(i)).getType()!=null &&((PosVO)bis.get(i)).getType().intValue() != -1) {
				createRow(i,id,position,bis,conn,1,keyGen);
				xlserrors.put(new Integer(position),((PosVO)bis.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}
		//Создание ист пит базовой станции
		for(int i = 0; i < bip.size(); i++) {
			if(bip.get(i)!=null && ((PosVO)bip.get(i)).getType()!=null &&((PosVO)bip.get(i)).getType().intValue() != -1) {
				createRow(i,id,position,bip,conn,2,keyGen);
				xlserrors.put(new Integer(position),((PosVO)bip.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Создание выпрям ист пит базовой станции
		for(int i = 0; i < vbip.size(); i++) {
			if(vbip.get(i)!=null && ((PosVO)vbip.get(i)).getType()!=null &&((PosVO)vbip.get(i)).getType().intValue() != -1) {
				//System.out.println("++++create: "+ ((PosVO)vbip.get(i)).getSn());
				createRow(i,id,position,vbip,conn,3,keyGen);
				xlserrors.put(new Integer(position),((PosVO)vbip.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}
		
		//Создание акк баз станций
		for(int i = 0; i < acc.size(); i++) {
			if(acc.get(i)!=null && ((PosVO)acc.get(i)).getType()!=null &&((PosVO)acc.get(i)).getType().intValue() != -1) {
				createAccRow(i,id,position,acc,conn,4,keyGen);
				xlserrors.put(new Integer(position),((PosVO)acc.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Создание блока преобразования аварий
		for(int i = 0; i < bia.size(); i++) {
			if(bia.get(i)!=null && ((PosVO)bia.get(i)).getType()!=null &&((PosVO)bia.get(i)).getType().intValue() != -1) {
				createBpaRow(i,id,position,bia,conn,5,keyGen);
				xlserrors.put(new Integer(position),((PosVO)bia.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Создание силового оборудования
		for(int i = 0; i < sio.size(); i++) {
			if(sio.get(i)!=null && ((PosVO)sio.get(i)).getType()!=null &&((PosVO)sio.get(i)).getType().intValue() != -1) {
				createBpaRow(i,id,position,sio,conn,6,keyGen);
				xlserrors.put(new Integer(position),((PosVO)sio.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Создание прочего оборудования
		for(int i = 0; i < pio.size(); i++) {
			if(pio.get(i)!=null && ((PosVO)pio.get(i)).getType()!=null &&((PosVO)pio.get(i)).getType().intValue() != -1) {
				createBpaRow(i,id,position,pio,conn,7,keyGen);
				xlserrors.put(new Integer(position),((PosVO)pio.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Малошумящий усилитель
		for(int i = 0; i < mio.size(); i++) {
			if(mio.get(i)!=null && ((PosVO)mio.get(i)).getType()!=null &&((PosVO)mio.get(i)).getType().intValue() != -1) {
				createBpaRow(i,id,position,mio,conn,8,keyGen);
				xlserrors.put(new Integer(position),((PosVO)mio.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Комбайнеры делители
		for(int i = 0; i < cio.size(); i++) {
			if(cio.get(i)!=null && ((PosVO)cio.get(i)).getType()!=null &&((PosVO)cio.get(i)).getType().intValue() != -1) {
				createBpaRow(i,id,position,cio,conn,9,keyGen);
				xlserrors.put(new Integer(position),((PosVO)cio.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Аппаратура контроллера базовых станций
		for(int i = 0; i < cbis.size(); i++) {
			if(cbis.get(i)!=null && ((PosVO)cbis.get(i)).getType()!=null &&((PosVO)cbis.get(i)).getType().intValue() != -1) {
				createBpaRow(i,id,position,cbis,conn,10,keyGen);
				xlserrors.put(new Integer(position),((PosVO)cbis.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Создание ист пит контроллера базовой станции
		for(int i = 0; i < cbip.size(); i++) {
			if(cbip.get(i)!=null && ((PosVO)cbip.get(i)).getType()!=null &&((PosVO)cbip.get(i)).getType().intValue() != -1) {
				createRow(i,id,position,cbip,conn,11,keyGen);
				xlserrors.put(new Integer(position),((PosVO)cbip.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Репитер
		
		for(int i = 0; i < rip.size(); i++) {
			if(rip.get(i)!=null && ((PosVO)rip.get(i)).getType()!=null &&((PosVO)rip.get(i)).getType().intValue() != -1) {
				createRow(i,id,position,rip,conn,12,keyGen);
				xlserrors.put(new Integer(position),((PosVO)rip.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Антенны
		
		for(int i = 0; i < ain.size(); i++) {
			if(ain.get(i)!=null && ((PosVO)ain.get(i)).getType()!=null &&((PosVO)ain.get(i)).getType().intValue() != -1) {
				createRow(i,id,position,ain,conn,13,keyGen);
				xlserrors.put(new Integer(position),((PosVO)ain.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//кабели
		for(int i = 0; i < aif.size(); i++) {
			if(aif.get(i)!=null && ((PosVO)aif.get(i)).getType()!=null &&((PosVO)aif.get(i)).getType().intValue() != -1) {
				createAftRow(i,id,position,aif,conn,14,keyGen);
				xlserrors.put(new Integer(position),((PosVO)aif.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		//Прочее оборудование
		for(int i = 0; i < prio.size(); i++) {
			if(prio.get(i)!=null && ((PosVO)prio.get(i)).getTypename()!=null) {
				createRow(i,id,position,prio,conn,15,keyGen);
				xlserrors.put(new Integer(position),((PosVO)prio.get(i)).getUnknownTypeError() + postfix);
				position++;
			}
		}

		request.getSession().setAttribute("xlserrors",xlserrors);
	}catch(jxl.read.biff.PasswordException ex){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.load.password", xslFile.getFileName()));
	}catch(ValidationException vex){
	}catch(Exception e){
		e.printStackTrace(System.out);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.load", xslFile.getFileName()));
	}finally{
	    try{
		    if(workbook!=null) workbook.close();
		    if(ps!=null) ps.close();
			if(bsSearcgPs!=null) bsSearcgPs.close(); 
		    if(ps3!=null) ps3.close();	
		    if(ps5!=null) ps5.close();
		    if(ps6!=null) ps6.close();
		    if(ps7!=null) ps7.close();
		    if(ps8!=null) ps8.close();
		    if(conn!=null) conn.close();
	    }catch(Exception exc){
		    exc.printStackTrace(System.out);
	    }
    }
	if (!errors.empty())
		throw new ValidationException();
	
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2005 15:59:21)
 * @param newXslFile org.apache.struts.upload.FormFile
 */
public void setXslFile(org.apache.struts.upload.FormFile newXslFile) {
	xslFile = newXslFile;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	
	if(xslFile != null && xslFile.getFileName().length() > 0 && xslFile.getFileSize() > 0){
		if(!(xslFile.getFileName().endsWith(".xls"))){
		    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.extension", xslFile.getFileName()));		
		}
	}else
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file"));		

	
	if (!errors.empty())
		throw new ValidationException();	
}
}
