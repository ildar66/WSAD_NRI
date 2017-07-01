package com.hps.july.dataimport.lib;

import java.util.*;
import jxl.*;
import com.hps.july.dataimport.dataobjects.*;
/**
  * Обработчик блока данных
*/
public class BlockHandler {
    private BlockDOMHandler domHandler;
    private Sheet sheet;

    private String sheetDescription;

    private int recCount = 0;
    private int errCount = 0;

    private LoggerHandler logHandler;
    private int sessId;
    private Map parameters;
    private int startBlockRow = -1;
    private int second_flag;
    private Hashtable cellstable;
    private BsBlockHandler bsBlockHandler;
    private boolean isConsole = true;
public BlockHandler(
    org.w3c.dom.Document doc,
    Sheet sheet,
    int sheetNum,
    int sessid,
    Map parameters) {

    this.sheet = sheet;
    domHandler = new BlockDOMHandler(doc, sheetNum);
    //  this.numberOfSheet = sheetNum - 1;
    sheetDescription = domHandler.getSheetDescription();
    if (sheetDescription.equals(""))
        sheetDescription = sheet.getName();
    //  process();

    this.sessId = sessid;
    this.parameters = parameters;

}
private int convert0HCoord(String sym) {
    char c = sym.charAt(0);

    return (int) c - 'A';
}
private String convertHCoord(int num) {

    char c1 = 0;
    char c2 = 0;
    int dx = 'A';
    int mod = 'Z' - 'A' + 1;

    int i = 0;
    if ((num - 1) / (mod) >= 1 && (num - 1) / (mod) < mod) {
        char[] arr = new char[2];
        i = (num - 1) / (mod);
        arr[0] = (char) (i + dx - 1);
        i = (num - 1) % (mod);
        arr[1] = (char) (i + dx);
        return new String(arr);
    } else
        if ((num - 1) / (mod) < 1) {
            return (char) (num + dx - 1) + "";
        } else {
            return num + "";
        }
}
public int getErrCount() {
    return errCount;
}
private void getMessage() {
    String mes = "";
    char quote = '"';

    for (int i = 0; i < cellstable.size(); i++) {
        String key = convertHCoord(i + 1);
        mes = key + "= {";
        
        String[] val = (String[]) cellstable.get(key);

        for (int j = 0; j < val.length; j++) {
            if (val[j].equals(""))
                val[j] = " ";
                
            mes += quote + val[j] + quote + " : ";
        }
        
        int k = mes.lastIndexOf(" : ");
        mes = mes.substring(0, k);
        mes += "}";
        
        DebugSupport.getMessage(mes);
    }
}
public int getRecCount() {
    return recCount;
}
private int handleBlock(int flag) {
    try {
        cellstable = new Hashtable();
        Cell[] row = sheet.getRow(startBlockRow);

        if (isConsole)
            DebugSupport.getMessage("Block is started. row=" + (startBlockRow + 1));

        int count = row.length;
        int i;
        for (i = startBlockRow + 1;; i++) {
            try {
                row = sheet.getRow(i);
                if (row[second_flag] == null
                    || row[second_flag].getContents().trim().equals(""))
                    break;
                else
                    if (row[flag] != null && !row[flag].getContents().trim().equals(""))
                        break;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }

        }
        for (int j = 0; j < count; j++) {
            Cell[] column = sheet.getColumn(j);
            String[] columnContents = new String[i - startBlockRow];

            for (int a = startBlockRow; a < i; a++) {
                if (column[a] != null)
                    columnContents[a - startBlockRow] = column[a].getContents();

                else
                    columnContents[a - startBlockRow] = "";

                if (columnContents[a - startBlockRow] == null)
                    columnContents[a - startBlockRow] = "";
            }

            cellstable.put(convertHCoord(j + 1), columnContents);
        }
        if (isConsole)
            getMessage();

        bsBlockHandler =
            new BsBlockHandler(sessId, startBlockRow + 1, cellstable, parameters);
        bsBlockHandler.process();

        return i - startBlockRow;
    } catch (Exception e) {
        System.out.println(e);
        return 99;
    }
}
private boolean isFinish(Cell[] row) {
    String[] flags = domHandler.getFinish();
    int first = convert0HCoord(flags[0]);
    second_flag = convert0HCoord(flags[1]);

    if ((row[first] == null || row[first].equals(""))
        && (row[second_flag] == null || row[second_flag].equals("")))
        return true;

    return false;
}
public void process() {
    try {
        int start = domHandler.getStartRow();
        for (int i = start - 1;; i++) {

            Cell[] row = sheet.getRow(i);

            if (isFinish(row))
                break;

            int k = convert0HCoord(domHandler.getStartFlagCell());
            k = 0 + k;

            if (row[k] != null && !row[k].getContents().equals("")) {
                startBlockRow = i;
                i += handleBlock(k) - 1;
                
                recCount += bsBlockHandler.getReccount();
                errCount += bsBlockHandler.getErrcount();

            }

        }

    } catch (ArrayIndexOutOfBoundsException e) {
    } catch (Exception ex) {

        DebugSupport.getException(ex);

    }
}
public void setLogHandler(LoggerHandler newLogHandler) {
	logHandler = newLogHandler;
}
}
